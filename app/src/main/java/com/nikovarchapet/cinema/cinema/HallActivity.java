package com.nikovarchapet.cinema.cinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import static com.nikovarchapet.cinema.cinema.Hall.HALL_1;

public class HallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);
        Intent intent = getIntent();
        Hall hall = (Hall) intent.getSerializableExtra("Hall");

        DrawingViews hallView = findViewById(R.id.hallView);
        hallView.setHall(hall);
    }
}
