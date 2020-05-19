package com.example.momentum_demo;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/* This class makes a share sheet and a peek for created video.
   @author Can Avsar and Ayda Yurtoglu
   @version 6 May 2020 (should be changed)
 */
public class AutoImageSlider extends AppCompatActivity {

    //variables
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
    *This method creates the current activity with an array of pictures
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_image_slider);

        //matching properties with their xml view
        imageanim = findViewById(R.id.imageanim);
        buttonFast = findViewById(R.id.saveButtonFast);
        buttonSlow = findViewById(R.id.saveButtonSlow);
        doneButton = findViewById(R.id.done);

        //creating an animation and initializing the settings
        animation = new AnimationDrawable();
        for ( int i = 0; i < imageArray.length; i++) {
            animation.addFrame(getResources().getDrawable(imageArray[i]), dur);
        }
        animation.setOneShot(true); //If true, the animation will only run a single time and then stop.
        imageanim.setImageDrawable(animation);
        animation.start();

        //adding action listener to the button which fastens the animation
        buttonFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( dur > 50 ) {
                    dur = dur - 50;
                }
            }
        });

        //adding action listener to the button which slows the animation
        buttonSlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( dur < 600) {
                    dur = dur + 50;
                }
            }
        });

        //making animation controlled by enabling pausing and resuming
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

        //finishing the editing process on the animation
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AutoImageSlider.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }

    /*
    //In this we tried to save the animation as an mp4 file instead of a viewflipper image.
    Save Button and OnClickListener
    saveButton.setOnClickListener(new View.OnClickListener() {
     @Override
      public void onClick(View v) {
     Intent sendIntent = new Intent();
     sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_, something");
      sendIntent.setType("video/mp4");
       Intent shareIntent = Intent.createChooser(sendIntent, null);
       startActivity(shareIntent);
     }
    });
    */
}
