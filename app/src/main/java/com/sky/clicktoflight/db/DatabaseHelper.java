package com.sky.clicktoflight.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sky.clicktoflight.Constants;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + Constants.TABLE_NAME_AIRPODR + "(ICAO varchar PRIMARY KEY, AIRPORT_NAME varchar)";
        String initSqlData = "insert into " + Constants.TABLE_NAME_AIRPODR + " values " +
                "('ZBAA','Beijing capital international airport')," +
                "('ZSPD','Shanghai pudong international airport')," +
                "('ZGGG','Guangzhou Baiyun International Airport')," +
                "('ZHHH','Wuhan Tianhe International Airport')," +
                "('ZSAQ','Anqing Tianzhushan Airport')," +
                "('ZSOF','Hefei Xinqiao International Airport')," +
                "('ZBAD','Beijing Daxing International Airport')," +
                "('ZUCK','Chongqing Jiangbei International Airport')," +
                "('ZSFZ','Fuzhou Changle International Airport')," +
                "('ZSQZ','Quanzhou Jinjiang International Airport')," +
                "('ZSAM','Xiamen Gaoqi International Airport')," +
                "('ZGKL','Guilin Liangjiang International Airport')," +
                "('ZSSS','Shanghai hongqiao international airport')," +
                "('ZGSZ','Shenzhen Bao an International Airport')," +
                "('KLAX','Los Angeles International Airport')";
        db.execSQL(sql);
        db.execSQL(initSqlData);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
