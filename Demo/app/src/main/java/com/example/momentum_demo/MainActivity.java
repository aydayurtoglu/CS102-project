package com.example.momentum_demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.momentum_demo.Main2Activity;
import com.example.momentum_demo.R;

/*
This class is the welcome page of Momentum
 */
public class MainActivity extends AppCompatActivity {

    //variables
    private Button buttonStart;
    private Button buttonAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //matching variables with their xml view
        buttonAbout = findViewById(R.id.ButtonAbout);
        buttonStart = findViewById(R.id.ButtonStart);

        //adding actionListener to buttons
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

            }
        });

        //adding actionListener to buttons
        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutMomentum.class);
                startActivity(intent);
            }
        });
    }
}
