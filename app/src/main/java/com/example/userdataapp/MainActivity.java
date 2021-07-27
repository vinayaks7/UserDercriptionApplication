package com.example.userdataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.example.userdataapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());


        String name=activityMainBinding.name.getText().toString();
        String phno=activityMainBinding.phno.getText().toString();
        String email=activityMainBinding.email.getText().toString();
        String age=activityMainBinding.age.getText().toString();
        String gender=activityMainBinding.gender.getText().toString();

    }



}