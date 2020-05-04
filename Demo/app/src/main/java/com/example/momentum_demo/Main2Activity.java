package com.example.momentum_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private Button buttonHelp;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonHelp = findViewById(R.id.helpButton);
        buttonBack = findViewById(R.id.backButton);
    }

}
