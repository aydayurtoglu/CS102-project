package com.example.momentum_demo;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;
import java.util.ArrayList;

/*
This class is the page where the projects are seen
 */
public class Main2Activity extends AppCompatActivity {

    //variables
    private ImageButton buttonHelp;
    private ArrayList<ImageButton> buttons;
    private ImageButton buttonAdd;

    //methods
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonHelp = findViewById(R.id.helpButton);
        buttonAdd = findViewById(R.id.addButton);


        buttons = new ArrayList<ImageButton>();

        //adding actionListener to the button
        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, HelpPage.class);
                startActivity(intent);
            }
        });

        final int[] count = {1};

        //adding actionListener to the button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             /*
            In this part we tried to add multiple projects
                int id;
               id = count[0];
             Button btn = new Button( Main2Activity.this);
                params.gravity = Gravity.CENTER_HORIZONTAL;
             btn.setLayoutParams(params);
             btn.setText("Project " + count[0]);
             btn.setVisibility(View.VISIBLE);
             btn.setGravity(View.TEXT_ALIGNMENT_GRAVITY);
             btn.setId(id);
             layout.addView(btn);
              Creating the new project
              Project newProject = new Project( "Project " + count[0]);
              ExistingProject projectPage = new ExistingProject(newProject);
             count[0]++;
            */
                 Intent intent = new Intent(Main2Activity.this, CameraActivity.class);
               startActivity(intent);
             }

        });
    }
}
