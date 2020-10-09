package com.gst.gstapplet.room.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;


import com.gst.gstapplet.retrofit.bean.RcsInfoBean;
import com.gst.gstapplet.room.dao.RcsInfoDao;
import com.gst.gstapplet.room.database.MaaSDataBase;

import java.util.List;

public class RcsInfoRepository {
    private RcsInfoDao rcsInfoDao;
    private LiveData<List<RcsInfoBean>> rcsInfoList;

    public RcsInfoRepository(Application application) {
        MaaSDataBase db = MaaSDataBase.getDatabase(application);
        rcsInfoDao = db.rcsInfoDao();
    }

    public LiveData<List<RcsInfoBean>> getRcsInfos() {
        rcsInfoList = rcsInfoDao.getRcsInfoList();
        return rcsInfoList;
    }

    public void insert(RcsInfoBean ...rcsInfoBeans) {
        MaaSDataBase.databaseWriteExecutor.execute(()->{
            rcsInfoDao.insertRcsInfo(rcsInfoBeans);
        });

    }
    public LiveData<List<RcsInfoBean>> getChatBotList() {
        rcsInfoList = rcsInfoDao.getChatBotList();
        return rcsInfoList;
    }

    public void deleteRscInfos() {
        rcsInfoDao.deleteRscInfos();
    }

    public LiveData<List<RcsInfoBean>> getChatBotListByCode(String code){
        return rcsInfoDao.getChatBotListByCode(code);
    }

}
