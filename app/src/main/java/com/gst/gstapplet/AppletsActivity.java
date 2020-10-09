package com.gst.gstapplet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.finogeeks.lib.applet.client.FinAppClient;
import com.finogeeks.lib.applet.client.FinAppConfig;
import com.finogeeks.lib.applet.interfaces.FinCallback;
import com.google.gson.Gson;
import com.gst.gstapplet.adapter.ChatBotListAdapter;
import com.gst.gstapplet.adapter.CustomDecoration;
import com.gst.gstapplet.databinding.ActivityAppletsBinding;
import com.gst.gstapplet.retrofit.HttpRequestInterface;
import com.gst.gstapplet.retrofit.bean.RcsInfoBean;
import com.gst.gstapplet.retrofit.bean.ResponseMsgBean;
import com.gst.gstapplet.retrofit.request.GetRcsInfoRequest;
import com.gst.gstapplet.retrofit.request.GetTokenRequest;
import com.gst.gstapplet.retrofit.response.GetRcsInfoResponse;
import com.gst.gstapplet.retrofit.response.GetTokenResponse;
import com.gst.gstapplet.util.Constant;
import com.gst.gstapplet.util.RetrofitUtil;
import com.gst.gstapplet.util.SharedPreferencesUtils;
import com.gst.gstapplet.viewmodel.ChatBotListViewModel;
import com.gst.gstapplet.viewmodel.RcsInfoListViewModel;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

public class AppletsActivity extends AppCompatActivity {
    public static final String TYPE_INTENT = "type";
    public static final String URL_INTENT = "url";
    public static final String APPLET_INTENT = "appletid";
    public static final String SMSID="smsId";
    Retrofit retrofit;
    HttpRequestInterface requestInterface;
    Disposable tokenDisposable;
    private RcsInfoListViewModel rcsInfoListViewModel;
    private RecyclerView recyclerview;
    private ChatBotListAdapter adapter;
    ChatBotListViewModel chatBotListViewModel;
    ActivityAppletsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applets);
        retrofit = RetrofitUtil.getInstance();
        requestInterface = retrofit.create(HttpRequestInterface.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_applets);
        chatBotListViewModel = new ChatBotListViewModel(getApplication());
        binding.setChatbotList(chatBotListViewModel);
        binding.setLifecycleOwner(this);
        initEvent();
        initView();


        if (FinAppClient.INSTANCE.isFinAppProcess(this)) {
            return;
        }
        FinAppConfig config = new FinAppConfig.Builder()
                .setAppKey("awbN6seUZbe/eoWaP6a1gVMaeBUdGgF3fxG7KfEIKSY=")
                .setAppSecret("493c6fa479c8c375")
                .setApiUrl("https://mp.finogeeks.com")
                .setApiPrefix("/api/v1/mop")
                .setGlideWithJWT(false)
                .build();
        // SDK初始化结果回调，用于接收SDK初始化状态
        FinCallback<Object> callback = new FinCallback<Object>() {
            @Override
            public void onSuccess(Object result) {
                // SDK初始化成功
            }

            @Override
            public void onError(int code, String error) {
                // SDK初始化失败
                Toast.makeText(AppletsActivity.this, "SDK初始化失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProgress(int status, String error) {

            }
        };
        FinAppClient.INSTANCE.init(this.getApplication(), config, callback);
        Intent intent = getIntent();
        if (intent.getData() != null)
        {
            Log.e("yujl","intent.getData() != null");
            Uri uri = intent.getData();
            uri.getScheme();//获取scheme
            uri.getHost();//获取host
            uri.getAuthority();//获取authority
            String type = uri.getQueryParameter(TYPE_INTENT);//获取传递参数
            String url = uri.getQueryParameter(URL_INTENT);
            String appletid = uri.getQueryParameter(APPLET_INTENT);
            String smsId=uri.getQueryParameter(SMSID);
            getToken(smsId);
            //标题转UTF-8码
            if (!TextUtils.isEmpty(appletid))
            {
                try
                {
                    appletid = URLDecoder.decode(appletid, "UTF-8");
                    Log.e("yujl",appletid);
                    FinAppClient.INSTANCE.getAppletApiManager().startApplet(AppletsActivity.this, appletid);
                } catch (UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    private void initEvent() {
        chatBotListViewModel.getIsShowAll().observe(this, aBoolean -> {

        });
    }

    private void initView() {
        recyclerview = binding.recyclerview;
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ChatBotListAdapter((view, rcsInfoBean) -> {
//            Intent intent = new Intent(this, ChatBotDetailActivity.class);
//            intent.putExtra("chatBotCode",rcsInfoBean.getChatbotCode());
//            startActivity(intent);
        });

        recyclerview.setAdapter(adapter);
        recyclerview.addItemDecoration(new CustomDecoration(this, CustomDecoration.VERTICAL_LIST, R.drawable.shape_divider, 16));
        rcsInfoListViewModel = new ViewModelProvider(this).get(RcsInfoListViewModel.class);
        rcsInfoListViewModel.getChatBotList().observe(this, rcsInfoBeans -> adapter.setList(rcsInfoBeans));
    }
    private void getToken(String smsId) {
        GetTokenRequest getTokenRequest;
        String sp_localDeviceId = SharedPreferencesUtils.getString(this, Constant.LOCALDEVICEID, "");
        if (TextUtils.isEmpty(sp_localDeviceId)) {
            getTokenRequest = new GetTokenRequest(smsId, "1", "");
        } else {
            getTokenRequest = new GetTokenRequest(smsId, "1", sp_localDeviceId);
        }
        Gson gson = new Gson();
        String json = gson.toJson(getTokenRequest);
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type application/json"), json);
        Observable<GetTokenResponse> tokenResponseObservable = requestInterface.getToken(requestBody);
        tokenDisposable = tokenResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getTokenResponse -> {
                    Log.e("yujl", getTokenResponse.toString());
                    String responseMsg = getTokenResponse.getBody().getResponseMsg();
                    Gson gson1 = new Gson();
                    ResponseMsgBean responseMsgBean = gson1.fromJson(responseMsg, ResponseMsgBean.class);
                    String localDeviceId = responseMsgBean.getBody().getLocalDeviceId();
                    String token = responseMsgBean.getBody().getToken();
                    String smsId2 = getTokenResponse.getBody().getSmsId();
                    SharedPreferencesUtils.saveString(AppletsActivity.this, Constant.LOCALDEVICEID, localDeviceId);
                    SharedPreferencesUtils.saveString(AppletsActivity.this, Constant.TOKEN, token);
                    int shortLinkType = responseMsgBean.getBody().getShortLinkType();
                    getRcsInfo(smsId2, token, localDeviceId);
                }, throwable -> Log.e("yujl", throwable.toString()));
    }

    public void getRcsInfo(String smsId, String token, String localDeviceId) {
        GetRcsInfoRequest getRcsInfoRequest = new GetRcsInfoRequest("returnPageInfo", smsId, smsId, localDeviceId);
        Gson gson = new Gson();
        String json = gson.toJson(getRcsInfoRequest);
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type application/json"), json);
        Observable<GetRcsInfoResponse> rcsInfoObservable = requestInterface.getRcsInfo(token, requestBody);
        rcsInfoObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(getRcsInfoResponse -> {
                    Log.e("yujl", getRcsInfoResponse.toString());
                    for (RcsInfoBean rcsInfoBean : getRcsInfoResponse.getBody()) {
                        rcsInfoListViewModel.insert(rcsInfoBean);
                    }
                }, throwable -> Log.e("yujl", throwable.toString()));
    }

}
