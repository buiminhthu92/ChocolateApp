package com.gabbybears.foodappver4.test_list_fragment;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.ListFragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.gabbybears.foodappver4.R;

public class MyListFragment extends android.support.v4.app.ListFragment implements OnItemClickListener {

    String[] menutitles;
    String[] timeArr;
    String[] comArr;
    String[] likeNumArr;
    String[] commentNumArr;
    String[] shareNumArr;

    TypedArray menuIcons;
    TypedArray imgArr;

    CustomAdapter adapter;
    private List<RowItem> rowItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.test_list_fragment, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        menuIcons = getResources().obtainTypedArray(R.array.avar_feed_user);

        menutitles = getResources().getStringArray(R.array.name_feed_user);
        timeArr = getResources().getStringArray(R.array.time_post_feed_user);
        comArr = getResources().getStringArray(R.array.comment_post_feed_user);
        imgArr = getResources().obtainTypedArray(R.array.img_post_feed_user);
        likeNumArr = getResources().getStringArray(R.array.like_num_feed_user);
        commentNumArr = getResources().getStringArray(R.array.comment_num_feed_user);
        shareNumArr = getResources().getStringArray(R.array.share_num_feed_user);

        rowItems = new ArrayList<RowItem>();

        for (int i = 0; i < menutitles.length; i++) {
            RowItem items = new RowItem(
                    menutitles[i],
                    menuIcons.getResourceId(i, -1),
                    timeArr[i],
                    comArr[i],
                    imgArr.getResourceId(i, -1),
                    likeNumArr[i],
                    commentNumArr[i],
                    shareNumArr[i]
                    );

            rowItems.add(items);
        }

        adapter = new CustomAdapter(getActivity(), rowItems);
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

