package com.sky.clicktoflight.Model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.sky.clicktoflight.Constants;
import com.sky.clicktoflight.db.DatabaseHelper;

public class AirportDaoImpl implements AirportDao{

    private final DatabaseHelper mDatabaseHelper;

    public AirportDaoImpl(Context context) {
        this.mDatabaseHelper = new DatabaseHelper(context);
    }


    @Override
    public void icaoQuery(String airportName) {
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        String sql = "select ICAO from " + Constants.TABLE_NAME_AIRPODR + " where AIRPORT_NAME like ?";
        Cursor cursor = db.rawQuery(sql, new String[]{'%' + airportName + '%'});
        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex("ICAO");
            String ICAO = cursor.getString(index);
            Log.d("print icao is = ", ICAO);
        }
        cursor.close();
        db.close();
    }

    @Override
    public String airportQuery(String icao) {
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        String sql = "select AIRPORT_NAME from " + Constants.TABLE_NAME_AIRPODR + " where ICAO like ?";
        Cursor cursor = db.rawQuery(sql, new String[]{icao});
        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex("AIRPORT_NAME");
            String airportName = cursor.getString(index);
            Log.d("print airport name : ", airportName);
            return airportName;
        }
        cursor.close();
        db.close();
        return null;
    }

    @Override
    public void insert() {
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ICAO","ZSPD");
        values.put("AIRPORT_NAME","Shanghai pudong international airport");
        db.insert(Constants.TABLE_NAME_AIRPODR,null,values);
        db.close();
    }
}
