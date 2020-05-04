package com.example.momentum_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.momentum_demo.Main2Activity;
import com.example.momentum_demo.R;

public class MainActivity extends AppCompatActivity {


    //properties
    private Button buttonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.ButtonStart); //we typecasted to ensure that id belongs to a button
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProjectPage();
            }
        });
    }

    public void openProjectPage()
    {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
