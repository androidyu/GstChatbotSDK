package com.gst.gstapplet.retrofit;


import com.gst.gstapplet.retrofit.response.GetRcsInfoResponse;
import com.gst.gstapplet.retrofit.response.GetTokenResponse;
import com.gst.gstapplet.retrofit.response.GetVerifyCodeResponse;
import com.gst.gstapplet.retrofit.response.LoginVerifyCodeResponse;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface HttpRequestInterface {
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("send/sendValidateCode")
    Observable<GetVerifyCodeResponse> getVerifyCode(@Body RequestBody json);


    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("send/getValidateCode")
    Observable<LoginVerifyCodeResponse> loginVerifyCode(@Body RequestBody json);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("show/prov/sign.do")
    Observable<GetTokenResponse> getToken(@Body RequestBody json);


    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("show/getRcsInfo")
    Observable<GetRcsInfoResponse> getRcsInfo(@Header("token") String token, @Body RequestBody json);
}
