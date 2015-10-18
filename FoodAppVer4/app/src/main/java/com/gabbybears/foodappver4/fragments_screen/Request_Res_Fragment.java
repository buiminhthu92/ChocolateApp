package com.gabbybears.foodappver4.fragments_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gabbybears.foodappver4.R;

/**
 * Created by Android on 10/17/2015.
 */
public class Request_Res_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.request_restaurant_fragment, container, false);
        return view;
    }
}
