package com.gst.gstapplet.bindingConverters;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gst.gstapplet.R;
import com.gst.gstapplet.util.TimeUtils;

import java.text.ParseException;
import java.util.Date;

public class RcsInfoItemConverters {
    @BindingAdapter({"chatBotLogo"})
    public static  void loadImageFromUrl(ImageView imageView,String url){
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.mipmap.logo)
                .error(R.mipmap.logo);
        Glide.with(imageView.getContext())
                .applyDefaultRequestOptions(requestOptions)
                .load("http:" + url).centerCrop().circleCrop().into(imageView);
    }

    @BindingAdapter({"time"})
    public static void setRcsInfoItemTime(TextView textView, Date date){
        try {
            String time = TimeUtils.value(date, new Date());
//                holder.tv_time.setText(time);
            textView.setText(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @BindingAdapter({"cardImage"})
    public static void setCardImage(ImageView imageView, String url  ){
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.mipmap.logo)
                .error(R.mipmap.logo);
        Glide.with(imageView.getContext())
                .applyDefaultRequestOptions(requestOptions)
                .load("http:" + url).into(imageView);
    }

}
