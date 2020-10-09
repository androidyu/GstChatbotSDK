package com.gst.gstapplet.retrofit.response;

public class GetVerifyCodeResponse {
    private int status;
    private String body;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "GetVerifyCodeBean{" +
                "status=" + status +
                ", body='" + body + '\'' +
                '}';
    }
}
