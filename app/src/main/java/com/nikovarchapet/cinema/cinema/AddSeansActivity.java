package com.nikovarchapet.cinema.cinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;

public class AddSeansActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText addDate;
    private EditText addPrice;
    private Hall[] halls;
    private Hall item;

    Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_seans);

        String[] spinnerArray = {"Select Hall", "Hall 1", "Hall 2", "Hall 3", "Vip Hall"};

        halls = new Hall[]{
                null,
                Hall.HALL_1,
                Hall.HALL_2,
                Hall.HALL_3,
                Hall.VIP_HALL
        };

        spinner = findViewById(R.id.addSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    item = halls[position];
                } else {
                    item = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addDate = findViewById(R.id.addDate);

        addPrice = findViewById(R.id.addPrice);


        okBtn = findViewById(R.id.btnOk);


        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(item == null){
                    Toast.makeText(AddSeansActivity.this, "Please select hall", Toast.LENGTH_SHORT).show();
                }

                else if(addDate.getText().toString().equals("")){
                    Toast.makeText(AddSeansActivity.this, "Please enter date", Toast.LENGTH_SHORT).show();
                }
                else if(addPrice.getText().toString().equals("")){
                    Toast.makeText(AddSeansActivity.this, "Please enter price", Toast.LENGTH_SHORT).show();
                }
                else  {
                    Seans seans = new Seans(item, addDate.getText().toString(), Integer.parseInt(addPrice.getText().toString()));
                    Intent resaultIntent = new Intent(AddSeansActivity.this, AddFilmActivity.class);
                    resaultIntent.putExtra("Seans", seans);
                    setResult(RESULT_OK, resaultIntent);
                    finish();
                }
            }
        });

    }



}
