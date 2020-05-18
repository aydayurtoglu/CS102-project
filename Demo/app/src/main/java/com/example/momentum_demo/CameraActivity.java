package com.example.momentum_demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *This class represents the camera for our app
 * @author Beste Guney and Ece Teker
 * @version 1.0
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public class CameraActivity extends Activity {

    //constants
    private static final int IMAGE_REQUEST = 1;

    //variables
    private String currentImagePath;
    private Button captureButton;
    private File imageFile;
    private int count;

    //methods

    /*
    This method starts the camera activity.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_preview);

        //matching the button with its xml view
        captureButton = findViewById(R.id.captureButton1);

        //adding action listener to the button
        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureImage(v);
            }
        });

        //initializing the variables
        currentImagePath = null;
        count = 0;
    }

    /*
    This method captures the image by using an Intent object in android.
     */
    public void captureImage(View view)
    {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (cameraIntent.resolveActivity(getPackageManager()) != null)
        {
             imageFile = null;

            try {
                imageFile = getImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (imageFile != null)
            {
                increaseCount();
                Uri imageUri = FileProvider.getUriForFile(this,"com.example.momentum_demo",imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(cameraIntent,IMAGE_REQUEST);

            }
        }
    }

    /*
    This method shows the pages captured by the camera (the pictures in the array)
    */
    public void displayImage(View view)
    {
        Intent intent = new Intent(this,ImageGallery.class);
        intent.putExtra("image_path", currentImagePath);
        startActivity(intent);
    }

    /*
    This method returns the file for saving the captured images
     */
    private File getImageFile() throws IOException
    {

        //String timeStamp = new SimpleDateFormat( "pic" +count ).format(new Date());
        String imageName = "pic" + count + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File imageFile = File.createTempFile(imageName, ".jpg", storageDir);
        currentImagePath = imageFile.getAbsolutePath();
        return imageFile;

    }

    /*
    This method helps the number of pictures taken by camera
     */
    public void increaseCount() {
        count++;
    }

    /*
    This method returns the current picture number
     */
    public int getCount() {
        return count;
    }
}