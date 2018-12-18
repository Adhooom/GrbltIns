package com.example.ad3am.grbltins.SqlDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.ad3am.grbltins.model.NewInspectionFormPojo;

import java.util.ArrayList;
import java.util.List;

public class FormDataBase {

    private final String TAG = "FormDataBase";
    FormDbHelper helper;

    public FormDataBase(Context context) {
        helper = new FormDbHelper(context);
        Log.i("db", " db constructor called");
    }

    public long insert( String wayName, String wayNum, String engName,String date ) {
//    )public long insert(String wayNam, String wayNum, String date, String area, String roadType, String roadImportants,
//            String roadExplanition, String floorSign, String upperSign, String actualSpeed, String designSpeed,
//            String trafficReport, String progressOperation, String kmLocation, String accidentNum, String killedNum,
//            String injuryNum, String firstNote, String secondNote, String thirdNotes,
//            String liningNote, String reflectionNote, String upperSignsNotes, String floorSignsNotes,
//            String fifthNote, String safeSpaces, String randomTurns,String weatherEffect,
//            String shortTermOne, String shortTermTwo, String shortTermThree, String shortTermFour,
//            String shortTermFive, String longTermOne, String longTermTwo, String longTermThree,
//            String longTermFour, String longTermFive
//    ){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FormDbHelper.COLUMN_WAY_NAME, wayName);
        values.put(FormDbHelper.COLUMN_WAY_NUMBER,wayNum);
        values.put(FormDbHelper.COLUMN_ENG_NAME,engName);
        values.put(FormDbHelper.COLUMN_DATE,date);
//        values.put(FormDbHelper.COLUMN_AREA,area);
//        values.put(FormDbHelper.COLUMN_ROAD_TYBE,roadType);
//        values.put(FormDbHelper.COLUMN_ROAD_IMPORTANTS,roadImportants);
//        values.put(FormDbHelper.COLUMN_ROAD_EXPLANATION,roadExplanition);
//        values.put(FormDbHelper.COLUMN_FLOOR_SIGN,floorSign);
//        values.put(FormDbHelper.COLUMN_UPPER_SIGN,upperSign);
//        values.put(FormDbHelper.COLUMN_ACTUAL_SPEED,actualSpeed);
//        values.put(FormDbHelper.COLUMN_DESIGN_SPEED,designSpeed);
//        values.put(FormDbHelper.COLUMN_TRAFFIC_REPORT,trafficReport);
//        values.put(FormDbHelper.COLUMN_PROGRESS_OPERATION,progressOperation);
//        values.put(FormDbHelper.COLUMN_KM_LOCATION,kmLocation);
//        values.put(FormDbHelper.COLUMN_ACCIDENT_NUM,accidentNum);
//        values.put(FormDbHelper.COLUMN_KILLED_NUM,killedNum);
//        values.put(FormDbHelper.COLUMN_INJURIED_NUM,injuryNum);
//        values.put(FormDbHelper.COLUMN_FIRST_NOTE,firstNote);
//        values.put(FormDbHelper.COLUMN_SECOND_NOTE,secondNote);
//        values.put(FormDbHelper.COLUMN_THIRD_NOTE,thirdNotes);
//        values.put(FormDbHelper.COLUMN_LINING_NOTE,liningNote);
//        values.put(FormDbHelper.COLUMN_REFLECTION_NOTE,reflectionNote);
//        values.put(FormDbHelper.COLUMN_UPPER_SIGNS_NOTE,upperSignsNotes);
//        values.put(FormDbHelper.COLUMN_FLOOR_SIGNS_NOTE,floorSignsNotes);
//        values.put(FormDbHelper.COLUMN_FIFTH_NOTE,fifthNote);
//        values.put(FormDbHelper.COLUMN_SAFE_SPACES,safeSpaces);
//        values.put(FormDbHelper.COLUMN_RANDOM_TURNS,randomTurns);
//        values.put(FormDbHelper.COLUMN_WEATHER_EFFECT,weatherEffect);
//        values.put(FormDbHelper.COLUMN_SHORT_ONE,shortTermOne);
//        values.put(FormDbHelper.COLUMN_SHORT_TWO,shortTermTwo);
//        values.put(FormDbHelper.COLUMN_SHORT_THREE,shortTermThree);
//        values.put(FormDbHelper.COLUMN_SHORT_FOUR,shortTermFour);
//        values.put(FormDbHelper.COLUMN_SHORT_FIVE,shortTermFive);
//        values.put(FormDbHelper.COLUMN_LONG_ONE,longTermOne);
//        values.put(FormDbHelper.COLUMN_LONG_TWO,longTermTwo);
//        values.put(FormDbHelper.COLUMN_LONG_THREE,longTermThree);
//        values.put(FormDbHelper.COLUMN_LONG_FOUR,longTermFour);
//        values.put(FormDbHelper.COLUMN_LONG_FIVE,longTermFive);
        long id = db.insert(FormDbHelper.TABLE_NAME, null, values);
        Log.i("db", "insert method called " + id);
        return id;
    }

    public ArrayList<NewInspectionFormPojo> view() {
        ArrayList<NewInspectionFormPojo> items = new ArrayList<>();
        try {
            Log.i(TAG, "View is called");
            SQLiteDatabase db = helper.getReadableDatabase();
            Log.i(TAG, "help readable db is created");
            String[] projection = {
                    FormDbHelper.COLUMN_WAY_NAME,FormDbHelper.COLUMN_WAY_NUMBER,FormDbHelper.COLUMN_ENG_NAME,FormDbHelper.COLUMN_DATE

            };

            Cursor cursor = db.query(
                    FormDbHelper.TABLE_NAME,   // The table to query
                    projection,             // The array of columns to return (pass null to get all)
                    null,
                    null,
                    null,                   // don't group the rows
                    null,                   // don't filter by row groups
                    null
            );
            Log.i(TAG, "help readable db is created");
            String[] columnnames = cursor.getColumnNames();

            while (cursor.moveToNext()) {
                String wayName = cursor.getString(0);
                Log.i(TAG, "Way Name = " + wayName);
                String wayNum = cursor.getString(1);
                Log.i(TAG,"way num ="+wayNum);
                String engName = cursor.getString(2);
                Log.i(TAG,"eng name ="+engName);
                String date = cursor.getString(3);
                Log.i(TAG,"date ="+date);

                NewInspectionFormPojo formBojo = new NewInspectionFormPojo();
                formBojo.setWayName(wayName);
                formBojo.setWayNum(wayNum);
                formBojo.setEngName(engName);
                formBojo.setDate(date);
                items.add(formBojo);
            }
            Log.i(TAG, (String.valueOf(items.size())));
            Log.i(TAG, "data has been read");
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

}
