package com.anurag.instagramclone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.parse.ParseInstallation;

public class MainActivity extends AppCompatActivity  {


    private Button signup;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        signup =  findViewById(R.id.signup);
        login = findViewById(R.id.login);

    }


    }

