package com.gst.gstapplet.retrofit.response;


import com.gst.gstapplet.retrofit.bean.RcsInfoBean;

import java.util.List;

public class GetRcsInfoResponse {
    public GetRcsInfoResponse() {
    }


    private Integer status;
    private String desc;
    private List<RcsInfoBean> body;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<RcsInfoBean> getBody() {
        return body;
    }

    public void setBody(List<RcsInfoBean> body) {
        this.body = body;
    }




    @Override
    public String toString() {
        return "GetRcsInfoResponse{" +
                "status=" + status +
                ", desc='" + desc + '\'' +
                ", body=" + body +
                '}';
    }
}
