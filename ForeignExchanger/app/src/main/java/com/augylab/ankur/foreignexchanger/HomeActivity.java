package com.augylab.ankur.foreignexchanger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import model.AggregateCurrency;
import model.TransactionHistory;
import repo.AggregateCurrencyRepo;

public class HomeActivity extends AppCompatActivity implements CustomHomeAdapter.OnItemClickListener {

    private RecyclerView recordRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<AggregateCurrency> listArray = new ArrayList<>();

    private ArrayList<String> listhistory = new ArrayList<>();
    final static int REQUEST_CODE = 101;
    final static int RESULT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recordRecyclerView = (RecyclerView) findViewById(R.id.record_recycler_view);

        assert recordRecyclerView != null;
        recordRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        recordRecyclerView.setLayoutManager(mLayoutManager);
       // dbHelper = new DatabaseManager();

        refresh();




    }

    public void refresh() {
       listArray = AggregateCurrencyRepo.getRecords(getApplicationContext());
       mAdapter = new CustomHomeAdapter(this, listArray,this);
       recordRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_refresh:
                refresh();
                break;

            case R.id.action_arrow:
                Intent intent = new Intent(this, AddRecordActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CODE) {
                Log.d("outcome", "I am in");
                refresh();
            }

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onItemClick(AggregateCurrency item) {

        Intent in = new Intent(HomeActivity.this, CurrencyHistoryActivity.class);
        in.putExtra("code", item.getCode());
        startActivity(in);
    }
}
