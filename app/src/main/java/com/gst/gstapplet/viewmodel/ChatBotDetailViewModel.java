package com.gst.gstapplet.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.gst.gstapplet.retrofit.bean.RcsInfoBean;
import com.gst.gstapplet.room.repository.RcsInfoRepository;

import java.util.List;

public class ChatBotDetailViewModel extends AndroidViewModel {
    RcsInfoRepository rcsInfoRepository;
    private LiveData<List<RcsInfoBean>> chatBotItemList;

    public ChatBotDetailViewModel(@NonNull Application application) {
        super(application);
        rcsInfoRepository = new RcsInfoRepository(application);
    }

    public void insert(RcsInfoBean... rcsInfoBeans) {
        rcsInfoRepository.insert(rcsInfoBeans);
    }

    public LiveData<List<RcsInfoBean>> getChatBotListByCode(String code) {
        chatBotItemList = rcsInfoRepository.getChatBotListByCode(code);
        return chatBotItemList;
    }

}
