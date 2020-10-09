package com.gst.gstapplet.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit != null)
            return retrofit;
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASEURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient.build())
                .build();
        return retrofit;
    }
    private static final Gson gson = new GsonBuilder()
            //.setDateFormat("yyyy-MM-dd 'T' HH:mm:ss 'Z'")
            //.setDateFormat("yyyy-MM-dd HH:mm:ss")
            .registerTypeAdapter(Date.class,new DateDeserializer())
            .create();
    private static class DateDeserializer implements JsonDeserializer<Date> {

        private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (json != null) {
                final String jsonString = json.getAsString();
                try {
                    return dateFormat.parse(jsonString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                final long jsonLong= json.getAsLong();
                try {
                    return new Date(jsonLong);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
