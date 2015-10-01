package com.gabbyberas.foodmapapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.gabbyberas.foodmapapp.R.color.cafe_color;
import static com.gabbyberas.foodmapapp.R.color.red;

public class MapsActivity extends FragmentActivity implements AdapterView.OnItemSelectedListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    String[] contentTag = {"Tim tat ca", "gia cao", "Com vp", "Com bd", "Quan cafe", "bia, nhau", "KFC", "Che"};
    String[] nameTag = {"Tat Ca", "Sang Trong", "Van Phong", "Binh Dan", "Cafe", "Quan Nhau", "Do An Nhanh", "Via He"};
    int[] idTagImg = {R.drawable.app_icon2, R.drawable.sang_trong_icon, R.drawable.van_phong_icon,
            R.drawable.binh_dan_icon, R.drawable.cafe_icon,
            R.drawable.quan_nhau_icon, R.drawable.do_an_nhanh_icon, R.drawable.duong_pho_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        Spinner mySpinner = (Spinner) findViewById(R.id.tagSpinner);
        mySpinner.setAdapter(new MyAdapter(this, R.layout.search_by_tag_layout, contentTag));
    }

    public class MyAdapter extends ArrayAdapter<String> {
        public MyAdapter(Context ctx, int textViewResouceId, String[] objects) {
            super(ctx, textViewResouceId, objects);
        }

        @Override
        public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
            return getCustomView(position, cnvtView, prnt);
        }

        @Override
        public View getView(int pos, View cnvtView, ViewGroup prnt) {
            return getCustomView(pos, cnvtView, prnt);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View mySpinner = inflater.inflate(R.layout.search_by_tag_layout, parent, false);

            TextView main_text = (TextView) mySpinner.findViewById(R.id.nameTagTv);
            main_text.setText(nameTag[position]);

            TextView subSpinner = (TextView) mySpinner.findViewById(R.id.contentTag);
            subSpinner.setText(contentTag[position]);

            ImageView left_icon = (ImageView) mySpinner .findViewById(R.id.tagIconImg);
            left_icon.setImageResource(idTagImg[position]);

            return mySpinner;
        }

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    //search method on the search Button in activity_map.xml file
//    public void onSearch(View v) {
//        EditText location_tf = (EditText)findViewById(R.id.search_text);
//        String location = location_tf.getText().toString();
//        List<Address> addressList = null;
//
//        if(location != null || !location.equals(" ")) {
//            Geocoder geocoder = new Geocoder(this);
//            try {
//               addressList = geocoder.getFromLocationName(location, 1);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            //Set try catch o day
//            Address address = addressList.get(0);
//
//            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
//            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
//            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
//        }
//    }

    //Change type of map method on the type Button in activity_map.xml file
    public void onMapType(View v) {
        if(mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }
        else {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    }

    //zoom method on the zoom Button in activity_map.xml file
    public void onZoom(View v) {
        if(v.getId() == R.id.zoon_in_Ibtn) {
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }

        if(v.getId() == R.id.zoon_out_Ibtn) {
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        mMap.setMyLocationEnabled(true);
    }
}
