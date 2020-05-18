package com.example.momentum_demo;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

/**
 *This class shows the last picture taken by the camera
 * @author Beste Guney
 * @version 1.0
 */
public class DisplayImage extends AppCompatActivity {

    //variables
    private ImageView imageView;
    private Bitmap bitmap;

    //methods

    /*
    This method returns the last picture on the matched xml page.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);

        //matching variables by their xml view
        imageView = findViewById(R.id.mimageView);

        bitmap = BitmapFactory.decodeFile(getIntent().getStringExtra("image_path"));

        imageView.setImageBitmap(bitmap); //putting the bitmap in the image view

    }
}
