package com.example.userdataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Email;
    EditText Phno;
    EditText Age;
    EditText Gender;
    Button Addvideo;
    Button Addphoto;
    Button OnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.name);
        Email = findViewById(R.id.email);
        Phno = findViewById(R.id.phno);
        Age = findViewById(R.id.age);
        Gender = findViewById(R.id.gender);
        OnSubmit = findViewById(R.id.onSubmit);
        Addphoto = findViewById(R.id.addphoto);
        Addvideo = findViewById(R.id.addvideo);


        final DatabaseReference database = FirebaseDatabase.getInstance().getReference();

        Addphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Reached", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddPhoto.class);
                startActivity(intent);
            }
        });

        Addvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Reached", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddVideo.class);
                startActivity(intent);

            }
        });


        OnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();

                String phno = Phno.getText().toString();
                String email = Email.getText().toString();
                String age = Age.getText().toString();
                String gender = Gender.getText().toString();

                obj1.name = name;
                obj1.age = age;
                obj1.phoneNo = phno;
                obj1.emailId = email;
                obj1.Gender = gender;
                if (name.isEmpty()) {
                    Name.setError("Please Enter the name");
                    return;
                }

                if (phno.isEmpty()) {
                    Phno.setError("Please Enter the name");
                    return;
                }
                if (email.isEmpty()) {
                    Email.setError("Please Enter the name");
                    return;
                }
                if (age.isEmpty()) {
                    Age.setError("Please Enter the name");
                    return;
                }

                if (gender.isEmpty()) {
                    Gender.setError("Please Enter the name");
                    return;
                }

                User obj1 = new User();
                database.child("users").push().setValue(obj1).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Name.getText().clear();
                        Phno.getText().clear();
                        Age.getText().clear();
                        Gender.getText().clear();
                        Email.getText().clear();

                    }
                });
            }
        });

    }
}