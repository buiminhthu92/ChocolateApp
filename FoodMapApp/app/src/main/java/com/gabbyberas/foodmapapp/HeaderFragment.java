package com.gabbyberas.foodmapapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Android on 9/25/2015.
 */
public class HeaderFragment extends Fragment {

    Button homeBtn, searchBtn, saerchTagBtn, addLocationBtn, noticeBtn, loginFbBtn;

    ImageButton[] headerImgBtn = new ImageButton[6];

    LinearLayout searchForm;

    private boolean isDispay = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        return inflater.inflate(R.layout.header_fragment_layout, container, false);

        
    }
}
