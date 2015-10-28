package com.gabbybears.foodappver4;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by Android on 10/25/2015.
 */
public class TestRoundImage extends Activity {

    ImageView myImg;
    RoundImage roundImage;
    TypedArray listAvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_round_image_layout);

        listAvar = getResources().obtainTypedArray(R.array.icons);

        String a = String.valueOf(listAvar.getString(0));
        Log.d("NAME_ELEMENT0", a);

        myImg = (ImageView) findViewById(R.id.testRoundImg);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), listAvar.getResourceId(0, -1));
        roundImage = new RoundImage(bm);
        myImg.setImageDrawable(roundImage);
    }
}
