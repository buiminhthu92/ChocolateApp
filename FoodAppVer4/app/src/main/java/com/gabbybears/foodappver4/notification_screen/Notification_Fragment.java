package com.gabbybears.foodappver4.notification_screen;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.ListFragment;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.gabbybears.foodappver4.R;

public class Notification_Fragment extends android.support.v4.app.ListFragment implements OnItemClickListener {

    String[] nameArr;
    String[] timeArr;
    String[] nameNoticeArr;

    TypedArray stateArr;
    TypedArray avarArr;

    Notification_Adapter adapter;
    private List<Notification_Item> rowItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.notification_fragment_layout, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        avarArr = getResources().obtainTypedArray(R.array.friend_avar);
        stateArr = getResources().obtainTypedArray(R.array.state_of_noticce);
        nameArr = getResources().getStringArray(R.array.name_feed_user);
        timeArr = getResources().getStringArray(R.array.time_post_feed_user);
        nameNoticeArr = getResources().getStringArray(R.array.name_of_notice);

        rowItems = new ArrayList<Notification_Item>();

        for (int i = 0; i < nameNoticeArr.length; i++) {

            Notification_Item items = new Notification_Item(
                    avarArr.getResourceId(i, -1),
                    nameArr[i],
                    nameNoticeArr[i],
                    stateArr.getResourceId(i, -1),
                    timeArr[i]
                 );

            rowItems.add(items);
        }

        adapter = new Notification_Adapter(getActivity(), rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Toast.makeText(getActivity(), nameNoticeArr[position], Toast.LENGTH_SHORT)
                .show();
    }
}