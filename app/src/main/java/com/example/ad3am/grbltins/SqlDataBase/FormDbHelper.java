package com.example.ad3am.grbltins.SqlDataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FormDbHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String UID = "_id";
    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Form.db";
    public static final String TABLE_NAME = "forms";
    public static final String COLUMN_WAY_NAME = "wayname";
    public static final String COLUMN_WAY_NUMBER = "waynum";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_AREA = "are";
    public static final String COLUMN_ROAD_TYBE = "roadtype";
    public static final String COLUMN_ROAD_IMPORTANTS = "roadImportants";
    public static final String COLUMN_ROAD_EXPLANATION = "roadExplanation";
    public static final String COLUMN_FLOOR_SIGN = "floorSign";
    public static final String COLUMN_UPPER_SIGN = "upperSign";
    public static final String COLUMN_ACTUAL_SPEED = "actualSpeed";
    public static final String COLUMN_DESIGN_SPEED = "designSpeed";
    public static final String COLUMN_TRAFFIC_REPORT = "trafficReport";
    public static final String COLUMN_PROGRESS_OPERATION = "progressOperation";
    public static final String COLUMN_KM_LOCATION = "kmLocation";
    public static final String COLUMN_ACCIDENT_NUM = "accidentNum";
    public static final String COLUMN_KILLED_NUM = "killedNum";
    public static final String COLUMN_INJURIED_NUM = "injuredNum";
    public static final String COLUMN_FIRST_NOTE = "firstNote";
    public static final String COLUMN_SECOND_NOTE = "secondNote";
    public static final String COLUMN_THIRD_NOTE = "thirdNote";
    public static final String COLUMN_LINING_NOTE = "liningNote";
    public static final String COLUMN_REFLECTION_NOTE = "reflectionNote";
    public static final String COLUMN_UPPER_SIGNS_NOTE = "upperSignsNote";
    public static final String COLUMN_FLOOR_SIGNS_NOTE = "floorSignsNote";
    public static final String COLUMN_FIFTH_NOTE = "fifthNote";
    public static final String COLUMN_SAFE_SPACES = "safeSpaces";
    public static final String COLUMN_RANDOM_TURNS = "randomTurns";
    public static final String COLUMN_WEATHER_EFFECT = "weatherEffect";
    public static final String COLUMN_SHORT_ONE = "shortOne";
    public static final String COLUMN_SHORT_TWO = "shortTwo";
    public static final String COLUMN_SHORT_THREE = "shortThree";
    public static final String COLUMN_SHORT_FOUR = "shortFour";
    public static final String COLUMN_SHORT_FIVE = "shortFive";
    public static final String COLUMN_LONG_ONE = "longOne";
    public static final String COLUMN_LONG_TWO = "longTwo";
    public static final String COLUMN_LONG_THREE = "longThree";
    public static final String COLUMN_LONG_FOUR = "longFour";
    public static final String COLUMN_LONG_FIVE = "longFive";

    private static final String CREATE_TABLE =
            "CREATE TABLE " + FormDbHelper.TABLE_NAME + " (" +
                    FormDbHelper.UID+ " INTEGER PRIMARY KEY," +
                    FormDbHelper.COLUMN_WAY_NAME + " TEXT," +
                    FormDbHelper.COLUMN_WAY_NUMBER + " TEXT,"+
                    FormDbHelper.COLUMN_DATE + " TEXT," +
                    FormDbHelper.COLUMN_AREA + " TEXT ," +
                    FormDbHelper.COLUMN_ROAD_TYBE + " TEXT ," +
                    FormDbHelper.COLUMN_ROAD_IMPORTANTS + " TEXT ," +
                    FormDbHelper.COLUMN_ROAD_EXPLANATION + " TEXT ," +
                    FormDbHelper.COLUMN_FLOOR_SIGN + " TEXT ," +
                    FormDbHelper.COLUMN_UPPER_SIGN + " TEXT ," +
                    FormDbHelper.COLUMN_ACTUAL_SPEED + " TEXT ," +
                    FormDbHelper.COLUMN_DESIGN_SPEED + " TEXT ," +
                    FormDbHelper.COLUMN_TRAFFIC_REPORT + " TEXT ," +
                    FormDbHelper.COLUMN_PROGRESS_OPERATION + " TEXT ," +
                    FormDbHelper.COLUMN_KM_LOCATION + " TEXT ," +
                    FormDbHelper.COLUMN_ACCIDENT_NUM + " TEXT ," +
                    FormDbHelper.COLUMN_KILLED_NUM + " TEXT ," +
                    FormDbHelper.COLUMN_INJURIED_NUM + "TEXT ," +
                    FormDbHelper.COLUMN_FIRST_NOTE + " TEXT ," +
                    FormDbHelper.COLUMN_SECOND_NOTE + " TEXT ," +
                    FormDbHelper.COLUMN_THIRD_NOTE + " TEXT ," +
                    FormDbHelper.COLUMN_LINING_NOTE + " TEXT ," +
                    FormDbHelper.COLUMN_REFLECTION_NOTE + " TEXT ," +
                    FormDbHelper.COLUMN_UPPER_SIGNS_NOTE + " TEXT ," +
                    FormDbHelper.COLUMN_FLOOR_SIGNS_NOTE + " TEXT ," +
                    FormDbHelper.COLUMN_FIFTH_NOTE + " TEXT ," +
                    FormDbHelper.COLUMN_SAFE_SPACES + " TEXT ," +
                    FormDbHelper.COLUMN_RANDOM_TURNS + " TEXT ," +
                    FormDbHelper.COLUMN_WEATHER_EFFECT + " TEXT ," +
                    FormDbHelper.COLUMN_SHORT_ONE + " TEXT ," +
                    FormDbHelper.COLUMN_SHORT_TWO + " TEXT ," +
                    FormDbHelper.COLUMN_SHORT_THREE + " TEXT ," +
                    FormDbHelper.COLUMN_SHORT_FOUR + " TEXT ," +
                    FormDbHelper.COLUMN_SHORT_FIVE + " TEXT ," +
                    FormDbHelper.COLUMN_LONG_ONE + " TEXT ," +
                    FormDbHelper.COLUMN_LONG_TWO + " TEXT ," +
                    FormDbHelper.COLUMN_LONG_THREE + " TEXT ," +
                    FormDbHelper.COLUMN_LONG_FOUR + " TEXT ," +
                    FormDbHelper.COLUMN_LONG_FIVE + " TEXT)";

    private static final String Drop_TABLE =
            "DROP TABLE IF EXISTS " + FormDbHelper.TABLE_NAME;



    public FormDbHelper(Context context) {
        super(context,TABLE_NAME ,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Drop_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onDowngrade(db, oldVersion, newVersion);
    }
}
