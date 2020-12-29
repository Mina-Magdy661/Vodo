package com.example.androidtaskvodo.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.androidtaskvodo.Caption.HomeForCaption.HomeActivityForCaption;
import com.example.androidtaskvodo.CarRepair.CarRepairActivity;
import com.example.androidtaskvodo.PickUp.PickUpActivity;
import com.example.androidtaskvodo.SparePart.SparePartActivity;
import com.example.androidtaskvodo.databinding.ActivityHomeBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HomeActivityForUser extends AppCompatActivity {

    private ActivityHomeBinding binding ;
    List itemList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        loadData();
        MakeNotifaction();





        binding.btnPickUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent pickUpActivit = new Intent(HomeActivityForUser.this , PickUpActivity.class);
                startActivity(pickUpActivit);

            }
        });

        binding.btnSparePart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent SparePartActivity = new Intent(HomeActivityForUser.this , SparePartActivity.class);
                startActivity(SparePartActivity);
            }
        });

        binding.cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent FixActifvity = new Intent(HomeActivityForUser.this , CarRepairActivity.class);
                startActivity(FixActifvity);


            }
        });


    }

    private void MakeNotifaction() {

        if(itemList != null){

        }
    }

    private void loadData() {

        SharedPreferences sharedPreferences = getSharedPreferences("SaveItemListNotfy" , MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("itemList", null);
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        itemList = gson.fromJson(json , type);

        if(itemList == null){
            itemList = new ArrayList<>();
        }

    }
}