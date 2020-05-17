package com.example.momentum_demo;
/**
 * DrawActivity class (drawing shit) """NEAT"""
 * @author Ata Seren, Eren Polat
 * @version 1.0
 */
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DrawActivity extends AppCompatActivity {

    Button btnLoadImage, btnSaveImage;
    ImageView imageResult;

    final int RQS_IMAGE1 = 1;

    Uri source;
    Bitmap bitmapMaster;
    Canvas canvasMaster;

    int prvX, prvY;

    Paint paintDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        btnSaveImage = (Button)findViewById(R.id.saveimage);
        imageResult = (ImageView)findViewById(R.id.result);

        paintDraw = new Paint();
        paintDraw.setStyle(Paint.Style.FILL);
        paintDraw.setColor(Color.BLACK);
        paintDraw.setStrokeWidth(10);
        saveImageView();

        /*btnLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RQS_IMAGE1);
            }
        });
         */

        btnSaveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bitmapMaster != null){
                    saveBitmap(bitmapMaster);
                }
            }
        });

        imageResult.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int action = event.getAction();
                int x = (int) event.getX();
                int y = (int) event.getY();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        prvX = x;
                        prvY = y;
                        drawOnProjectedBitMap((ImageView) v, bitmapMaster, prvX, prvY, x, y);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        drawOnProjectedBitMap((ImageView) v, bitmapMaster, prvX, prvY, x, y);
                        prvX = x;
                        prvY = y;
                        break;
                    case MotionEvent.ACTION_UP:
                        drawOnProjectedBitMap((ImageView) v, bitmapMaster, prvX, prvY, x, y);
                        break;
                }
                /*
                 * Return 'true' to indicate that the event have been consumed.
                 * If auto-generated 'false', your code can detect ACTION_DOWN only,
                 * cannot detect ACTION_MOVE and ACTION_UP.
                 */
                return true;
            }
        });
    }

    /*
    Project position on ImageView to position on Bitmap draw on it
     */

    private void drawOnProjectedBitMap(ImageView iv, Bitmap bm,
                                       float x0, float y0, float x, float y){
        if(x<0 || y<0 || x > iv.getWidth() || y > iv.getHeight()){
            //outside ImageView
            return;
        }else{

            float ratioWidth = (float)bm.getWidth()/(float)iv.getWidth();
            float ratioHeight = (float)bm.getHeight()/(float)iv.getHeight();

            canvasMaster.drawLine(
                    x0 * ratioWidth,
                    y0 * ratioHeight,
                    x * ratioWidth,
                    y * ratioHeight,
                    paintDraw);
            imageResult.invalidate();
        }
    }


    protected void saveImageView() {

        Bitmap tempBitmap;
        ImageAdapter imageAdapter = new ImageAdapter(this);
        Intent i = getIntent();
        int position = i.getExtras().getInt("id");


        //tempBitmap is Immutable bitmap,
        //cannot be passed to Canvas constructor
        tempBitmap = BitmapFactory.decodeResource(getResources(), imageAdapter.imageArray[position]);

        Bitmap.Config config;
        if(tempBitmap.getConfig() != null){
            config = tempBitmap.getConfig();
        }else{
            config = Bitmap.Config.ARGB_8888;
        }

        //bitmapMaster is Mutable bitmap
        bitmapMaster = Bitmap.createBitmap(
                tempBitmap.getWidth(),
                tempBitmap.getHeight(),
                config);

        canvasMaster = new Canvas(bitmapMaster);
        canvasMaster.drawBitmap(tempBitmap, 0, 0, null);

        imageResult.setImageBitmap(bitmapMaster);

    }

    private void saveBitmap(Bitmap bm){
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File newFile = new File(storageDir, "test.jpg");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile);
            bm.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(DrawActivity.this,
                    "Save Bitmap: " + fileOutputStream.toString(),
                    Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(DrawActivity.this,
                    "Something wrong: " + e.getMessage(),
                    Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(DrawActivity.this,
                    "Something wrong: " + e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }
}