package com.gabbyberas.foodmapapp;

import android.app.DialogFragment;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Android on 9/28/2015.
 */
public class TestList extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {

        setCancelable(false);

        View view = inflater.inflate(R.layout.search_by_tag_layout, null);
        getDialog().setTitle("Search By Tag");

        return view;
    }
}
