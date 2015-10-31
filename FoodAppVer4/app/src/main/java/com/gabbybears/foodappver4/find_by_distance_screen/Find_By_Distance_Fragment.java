package com.gabbybears.foodappver4.find_by_distance_screen;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.TestFragment;
import com.gabbybears.foodappver4.restaurant_screen.Restaurant_Fragment_Adapter;
import com.gabbybears.foodappver4.restaurant_screen.Restaurant_Page_Activity;

public class Find_By_Distance_Fragment extends android.support.v4.app.ListFragment implements OnItemClickListener {

    TypedArray avarRestArr;
    String[] nameRestArr;
    String[] addressRestArr;
    String[] distanceRestArr;
    String[] nameTagRestArr;
    String[] numCmtRestArr;
    String[] numImgRestArr;
    String[] numLikeRestArr;

    Find_By_Distance_Adapter adapter;
    private List<Find_By_Distance_Item> rowItems;

    private static final String TAG = "SecondFragmentFindByDistance";
    Fragment fragment = null;
    FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.find_by_distance_fragment_layout, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        avarRestArr = getResources().obtainTypedArray(R.array.cover_rest);
        nameRestArr = getResources().getStringArray(R.array.name_rest);
        addressRestArr = getResources().getStringArray(R.array.address_rest);
        distanceRestArr = getResources().getStringArray(R.array.distance_rest);
        nameTagRestArr = getResources().getStringArray(R.array.name_tag_rest);
        numCmtRestArr = getResources().getStringArray(R.array.num_comment_rest);
        numImgRestArr = getResources().getStringArray(R.array.num_img_rest);
        numLikeRestArr = getResources().getStringArray(R.array.num_like_rest);

        rowItems = new ArrayList<Find_By_Distance_Item>();

        for (int i = 0; i < nameRestArr.length; i++) {
            Find_By_Distance_Item items = new Find_By_Distance_Item(
                    avarRestArr.getResourceId(i, -1),
                    nameRestArr[i],
                    addressRestArr[i],
                    distanceRestArr[i],
                    nameTagRestArr[i],
                    numCmtRestArr[i],
                    numImgRestArr[i],
                    numLikeRestArr[i]
            );

            rowItems.add(items);
        }

        adapter = new Find_By_Distance_Adapter(getActivity(), rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Toast.makeText(getActivity(), nameRestArr[position], Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getActivity(), Restaurant_Page_Activity.class);
        startActivity(intent);
    }

}