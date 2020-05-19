package com.example.momentum_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * ImageGallery activity
 * @author Ayda Yurtoglu
 * @version 1.0
 */
public class ImageGallery extends AppCompatActivity {

    //variables
    private Button proceedButton;
    private GridView gridView;

    //methods

    /*
    This method creates the view for displaying every picture in the array
     */
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

        proceedButton = findViewById(R.id.proceedbutton);

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImageGallery.this, AutoImageSlider.class);
                startActivity(intent);
            }
        });


    }

    /*
    At this part we tried to pick the photos in the gallery

    // PICK_PHOTO_CODE is a constant integer
    public final static int PICK_PHOTO_CODE = 1046;

    // Trigger gallery selection for a photo
    public void onPickPhoto(View view) {
        // Create intent for picking a photo from the gallery
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        // If you call startActivityForResult() using an intent that no app can handle, your app will crash.
        // So as long as the result is not null, it's safe to use the intent.
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Bring up gallery to select a photo
            startActivityForResult(intent, PICK_PHOTO_CODE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Uri photoUri = data.getData();
            // Do something with the photo based on Uri
            Bitmap selectedImage = null;
            try {
                selectedImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Load the selected image into a preview
            ImageView ivPreview = (ImageView) findViewById(R.id.myiamge);
            ivPreview.setImageBitmap(selectedImage);
        }
   }

     */
}
