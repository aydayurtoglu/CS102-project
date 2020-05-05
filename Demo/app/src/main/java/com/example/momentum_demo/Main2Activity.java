package com.example.momentum_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ImageButton buttonHelp;
    private ImageButton buttonBack;
    private ImageButton buttonAdd;
    private ImageButton buttonDelete;
    private SearchView searchView;
    private ArrayList<ImageButton> buttons;
    private LinearLayout layout;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonHelp = findViewById(R.id.helpButton);
        buttonBack = findViewById(R.id.backButton);
        buttonAdd = findViewById(R.id.addButton);
        searchView = findViewById(R.id.searchView);
        buttons = new ArrayList<ImageButton>();


        layout = findViewById (R.id.linearLayout);
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(20, 10, 20, 10);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, HelpPage.class);
                startActivity(intent);
            }
        });

        // Adding project buttons for every new project
        final int[] count = {1};

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creating a new button for the new project
             Button btn = new Button( Main2Activity.this);
             params.gravity = Gravity.CENTER_HORIZONTAL;
             btn.setLayoutParams(params);
             btn.setText("Project " + count[0]);
             btn.setVisibility(View.VISIBLE);
             btn.setGravity(View.TEXT_ALIGNMENT_GRAVITY);
             layout.addView(btn);

             // Creating the new project
             Project newProject = new Project( "Project " + count[0]);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Main2Activity.this, ExistingProject.class);
                        startActivity(intent);
                    }
                });

                count[0]++;
             }

        });


    }

}
