package com.example.androidtaskvodo.PickUp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.androidtaskvodo.Login.LoginActivity;
import com.example.androidtaskvodo.database.PickUpViewModel;
import com.example.androidtaskvodo.databinding.ActivityPickUpBinding;
import com.example.androidtaskvodo.utils.autocomplete.PlacesAutoSuggestAdapter;
import com.google.android.libraries.places.api.Places;

import java.util.List;

public class PickUpActivity extends AppCompatActivity {

    private ActivityPickUpBinding binding ;
    PickUpViewModel pickUpViewModel ;

    private  PickUpDeatils pickUpDeatils  ;

    private AutoCompleteTextView address;
    private final String mAPIKey = "AIzaSyAPFni3t26DtJiN3GO2k8fk0sp1H19Ptdg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPickUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        pickUpViewModel = ViewModelProviders.of(this).get(PickUpViewModel.class);



        initViews();

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pickUpDeatils = new PickUpDeatils(binding.editCarModel.getText().toString() ,
                        binding.editCarType.getText().toString(), binding.address.getText().toString() ,
                        LoginActivity.accountData.getMembershipID());

              Thread thread = new Thread(new Runnable() {
                  @Override
                  public void run() {
                      pickUpViewModel.addPickUpDeatils(pickUpDeatils);

                  }
              });
              thread.start();
            }
        });

    }

    private void initViews() {

        if (!Places.isInitialized()) {
            // Initialize the SDK
            Places.initialize(this, mAPIKey);
        }

        address = binding.address ;
        address.setAdapter(new PlacesAutoSuggestAdapter(this, android.R.layout.simple_list_item_1));
    }
}