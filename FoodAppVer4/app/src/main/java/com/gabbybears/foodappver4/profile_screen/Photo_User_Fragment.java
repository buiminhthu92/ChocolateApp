package com.gabbybears.foodappver4.profile_screen;

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

import java.util.ArrayList;

/**
 * Created by Android on 10/20/2015.
 */
public class Photo_User_Fragment extends Fragment implements AdapterView.OnItemClickListener {

   private GridView lvStudent;
   private ArrayList<Photo_User_Item> arrayStudent;
   private Photo_User_Adapter adapter;

   TypedArray photoGallery;

   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.photos_fragment_layout, container, false);

      //khoi tao
      lvStudent = (GridView)view.findViewById(R.id.user_photo_GV);
      arrayStudent = new ArrayList<Photo_User_Item>();

      photoGallery = getResources().obtainTypedArray(R.array.img_post_feed_user);
      int a = photoGallery.length();
      Log.d("NUM_ARR", String.valueOf(a));
      for (int i = 0; i < photoGallery.length(); i++) {
         Photo_User_Item items = new Photo_User_Item(
                 photoGallery.getResourceId(i, -1)
             );

         arrayStudent.add(items);
      }

      adapter = new Photo_User_Adapter(getActivity(), R.layout.photos_fragment_layout, arrayStudent);
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
}

