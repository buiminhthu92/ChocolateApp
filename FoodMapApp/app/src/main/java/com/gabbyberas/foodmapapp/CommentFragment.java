package com.gabbyberas.foodmapapp;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Android on 9/29/2015.
 */
public class CommentFragment extends Fragment {

    ImageView userImg;
    RoundImage roundedImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.comment_layout, container, false);

        userImg = (ImageView)view.findViewById(R.id.userImg);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.selfies_girl_2);
        roundedImage = new RoundImage(bm);
        userImg.setImageDrawable(roundedImage);

        return view;
    }
}
