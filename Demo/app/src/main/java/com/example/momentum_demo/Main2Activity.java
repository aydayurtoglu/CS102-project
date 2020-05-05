package com.example.momentum_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
<<<<<<< HEAD
    private ImageButton buttonAdd;
    private ArrayList<ImageButton> buttons;
    //private ImageButton buttonDelete;
    //private ImageButton buttonAdd;
    private ImageButton buttonDelete;
    private ImageButton buttonAdd;
    //private SearchView searchView;
=======
    private ArrayList<ImageButton> buttons;
    private ImageButton buttonAdd;
    private SearchView searchView;

    private LinearLayout layout = (LinearLayout) findViewById (R.id.linearLayout);

>>>>>>> 8e4daf3117ccba19031f20645cad9a123e5c8ea7

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonHelp = findViewById(R.id.helpButton);
        buttonBack = findViewById(R.id.backButton);
<<<<<<< HEAD
        buttonAdd = findViewById(R.id.addProjectButton);
        //buttonDelete = findViewById(R.id.deleteProjectButton);
        //buttonAdd = findViewById(R.id.addProjectButton);
        buttons = new ArrayList<ImageButton>;
======
       // buttonAdd = findViewById(R.id.addProjectButton);
=======
        buttonAdd = findViewById(R.id.addButton);


        buttons = new ArrayList<ImageButton>();

        searchView = findViewById(R.id.searchView);


>>>>>>> 8e4daf3117ccba19031f20645cad9a123e5c8ea7


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
                Button a1 = new Button( getApplicationContext());
                a1.setText("Dynamic layouts ftw!");
                a1.setVisibility(View.VISIBLE);
                layout.addView(a1);
            }
        });


    }

}
