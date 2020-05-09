package com.example.momentum_demo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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

    private Context mContext;
    public int[] imageArray = { R.drawable.logo, R.drawable.logo1, R.drawable.logo, R.drawable.logo1,
            R.drawable.logo, R.drawable.logo1, R.drawable.logo, R.drawable.logo1, R.drawable.logo,
            R.drawable.logo1}; // buraya çektiğimiz resimleri koymamız lazım


    public ImageAdapter(Context mContext){

        this.mContext = mContext;
        Resources res = mContext.getResources();

        //int[] drawables = new int[N];
        //for ( int i = 1; i < N; i++) {
        //    drawables[i] = res.getIdentifier("pic"+i, "drawable", "Android/data/com.example.momentum_demo/files/Pictures");
       // }
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams( new GridView.LayoutParams(340, 350));

        return imageView;

    }
}
