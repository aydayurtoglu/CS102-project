package com.example.momentum_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ImageButton buttonHelp;
    private ImageButton buttonBack;
    private ImageButton buttonAdd;
    private ArrayList<ImageButton> buttons;
    //private ImageButton buttonDelete;
    //private ImageButton buttonAdd;
    private ImageButton buttonDelete;
    private ImageButton buttonAdd;
    //private SearchView searchView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonHelp = findViewById(R.id.helpButton);
        buttonBack = findViewById(R.id.backButton);
        buttonAdd = findViewById(R.id.addProjectButton);
        //buttonDelete = findViewById(R.id.deleteProjectButton);
        //buttonAdd = findViewById(R.id.addProjectButton);
        buttons = new ArrayList<ImageButton>;
======
       // buttonAdd = findViewById(R.id.addProjectButton);

        //searchView = findViewById(R.id.searchView);

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

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                private ImageButton e

                buttons.add(ImageButton e)
            }
        });


    }

}
