package com.example.userdataapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AddPhoto extends AppCompatActivity {

    private Button btnChoose, btnUpload,btnCamera;

    // view for image view
    private ImageView imageView;

    // Uri indicates, where the image will be picked from
    private Uri filePath;
    String imageUrl;

    // request code
    private final int PICK_IMAGE_REQUEST = 22;

    // instance for firebase storage and StorageReference
    FirebaseStorage storage;
    //    StorageReference storageReference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);


        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(
                Color.parseColor("#0F9D58"));
        actionBar.setBackgroundDrawable(colorDrawable);

        btnChoose = findViewById(R.id.btnChoose);
        btnUpload = findViewById(R.id.btnUpload);
        imageView = findViewById(R.id.imgView);
        btnCamera= findViewById(R.id.btncamera);


        storage = FirebaseStorage.getInstance();
//        storageReference = storage.getReference();
        database=FirebaseDatabase.getInstance();

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SelectImage();
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
                imageView.setImageResource(0);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencamera();
            }
        });
    }

    private void opencamera() {




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data!=null){
            if(data.getData()!=null){
                imageView.setImageURI(data.getData());
                filePath=data.getData();
                Toast.makeText(this, filePath.toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, filePath.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void uploadImage() {

        if(filePath!=null){
            StorageReference reference=storage.getReference().child("Images");
            reference.putFile(filePath).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    if(task.isSuccessful()){
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                imageUrl=uri.toString();
                                database.getReference().child("Images").push().setValue(imageUrl);
                                Toast.makeText(AddPhoto.this, "Uploaded", Toast.LENGTH_SHORT).show();

                            }
                        });

                    }
                    else{
                        Toast.makeText(AddPhoto.this, "Task failed", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
        else{
            Toast.makeText(this, "FilePath is null", Toast.LENGTH_SHORT).show();
        }

    }

    private void SelectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);

    }
}