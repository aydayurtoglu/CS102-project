package com.example.momentum_demo;

import android.graphics.Bitmap;
import android.net.wifi.p2p.WifiP2pManager;

import java.util.ArrayList;
import java.util.Timer;

public class Video
{
    //properties
    private Timer timer;
    private ArrayList<Bitmap> photos;
    private int duration;

    //constructor
    public Video()
    {
        photos = new ArrayList<Bitmap>();
    }

    //methods
    public void play()
    {

    }

    public void stop()
    {

    }

    public void removePhoto(int index)
    {
        photos.remove(index);
    }

    public void addPhoto(int index, Bitmap photo)
    {
        photos.add(index,photo);
    }

    public void setSpeed(int value)
    {

    }

    public void rewindBack()
    {

    }

    public void rewindForward()
    {

    }
}

