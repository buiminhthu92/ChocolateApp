package com.gabbybears.foodappver4;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
import com.squareup.picasso.Picasso;


public class TestActtivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_layout);

        ImageView imageView = (ImageView) findViewById(R.id.testShowImg);
        Picasso.with(TestActtivity.this)
                .load("http://hungnt-001-site1.1tempurl.com/get_1_image.php?imageId=1")
                .into(imageView);

    }
}
