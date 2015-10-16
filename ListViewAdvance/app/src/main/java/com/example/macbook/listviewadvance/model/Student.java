package com.example.macbook.listviewadvance.model;

import android.graphics.Bitmap;

/**
 * Buoc3: dinh nghia doi tuong lam viec voi listview
 * Created by SonNV1368 on 10/6/15.
 */
public class Student {
    //dinh nghia cac thuoc tinh su dung de gan cho item cua listview
    private Bitmap imageStudent;

    //xay dung cac phuong thuc khoi tao, cac phuong thuc set get

    public Student(Bitmap imageStudent) {
        this.imageStudent = imageStudent;
    }

    public Bitmap getImageStudent() {
        return imageStudent;
    }

    public void setImageStudent(Bitmap imageStudent) {
        this.imageStudent = imageStudent;
    }

}
