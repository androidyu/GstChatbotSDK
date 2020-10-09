package com.gst.gstapplet.retrofit.request;

public class LoginVerifyCodeRequest {
    private String phone;
    private String code;

    public LoginVerifyCodeRequest() {
    }

    public LoginVerifyCodeRequest(String phone, String code) {
        this.phone = phone;
        this.code = code;
    }
}

