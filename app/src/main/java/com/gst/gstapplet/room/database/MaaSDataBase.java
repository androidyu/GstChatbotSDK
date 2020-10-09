package com.gst.gstapplet.room.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;


import com.gst.gstapplet.retrofit.bean.RcsInfoBean;
import com.gst.gstapplet.room.convert.ButtonConvert;
import com.gst.gstapplet.room.convert.CardConvert;
import com.gst.gstapplet.room.convert.DateConvert;
import com.gst.gstapplet.room.dao.RcsInfoDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {RcsInfoBean.class}, version = 1, exportSchema = false)
@TypeConverters({ButtonConvert.class, DateConvert.class, CardConvert.class})
public abstract class MaaSDataBase extends RoomDatabase {
    public abstract RcsInfoDao rcsInfoDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile MaaSDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public  static MaaSDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MaaSDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE  = Room.databaseBuilder(context.getApplicationContext(), MaaSDataBase.class, "maas_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static  RoomDatabase.Callback sRoomDatabaseCallback=new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            //打开数据库要执行的操作可以在这写，譬如清空数据，插入默认数据等
            super.onOpen(db);

        }
    };
}
