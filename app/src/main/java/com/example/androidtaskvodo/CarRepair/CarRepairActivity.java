package com.example.androidtaskvodo.CarRepair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidtaskvodo.Login.AccountData;
import com.example.androidtaskvodo.SparePart.SparePartActivity;
import com.example.androidtaskvodo.databinding.ActivityCarRepairBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CarRepairActivity extends AppCompatActivity {

    private ActivityCarRepairBinding carRepairBinding;
    String item ;

    List<String> itemList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carRepairBinding = ActivityCarRepairBinding.inflate(getLayoutInflater());
        View view = carRepairBinding.getRoot();
        setContentView(view);

        loadData();
        carRepairBinding.btnCarSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(carRepairBinding.carEditItem.getText().toString().isEmpty()){

                    Toast.makeText(CarRepairActivity.this, "Please Fill All Data", Toast.LENGTH_SHORT).show();
                }else{

                    item = carRepairBinding.carEditItem.getText().toString();
                    itemList.add(item);
                    saveData();

                }

            }
        });


    }
    private void saveData() {

        SharedPreferences sharedPreferences = getSharedPreferences("SaveCarRepairItemList" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(itemList);
        editor.putString("itemList" , json);
        editor.apply();

    }

    private void loadData() {

        SharedPreferences sharedPreferences = getSharedPreferences("SaveCarRepairItemList" , MODE_PRIVATE);
        Gson  gson = new Gson();
        String json = sharedPreferences.getString("itemList", null);
        Type type = new TypeToken<ArrayList<AccountData>>(){}.getType();
        itemList = gson.fromJson(json , type);

        if(itemList == null){
            itemList = new ArrayList<>();
        }

    }
}