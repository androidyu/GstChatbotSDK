package com.gst.gstapplet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.finogeeks.lib.applet.client.FinAppClient;
import com.finogeeks.lib.applet.client.FinAppConfig;
import com.finogeeks.lib.applet.interfaces.FinCallback;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public static final String TYPE_INTENT = "type";
    public static final String URL_INTENT = "url";
    public static final String APPLET_INTENT = "applet";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (FinAppClient.INSTANCE.isFinAppProcess(this)) {
            return;
        }




        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
                Toast.makeText(MainActivity.this, "SDK初始化失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProgress(int status, String error) {

            }
        };
        FinAppClient.INSTANCE.init(this.getApplication(), config, callback);

//        Button btn5G = findViewById(R.id.btn5G);
//        Button btnLoveSchool = findViewById(R.id.btnLoveSchool);


//        btnLoveSchool.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                FinAppClient.INSTANCE.getAppletApiManager().startApplet(MainActivity.this, "5ea0401463cb900001d73865");
//            }
//        });

    }
}
