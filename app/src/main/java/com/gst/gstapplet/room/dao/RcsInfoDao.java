package com.gst.gstapplet.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.gst.gstapplet.retrofit.bean.RcsInfoBean;

import java.util.List;

@Dao
public interface RcsInfoDao {

    @Insert
    void insertRcsInfo(RcsInfoBean... rcsInfoBeans);

    @Query("SELECT * FROM rcsinfo_table ORDER BY templateUpdateTime ASC")
    LiveData<List<RcsInfoBean>> getRcsInfoList();

    @Query("DELETE FROM rcsinfo_table")
    void deleteRscInfos();

    @Query(" SELECT * from  rcsinfo_table group by chatbotName")
    LiveData<List<RcsInfoBean>> getChatBotList();


    @Query("SELECT * from rcsinfo_table WHERE chatbotCode like '%'|| :code || '%' ")
    LiveData<List<RcsInfoBean>> getChatBotListByCode(String code);
}


