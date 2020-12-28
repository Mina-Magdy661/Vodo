package com.example.androidtaskvodo.database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidtaskvodo.PickUp.PickUpDeatils;

import java.util.List;

public class PickUpDeatilsRepo  {

    PickUpDao pickUpDao;
    public PickUpDeatilsRepo( PickUpDao pickUpDao) {

        this.pickUpDao = pickUpDao;
    }

    public void addPickUpDeatils(PickUpDeatils pickUpDeatils){
        pickUpDao.addPickUpDeatils(pickUpDeatils);
    }

    public LiveData<List<PickUpDeatils>> retrive (){

        return pickUpDao.getPickUpDeatils();
    }
}
