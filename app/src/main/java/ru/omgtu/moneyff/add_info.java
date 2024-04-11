package ru.omgtu.moneyff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_info extends AppCompatActivity {

    EditText human_input, date_input, summa_input;
    Button add_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);

        human_input = findViewById(R.id.name_input);
        date_input = findViewById(R.id.date_input);
        summa_input = findViewById(R.id.sum_input);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDB = new DatabaseHelper(add_info.this);
                myDB.AddDebtor(human_input.getText().toString().trim(),
                        date_input.getText().toString().trim(),
                        Integer.valueOf(summa_input.getText().toString().trim()));
            }
        });

    }
}