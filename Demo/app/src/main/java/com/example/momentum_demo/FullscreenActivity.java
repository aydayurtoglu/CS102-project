package com.example.momentum_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
/**
 * Fullscreen activity
 * @author Ayda Yurtoglu
 * @version 1.0
 */
public class FullscreenActivity extends AppCompatActivity {

    ImageView imageView;
    ImageAdapter imageAdapter;
    Button draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        draw = findViewById(R.id.draw);

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), DrawActivity.class);
                Intent i = getIntent();
                int position = i.getExtras().getInt("id");

                intent.putExtra( "id", position);
                startActivity(intent);
            }
        });

        imageView = (ImageView) findViewById(R.id.image_view);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");

        imageAdapter = new ImageAdapter(this);

        imageView.setImageResource(imageAdapter.imageArray[position]);

    }
}
