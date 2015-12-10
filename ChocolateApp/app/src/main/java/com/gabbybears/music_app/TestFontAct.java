package com.gabbybears.music_app;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Android on 12/8/2015.
 */
public class TestFontAct extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_font);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "DistProTh.otf");
        TextView tv = (TextView)findViewById(R.id.testTv);
        tv.setTypeface(myTypeface);
    }
}
