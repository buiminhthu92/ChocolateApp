package com.gabbyberas.foodmapapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by Android on 10/1/2015.
 */
public class StartScreenActivity extends Activity {

    int[] listStartImg = {R.drawable.app_cover_pic_1, R.drawable.app_cover_pic_2,
            R.drawable.app_cover_pic_3, R.drawable.app_cover_pic_4, R.drawable.app_cover_pic_5,
            R.drawable.app_cover_pic_6, R.drawable.app_cover_pic_7};
    int curImgNum;

    ImageView coverStartImg;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.start_screen_layout);

        coverStartImg = (ImageView)findViewById(R.id.coverStartImg);
        Random random = new Random();
        curImgNum = random.nextInt(listStartImg.length);
        coverStartImg.setImageResource(listStartImg[curImgNum]);
    }
}
