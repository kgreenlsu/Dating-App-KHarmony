package com.example.kgreen.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AccountClassDB  {

    // database constants
    public static final String DB_NAME = "account.db";
    public static final int DB_VERSION = 3;

    // task table constants
    public static final String ACCOUNT_TABLE = "account";

    public static final String ACCOUNT_ID = "_id";
    public static final int ACCOUNT_ID_COL = 0;

    public static final String ACCOUNT_FIRST_NAME = "account_first";
    public static final int ACCOUNT_LIST_FIRST_COL = 1;

    public static final String ACCOUNT_LAST_NAME = "account_last_name";
    public static final int ACCOUNT_LAST_NAME_COL = 2;

    public static final String ACCOUNT_USERNAME = "username";
    public static final int ACCOUNT_USERNAME_COL = 3;

    public static final String ACCOUNT_PASSWORD = "password";
    public static final int ACCOUNT_PASSWORD_COL = 4;

    public static final String ACCOUNT_PICTURE_PATH = "picture_path";
    public static final int ACCOUNT_PICTURE_PATH_COL = 5;


    public static final String CREATE_ACCOUNT_TABLE =
            "CREATE TABLE " + ACCOUNT_TABLE + " (" +
                    ACCOUNT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ACCOUNT_FIRST_NAME + " TEXT NOT NULL, " +
                    ACCOUNT_LAST_NAME + " TEXT NOT NULL, " +
                    ACCOUNT_USERNAME + " TEXT NOT NULL, " +
                    ACCOUNT_PASSWORD + " TEXT NOT NULL, " +
                    ACCOUNT_PICTURE_PATH + " TEXT);";


    public static final String DROP_ACCOUNT_TABLE =
            "DROP TABLE IF EXISTS " + ACCOUNT_TABLE + ";";


    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name,
                        SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {

            // create tables
            db.execSQL(CREATE_ACCOUNT_TABLE);



        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            Log.d("Task list", "Upgrading db from version "
                    + oldVersion + " to " + newVersion);

            db.execSQL(DROP_ACCOUNT_TABLE);
            onCreate(db);
        }
    }

    // database and database helper objects
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    // constructor
    public AccountClassDB(Context context) {
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
    }

    // private methods
    private void openReadableDB() {
        db = dbHelper.getReadableDatabase();
    }

    private void openWritableDB() {
        db = dbHelper.getWritableDatabase();
    }

    private void closeDB() {
        if (db != null)
            db.close();
    }


    public Account getAcc(String name) {
        String where = "username =?";
        String[] whereArgs = { name };

        this.openReadableDB();
        Cursor cursor = db.query(ACCOUNT_TABLE,
                null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Account acc = getAccFromCursor(cursor);
        if (cursor != null)
            cursor.close();
        this.closeDB();

        return acc;
    }

    public Account getAcc2(String name) {
        String where = ACCOUNT_USERNAME + "= ?";
        String[] whereArgs = { name };

        this.openReadableDB();
        Cursor cursor = db.query(ACCOUNT_TABLE,
                null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Account acc = getAccFromCursor(cursor);
        if (cursor != null)
            cursor.close();
        this.closeDB();

        return acc;
    }

    public Account user(int id) {
        String where = ACCOUNT_ID + "= ?";
        String[] whereArgs = { Integer.toString(id) };

        this.openReadableDB();
        Cursor cursor = db.query(ACCOUNT_TABLE,
                null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Account acc = getAccFromCursor(cursor);
        if (cursor != null)
            cursor.close();
        this.closeDB();

        return acc;
    }

    public Account password(String password) {
        String where = "password =?";
        String[] whereArgs = { password };

        this.openReadableDB();
        Cursor cursor = db.query(ACCOUNT_TABLE,
                null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Account acc = getAccFromCursor(cursor);
        if (cursor != null)
            cursor.close();
        this.closeDB();

        return acc;
    }

    private static Account getAccFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0){
            return null;
        }
        else {
            try {
                Account account = new Account(
                        cursor.getInt(ACCOUNT_ID_COL),
                        cursor.getString(ACCOUNT_LIST_FIRST_COL),
                        cursor.getString(ACCOUNT_LAST_NAME_COL),
                        cursor.getString(ACCOUNT_USERNAME_COL),
                        cursor.getString(ACCOUNT_PASSWORD_COL),
                        cursor.getString(ACCOUNT_PICTURE_PATH_COL));
                return account;
            }
            catch(Exception e) {
                return null;
            }
        }
    }

    public long insertAcc(Account account) {
        ContentValues cv = new ContentValues();
        cv.put(ACCOUNT_ID, account.getId());
        cv.put(ACCOUNT_FIRST_NAME, account.getFirstName());
        cv.put(ACCOUNT_LAST_NAME, account.getLastName());
        cv.put(ACCOUNT_USERNAME, account.getUserName());
        cv.put(ACCOUNT_PASSWORD, account.getPassword());
        cv.put(ACCOUNT_PICTURE_PATH, account.getPicPath());

        this.openWritableDB();


        long rowID = db.insert(ACCOUNT_TABLE, null, cv);


        this.closeDB();

        return rowID;
    }

    public int updateAcc(Account account1) {
        ContentValues cv = new ContentValues();
        cv.put(ACCOUNT_ID, account1.getId());
        cv.put(ACCOUNT_FIRST_NAME, account1.getFirstName());
        cv.put(ACCOUNT_LAST_NAME, account1.getLastName());
        cv.put(ACCOUNT_USERNAME, account1.getUserName());
        cv.put(ACCOUNT_PASSWORD, account1.getPassword());
        cv.put(ACCOUNT_PICTURE_PATH, account1.getPicPath());

        String where = ACCOUNT_ID + "= ?";
        String[] whereArgs = { String.valueOf(account1.getId()) };

        this.openWritableDB();
        int rowCount = db.update(ACCOUNT_TABLE, cv, where, whereArgs);
        this.closeDB();

        return rowCount;
    }

    public int deleteAcc(long id) {
        String where = ACCOUNT_ID + "= ?";
        String[] whereArgs = { String.valueOf(id) };

        this.openWritableDB();
        int rowCount = db.delete(ACCOUNT_TABLE, where, whereArgs);
        this.closeDB();

        return rowCount;
    }
}
