package com.nikovarchapet.cinema.cinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Film> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();
        Film film1 = new Film(R.drawable.pirates, "Pirates");
        Film film2 = new Film(R.drawable.pirates, "Porsaj");
        Film film3 = new Film(R.drawable.pirates, "Fontan");
        Film film4 = new Film(R.drawable.pirates, "Nachalo");
        data.add(film1);
        data.add(film2);
        data.add(film3);
        data.add(film4);
        Seans seans1 = new Seans(Hall.HALL_1, new Date(2018, 02, 12, 11, 00), 2000);
        Seans seans2 = new Seans(Hall.HALL_2, new Date(2019, 05, 10, 15, 30), 1500);
        Seans seans3 = new Seans(Hall.HALL_3, new Date(2019, 04, 8, 18, 00), 3000);
        film1.addSeans(seans1);
        film1.addSeans(seans2);
        film1.addSeans(seans3);
        film2.addSeans(seans1);
        film2.addSeans(seans2);
        film2.addSeans(seans3);
        film3.addSeans(seans1);
        film3.addSeans(seans3);
        film4.addSeans(seans1);
        film4.addSeans(seans3);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        SimpleAdapter adapter = new SimpleAdapter(this,data);
        recyclerView.setAdapter(adapter);


    }

}