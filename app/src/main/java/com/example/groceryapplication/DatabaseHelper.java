package com.example.groceryapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "grocery_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_DELIVERY = "delivery";
    private static final String TABLE_PAYMENT = "payment";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_STREET_ADDRESS = "street_address";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_STATE = "state";
    private static final String COLUMN_ZIPCODE = "zipcode";
    private static final String COLUMN_PAYMENT_ID = "payment_id";
    private static final String COLUMN_ORDER_COST = "order_cost";
    private static final String COLUMN_PAYMENT_AMOUNT = "payment_amount";
    private static final String COLUMN_PAYMENT_STATUS = "payment_status";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_DELIVERY + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_STREET_ADDRESS + " TEXT, " +
                COLUMN_CITY + " TEXT, " +
                COLUMN_STATE + " TEXT, " +
                COLUMN_ZIPCODE + " TEXT)";
        db.execSQL(createTableQuery);

        String createPaymentTableQuery = "CREATE TABLE " + TABLE_PAYMENT + "(" +
                COLUMN_PAYMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ORDER_COST + " REAL, " +
                COLUMN_PAYMENT_AMOUNT + " REAL, " +
                COLUMN_PAYMENT_STATUS + " TEXT)";
        db.execSQL(createPaymentTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DELIVERY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAYMENT);
        onCreate(db);
    }

    public long addDelivery(String streetAddress, String city, String state, String zipcode) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_STREET_ADDRESS, streetAddress);
        values.put(COLUMN_CITY, city);
        values.put(COLUMN_STATE, state);
        values.put(COLUMN_ZIPCODE, zipcode);
        long result = db.insert(TABLE_DELIVERY, null, values);
        db.close();
        return result;
    }
    public long addPayment(double orderCost, double paymentAmount, String paymentStatus) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ORDER_COST, orderCost);
        values.put(COLUMN_PAYMENT_AMOUNT, paymentAmount);
        values.put(COLUMN_PAYMENT_STATUS, paymentStatus);
        long result = db.insert(TABLE_PAYMENT, null, values);
        db.close();
        return result;
    }
}
