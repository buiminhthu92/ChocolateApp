package com.gabbybears.foodappver4.restaurant_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gabbybears.foodappver4.R;

/**
 * Created by Android on 10/28/2015.
 */
public class Feed_Restaurant_Fragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.feed_restaurant_fragment_layout, container, false);
        return v;
    }
}
