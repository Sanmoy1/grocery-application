package com.example.groceryapplication;

import static com.example.groceryapplication.database.TABLE_NAME;

public class PaymentContract {

    public static final String TABLE_NAME = "payments";

    public static final String COLUMN_PAYMENT_ID = "payment_id";
    public static final String COLUMN_ORDER_ID = "order_id";
    public static final String COLUMN_ORDER_COST = "order_cost";
    public static final String COLUMN_PAYMENT_AMOUNT = "payment_amount";
    public static final String COLUMN_PAYMENT_STATUS = "payment_status";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + COLUMN_PAYMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_ORDER_ID + " INTEGER,"
            + COLUMN_ORDER_COST + " REAL,"
            + COLUMN_PAYMENT_AMOUNT + " REAL,"
            + COLUMN_PAYMENT_STATUS + " TEXT"
            + ")";

    // Define getter and setter methods for each column




}
