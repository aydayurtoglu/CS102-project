package com.example.momentum_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
/**
 * Fullscreen activity
 * @author Ayda Yurtoglu
 * @version 1.0
 */
public class FullscreenActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        imageView = (ImageView) findViewById(R.id.image_view);

        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Full Screen Image");

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");

        ImageAdapter imageAdapter = new ImageAdapter(this);

        imageView.setImageResource(imageAdapter.imageArray[position]);

    }
}
