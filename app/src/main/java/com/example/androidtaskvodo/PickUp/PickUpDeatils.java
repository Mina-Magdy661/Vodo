package com.example.androidtaskvodo.PickUp;

import android.location.Location;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.androidtaskvodo.Login.AccountData;
@Entity
public class PickUpDeatils {

    @PrimaryKey(autoGenerate = true)
    private int id ;
    String carModel ;
    String carType ;
    String location ;
    String membership_ID;

    public PickUpDeatils(String carModel, String carType, String location, String membership_ID) {
        this.carModel = carModel;
        this.carType = carType;
        this.location = location;
        this.membership_ID = membership_ID;

    }

    public String getMembership_ID() {
        return membership_ID;
    }

    public void setMembership_ID(String membership_ID) {
        this.membership_ID = membership_ID;
    }



    public PickUpDeatils() {
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
