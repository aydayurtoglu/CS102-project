package com.example.momentum_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ExistingProject extends AppCompatActivity {

    private ImageButton buttonBack;
    private ImageButton buttonRename;
    private Project project;

    // public ExistingProject(Project thisProject) {
    //    project = thisProject;
    //}


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_project);

        buttonBack = findViewById(R.id.backButton);
        buttonRename = findViewById(R.id.renameButton);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExistingProject.this, Main2Activity.class);
                startActivity(intent);
            }
        });



    }
}
