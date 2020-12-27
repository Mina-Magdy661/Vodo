package com.example.androidtaskvodo.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidtaskvodo.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    EditText editEmail , editPassword , editPhone , editMembershipID , editName;
    Button btnRegister ;
    List<AccountData> listToSaveAccounts ;

    AccountData accountData ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loadData();

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editPhone = findViewById(R.id.editPhone);
        editMembershipID = findViewById(R.id.editMembershipID);
        editName = findViewById(R.id.editName);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editEmail.getText().toString().isEmpty() || editPassword.getText().toString().isEmpty()
                        || editPhone.getText().toString().isEmpty() || editMembershipID.getText().toString().isEmpty() ||
                        editName.getText().toString().isEmpty()){

                    Toast.makeText(RegisterActivity.this, "Please Fill All Data", Toast.LENGTH_SHORT).show();

                }else{

                    accountData = new AccountData(editEmail.getText().toString() , editPassword.getText().toString()
                            ,editPhone.getText().toString(),  editMembershipID.getText().toString(),
                            editName.getText().toString());


                    listToSaveAccounts.add(accountData);

                    saveData();

                    Intent loginIntent = new Intent(RegisterActivity.this , LoginActivity.class);
                    startActivity(loginIntent);

                }

            }
        });

    }

    private void saveData() {

        SharedPreferences sharedPreferences = getSharedPreferences("Save" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listToSaveAccounts);
        editor.putString("list" , json);
        editor.apply();

    }

    private void loadData() {

        SharedPreferences sharedPreferences = getSharedPreferences("Save" , MODE_PRIVATE);
        Gson  gson = new Gson();
        String json = sharedPreferences.getString("list", null);
        Type type = new TypeToken<ArrayList<AccountData>>(){}.getType();
        listToSaveAccounts = gson.fromJson(json , type);

        if(listToSaveAccounts == null){
            listToSaveAccounts = new ArrayList<>();
        }

    }
}