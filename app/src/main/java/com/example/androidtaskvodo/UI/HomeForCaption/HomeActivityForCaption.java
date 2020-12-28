package com.example.androidtaskvodo.UI.HomeForCaption;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidtaskvodo.R;
import com.example.androidtaskvodo.UI.NotificationAdpter;

public class HomeActivityForCaption extends AppCompatActivity {


    RecyclerView recyclerView ;
    NotificationAdpter notificationAdpter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_for_caption);



    }
}