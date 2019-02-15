package tnt_codefest.dieta.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    // New Changes

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

    // GET METHODS

    public boolean addUser(String userName, String firstName, String lastName, double height, double weight, double bmi, int current_week){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_USERNAME, userName);
        contentValues.put(USER_FIRSTNAME, firstName);
        contentValues.put(USER_LASTNAME, lastName);
        contentValues.put(USER_HEIGHT, height);
        contentValues.put(USER_WEIGHT, weight);
        contentValues.put(USER_BMI, bmi);
        contentValues.put(CURRENT_WEEK, current_week);

        long results = db.insert(USER_TABLE, null, contentValues);

        if(results == -1)
            return false;
        else
            return true;

    }



}
