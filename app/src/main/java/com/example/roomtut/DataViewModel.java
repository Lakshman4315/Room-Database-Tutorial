package com.example.roomtut;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DataViewModel extends AndroidViewModel {

    private DataRepository mRepository;

    private final LiveData<List<Data>> mAllData;

    public DataViewModel(@NonNull Application application) {
        super(application);
        mRepository = new DataRepository(application);
        mAllData = mRepository.getAllData();
    }

    LiveData<List<Data>> getAllData(){
        return mAllData;
    }

    public void insert(Data data){
        mRepository.insert(data);
    }

}
