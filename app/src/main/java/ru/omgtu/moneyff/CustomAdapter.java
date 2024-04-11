package ru.omgtu.moneyff;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList human_id, human_name, human_date, human_summa;

    CustomAdapter(Activity activity,
                  Context context,
                  ArrayList human_id,
                  ArrayList human_name,
                  ArrayList human_date,
                  ArrayList human_summa){

        this.activity = activity;
        this.context = context;
        this.human_id = human_id;
        this.human_name = human_name;
        this.human_date = human_date;
        this.human_summa = human_summa;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.human_id_txt.setText(String.valueOf(human_id.get(position)));
        holder.human_name_txt.setText(String.valueOf(human_name.get(position)));
        holder.human_date_txt.setText(String.valueOf(human_date.get(position)));
        holder.human_summa_txt.setText(String.valueOf(human_summa.get(position)));


        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateDB.class);
                intent.putExtra("id", String.valueOf(human_id.get(position)));
                intent.putExtra("name", String.valueOf(human_name.get(position)));
                intent.putExtra("date", String.valueOf(human_date.get(position)));
                intent.putExtra("summa", String.valueOf(human_summa.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return human_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView human_id_txt, human_name_txt, human_date_txt, human_summa_txt;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            human_id_txt = itemView.findViewById(R.id.human_id_txt);
            human_name_txt = itemView.findViewById(R.id.human_name_txt);
            human_date_txt = itemView.findViewById(R.id.human_date_txt);
            human_summa_txt = itemView.findViewById(R.id.human_summa_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
