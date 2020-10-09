package com.gst.gstapplet.room.convert;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gst.gstapplet.retrofit.bean.RcsInfoBean;

import java.util.List;

public class CardConvert {
    @TypeConverter
    public static List<RcsInfoBean.Card> revert(String json) {

        Gson gson = new Gson();
        List<RcsInfoBean.Card> list = gson.fromJson(json, new TypeToken<List<RcsInfoBean.Card>>() {
        }.getType());

        return list;
    }

    @TypeConverter
    public static String convert(List<RcsInfoBean.Card> list){
        return  new Gson().toJson(list);
    }
}
