package com.nikovarchapet.cinema.cinema;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeansListActivity extends AppCompatActivity {

    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seans);

        Intent intent = getIntent();

        Film film = (Film) intent.getSerializableExtra("Film");

        List<Seans> seans = film.seanses;


        recyclerView = findViewById(R.id.recyclerSeans);

        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(manager);

        final SeansAdapter adapter = new SeansAdapter(this, seans);
        adapter.setOnItemClickListener(new SeansAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Seans seans) {
                Intent intent = new Intent(SeansListActivity.this,HallActivity.class);
                intent.putExtra("Hall", seans.hall);
                SeansListActivity.this.startActivity(intent);
            }
        });



        recyclerView.setAdapter(adapter);


    }
}
