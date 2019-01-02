package com.nikovarchapet.cinema.cinema;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.nikovarchapet.cinema.cinema.FilmListActivity.ADD_FILM;

public class AddFilmActivity extends AppCompatActivity implements View.OnClickListener

{
    public static final int REQUEST_CODE_INPUT = 10001;
    private static final int PICK_IMAGE_REQUEST = 10002;

    RecyclerView recyclerView;
    private Button addFilm;
    private Button addSeans;
    private Button addImage;
    private EditText filmName;
    private List<Seans> seanses;
    private CheckBox imgCheckBox;

    AddSeansAdapter adapter;

    Uri imageUri;


    Hall hall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_film);

        seanses = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerViewAdd);

        addFilm = findViewById(R.id.addFilmBtn);
        addSeans = findViewById(R.id.addSeanceBtn);
        addImage = findViewById(R.id.addImageBTN);
        filmName = findViewById(R.id.kinoName);
        imgCheckBox = findViewById(R.id.selectImg);



        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(manager);


        adapter = new AddSeansAdapter(seanses);

        recyclerView.setAdapter(adapter);


        addSeans.setOnClickListener(this);

        addImage.setOnClickListener(this);

        addFilm.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_INPUT) {
            if (resultCode == RESULT_OK) {
                seanses.add(0, (Seans) data.getSerializableExtra("Seans"));
                adapter.notifyItemInserted(0);

            }
        }

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            imageUri = data.getData();
            imgCheckBox.setChecked(true);
            addFilm.setEnabled(true);


        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addImageBTN:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
                break;

            case R.id.addSeanceBtn:
                Intent intent1 = new Intent(AddFilmActivity.this, AddSeansActivity.class);
                startActivityForResult(intent1, REQUEST_CODE_INPUT);
                break;

            case R.id.addFilmBtn:
                if(filmName.getText().toString().equals("")){
                    Toast.makeText(this, "Please enter film name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Film film = new Film(seanses, imageUri.toString(), filmName.getText().toString());
                    Intent resaultIntent = new Intent(AddFilmActivity.this, FilmListActivity.class);
                    resaultIntent.putExtra("Film", film);
                    setResult(RESULT_OK, resaultIntent);
                    finish();
                }
        }
    }

}
