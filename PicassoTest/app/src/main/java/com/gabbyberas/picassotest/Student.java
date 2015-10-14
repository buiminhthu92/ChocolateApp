package com.gabbyberas.picassotest;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Android on 10/9/2015.
 */
public class Student {
    private Bitmap imageView;
    private String nameTxt;

    public Student(Bitmap imageView, String nameTxt) {
        this.imageView = imageView;
        this.nameTxt = nameTxt;
    }

    public Bitmap getImageView() {
        return imageView;
    }

    public void setImageView(Bitmap imageView) {
        this.imageView = imageView;
    }

    public String getNameTxt() {
        return nameTxt;
    }

    public void setNameTxt(String nameTxt) {
        this.nameTxt = nameTxt;
    }
}
