package com.gabbyberas.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Android on 10/1/2015.
 */
public class menu2_Fragment extends Fragment {

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        rootView = inflater.inflate(R.layout.menu1_layout, container, false);
        return rootView;
    }
}
