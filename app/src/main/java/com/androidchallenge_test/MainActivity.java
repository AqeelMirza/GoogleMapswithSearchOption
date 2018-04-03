package com.androidchallenge_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.androidchallenge_test.Adapter.MainRecyclerView_Adapter;
import com.androidchallenge_test.Utils.DB_Helper;
import com.androidchallenge_test.Utils.List_DataModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<List_DataModel> list_dataModelArrayList;
    DB_Helper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView no_Loc = findViewById(R.id.no_loc_tv);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.hasFixedSize();

        db = new DB_Helper(this);
        list_dataModelArrayList = db.getAllItems();
        if (list_dataModelArrayList.size() > 0) {

            recyclerView.setVisibility(View.VISIBLE);
            no_Loc.setVisibility(View.GONE);

            MainRecyclerView_Adapter recyclerAdapter = new MainRecyclerView_Adapter(this,
                    R.layout.list_items, list_dataModelArrayList);
            recyclerView.setAdapter(recyclerAdapter);
        } else {

            recyclerView.setVisibility(View.GONE);
            no_Loc.setVisibility(View.VISIBLE);
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}
