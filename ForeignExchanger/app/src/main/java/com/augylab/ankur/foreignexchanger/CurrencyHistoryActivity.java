package com.augylab.ankur.foreignexchanger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import model.AggregateCurrency;
import model.TransactionHistory;
import repo.AggregateCurrencyRepo;


public class CurrencyHistoryActivity extends AppCompatActivity {
    private RecyclerView recordRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<TransactionHistory> listArray = new ArrayList<>();

    private ArrayList<String> listhistory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_currency_history);
        recordRecyclerView = (RecyclerView) findViewById(R.id.record_recycler_view);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String code = bundle.getString("code");

        assert recordRecyclerView != null;
        recordRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        recordRecyclerView.setLayoutManager(mLayoutManager);
        // dbHelper = new DatabaseManager();

        listArray = AggregateCurrencyRepo.getParticularHistoryRecord(getApplicationContext(), code);
        mAdapter = new CustomCurrencyHistoryAdapter(this, listArray);
        recordRecyclerView.setAdapter(mAdapter);

    }
}
