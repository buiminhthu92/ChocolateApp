package com.gabbybears.foodappver4.friend_page_activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.RoundImage;

/**
 * Created by Android on 11/1/2015.
 */
public class About_Friend_Fragment extends Fragment {

    RoundImage roundImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_fragment_layout, container, false);

        ImageView avarFriendImv = (ImageView) view.findViewById(R.id.friendAvarPage);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.selfies_girl_3);
        roundImage = new RoundImage(bm);
        avarFriendImv.setImageDrawable(roundImage);


        return view;
    }
}
