package com.gabbyberas.materialtest;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Android on 10/14/2015.
 */
public class TestFontActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_font_text_layout);

        TextView myText = (TextView) findViewById(R.id.testFontText);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "DistProTh.otf");
        myText.setTypeface(myTypeface);
    }
}
