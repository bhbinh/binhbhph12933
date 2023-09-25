package com.example.myapplication.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.Dbhelper;
import com.example.myapplication.model.ThuThu;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("Range")
public class ThuThuDAO {
    private SQLiteDatabase db;
    public ThuThuDAO(Context context){
        Dbhelper dbhelper = new Dbhelper(context);
        db = dbhelper.getWritableDatabase();

    }
    public long insert(ThuThu obj){

        ContextValues values = new ContentValues();
        values.put("maTT",obj.getMaTT());
        values.put("hoTen",obj.getHoTen());
        values.put("matKhau",obj.setMatKhau());

        return db.insert("ThuThu",null,values);
    }
    public long updatePass(ThuThu obj){

        ContextValues values = new ContentValues();

        values.put("hoTen",obj.getHoTen());
        values.put("matkhau",obj.getMatKhau());

        return db.update("ThuThu",values,"maTT=?",new String[]{String.valueOf(obj.getMaTT())});
    }
    public long delete(String id){
        return db.delete("ThuThu","maTT=?",new String[]{id});
    }
    public List<ThuThu> getData {String sql, String...selectionArgs}{
        List<ThuThu> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            ThuThu obj = new ThuThu();
            obj.setMaTT(Integer.parseInt(c.getString(c.getColumnIndex("maTT"))));
            obj.getHoTen(c.getString(c.getColumnIndex("hoTen")));
            obj.getMatKhau(c.getString(c.getColumnIndex("matKhau")));
            list.add(obj);
        }
        return list;
    }
    public List<ThuThu> getAll(){
        String sql = "SELECT * FROM ThuThu";
        return getData(sql);
    }
    public ThuThu getID(String id){
        String sql = "SELECT * FROM ThuThu WHERE maTV=?";
        List<ThuThu> list = getData(sql,id);
        return list.get(0);
    }
    public int checkLogin(String id, String password){
        String sql = "SELECT * FROM ThuThu WHERE maTT=? AND matKhau=?";
        List<ThuThu> list = getData(sql,id,password);
        if (list.size() == 0)
            return -1;
            return 1;

    }
}
