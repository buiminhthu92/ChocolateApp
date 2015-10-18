package com.gabbyberas.fbloginsample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Android on 10/16/2015.
 */
public class NewActivity extends Activity {

    ImageView avarFB;
    TextView nameFB;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_layout);

        avarFB = (ImageView) findViewById(R.id.avarFBImg);
        nameFB = (TextView) findViewById(R.id.nameFBTv);
        backBtn = (Button) findViewById(R.id.backBtn);



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
