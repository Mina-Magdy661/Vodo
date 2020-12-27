package com.example.androidtaskvodo.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.androidtaskvodo.Login.LoginActivity;
import com.example.androidtaskvodo.R;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 100 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent homeIntent = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(homeIntent);
                finish();

            }
        } , SPLASH_SCREEN);

    }
}