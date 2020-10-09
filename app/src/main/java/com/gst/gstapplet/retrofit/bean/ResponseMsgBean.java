package com.gst.gstapplet.retrofit.bean;

public class ResponseMsgBean {
    private int status;
    private String desc;
    private Body body;

    public ResponseMsgBean() {
    }

    public ResponseMsgBean(int status, String desc, Body body) {
        this.status = status;
        this.desc = desc;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public class Body{
        private int  shortLinkType;
        private String localDeviceId;
        private String token;

        public Body() {
        }

        public Body(int shortLinkType, String localDeviceId, String token) {
            this.shortLinkType = shortLinkType;
            this.localDeviceId = localDeviceId;
            this.token = token;
        }

        public int getShortLinkType() {
            return shortLinkType;
        }

        public void setShortLinkType(int shortLinkType) {
            this.shortLinkType = shortLinkType;
        }

        public String getLocalDeviceId() {
            return localDeviceId;
        }

        public void setLocalDeviceId(String localDeviceId) {
            this.localDeviceId = localDeviceId;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}

