package ru.omgtu.moneyff;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    DatabaseHelper myDB;
    ArrayList<String> human_id, human_name, human_date, human_summa;

    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, add_info.class);
                startActivity(intent);

            }
        });

        myDB = new DatabaseHelper(MainActivity.this);
        human_id = new ArrayList<>();
        human_name = new ArrayList<>();
        human_date = new ArrayList<>();
        human_summa = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(MainActivity.this,this, human_id, human_name, human_date, human_summa);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){

        Cursor cursor = myDB.readAllData();
        if(cursor.getCount()==0){
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                human_id.add(cursor.getString(0));
                human_name.add(cursor.getString(1));
                human_date.add(cursor.getString(2));
                human_summa.add(cursor.getString(3));
            }
        }

    }

}











