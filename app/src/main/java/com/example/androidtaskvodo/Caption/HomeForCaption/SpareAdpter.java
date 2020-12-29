package com.example.androidtaskvodo.Caption.HomeForCaption;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtaskvodo.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SpareAdpter extends RecyclerView.Adapter<SpareAdpter.SpareViewHolder> {

    private List<String> listSpare ;
    Context context;
     List<String> listNotfy = new ArrayList<>();



    public SpareAdpter(List<String> listSpare, Context context) {
        this.listSpare = listSpare;
        this.context = context;
    }

    @NonNull
    @Override
    public SpareViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SpareViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.spareitem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SpareViewHolder holder, int position) {

        holder.txtSpare.setText(listSpare.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, listSpare.get(position), Toast.LENGTH_SHORT).show();
                listNotfy.add(listSpare.get(position));
                listSpare.remove(position);
                notifyDataSetChanged();
                saveDatanotfy();
                saveData();

            }
        });

    }

    @Override
    public int getItemCount() {
        return listSpare.size();
    }


    public class SpareViewHolder extends RecyclerView.ViewHolder {

        TextView txtSpare ;
        ImageView imgDone;

        public SpareViewHolder(@NonNull View itemView) {
            super(itemView);

            txtSpare = itemView.findViewById(R.id.txtRapit);
            imgDone = itemView.findViewById(R.id.done);



        }
    }

    private void saveDatanotfy() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("SaveItemListNotfy" ,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listNotfy);
        editor.putString("listNotfy" , json);
        editor.apply();

    }

    private void saveData() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("SaveItemList" , context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listSpare);
        editor.putString("itemList" , json);
        editor.apply();

    }


}
