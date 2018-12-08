package com.nikovarchapet.cinema.cinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeansListActivity extends AppCompatActivity {

    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seans);

        List<Seans> seans = new ArrayList<>();
        seans.add(new Seans(Hall.HALL_1,new Date(2018,12,8,11,30),1500));
        seans.add(new Seans(Hall.HALL_2,new Date(2018,12,8,12,20),1000));
        seans.add(new Seans(Hall.VIP_HALL,new Date(2018,12,8,8,0),2000));


        recyclerView = findViewById(R.id.recyclerSeans);

        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(manager);

        final SeansAdapter adapter = new SeansAdapter(this, seans);

        recyclerView.setAdapter(adapter);


    }
}
