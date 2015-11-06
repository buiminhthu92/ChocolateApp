package com.gabbybears.foodappver4.friends_screen;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.friend_page_activity.Friend_Page_Activity;

import java.util.ArrayList;

/**
 * Created by Android on 10/20/2015.
 */
public class Follower_Fragment extends Fragment implements AdapterView.OnItemClickListener {

    private GridView lvStudent;
    private ArrayList<Follower_Item> arrayStudent;
    private Follower_Adapter adapter;

    TypedArray avarFriends;
    String[] nameFriendArr;
    String[] numFlFriendArr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.follower_fragment_layout, container, false);

        //khoi tao
        lvStudent = (GridView)view.findViewById(R.id.follower_GV);
        arrayStudent = new ArrayList<Follower_Item>();

        avarFriends = getResources().obtainTypedArray(R.array.friend_avar);
        nameFriendArr = getResources().getStringArray(R.array.name_friend);
        numFlFriendArr = getResources().getStringArray(R.array.num_Follow_Friend);

        for (int i = 0; i < nameFriendArr.length; i++) {
            Follower_Item items = new Follower_Item(
                    avarFriends.getResourceId(i, -1),
                    nameFriendArr[i],
                    numFlFriendArr[i]
            );

            arrayStudent.add(items);
        }

        adapter = new Follower_Adapter(getActivity(), R.layout.follower_fragment_layout, arrayStudent);
        lvStudent.setAdapter(adapter);
        lvStudent.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getActivity(), "you click" + String.valueOf(i), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getActivity(), Friend_Page_Activity.class);
        startActivity(intent);
    }
}

