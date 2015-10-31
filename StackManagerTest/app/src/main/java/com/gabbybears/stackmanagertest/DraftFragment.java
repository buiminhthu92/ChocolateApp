package com.gabbybears.stackmanagertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Ratan on 7/29/2015.
 */
public class DraftFragment extends Fragment {

    Button changeFmtBtn;
    private static final String TAG = "FirstFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.draft_layout,null);

    }

    public void ChangeFrag(View view) {
        FragmentTransaction trans = getFragmentManager().beginTransaction();

        trans.replace(R.id.root_frame, new TestFragment());

        trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        trans.addToBackStack(TAG);

        trans.commit();
    }
}
