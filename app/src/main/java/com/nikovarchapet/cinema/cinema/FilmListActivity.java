package com.nikovarchapet.cinema.cinema;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilmListActivity extends AppCompatActivity {
    public static final int ADD_FILM = 10003;

    SimpleAdapter adapter;

    private RecyclerView recyclerView;
    private List<Film> filmsData = new ArrayList<>();;
    Button addBtn;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == ADD_FILM && resultCode == RESULT_OK){
            filmsData.add(0, (Film) data.getSerializableExtra("Film"));
            adapter.notifyItemInserted(0);


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);


//        Film film1 = new Film(R.drawable.pirates, "Pirates");
//        Film film2 = new Film(R.drawable.pirates, "Forsaj");
//        Film film3 = new Film(R.drawable.pirates, "Fontan");
//        Film film4 = new Film(R.drawable.pirates, "Nachalo");
//        data.add(film1);
//        data.add(film2);
//        data.add(film3);
//        data.add(film4);
//        Seans seans1 = new Seans(Hall.HALL_1, "2018.04.05 11:44 ", 2000);
//        Seans seans2 = new Seans(Hall.HALL_2, "2018.05.25 12:25 ", 1500);
//        Seans seans3 = new Seans(Hall.HALL_3, "2018.07.14 18:00 ", 3000);
//        film1.addSeans(seans1);
//        film1.addSeans(seans2);
//        film1.addSeans(seans3);
//        film2.addSeans(seans1);
//        film2.addSeans(seans2);
//        film2.addSeans(seans3);
//        film3.addSeans(seans1);
//        film3.addSeans(seans3);
//        film4.addSeans(seans1);
//        film4.addSeans(seans3);
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(manager);
        adapter = new SimpleAdapter(this, filmsData);
        recyclerView.setAdapter(adapter);

        addBtn = findViewById(R.id.addFilm);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FilmListActivity.this, AddFilmActivity.class);
                FilmListActivity.this.startActivityForResult(intent,ADD_FILM);
            }
        });



    }
}
