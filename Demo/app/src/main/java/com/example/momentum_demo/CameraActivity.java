package com.example.momentum_demo;

/**
 *This class represents the camera for our app
 * @author Beste Guney and Ece Teker
 * @version 1.0
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.ContentValues.TAG;
import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE;
import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;
//import static androidx.constraintlayout.widget.Constraints.TAG;

@RequiresApi(api = Build.VERSION_CODES.N)
public class CameraActivity extends Activity {

    String currentImagePath = null;
    private static final int IMAGE_REQUEST = 1;
    private Button captureButton;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_preview);

        captureButton = findViewById(R.id.captureButton1);
        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureImage(v);
            }
        });

    }
    public void captureImage(View view)
    {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (cameraIntent.resolveActivity(getPackageManager()) != null)
        {
            File imageFile = null;

            try {
                imageFile = getImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (imageFile != null)
            {
                Uri imageUri = FileProvider.getUriForFile(this,"com.example.momentum_demo",imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(cameraIntent,IMAGE_REQUEST);
            }
        }
    }

    public void displayImage(View view)
    {
        Intent intent = new Intent(this,DisplayImage.class);
        intent.putExtra("image_path", currentImagePath);
        startActivity(intent);
    }
    private File getImageFile() throws IOException
    {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageName = "jpg" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File imageFile = File.createTempFile(imageName, ".jpg", storageDir);
        currentImagePath = imageFile.getAbsolutePath();
        return imageFile;

    }
}