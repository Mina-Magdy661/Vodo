package com.example.androidtaskvodo.Login;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class AccountData {


    private String email ;
    private  String password ;
    private String membershipID ;
    private  String Name ;
    private String Phone ;

    public AccountData(String email, String password, String membershipID, String name, String phone) {
        this.email = email;
        this.password = password;
        this.membershipID = membershipID;
        Name = name;
        Phone = phone;
    }

    public AccountData() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(String membershipID) {
        this.membershipID = membershipID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
