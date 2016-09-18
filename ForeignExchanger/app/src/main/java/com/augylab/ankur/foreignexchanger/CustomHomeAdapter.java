package com.augylab.ankur.foreignexchanger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import model.AggregateCurrency;

/**
 * Created by ankur on 9/13/16.
 */
public class CustomHomeAdapter extends RecyclerView.Adapter<CustomHomeAdapter.ViewHolder> {


    public interface OnItemClickListener {
        void onItemClick(AggregateCurrency item);
    }


    DBHelper dbHelper;
    private ArrayList<AggregateCurrency> listArray = null;
    Context c;
    private AggregateCurrency recordDetail;

    private final OnItemClickListener listener;

    View v;



    public class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView codeTv, quantityTv, investedTv, currentTv;

        public ViewHolder(View v) {
            super(v);
            codeTv = (TextView) v.findViewById(R.id.codeTv);
            quantityTv = (TextView) v.findViewById(R.id.qtyTv);
            investedTv = (TextView) v.findViewById(R.id.investedTv);
            currentTv = (TextView) v.findViewById(R.id.currentTv);
        }



        public void bind(final AggregateCurrency aggregateCurrency, final OnItemClickListener listener) {

            v.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(aggregateCurrency);
                }
            });
        }
    }

    public CustomHomeAdapter(Context ctx, ArrayList<AggregateCurrency> listArray, OnItemClickListener onItemClickListener) {
        this.c = ctx;
        this.listArray = listArray;
       // this.dbHelper = (new DBHelper(c)).getWriteDB();
        listener = onItemClickListener;

    }



    @Override
    public CustomHomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_home_adapter, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;    }

    @Override
    public void onBindViewHolder(CustomHomeAdapter.ViewHolder holder, int position) {
        holder.bind(listArray.get(position), listener);

    recordDetail = listArray.get(position);
        holder.codeTv.setText(recordDetail.getCode());
        holder.quantityTv.setText(recordDetail.getQuantity() + "");
        holder.investedTv.setText(recordDetail.getTotalInvestment() + "");

    }


    @Override
    public int getItemCount() {
        return listArray.size();
    }





}
