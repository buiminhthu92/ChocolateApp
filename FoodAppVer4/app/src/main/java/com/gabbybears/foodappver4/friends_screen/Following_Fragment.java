package com.gabbybears.foodappver4.friends_screen;

import java.util.ArrayList;
import java.util.List;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.profile_screen.Feed_User_Adapter;
import com.gabbybears.foodappver4.profile_screen.Feed_User_Item;

public class Following_Fragment extends android.support.v4.app.ListFragment implements OnItemClickListener {

    String[] menutitles;
    String[] timeArr;
    String[] comArr;
    String[] likeArr;
    String[] cmtNumArr;
    String[] shareArr;

    TypedArray imgArr;
    TypedArray avarArr;

    Feed_User_Adapter adapter;
    private List<Feed_User_Item> rowItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.feed_user_fragment_layout, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        avarArr = getResources().obtainTypedArray(R.array.friend_avar);
        imgArr = getResources().obtainTypedArray(R.array.img_post_feed_user);
        menutitles = getResources().getStringArray(R.array.name_friend);
        timeArr = getResources().getStringArray(R.array.time_post_feed_user);
        comArr = getResources().getStringArray(R.array.comment_post_feed_user);
        likeArr = getResources().getStringArray(R.array.like_num_feed_user);
        cmtNumArr = getResources().getStringArray(R.array.comment_num_feed_user);
        shareArr = getResources().getStringArray(R.array.share_num_feed_user);

        rowItems = new ArrayList<Feed_User_Item>();

        for (int i = 0; i < timeArr.length; i++) {

            Feed_User_Item items = new Feed_User_Item(
                    menutitles[i],
                    avarArr.getResourceId(i, -1),
                    timeArr[i],
                    comArr[i],
                    imgArr.getResourceId(i, -1),
                    likeArr[i],
                    cmtNumArr[i],
                    shareArr[i]);

            rowItems.add(items);
        }

        adapter = new Feed_User_Adapter(getActivity(), rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Toast.makeText(getActivity(), menutitles[position], Toast.LENGTH_SHORT)
                .show();
    }
}
