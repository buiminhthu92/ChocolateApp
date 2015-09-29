package com.gabbyberas.foodmapapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Android on 9/27/2015.
 */
public class ShowDialogFragment extends Activity {
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.dispay_dialog_fragment_layout);
    }

    public void showDialog(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        ButtonFragment buttonFragment = new ButtonFragment();
        buttonFragment.show(fragmentManager, "ButtonFragment");
    }
}
