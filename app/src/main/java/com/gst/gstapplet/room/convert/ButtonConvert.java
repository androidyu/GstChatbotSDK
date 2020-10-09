package com.gst.gstapplet.room.convert;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gst.gstapplet.retrofit.bean.RcsInfoBean;

import java.util.List;

public class ButtonConvert {
    @TypeConverter
    public static List<RcsInfoBean.Button> revert(String json) {

        Gson gson = new Gson();
        List<RcsInfoBean.Button> list = gson.fromJson(json, new TypeToken<List<RcsInfoBean.Button>>() {
        }.getType());

        return list;
    }

    @TypeConverter
    public static String convert(List<RcsInfoBean.Button> list){
        return  new Gson().toJson(list);
    }
}
