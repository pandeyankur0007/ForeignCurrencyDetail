package com.augylab.ankur.foreignexchanger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import model.AggregateCurrency;
import model.CurrentCurrencyValue;
import model.TransactionHistory;
import repo.AggregateCurrencyRepo;
import repo.CurrentCurrencyValueRepo;
import repo.TransactionHistoryRepo;


/**
 * Created by ankur on 9/18/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    // Database Name
    private static final String DATABASE_NAME = "CurrencyExchanger.db";
    private static final String TAG = DBHelper.class.getSimpleName().toString();

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("<<<<","I am in DBHelper instance");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here
        db.execSQL(TransactionHistoryRepo.createTable());
        db.execSQL(CurrentCurrencyValueRepo.createTable());
        db.execSQL(AggregateCurrencyRepo.createTable());

        Log.d("<<<<","I am in creating table instances instance");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + AggregateCurrency.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CurrentCurrencyValue.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TransactionHistory.TABLE);
        onCreate(db);
    }

    public  SQLiteDatabase getWriteDB() {

        return getWritableDatabase();
    }



}
