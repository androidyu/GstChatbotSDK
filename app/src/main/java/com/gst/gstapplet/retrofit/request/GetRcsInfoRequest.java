package com.gst.gstapplet.retrofit.request;

public class GetRcsInfoRequest {
    private String reqType;//returnPageInfo
    private String smsId;//smsId
    private String smsIdArray;//传smsId
    private String localDeviceId;//本地标识

    public GetRcsInfoRequest() {
    }

    public GetRcsInfoRequest(String reqType, String smsId, String smsIdArray, String localDeviceId) {
        this.reqType = reqType;
        this.smsId = smsId;
        this.smsIdArray = smsIdArray;
        this.localDeviceId = localDeviceId;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    public String getSmsIdArray() {
        return smsIdArray;
    }

    public void setSmsIdArray(String smsIdArray) {
        this.smsIdArray = smsIdArray;
    }

    public String getLocalDeviceId() {
        return localDeviceId;
    }

    public void setLocalDeviceId(String localDeviceId) {
        this.localDeviceId = localDeviceId;
    }

    @Override
    public String toString() {
        return "GetRcsInfoRequest{" +
                "reqType='" + reqType + '\'' +
                ", smsId='" + smsId + '\'' +
                ", smsIdArray='" + smsIdArray + '\'' +
                ", localDeviceId='" + localDeviceId + '\'' +
                '}';
    }
}
