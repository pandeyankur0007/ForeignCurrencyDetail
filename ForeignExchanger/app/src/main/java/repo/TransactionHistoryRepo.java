package repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.augylab.ankur.foreignexchanger.DBHelper;

import model.TransactionHistory;

/**
 * Created by ankur on 9/18/16.
 */
public class TransactionHistoryRepo {

    private TransactionHistory transactionHistory;

    public TransactionHistoryRepo() {
        transactionHistory = new TransactionHistory();
    }

    public static String createTable() {
        return "CREATE TABLE IF NOT EXISTS " + TransactionHistory.TABLE  + "("
                + TransactionHistory.KEY_Id  + " INTEGER PRIMARY KEY, "
                + TransactionHistory.KEY_Code + " TEXT, "
                + TransactionHistory.KEY_Quantity + " REAL, "
                + TransactionHistory.KEY_TimeStamp + " TEXT, "
                + TransactionHistory.KEY_Debit + " TEXT, "
                + TransactionHistory.KEY_PaidValue + " REAL "
                +")";
    }

   /* public int insert(TransactionHistory transactionHistory) {
        int historyId;
        SQLiteDatabase db = (new DBHelper()).getWriteDB();
        ContentValues values = new ContentValues();
        values.put(TransactionHistory.KEY_Id, transactionHistory.getId());
        values.put(TransactionHistory.KEY_Code, transactionHistory.getCode());
        values.put(TransactionHistory.KEY_Quantity, transactionHistory.getQuantity());
        values.put(TransactionHistory.KEY_TimeStamp, String.valueOf(transactionHistory.getTimestamp()));
        values.put(TransactionHistory.KEY_Debit, transactionHistory.getDebit());
        values.put(TransactionHistory.KEY_PaidValue, transactionHistory.getPaidValue());

        // Inserting Row
        historyId=(int)db.insert(TransactionHistory.TABLE, null, values);



        return historyId;*/
   // }





}
