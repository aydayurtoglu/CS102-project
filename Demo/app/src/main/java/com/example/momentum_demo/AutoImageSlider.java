package com.example.momentum_demo;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/* This class makes a share sheet and a peek for created video.
   @author Can Avsar and Ayda Yurtoglu
   @version 6 May 2020 (should be changed)
 */
public class AutoImageSlider extends AppCompatActivity {

    ViewFlipper viewFlipper;
    Button saveButton;
    //boolean shareBody;
    //boolean shareSub;
    AnimationDrawable animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_image_slider);

        viewFlipper = findViewById(R.id.viewFlipper);
        saveButton = findViewById(R.id.saveButton);


        animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.logo), 500);
        animation.addFrame(getResources().getDrawable(R.drawable.logo1), 500);
        animation.setOneShot(false); //If true, the animation will only run a single time and then stop.

        // Share Sheet Codes

        //import org.jcodec.api.awt.SequenceEncoder;
        //SequenceEncoder enc = new SequenceEncoder(new File("filename"));
        // GOP size will be supported in 0.2
        // enc.getEncoder().setKeyInterval(25);
        // for(...) {
        //  BufferedImage image = ... // Obtain an image to encode
        // enc.encodeImage(image);
        //}
        // enc.finish();


        //Save Button and OnClickListener

        //saveButton.setOnClickListener(new View.OnClickListener() {
        // @Override
        //  public void onClick(View v) {
        // Intent sendIntent = new Intent();
        // sendIntent.setAction(Intent.ACTION_SEND);
        //sendIntent.putExtra(Intent.EXTRA_, something");
        //  sendIntent.setType("video/mp4");
        //   Intent shareIntent = Intent.createChooser(sendIntent, null);
        //   startActivity(shareIntent);
        // }
        //});


        int images[] = {R.drawable.logo, R.drawable.logo1}; //BUNLARI Bİ YERDEN ALMAMIZ LAZIM

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
