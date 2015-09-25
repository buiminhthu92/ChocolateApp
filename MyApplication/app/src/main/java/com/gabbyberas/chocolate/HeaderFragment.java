package com.gabbyberas.chocolate;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Android on 9/24/2015.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class HeaderFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        return inflater.inflate(R.layout.header_layout, container, false);
    }
}
