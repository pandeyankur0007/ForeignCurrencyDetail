package com.augylab.ankur.foreignexchanger;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import model.TransactionHistory;

/**
 * Created by ankur on 9/18/16.
 */
public class CustomCurrencyHistoryAdapter extends RecyclerView.Adapter<CustomCurrencyHistoryAdapter.ViewHolder> {

    DBHelper dbHelper;
    private ArrayList<TransactionHistory> listArray = null;
    Context c;
    private TransactionHistory recordDetail;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dateTv, quantityTv, investedTv, debitedTv;

        public ViewHolder(View v) {
            super(v);
            quantityTv = (TextView) v.findViewById(R.id.qtyTv);
            investedTv = (TextView) v.findViewById(R.id.investedTv);
            dateTv = (TextView) v.findViewById(R.id.dateTv);
            debitedTv = (TextView) v.findViewById(R.id.debitedTv);
        }

    }

    public CustomCurrencyHistoryAdapter(Context ctx, ArrayList<TransactionHistory> listArray) {
        this.c = ctx;
        this.listArray = listArray;
    }

    @Override
    public CustomCurrencyHistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_currency_history, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(CustomCurrencyHistoryAdapter.ViewHolder holder, int position) {
        recordDetail = listArray.get(position);
        holder.dateTv.setText(recordDetail.getTimestamp() + "");
        holder.quantityTv.setText(recordDetail.getQuantity() + "");
        holder.investedTv.setText(recordDetail.getPaidValue() + "");
        holder.debitedTv.setText(recordDetail.getDebit() + "");

    }

    @Override
    public int getItemCount() {
        return listArray.size();
    }


}
