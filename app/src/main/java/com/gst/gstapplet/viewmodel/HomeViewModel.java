package com.gst.gstapplet.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<Boolean> isMsgSel;
    private MutableLiveData<Boolean> isSendSel;
    private MutableLiveData<Boolean> isMineSel;

    public HomeViewModel() {
        isMsgSel = new MutableLiveData<>(true);
        isSendSel = new MutableLiveData<>(false);
        isMineSel = new MutableLiveData<>(false);
    }

    public LiveData<Boolean> getIsMsgSel() {
        return isMsgSel;
    }

    public LiveData<Boolean> getIsSendSel() {
        return isSendSel;
    }

    public LiveData<Boolean> getIsMineSel() {
        return isMineSel;
    }

    public void selectMsg() {
        isMsgSel.setValue(true);
        isSendSel.setValue(false);
        isMineSel.setValue(false);
    }

    public void selectSend() {
        isMsgSel.setValue(false);
        isSendSel.setValue(true);
        isMineSel.setValue(false);
    }

    public void selectMine() {
        isMsgSel.setValue(false);
        isSendSel.setValue(false);
        isMineSel.setValue(true);
    }

}
