package com.gst.gstapplet.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.gst.gstapplet.retrofit.bean.RcsInfoBean;
import com.gst.gstapplet.room.repository.RcsInfoRepository;

import java.util.List;

public class RcsInfoListViewModel extends AndroidViewModel {
    RcsInfoRepository rcsInfoRepository;
    private LiveData<List<RcsInfoBean>> rcsInfoList;
    private LiveData<List<RcsInfoBean>> chatBoxList;

    public RcsInfoListViewModel(@NonNull Application application) {
        super(application);
        rcsInfoRepository = new RcsInfoRepository(application);
        rcsInfoList = rcsInfoRepository.getRcsInfos();
        chatBoxList = rcsInfoRepository.getChatBotList();
    }

    public LiveData<List<RcsInfoBean>> getRcsInfos() {
        return rcsInfoList;
    }

    public LiveData<List<RcsInfoBean>> getChatBotList() {
        return chatBoxList;
    }

    public void insert(RcsInfoBean... rcsInfoBeans) {
        rcsInfoRepository.insert(rcsInfoBeans);
    }
}
