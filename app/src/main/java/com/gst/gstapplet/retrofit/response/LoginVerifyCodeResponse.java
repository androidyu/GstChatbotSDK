package com.gst.gstapplet.retrofit.response;

public class LoginVerifyCodeResponse {
    private int Status;
    private Body body;

    public LoginVerifyCodeResponse() {
    }

    public LoginVerifyCodeResponse(int status, Body body) {
        Status = status;
        this.body = body;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public class Body{
        public Body() {
        }

        public Body(String smsId) {
            this.smsId = smsId;
        }

        private String smsId;

        public String getSmsId() {
            return smsId;
        }

        public void setSmsId(String smsId) {
            this.smsId = smsId;
        }

        @Override
        public String toString() {
            return "Body{" +
                    "smsId='" + smsId + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginVerifyCodeResponse{" +
                "Status='" + Status + '\'' +
                ", body=" + body +
                '}';
    }
}
