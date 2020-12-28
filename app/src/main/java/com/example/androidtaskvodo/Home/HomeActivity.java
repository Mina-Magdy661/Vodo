package com.example.androidtaskvodo.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidtaskvodo.PickUp.PickUpActivity;
import com.example.androidtaskvodo.R;
import com.example.androidtaskvodo.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnPickUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pickUpActivit = new Intent(HomeActivity.this , PickUpActivity.class);
                startActivity(pickUpActivit);


            }
        });


    }
}