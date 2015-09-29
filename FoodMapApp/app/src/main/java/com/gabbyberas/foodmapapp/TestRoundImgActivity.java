package com.gabbyberas.foodmapapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by Android on 9/29/2015.
 */
public class TestRoundImgActivity extends Activity {

    ImageView imageView1;
    RoundImage roundedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_round_image_layout);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.selfies_girl_2);
        roundedImage = new RoundImage(bm);
        imageView1.setImageDrawable(roundedImage);
    }
}
