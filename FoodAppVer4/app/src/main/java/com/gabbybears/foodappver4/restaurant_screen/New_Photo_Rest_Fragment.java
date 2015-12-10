package com.gabbybears.foodappver4.restaurant_screen;

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
import com.gabbybears.foodappver4.api_retrofit.Curator;
import com.gabbybears.foodappver4.api_retrofit.IApiMethods;
import com.gabbybears.foodappver4.profile_screen.Photo_User_Adapter;
import com.gabbybears.foodappver4.profile_screen.Photo_User_Item;
import com.gabbybears.foodappver4.test_list_fragment.Constants;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Android on 10/20/2015.
 */
public class New_Photo_Rest_Fragment extends Fragment implements AdapterView.OnItemClickListener {

    private GridView lvStudent;
    private ArrayList<Photo_Rest_Item> arrayStudent;
    private Photo_Rest_Adapter adapter;

    TypedArray photoGallery;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.photo_restaurant_fragment_layout, container, false);

        //khoi tao
        lvStudent = (GridView)view.findViewById(R.id.restaurant_photo_GV);
        arrayStudent = new ArrayList<Photo_Rest_Item>();

        /*photoGallery = getResources().obtainTypedArray(R.array.img_post_feed_user);
        int a = photoGallery.length();
        Log.d("NUM_ARR", String.valueOf(a));
        for (int i = 0; i < photoGallery.length(); i++) {
            Photo_User_Item items = new Photo_User_Item(
                    photoGallery.getResourceId(i, -1)
            );

            arrayStudent.add(items);
        }*/
        GetData();

        adapter = new Photo_Rest_Adapter(getActivity(), R.layout.photos_fragment_layout, arrayStudent);
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

    }

    public void GetData() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://hungnt-001-site1.1tempurl.com")
                .build();
        IApiMethods methods = restAdapter.create(IApiMethods.class);
        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                ImageRestObj curators = (ImageRestObj) o;

                for (ImageRestObj.Dataset2 imageFake : curators.imageFake) {
                    Log.d("NAME_TAG", imageFake.imageName);
                    //Toast.makeText(getActivity(), imageFake.imageName, Toast.LENGTH_SHORT).show();
                    Photo_Rest_Item item = new Photo_Rest_Item(imageFake.imageName);
                    adapter.add(item);
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        };

        methods.getImageRest("", callback);
    }
}