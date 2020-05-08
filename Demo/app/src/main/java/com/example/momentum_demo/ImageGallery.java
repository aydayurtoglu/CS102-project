package com.example.momentum_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * ImageGallery activity
 * @author Ayda Yurtoglu
 * @version 1.0
 */
public class ImageGallery extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery);

        gridView = (GridView) findViewById(R.id.grid_view);

        gridView.setAdapter( new ImageAdapter( this));

        gridView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent( getApplicationContext(), FullscreenActivity.class);
                intent.putExtra( "id", position);
                startActivity(intent);
            }
        });
    }
}
