package com.example.momentum_demo;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * ImageAdapter class
 * @author Ayda Yurtoglu
 * @version 1.0
 */
public class ImageAdapter<imageArray> extends BaseAdapter {

    //properties
    private Context mContext;
    public int[] imageArray = {R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4,
            R.drawable.cat5, R.drawable.cat6, R.drawable.cat7, R.drawable.cat8, R.drawable.cat9,
            R.drawable.cat10, R.drawable.cat11, R.drawable.cat12, R.drawable.cat13, R.drawable.cat14,
            R.drawable.cat15, R.drawable.cat16, R.drawable.cat17, R.drawable.cat18, R.drawable.cat19,
            R.drawable.cat20, R.drawable.cat21, R.drawable.cat22, R.drawable.cat23, R.drawable.cat24,
            R.drawable.cat25, R.drawable.cat26, R.drawable.cat27, R.drawable.cat28};

    //constructor
    public ImageAdapter(Context mContext){

        this.mContext = mContext;
        Resources res = mContext.getResources();
    }

    //methods

    /*
    This method is a getter for number of pictures in the array
    @return is the length of the array
     */
    @Override
    public int getCount() {
        return imageArray.length;
    }

    /*
    This method returns the picture at specified location
    @return Object is the picture at that location
     */
    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    /*
    This method returns the view of the specified location
    @return view is the picture
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams( new GridView.LayoutParams(340, 350));

        return imageView;

    }
}
