package com.example.userdataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.userdataapp.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());




        final DatabaseReference database = FirebaseDatabase.getInstance().getReference();


        activityMainBinding.onSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=activityMainBinding.name.getText().toString();

                String phno=activityMainBinding.phno.getText().toString();
                String email=activityMainBinding.email.getText().toString();
                String age=activityMainBinding.age.getText().toString();
                String gender=activityMainBinding.gender.getText().toString();
                User obj1=new User();
                obj1.Name=name;
                obj1.age=age;
                obj1.PhoneNo=phno;
                obj1.emailid=email;
                obj1.Gender=gender;
                if(name.isEmpty()){
                    activityMainBinding.name.setError("Please Enter the name");
                    return;
                }

                if(phno.isEmpty()){
                    activityMainBinding.phno.setError("Please Enter the name");
                    return;
                }
                if(email.isEmpty()){
                    activityMainBinding.email.setError("Please Enter the name");
                    return;
                }
                if(age.isEmpty()){
                    activityMainBinding.age.setError("Please Enter the name");
                    return;
                }

                if(gender.isEmpty()){
                    activityMainBinding.gender.setError("Please Enter the name");
                    return;
                }

                database.child("users").push().setValue(obj1).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        activityMainBinding.name.getText().clear();
                        activityMainBinding.phno.getText().clear();
                        activityMainBinding.age.getText().clear();
                        activityMainBinding.gender.getText().clear();
                        activityMainBinding.email.getText().clear();

                    }
                });




            }
        });

    }



}