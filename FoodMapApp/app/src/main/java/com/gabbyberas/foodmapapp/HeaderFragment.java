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
public class HeaderFragment extends Fragment implements View.OnClickListener{

    Button homeBtn, searchBtn, saerchTagBtn, addLocationBtn, noticeBtn, loginFbBtn;

    ImageButton[] headerImgBtn = new ImageButton[6];

    LinearLayout searchForm;

    private boolean isDispay = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.header_new, container, false);

        //ImageView imageView = (ImageView) view.findViewById(R.id.my_image);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
