package com.example.androidtaskvodo.Caption.HomeForCaption;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidtaskvodo.PickUp.PickUpDeatils;
import com.example.androidtaskvodo.R;
import com.example.androidtaskvodo.Caption.NotificationAdpter;
import com.example.androidtaskvodo.database.PickUpViewModel;

import java.util.List;

public class HomeActivityForCaption extends AppCompatActivity {


   Button btnPickUp ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_for_caption);

        btnPickUp = findViewById(R.id.btnPickUpCaption);

        btnPickUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickUpActivity = new Intent(HomeActivityForCaption.this , PickUpForCaption.class );
                startActivity(pickUpActivity);
            }
        });

    }
}