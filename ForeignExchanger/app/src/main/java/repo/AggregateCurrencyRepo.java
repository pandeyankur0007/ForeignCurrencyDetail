package repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.augylab.ankur.foreignexchanger.DBHelper;

import java.sql.Date;

import model.AggregateCurrency;
import model.TransactionHistory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 * Created by ankur on 9/18/16.
 */
public class AggregateCurrencyRepo {
    private AggregateCurrency aggregateCurrency;


    public AggregateCurrencyRepo() {
        aggregateCurrency = new AggregateCurrency();
    }

    public static String createTable() {
        return "CREATE TABLE IF NOT EXISTS "  + AggregateCurrency.TABLE  + "("
                + AggregateCurrency.KEY_Id  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AggregateCurrency.KEY_Code + " TEXT, "
                + AggregateCurrency.KEY_Quantity + " REAL, "
                + AggregateCurrency.KEY_TotalInvestment + " REAL "+ ")";
    }

    public static void insertIntoTransactionHistory(AggregateCurrency aggregateCurrency, boolean debitStatus, Context context) {

        int aggregateId=0;

        SQLiteDatabase db = (new DBHelper(context)).getWriteDB();
        String code =null;
        double qty =0;
        double paidValue =0;


        ContentValues values = new ContentValues();


        // SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + "transaction_history"   + " where " + "code" + " = " + "'" + aggregateCurrency.getCode() + "'", null);
        if (cursor.moveToNext() == true) {
            code = cursor.getString(1);
            qty = cursor.getDouble(2);
            paidValue = cursor.getDouble(5);
            // history = cursor.getString(4);
            //usdResult = true;


            if(debitStatus) {
                values.put(AggregateCurrency.KEY_Code, aggregateCurrency.getCode());
                values.put(AggregateCurrency.KEY_Quantity,qty - aggregateCurrency.getQuantity() );
                values.put(TransactionHistory.KEY_PaidValue, paidValue - aggregateCurrency.getTotalInvestment());
                values.put(TransactionHistory.KEY_TimeStamp,new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
                values.put(TransactionHistory.KEY_Debit,String.valueOf("debit"));
            } else {
                values.put(AggregateCurrency.KEY_Code, aggregateCurrency.getCode());
                values.put(AggregateCurrency.KEY_Quantity, qty + aggregateCurrency.getQuantity());
                values.put(TransactionHistory.KEY_PaidValue, paidValue + aggregateCurrency.getTotalInvestment());
                values.put(TransactionHistory.KEY_TimeStamp,new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
                values.put(TransactionHistory.KEY_Debit,String.valueOf("Credit"));
            }

        } else {
            if (debitStatus) {
                values.put(AggregateCurrency.KEY_Code, aggregateCurrency.getCode());
                values.put(AggregateCurrency.KEY_Quantity, qty - aggregateCurrency.getQuantity());
                values.put(TransactionHistory.KEY_PaidValue, paidValue - aggregateCurrency.getTotalInvestment());
                values.put(TransactionHistory.KEY_TimeStamp, new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
                values.put(TransactionHistory.KEY_Debit, String.valueOf("debit"));
            } else {
                values.put(AggregateCurrency.KEY_Code, aggregateCurrency.getCode());
                values.put(AggregateCurrency.KEY_Quantity, qty + aggregateCurrency.getQuantity());
                values.put(TransactionHistory.KEY_PaidValue, paidValue + aggregateCurrency.getTotalInvestment());
                values.put(TransactionHistory.KEY_TimeStamp, new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
                values.put(TransactionHistory.KEY_Debit, String.valueOf("Credit"));
            }
        }

        cursor.close();
        // db.close();

        Log.d(">>>>>","record added");
        //values.put(AggregateCurrency.KEY_Id, aggregateCurrency.getId());


        // Inserting Row
        aggregateId=(int)db.insert(TransactionHistory.TABLE, null, values);
        db.close();

    }


    public static void insertIntoAggregateCurrent(AggregateCurrency aggregateCurrency, boolean debitStatus, Context context) {

        int aggregateId=0;
        SQLiteDatabase db = (new DBHelper(context)).getWriteDB();
        String code =null;
        double qty =0;
        double paidValue =0;


        ContentValues values = new ContentValues();


        // SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + "aggregate_currency"   + " where " + "code" + " = " + "'" + aggregateCurrency.getCode() + "'", null);
        if (cursor.moveToNext() == true) {
            code = cursor.getString(1);
            qty = cursor.getDouble(2);
            paidValue = cursor.getDouble(3);
            // history = cursor.getString(4);
            //usdResult = true;


            if(debitStatus) {
                values.put(AggregateCurrency.KEY_Code, aggregateCurrency.getCode());
                values.put(AggregateCurrency.KEY_Quantity,qty - aggregateCurrency.getQuantity() );
                values.put(AggregateCurrency.KEY_TotalInvestment, paidValue - aggregateCurrency.getTotalInvestment());

            } else {
                values.put(AggregateCurrency.KEY_Code, aggregateCurrency.getCode());
                values.put(AggregateCurrency.KEY_Quantity, qty + aggregateCurrency.getQuantity());
                values.put(AggregateCurrency.KEY_TotalInvestment, paidValue + aggregateCurrency.getTotalInvestment());

            }

            int result = db.update(AggregateCurrency.TABLE, values, "code=?", new String[]{aggregateCurrency.getCode() + ""});
            Log.e("Result ", result + "");

        } else {

            if(debitStatus) {
                values.put(AggregateCurrency.KEY_Code, aggregateCurrency.getCode());
                values.put(AggregateCurrency.KEY_Quantity,qty - aggregateCurrency.getQuantity() );
                values.put(AggregateCurrency.KEY_TotalInvestment, paidValue - aggregateCurrency.getTotalInvestment());

            } else {
                values.put(AggregateCurrency.KEY_Code, aggregateCurrency.getCode());
                values.put(AggregateCurrency.KEY_Quantity, qty + aggregateCurrency.getQuantity());
                values.put(AggregateCurrency.KEY_TotalInvestment, paidValue + aggregateCurrency.getTotalInvestment());

            }


            aggregateId=(int)db.insert(AggregateCurrency.TABLE, null, values);
            Log.e("Result ", aggregateId + "");
        }

        cursor.close();
        // db.close();

        Log.d(">>>>>","record added");
        //values.put(AggregateCurrency.KEY_Id, aggregateCurrency.getId());


        // Inserting Row

        db.close();

    }

    public static int insert(AggregateCurrency aggregateCurrency, boolean debitStatus, Context context) {
       // int aggregateId;

        try {

            insertIntoTransactionHistory(aggregateCurrency, debitStatus, context);
            insertIntoAggregateCurrent(aggregateCurrency, debitStatus, context);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return -1;


    }


    public static ArrayList<TransactionHistory> getParticularHistoryRecord(Context context, String code) {

        ArrayList<TransactionHistory> newList = new ArrayList<>();

        int aggregateId=0;
        SQLiteDatabase db = (new DBHelper(context)).getWriteDB();

        double qty =0;
        double paidValue =0;
        String timeStamp = null;
        String debit = null;

        Cursor cursor = db.rawQuery("select * from " + TransactionHistory.TABLE + " where " + TransactionHistory.KEY_Code + " = " + "'" + code + "'", null);
        while(cursor.moveToNext() == true) {

            qty = cursor.getInt(2);
            timeStamp = cursor.getString(3);
            debit = cursor.getString(4);
            paidValue = cursor.getDouble(5);

            newList.add(new TransactionHistory(qty, paidValue,Date.valueOf(timeStamp),debit));



        }
        cursor.close();
        db.close();

        return  newList;


    }

    public static ArrayList<AggregateCurrency> getRecords(Context context) {

        ArrayList<AggregateCurrency> newList = new ArrayList<>();

        int aggregateId=0;
        SQLiteDatabase db = (new DBHelper(context)).getWriteDB();
        String code =null;
        double qty =0;
        double paidValue =0;

        Cursor cursor = db.rawQuery("select * from " + AggregateCurrency.TABLE, null);
        while (cursor.moveToNext() == true) {
            code = cursor.getString(1);
            qty = cursor.getInt(2);
            paidValue = cursor.getDouble(3);
            newList.add(new AggregateCurrency(code, paidValue,qty));
        }
        cursor.close();
        db.close();


        return  newList;


    }


}

