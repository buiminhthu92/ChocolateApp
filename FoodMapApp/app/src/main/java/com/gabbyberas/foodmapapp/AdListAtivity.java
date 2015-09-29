package com.gabbyberas.foodmapapp;

import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

/**
 * Created by Android on 9/28/2015.
 */
public class AdListAtivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list_layout);

        Context ctx = getApplicationContext();
        Resources res = ctx.getResources();

        String[] options = res.getStringArray(R.array.tag_name);
        TypedArray icons = res.obtainTypedArray(R.array.tag_icon);

        setListAdapter(new ImageAndTextAdapter(ctx, R.layout.main_list_item_layout, options, icons));
    }
}
