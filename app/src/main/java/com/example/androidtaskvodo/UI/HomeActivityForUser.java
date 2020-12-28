package com.example.androidtaskvodo.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidtaskvodo.PickUp.PickUpActivity;
import com.example.androidtaskvodo.databinding.ActivityHomeBinding;

public class HomeActivityForUser extends AppCompatActivity {

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


                Intent pickUpActivit = new Intent(HomeActivityForUser.this , PickUpActivity.class);
                startActivity(pickUpActivit);


            }
        });


    }
}