package com.example.androidtaskvodo.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidtaskvodo.Home.HomeActivity;
import com.example.androidtaskvodo.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



public class LoginActivity extends AppCompatActivity {

    Button btnRegister  , btnLogin ;
    EditText editEmail , editPassword ;
    List<AccountData> listofAccounts ;
    AccountData accountData ;
    String email , password ;

    String emailCaption = "Admin" ;
    String passwordCaption = "Admin" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loadData();


        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editEmail.getText().toString().isEmpty() || editPassword.getText().toString().isEmpty()){

                    Toast.makeText(LoginActivity.this, "Please Fill All Data", Toast.LENGTH_SHORT).show();
                }else{

                    email = editEmail.getText().toString();
                    password = editPassword.getText().toString();

                  accountData =  findUser(email , password);

                  if(accountData == null){
                      Toast.makeText(LoginActivity.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                  }else{
                      Intent HomeIntent = new Intent(LoginActivity.this , HomeActivity.class);
                      startActivity(HomeIntent);
                  }

                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(LoginActivity.this , RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
        
    }

    private AccountData findUser(final String email , String password) {

        for(AccountData accountData : listofAccounts){
            if(accountData.getEmail().equals(email) && accountData.getPassword().equals(password)){
                return accountData;
            }
        }

        return null ;
    }


    private void loadData() {

        SharedPreferences sharedPreferences = getSharedPreferences("Save" , MODE_PRIVATE);
        Gson  gson = new Gson();
        String json = sharedPreferences.getString("list", null);
        Type type = new TypeToken<ArrayList<AccountData>>(){}.getType();
        listofAccounts = gson.fromJson(json , type);

        if(listofAccounts == null){
            listofAccounts = new ArrayList<>();
        }

    }

}