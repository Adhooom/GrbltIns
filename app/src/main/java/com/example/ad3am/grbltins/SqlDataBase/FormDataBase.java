package com.example.ad3am.grbltins.SqlDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class FormDataBase {
    FormDbHelper helper ;

    private FormDataBase(Context context) {
        helper = new FormDbHelper(context);
    }
    public long insert(String wayNam, String wayNum, String date, String area, String roadType, String roadImportants,
            String roadExplanition, String floorSign, String upperSign, String actualSpeed, String designSpeed,
            String trafficReport, String progressOperation, String kmLocation, String accidentNum, String killedNum,
            String injuryNum, String firstNote, String secondNote, String thirdNotes,
            String liningNote, String reflectionNote, String upperSignsNotes, String floorSignsNotes,
            String fifthNote, String safeSpaces, String randomTurns,String weatherEffect,
            String shortTermOne, String shortTermTwo, String shortTermThree, String shortTermFour,
            String shortTermFive, String longTermOne, String longTermTwo, String longTermThree,
            String longTermFour, String longTermFive
    ){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FormDbHelper.COLUMN_WAY_NAME,wayNam);
        values.put(FormDbHelper.COLUMN_WAY_NUMBER,wayNum);
        values.put(FormDbHelper.COLUMN_DATE,date);
        values.put(FormDbHelper.COLUMN_AREA,area);
        values.put(FormDbHelper.COLUMN_ROAD_TYBE,roadType);
        values.put(FormDbHelper.COLUMN_ROAD_IMPORTANTS,roadImportants);
        values.put(FormDbHelper.COLUMN_ROAD_EXPLANATION,roadExplanition);
        values.put(FormDbHelper.COLUMN_FLOOR_SIGN,floorSign);
        values.put(FormDbHelper.COLUMN_UPPER_SIGN,upperSign);
        values.put(FormDbHelper.COLUMN_ACTUAL_SPEED,actualSpeed);
        values.put(FormDbHelper.COLUMN_DESIGN_SPEED,designSpeed);
        values.put(FormDbHelper.COLUMN_TRAFFIC_REPORT,trafficReport);
        values.put(FormDbHelper.COLUMN_PROGRESS_OPERATION,progressOperation);
        values.put(FormDbHelper.COLUMN_KM_LOCATION,kmLocation);
        values.put(FormDbHelper.COLUMN_ACCIDENT_NUM,accidentNum);
        values.put(FormDbHelper.COLUMN_KILLED_NUM,killedNum);
        values.put(FormDbHelper.COLUMN_INJURIED_NUM,injuryNum);
        values.put(FormDbHelper.COLUMN_FIRST_NOTE,firstNote);
        values.put(FormDbHelper.COLUMN_SECOND_NOTE,secondNote);
        values.put(FormDbHelper.COLUMN_THIRD_NOTE,thirdNotes);
        values.put(FormDbHelper.COLUMN_LINING_NOTE,liningNote);
        values.put(FormDbHelper.COLUMN_REFLECTION_NOTE,reflectionNote);
        values.put(FormDbHelper.COLUMN_UPPER_SIGNS_NOTE,upperSignsNotes);
        values.put(FormDbHelper.COLUMN_FLOOR_SIGNS_NOTE,floorSignsNotes);
        values.put(FormDbHelper.COLUMN_FIFTH_NOTE,fifthNote);
        values.put(FormDbHelper.COLUMN_SAFE_SPACES,safeSpaces);
        values.put(FormDbHelper.COLUMN_RANDOM_TURNS,randomTurns);
        values.put(FormDbHelper.COLUMN_WEATHER_EFFECT,weatherEffect);
        values.put(FormDbHelper.COLUMN_SHORT_ONE,shortTermOne);
        values.put(FormDbHelper.COLUMN_SHORT_TWO,shortTermTwo);
        values.put(FormDbHelper.COLUMN_SHORT_THREE,shortTermThree);
        values.put(FormDbHelper.COLUMN_SHORT_FOUR,shortTermFour);
        values.put(FormDbHelper.COLUMN_SHORT_FIVE,shortTermFive);
        values.put(FormDbHelper.COLUMN_LONG_ONE,longTermOne);
        values.put(FormDbHelper.COLUMN_LONG_TWO,longTermTwo);
        values.put(FormDbHelper.COLUMN_LONG_THREE,longTermThree);
        values.put(FormDbHelper.COLUMN_LONG_FOUR,longTermFour);
        values.put(FormDbHelper.COLUMN_LONG_FIVE,longTermFive);

        long id = db.insert(FormDbHelper.TABLE_NAME, null, values);
        return id;
    }


}
