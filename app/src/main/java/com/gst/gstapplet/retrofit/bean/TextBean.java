package com.gst.gstapplet.retrofit.bean;


import com.gst.gstapplet.adapter.ChatBotItem;

import static com.gst.gstapplet.util.Constant.SELF_MSG_TEXT;

public class TextBean implements ChatBotItem {
    private String text;

    public TextBean() {
    }

    public TextBean(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int viewType() {
        return SELF_MSG_TEXT;
    }
}
