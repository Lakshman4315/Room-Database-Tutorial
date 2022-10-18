package com.example.roomtut;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import androidx.room.ColumnInfo;

@Entity(tableName = "main_table")
public class Data {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "names")
    private String name;

    Data(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Ignore
    Data(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
