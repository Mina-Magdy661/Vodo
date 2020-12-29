package com.example.androidtaskvodo.SparePart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidtaskvodo.Login.AccountData;
import com.example.androidtaskvodo.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SparePartActivity extends AppCompatActivity {

    EditText editItem ;
    String item ;
    Button brnSend ;
    List<String> itemList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spare_part);

        loadData();

        editItem = findViewById(R.id.editItem);
        brnSend = findViewById(R.id.btnSend);

        brnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editItem.getText().toString().isEmpty()){

                    Toast.makeText(SparePartActivity.this, "Please Fill All Data", Toast.LENGTH_SHORT).show();
                }else{

                    item = editItem.getText().toString();
                    itemList.add(item);
                    saveData();
                    editItem.setText("Request Is Send Successfuly");

                }
            }
        });

    }

    private void saveData() {

        SharedPreferences sharedPreferences = getSharedPreferences("SaveItemList" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(itemList);
        editor.putString("itemList" , json);
        editor.apply();

    }

    private void loadData() {

        SharedPreferences sharedPreferences = getSharedPreferences("SaveItemList" , MODE_PRIVATE);
        Gson  gson = new Gson();
        String json = sharedPreferences.getString("itemList", null);
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        itemList = gson.fromJson(json , type);

        if(itemList == null){
            itemList = new ArrayList<>();
        }

    }

}