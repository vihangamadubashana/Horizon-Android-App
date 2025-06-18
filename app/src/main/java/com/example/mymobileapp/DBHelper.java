package com.example.mymobileapp;

import android.content.Context;
import android.database.Cursor;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Details.db";
    public static final String TABLE_NAME = "Persons";
    public static final String FIRST_NAME = "firstname";
    public static final String LAST_NAME = "lastname";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String CONFIRM_PASSWORD = "confirmpassword";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
        // Create or open the database
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Define the create table query
        String CREATE_USERS_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + " (" +
                "`" + FIRST_NAME + "` TEXT , " +
                "`" + LAST_NAME + "` TEXT, " +
                "`" + EMAIL + "` TEXT PRIMARY KEY, " +
                "`" + PASSWORD + "` TEXT, " +
                "`" + CONFIRM_PASSWORD + "` TEXT)";

        // Execute the query to create the table
        db.execSQL(CREATE_USERS_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the existing table if it exists
        db.execSQL("DROP TABLE IF EXISTS users");
        // Create the table again
        onCreate(db);
    }
    public boolean insertData(String firstname, String lastname, String email, String password, String confirmpassword) {
        // Get the writable database
        SQLiteDatabase db = this.getWritableDatabase();
        // Create a new ContentValues object to store the values to be inserted
        ContentValues values = new ContentValues();
        values.put(FIRST_NAME,firstname);
        values.put(LAST_NAME,lastname);
        values.put(EMAIL,email);
        values.put(PASSWORD,password);
        values.put(CONFIRM_PASSWORD, confirmpassword);

        // Insert the values into the table
        long result = db.insert(TABLE_NAME, null, values);
        // Check if the insertion was successful
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public boolean checkEmail(String email) {
        // Get the readable database
        SQLiteDatabase db = this.getWritableDatabase();
        // Execute a query to retrieve the rows with matching email
        Cursor cursor = db.rawQuery("SELECT * FROM Persons WHERE email=?", new String[] {email});
        // Check if there are any rows returned
        if(cursor.getCount()>0){
            return true;
        }else{
            // Email does not exist in the table
            return false;
        }
    }
    public boolean checkEmailPassword(String email, String password) {
        // Get the readable database
        SQLiteDatabase db = this.getWritableDatabase();
        // Execute a query to retrieve the rows with matching email and password
        Cursor cursor = db.rawQuery("SELECT * FROM Persons WHERE email=? AND password=?", new String[] {email, password});
        // Check if there are any rows returned
        if(cursor.getCount()>0){
            // Email and password combination exists in the table
            return true;
        }else{
            // Email and password combination does not exist in the table
            return false;
        }
    }
    public int updatepass(String email, String password,String confirm) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PASSWORD, password);
        values.put(CONFIRM_PASSWORD, confirm);


        return DB.update(TABLE_NAME, values, EMAIL + "=?", new String[]{email});
    }
}