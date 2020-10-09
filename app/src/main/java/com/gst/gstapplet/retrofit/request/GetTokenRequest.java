package com.gst.gstapplet.retrofit.request;

public class GetTokenRequest {
    private String smsId;
    private String linkType;
    private String localDeviceId;//初次获取不用传，第二次要传，永久有效
    public GetTokenRequest() {
    }

    public GetTokenRequest(String smsId, String linkType, String localDeviceId) {
        this.smsId = smsId;
        this.linkType = linkType;
        this.localDeviceId = localDeviceId;
    }

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLocalDeviceId() {
        return localDeviceId;
    }

    public void setLocalDeviceId(String localDeviceId) {
        this.localDeviceId = localDeviceId;
    }
}
