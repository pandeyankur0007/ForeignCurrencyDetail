package model;

/**
 * Created by ankur on 9/18/16.
 */
public class CurrentCurrencyValue {
    public static final String TAG = CurrentCurrencyValue.class.getSimpleName();
    public static final String TABLE = "current_currency_value";

    //Labels Table Column name
    public static final String KEY_Id = "id";
    public static final String KEY_Code = "code";
    public static final String KEY_CurrentValue = "current_value";

    private int id;
    private String code;
    private double currentValue;

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

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }
}
