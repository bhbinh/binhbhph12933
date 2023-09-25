package com.example.myapplication.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.Dbhelper;

public class DemoDB {
    private SQLiteDatabase db;

    public DemoDB(Context context ){
        Dbhelper dbhelper = new Dbhelper(context);
        db = dbhelper.getWritableDatabase();
    }
}
