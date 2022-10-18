package com.example.roomtut;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities = Data.class ,version = 1, exportSchema = false)
public abstract class MyRoomDatabase extends RoomDatabase {

    private static final int NUMBER_OF_THREADS = 4;
    public static Executor databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile MyRoomDatabase INSTANCE;

    public abstract DaoData dao();

    public static synchronized MyRoomDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,
                    MyRoomDatabase.class, "main_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
    }



}
