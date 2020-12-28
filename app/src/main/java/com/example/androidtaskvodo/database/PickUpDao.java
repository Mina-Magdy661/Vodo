package com.example.androidtaskvodo.database;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.androidtaskvodo.Login.AccountData;
import com.example.androidtaskvodo.PickUp.PickUpDeatils;

import java.util.List;

@Dao
public interface PickUpDao {

    @Insert
    void addPickUpDeatils (PickUpDeatils pickUpDeatils);

    @Query("Select * from PickUpDeatils")
    LiveData<List<PickUpDeatils>> getPickUpDeatils ();


}
