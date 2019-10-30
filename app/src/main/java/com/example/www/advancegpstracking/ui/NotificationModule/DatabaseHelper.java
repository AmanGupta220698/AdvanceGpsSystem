package com.example.www.advancegpstracking.ui.NotificationModule;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aman on 9/29/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="alarm_location.db";
    public static final String TABLE_NAME="location_table";
    public static final String COL_1="Id";
    public static final String COL_2="Latitude";
    public static final String COL_3="Longitude";
    public static final String COL_4="StartRange";
    public static final String COL_5="EndRange";





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +" " +
                "(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Latitude DOUBLE,Longitude DOUBLE,StartRange Double,EndRange DOUBLE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);


    }
    public boolean insertData(String latitude,String longitude,String startRange,String endRange){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,latitude);
        contentValues.put(COL_3,longitude);
        contentValues.put(COL_4,startRange);
        contentValues.put(COL_5,endRange);
       long result=db.insert(TABLE_NAME,null,contentValues);
       if (result == -1)
           return false;
       else
           return true;


    }

    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from "+TABLE_NAME,null);
        return res;

    }
    public  boolean updateData(String id,String latitude,String longitude,String startRange,String endRange){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,latitude);
        contentValues.put(COL_3,longitude);
        contentValues.put(COL_4,startRange);
        contentValues.put(COL_5,endRange);

        db.update(TABLE_NAME, contentValues,"Id=?",new String[]{id});
        return true;

    }
    public Integer deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();

       return db.delete(TABLE_NAME,"Id=?",new String[]{id});

    }
}
