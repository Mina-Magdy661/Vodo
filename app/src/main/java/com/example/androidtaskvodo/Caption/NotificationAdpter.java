package com.example.androidtaskvodo.Caption;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtaskvodo.PickUp.PickUpDeatils;
import com.example.androidtaskvodo.R;


import java.util.List;

public class NotificationAdpter extends RecyclerView.Adapter<NotificationAdpter.NotificationViewHolder> {

    private List<PickUpDeatils> pickUpDeatils ;
    Context context;

    public NotificationAdpter(List<PickUpDeatils> pickUpDeatils, Context context) {
        this.pickUpDeatils = pickUpDeatils;
        this.context = context;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotificationViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {

        holder.txtCarModel.setText(pickUpDeatils.get(position).getCarModel());
        holder.txtCarType.setText(pickUpDeatils.get(position).getCarType());
        holder.txtLocation.setText(pickUpDeatils.get(position).getLocation());
        holder.txtID.setText(pickUpDeatils.get(position).getMembership_ID());

        holder.imgOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //when Accpect

            }
        });

        holder.imgCANCEAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //when Canceal
                // remove row from DB

            }
        });





    }

    @Override
    public int getItemCount() {
        return pickUpDeatils.size();
    }


    public class NotificationViewHolder extends RecyclerView.ViewHolder {

        TextView txtCarModel , txtCarType , txtLocation , txtID ;
        ImageView imgOK , imgCANCEAL ;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCarModel = itemView.findViewById(R.id.txtCarModel);
            txtCarType = itemView.findViewById(R.id.txtCarType);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            txtID = itemView.findViewById(R.id.txtID);

            imgOK = itemView.findViewById(R.id.imgOk);
            imgCANCEAL = itemView.findViewById(R.id.imgCANCEAL);


        }
    }
}
