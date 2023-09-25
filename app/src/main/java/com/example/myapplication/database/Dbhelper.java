package com.example.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "PNLIB";
    private static final int DB_VERSION = 1;
    static final String CREATE_TABLE_THU_THU =
            "CREATE TABLE Thuthu (\n" +
            "    maTT    TEXT PRIMARY KEY,\n" +
            "    hoTen   TEXT NOT NULL,\n" +
            "    matKhau TEXT NOT NULL\n" +
            ");";
    static final String CREATE_TABLE_THANH_VIEN =
            "CREATE TABLE Thuthu (\n" +
                    "    maTT    TEXT PRIMARY KEY,\n" +
                    "    hoTen   TEXT NOT NULL,\n" +
                    "    matKhau TEXT NOT NULL\n" +
                    ");\n";
    static final String CREATE_TABLE_SACH =
            "CREATE TABLE Sach (\n" +
                    "    maSach  INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    tenSach TEXT    NOT NULL,\n" +
                    "    giaThue INTEGER NOT NULL,\n" +
                    "    maloai  INTEGER REFERENCES LoaiSach (maLoai) \n" +
                    ");";
    static final String CREATE_TABLE_PHIEU_MUON =
            "CREATE TABLE PhieuMuon (\n" +
                    "    maPM     INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    maTT     TEXT    REFERENCES ThuThu (maTT),\n" +
                    "    maTV     TEXT    REFERENCES ThanhVien (matv),\n" +
                    "    masach   INTEGER REFERENCES Sach (masach),\n" +
                    "    tienThue INTEGER NOT NULL,\n" +
                    "    ngay     DATE    NOT NULL,\n" +
                    "    traSach  INTEGER NOT NULL\n" +
                    ");\n";
    static final String CREATE_TABLE_LOAI_SACH =
            "CREATE TABLE LoaiSach (\n" +
                    "    maLoai  INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    tenLoai TEXT    NOT NULL\n" +
                    ");\n";
    public Dbhelper(@Nullable Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LOAI_SACH);
        db.execSQL(CREATE_TABLE_PHIEU_MUON);
        db.execSQL(CREATE_TABLE_SACH);
        db.execSQL(CREATE_TABLE_THANH_VIEN);
        db.execSQL(CREATE_TABLE_THU_THU);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String dropTableLoaiThuThu ="drop table if exists ThuThu";
        db.execSQL(CREATE_TABLE_THU_THU);
        String dropTableLoaiThanhVien ="drop table if exists ThanhVien";
        db.execSQL(CREATE_TABLE_THANH_VIEN);
        String dropTableLoaiSach ="drop table if exists Sach";
        db.execSQL(CREATE_TABLE_SACH);
        String dropTablePhieuMuon ="drop table if exists PhieuMuon";
        db.execSQL(CREATE_TABLE_PHIEU_MUON);
        String dropTableLoaiLoaiSach ="drop table if exists LoaiSach";
        db.execSQL(CREATE_TABLE_LOAI_SACH);

        onCreate(db);
    }
}
