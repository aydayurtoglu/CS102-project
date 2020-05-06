package com.example.momentum_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class AutoImageSlider extends AppCompatActivity {

    ViewFlipper viewFlipper;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_image_slider);

        viewFlipper = findViewById(R.id.viewFlipper);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // videoyu galeriye kaydetsin?
            }
        });

        int images[] = {R.drawable.logo, R.drawable.logo1}; // BUNLARI Bİ YERDEN ALMAMIZ LAZIM

        // for loop
        for (int image : images) {
            flipperImages(image);
        }
    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(100); // 1 sec
        viewFlipper.setAutoStart(true);

        //animation
        viewFlipper.setInAnimation(this, android.R.anim.fade_in);
        viewFlipper.setOutAnimation(this, android.R.anim.fade_out);
    }
}
