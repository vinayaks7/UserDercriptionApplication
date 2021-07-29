package com.example.userdataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class AddVideo extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 101;
    private Button btnSelect, btnUpload, btnShow;

    Uri selectedVideoUri;
    VideoView videoView;
    MediaController mediaController;
    private String videoUrl;
    FirebaseDatabase database;
    FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_video);
    }
}