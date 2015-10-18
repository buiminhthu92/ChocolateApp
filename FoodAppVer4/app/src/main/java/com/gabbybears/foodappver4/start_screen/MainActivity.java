package com.gabbybears.foodappver4.start_screen;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.gabbybears.foodappver4.R;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    int[] listStartImg = {R.drawable.app_cover_pic_1, R.drawable.app_cover_pic_2,
            R.drawable.app_cover_pic_3, R.drawable.app_cover_pic_4, R.drawable.app_cover_pic_5,
            R.drawable.app_cover_pic_6, R.drawable.app_cover_pic_7};
    int curImgNum;

    ImageView coverStartImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen_layout);

        coverStartImg = (ImageView)findViewById(R.id.coverStartImg);
        Random random = new Random();
        curImgNum = random.nextInt(listStartImg.length);
        coverStartImg.setImageResource(listStartImg[curImgNum]);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
