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

    //properties
    private AnimationDrawable animation;
    private ImageView imageanim;
    private Button buttonFast;
    private Button doneButton;
    private Button buttonSlow;
    private int[] imageArray = {R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4,
            R.drawable.cat5, R.drawable.cat6, R.drawable.cat7, R.drawable.cat8, R.drawable.cat9,
            R.drawable.cat10, R.drawable.cat11, R.drawable.cat12, R.drawable.cat13, R.drawable.cat14,
            R.drawable.cat15, R.drawable.cat16, R.drawable.cat17, R.drawable.cat18, R.drawable.cat19,
            R.drawable.cat20, R.drawable.cat21, R.drawable.cat22, R.drawable.cat23, R.drawable.cat24,
            R.drawable.cat25, R.drawable.cat26, R.drawable.cat27, R.drawable.cat28};
    private int dur = 300;

    //methods

    /*
    *This method creates the current activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_image_slider);

        //viewFlipper = findViewById(R.id.viewFlipper);
        //saveButton = findViewById(R.id.saveButton);

        imageanim = findViewById(R.id.imageanim);
        buttonFast = findViewById(R.id.saveButtonFast);
        buttonSlow = findViewById(R.id.saveButtonSlow);
        doneButton = findViewById(R.id.done);


        animation = new AnimationDrawable();
        for ( int i = 0; i < imageArray.length; i++) {
            animation.addFrame(getResources().getDrawable(imageArray[i]), dur);
        }
        animation.setOneShot(true); //If true, the animation will only run a single time and then stop.
        imageanim.setImageDrawable(animation);
        animation.start();


        buttonFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( dur > 50 ) {
                    dur = dur - 50;
                }
            }
        });

        buttonSlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( dur < 600) {
                    dur = dur + 50;
                }
            }
        });

        imageanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = new AnimationDrawable();
                for ( int i = 0; i < imageArray.length; i++) {
                    animation.addFrame(getResources().getDrawable(imageArray[i]), dur);
                }
                animation.setOneShot(true); //If true, the animation will only run a single time and then stop.
                imageanim.setImageDrawable(animation);
               animation.start();
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AutoImageSlider.this, MainActivity.class);
                startActivity(intent);

            }
        });


        //int images[] = {R.drawable.logo, R.drawable.logo1}; //BUNLARI Bİ YERDEN ALMAMIZ LAZIM

        // for loop
        //for (int image : images) {
        //   flipperImages(image);
        //}
    }

    //public void flipperImages(int image){
    // ImageView imageView = new ImageView(this);
    //  imageView.setBackgroundResource(image);

    //   viewFlipper.addView(imageView);
    //  viewFlipper.setFlipInterval(100); // 1 sec
    //  viewFlipper.setAutoStart(true);

    //animation
    //  viewFlipper.setInAnimation(this, android.R.anim.fade_in);
    //   viewFlipper.setOutAnimation(this, android.R.anim.fade_out);
    //}


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

}
