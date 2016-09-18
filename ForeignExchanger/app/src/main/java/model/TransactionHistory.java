package model;

import java.util.Date;

/**
 * Created by ankur on 9/18/16.
 */
public class TransactionHistory {
    public static final String TAG = TransactionHistory.class.getSimpleName();
    public static final String TABLE = "transaction_history";

    //Labels Table Column name
    public static final String KEY_Id = "id";
    public static final String KEY_Code = "code";
    public static final String KEY_Quantity = "quantity";
    public static final String KEY_TimeStamp = "timestamp";
    public static final String KEY_Debit = "debit";
    public static final String KEY_PaidValue = "paid_value";

    private String code,debit;
    private int id;
    private double quantity, paidValue;
    private Date timestamp;

    public TransactionHistory() {

    }

    public TransactionHistory(double quantity, double paidValue, Date timestamp, String debit) {
        this.quantity = quantity;
        this.paidValue = paidValue;
        this.timestamp = timestamp;
        this.debit = debit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPaidValue() {
        return paidValue;
    }

    public void setPaidValue(double paidValue) {
        this.paidValue = paidValue;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


}