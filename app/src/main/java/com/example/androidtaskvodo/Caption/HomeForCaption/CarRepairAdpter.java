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

import java.util.List;

public class CarRepairAdpter extends RecyclerView.Adapter<CarRepairAdpter.SpareViewHolder> {

    private List<String> listCarRapairRequest;
    Context context;
//     List<String> listNotfy = new ArrayList<>();



    public CarRepairAdpter(List<String> listCarRapairRequest, Context context) {
        this.listCarRapairRequest = listCarRapairRequest;
        this.context = context;
    }

    @NonNull
    @Override
    public SpareViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SpareViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.carrapiaritem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SpareViewHolder holder, int position) {

        holder.txtSpare.setText(listCarRapairRequest.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, listCarRapairRequest.get(position), Toast.LENGTH_SHORT).show();
                listCarRapairRequest.remove(position);
                notifyDataSetChanged();
                saveData();

            }
        });

    }

    @Override
    public int getItemCount() {
        return listCarRapairRequest.size();
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



    private void saveData() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("SaveItemListforRequestRepair" , context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listCarRapairRequest);
        editor.putString("itemListForCar" , json);
        editor.apply();

    }


}
