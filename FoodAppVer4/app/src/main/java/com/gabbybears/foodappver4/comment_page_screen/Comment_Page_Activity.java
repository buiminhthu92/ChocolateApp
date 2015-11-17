package com.gabbybears.foodappver4.comment_page_screen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gabbybears.foodappver4.R;

/**
 * Created by Android on 11/2/2015.
 */
public class Comment_Page_Activity extends Activity {

    Button backBtnCmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_page_activity_layout);

        backBtnCmt = (Button) findViewById(R.id.backBtnComtAct);
        backBtnCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
