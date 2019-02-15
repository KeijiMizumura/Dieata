package tnt_codefest.dieta.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    // Database Details
    private static final String DATABASE_NAME = "dieata.db";
    private static int DATABASE_VERSION = 1;

    // User Table
    private static final String USER_TABLE = "users";
    private static final String USER_ID = "user_id";
    private static final String USER_USERNAME = "user_name";
    private static final String USER_FIRSTNAME = "first_name";
    private static final String USER_LASTNAME = "last_name";
    private static final String USER_HEIGHT = "height";
    private static final String USER_WEIGHT = "weight";
    private static final String USER_BMI = "bmi";
    private static final String CURRENT_WEEK = "current_week";

    // Create User table

    private static final String CREATE_USER = "CREATE TABLE " + USER_TABLE + "(" +
            USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            USER_USERNAME + " TEXT," +
            USER_FIRSTNAME + " TEXT, " +
            USER_LASTNAME + " TEXT, " +
            USER_HEIGHT + " DOUBLE, " +
            USER_WEIGHT + " DOUBLE, " +
            USER_BMI + " DOUBLE, " +
            CURRENT_WEEK + " INTEGER);";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);

        onCreate(db);
    }
}
