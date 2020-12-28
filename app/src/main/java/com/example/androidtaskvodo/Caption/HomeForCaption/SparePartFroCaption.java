package com.example.androidtaskvodo.Caption.HomeForCaption;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.example.androidtaskvodo.Login.AccountData;
import com.example.androidtaskvodo.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SparePartFroCaption extends AppCompatActivity {

    RecyclerView recyclerView ;
    List<String> itemList ;
    SpareAdpter spareAdpter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spare_part_fro_caption);

        loadData();

        recyclerView = findViewById(R.id.recycleView);
        spareAdpter =  new SpareAdpter(itemList ,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(spareAdpter);
    }


    private void loadData() {

        SharedPreferences sharedPreferences = getSharedPreferences("SaveItemList" , MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("itemList", null);
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        itemList = gson.fromJson(json , type);

        if(itemList == null){
            itemList = new ArrayList<>();
        }

    }
}