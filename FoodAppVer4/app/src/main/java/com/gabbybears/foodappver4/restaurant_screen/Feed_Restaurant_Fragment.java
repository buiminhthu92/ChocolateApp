package com.gabbybears.foodappver4.restaurant_screen;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.comment_page_screen.Comment_Page_Activity;
import com.gabbybears.foodappver4.profile_screen.Feed_User_Adapter;
import com.gabbybears.foodappver4.profile_screen.Feed_User_Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 10/28/2015.
 */
public class Feed_Restaurant_Fragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView restFeedLv;
    private List<Feed_User_Item> feedRestArr;
    private Feed_User_Adapter adapter;

    String[] menutitles;
    String[] timeArr;
    String[] comArr;
    String[] likeArr;
    String[] cmtNumArr;
    String[] shareArr;

    TypedArray imgArr;
    TypedArray avarArr;

    ImageView showCmt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.feed_restaurant_fragment_layout, container, false);

        restFeedLv = (ListView) v.findViewById(R.id.commentRestLv);
        feedRestArr = new ArrayList<Feed_User_Item>();

        showCmt = (ImageView) v.findViewById(R.id.showCommentAct);
        showCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Comment_Page_Activity.class);
                getActivity().startActivity(intent);
            }
        });

        CreateDataRest();


        adapter = new Feed_User_Adapter(getActivity(), feedRestArr);
        restFeedLv.setAdapter(adapter);
        restFeedLv.setOnItemClickListener(this);

        setListViewHeightBasedOnChildren(restFeedLv);

        return v;
    }

    public void CreateDataRest() {
        avarArr = getResources().obtainTypedArray(R.array.avar_feed_user);
        imgArr = getResources().obtainTypedArray(R.array.img_post_feed_user);
        menutitles = getResources().getStringArray(R.array.name_feed_user);
        timeArr = getResources().getStringArray(R.array.time_post_feed_user);
        comArr = getResources().getStringArray(R.array.comment_post_feed_user);
        likeArr = getResources().getStringArray(R.array.like_num_feed_user);
        cmtNumArr = getResources().getStringArray(R.array.comment_num_feed_user);
        shareArr = getResources().getStringArray(R.array.share_num_feed_user);

        for (int i = 0; i < menutitles.length; i++) {

            Feed_User_Item items = new Feed_User_Item(
                    menutitles[i],
                    avarArr.getResourceId(i, -1),
                    timeArr[i],
                    comArr[i],
                    imgArr.getResourceId(i, -1),
                    likeArr[i],
                    cmtNumArr[i],
                    shareArr[i]);

            feedRestArr.add(items);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(getActivity(), menutitles[position], Toast.LENGTH_SHORT)
                .show();
    }

    /**** Method for Setting the Height of the ListView dynamically.
     **** Hack to fix the issue of not showing all the items of the ListView
     **** when placed inside a ScrollView  ****/
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, AbsListView.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}
