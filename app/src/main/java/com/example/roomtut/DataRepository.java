package com.example.roomtut;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DataRepository {

    private DaoData mDao;
    private LiveData<List<Data>> mAlldata;

    DataRepository(Application application){
        MyRoomDatabase db = MyRoomDatabase.getDatabase(application);
        mDao = db.dao();
        mAlldata = mDao.getAllData();
    }

    LiveData<List<Data>> getAllData(){
        return mAlldata;
    }

    void  insert(Data data){
        MyRoomDatabase.databaseWriteExecutor.execute(() -> {
            mDao.insert(data);
        });
    }
}
