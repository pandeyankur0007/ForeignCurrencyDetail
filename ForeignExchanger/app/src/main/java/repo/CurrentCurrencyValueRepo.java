package repo;

import model.CurrentCurrencyValue;

/**
 * Created by ankur on 9/18/16.
 */
public class CurrentCurrencyValueRepo {

    private CurrentCurrencyValue currentCurrencyValue;

    public CurrentCurrencyValueRepo() {
        currentCurrencyValue = new CurrentCurrencyValue();
    }

    public static String createTable() {
        return "CREATE TABLE IF NOT EXISTS " + CurrentCurrencyValue.TABLE  + "("
                + CurrentCurrencyValue.KEY_Id  + " INTEGER PRIMARY KEY, "
                + CurrentCurrencyValue.KEY_Code + " TEXT, "
                + CurrentCurrencyValue.KEY_CurrentValue + " REAL "+ ")";
    }


   /* public int insert(CurrentCurrencyValue currentCurrencyValue) {
        int currentId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(CurrentCurrencyValue.KEY_Id, currentCurrencyValue.getId());
        values.put(CurrentCurrencyValue.KEY_Code, currentCurrencyValue.getCode());
        values.put(CurrentCurrencyValue.KEY_CurrentValue, currentCurrencyValue.getCurrentValue());

        // Inserting Row
        currentId=(int)db.insert(CurrentCurrencyValue.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();

        return currentId;
    }*/
}
