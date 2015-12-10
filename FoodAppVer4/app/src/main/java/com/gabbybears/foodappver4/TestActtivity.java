package com.gabbybears.foodappver4;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.widget.ImageView;

import com.gabbybears.foodappver4.test_list_fragment.SwipeRefreshFragment;
import com.squareup.picasso.Picasso;


public class TestActtivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_layout);

        ImageView imageView =(ImageView) findViewById(R.id.testSwipeList);

        Picasso.with(TestActtivity.this).load("http://hungnt-001-site1.1tempurl.com/photo/an_chay.jpg").into(imageView);
    }
}
