package com.gst.gstapplet.listener;

import android.view.View;

import com.gst.gstapplet.retrofit.bean.RcsInfoBean;


public interface OnRcsInfoListClickListener {
    void onItemClick(View view, RcsInfoBean rcsInfoBean);
}
