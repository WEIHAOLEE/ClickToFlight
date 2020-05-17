package com.sky.clicktoflight;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import com.sky.clicktoflight.Model.DAO.AirportDaoImpl;
import com.sky.clicktoflight.db.DatabaseHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.sky.clicktoflight", appContext.getPackageName());
    }
    @Test
    public void testInsert(){
        Context context= InstrumentationRegistry.getTargetContext();

        AirportDaoImpl airportDao = new AirportDaoImpl(context);
        airportDao.insert();
    }

    @Test
    public void testQuery(){
        Context context = InstrumentationRegistry.getTargetContext();
        AirportDaoImpl airportDao = new AirportDaoImpl(context);
        airportDao.airportQuery("ZBAA");
        airportDao.icaoQuery("Beijing");
    }

    @Test
    public void testQuery2(){
        Context context = InstrumentationRegistry.getTargetContext();
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        String sql = "select AIRPORT_NAME from " + Constants.TABLE_NAME_AIRPODR + " where ICAO like ?";
        Cursor cursor = db.rawQuery(sql, new String[]{"KLAX"});
        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex("AIRPORT_NAME");
            String airportName = cursor.getString(index);
            Log.d("print airport name : ", airportName);
        }
        cursor.close();
        db.close();
    }
}
