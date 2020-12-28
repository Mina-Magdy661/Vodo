package com.example.androidtaskvodo.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.example.androidtaskvodo.PickUp.PickUpDeatils;

import java.util.List;

public class PickUpViewModel extends AndroidViewModel {

    public PickUpViewModel(@NonNull Application application) {
        super(application);
    }



    PickUpSave db = Room.databaseBuilder( getApplication() ,
            PickUpSave.class, "savePickUp").build();



    PickUpDao pickUpDao = (db).pickUpDao();
    PickUpDeatilsRepo pickUpDeatilsRepo  = new PickUpDeatilsRepo(pickUpDao);


    public void addPickUpDeatils(PickUpDeatils pickUpDeatils){

        pickUpDeatilsRepo.addPickUpDeatils(pickUpDeatils);

    }

    public LiveData<List<PickUpDeatils>> retrive (){

        return  pickUpDeatilsRepo.retrive();

    }


}
