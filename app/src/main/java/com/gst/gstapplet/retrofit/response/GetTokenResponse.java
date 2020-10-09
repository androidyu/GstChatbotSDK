package com.gst.gstapplet.retrofit.response;

public class GetTokenResponse {
    private int status;
    private Body body;

    public GetTokenResponse() {
    }

    public GetTokenResponse(int status, Body body) {
        this.status = status;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "GetTokenResponse{" +
                "status=" + status +
                ", body=" + body +
                '}';
    }

   public class Body {
        private String smsId;
        private String responseMsg;
        private String content;
        private String h5Url;
        private String params;
        private int linkType;

        public Body() {
        }

        public Body(String smsId, String responseMsg, String content, String h5Url, String params, int linkType) {
            this.smsId = smsId;
            this.responseMsg = responseMsg;
            this.content = content;
            this.h5Url = h5Url;
            this.params = params;
            this.linkType = linkType;
        }

        public String getSmsId() {
            return smsId;
        }

        public void setSmsId(String smsId) {
            this.smsId = smsId;
        }

        public String getResponseMsg() {
            return responseMsg;
        }

        public void setResponseMsg(String responseMsg) {
            this.responseMsg = responseMsg;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getH5Url() {
            return h5Url;
        }

        public void setH5Url(String h5Url) {
            this.h5Url = h5Url;
        }

        public String getParams() {
            return params;
        }

        public void setParams(String params) {
            this.params = params;
        }

        public int getLinkType() {
            return linkType;
        }

        public void setLinkType(int linkType) {
            this.linkType = linkType;
        }

        @Override
        public String toString() {
            return "Body{" +
                    "smsId='" + smsId + '\'' +
                    ", responseMsg='" + responseMsg + '\'' +
                    ", content='" + content + '\'' +
                    ", h5Url='" + h5Url + '\'' +
                    ", params='" + params + '\'' +
                    ", linkType=" + linkType +
                    '}';
        }
    }
}
