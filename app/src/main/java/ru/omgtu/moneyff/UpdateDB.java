package ru.omgtu.moneyff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class UpdateDB extends AppCompatActivity {

    EditText name_input, date_input, summa_input;
    Button update_button;
    String id, name, date, summa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_db);

        name_input = findViewById(R.id.name_input2);
        date_input = findViewById(R.id.date_input2);
        summa_input = findViewById(R.id.sum_input2);
        update_button = findViewById(R.id.update_button);

        getAndSetIntentData();

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDB = new DatabaseHelper(UpdateDB.this);
                myDB.updateData(id, name, date, summa);
            }
        });

    }

    void getAndSetIntentData(){

        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("name") &&
                getIntent().hasExtra("date") &&
                getIntent().hasExtra("summa")){

            // getting data from intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            date = getIntent().getStringExtra("date");
            summa = getIntent().getStringExtra("summa");

            //setting intent data
            name_input.setText(name);
            date_input.setText(date);
            summa_input.setText(summa);


        } else {
            Toast.makeText(this,"NO DATA", Toast.LENGTH_SHORT).show();
        }
    }

}