package model;

/**
 * Created by ankur on 9/18/16.
 */
public class AggregateCurrency {
    public static final String TAG = AggregateCurrency.class.getSimpleName();
    public static final String TABLE = "aggregate_currency";

    //Labels Table Column name
    public static final String KEY_Id = "id";
    public static final String KEY_Code = "code";
    public static final String KEY_TotalInvestment = "total_ivestment";
    public static final String KEY_Quantity = "quantity";

    private int id;
    private String code;
    private double totalInvestment, quantity;

    public AggregateCurrency() {
    }

    public AggregateCurrency(String code, double totalInvestment, double quantity) {
        this.code = code;
        this.totalInvestment = totalInvestment;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getTotalInvestment() {
        return totalInvestment;
    }

    public void setTotalInvestment(double totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
