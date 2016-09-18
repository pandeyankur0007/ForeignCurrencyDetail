package com.augylab.ankur.foreignexchanger;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.ArrayList;


import model.TransactionHistory;
import repo.AggregateCurrencyRepo;


public class CurrencyHistoryActivity extends AppCompatActivity {
    private RecyclerView recordRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<TransactionHistory> listArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_history);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("CURRENCY HISTORY");

        recordRecyclerView = (RecyclerView) findViewById(R.id.record_recycler_view);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String code = bundle.getString("code");

        assert recordRecyclerView != null;
        recordRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        recordRecyclerView.setLayoutManager(mLayoutManager);

        listArray = AggregateCurrencyRepo.getParticularHistoryRecord(getApplicationContext(), code);
        mAdapter = new CustomCurrencyHistoryAdapter(this, listArray);
        recordRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_history_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_add:
                Intent intent = new Intent(CurrencyHistoryActivity.this, AddRecordActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }
}
