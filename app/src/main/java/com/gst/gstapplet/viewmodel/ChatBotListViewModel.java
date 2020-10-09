package com.gst.gstapplet.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ChatBotListViewModel extends AndroidViewModel {
    private MutableLiveData<Boolean> isShowAll;
    private Application application;
    public ChatBotListViewModel(@NonNull Application application) {
        super(application);
        isShowAll = new MutableLiveData<>(true);
        this.application=application;
    }


    public MutableLiveData<Boolean> getIsShowAll() {
        return isShowAll;
    }

    public void selectShowAll(boolean showAll) {
        isShowAll.setValue(showAll);
    }
}
