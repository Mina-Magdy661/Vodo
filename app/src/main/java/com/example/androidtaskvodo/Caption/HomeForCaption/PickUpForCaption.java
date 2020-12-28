package com.example.androidtaskvodo.Caption.HomeForCaption;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidtaskvodo.Caption.NotificationAdpter;
import com.example.androidtaskvodo.PickUp.PickUpDeatils;
import com.example.androidtaskvodo.R;
import com.example.androidtaskvodo.database.PickUpViewModel;

import java.util.List;

public class PickUpForCaption extends AppCompatActivity {

    RecyclerView recyclerView ;
    NotificationAdpter notificationAdpter ;
    PickUpViewModel pickUpViewModel;
    LiveData<List<PickUpDeatils>> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up_for_caption);

        pickUpViewModel = ViewModelProviders.of(this).get(PickUpViewModel.class);
        list =    pickUpViewModel.retrive();
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list.observe(this, new Observer<List<PickUpDeatils>>() {
            @Override
            public void onChanged(List<PickUpDeatils> pickUpDeatils) {

                notificationAdpter = new NotificationAdpter( pickUpDeatils , PickUpForCaption.this);
                recyclerView.setAdapter(notificationAdpter);
            }
        });

    }
}