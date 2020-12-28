package com.example.androidtaskvodo.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.androidtaskvodo.Login.AccountData;
import com.example.androidtaskvodo.PickUp.PickUpDeatils;

@Database(entities = {PickUpDeatils.class}, version = 1)
public abstract class PickUpSave extends RoomDatabase {

        public abstract PickUpDao pickUpDao();


}
