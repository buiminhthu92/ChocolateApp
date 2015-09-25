package com.gabbyberas.foodmapapp;

import android.app.Activity;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import static com.gabbyberas.foodmapapp.R.color.cafe_color;
import static com.gabbyberas.foodmapapp.R.color.red;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    //Header elements
    ImageButton homeBtn;
    ImageButton searchBtn;
    ImageButton searchTagBtn;
    ImageButton addPlaceBtn;
    ImageButton noticeBtn;
    ImageButton loginFbBtn;

    ImageButton[] headerImgBtn = new ImageButton[6];

    LinearLayout searchForm;

    private boolean isDispay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();


        //Get ID of header elements
        homeBtn = (ImageButton)findViewById(R.id.homeBtn);
        searchBtn = (ImageButton)findViewById(R.id.searchBtn);
        searchTagBtn = (ImageButton)findViewById(R.id.searchTagBtn);
        addPlaceBtn = (ImageButton)findViewById(R.id.addLocationBtn);
        noticeBtn = (ImageButton)findViewById(R.id.noticeBtn);
        loginFbBtn = (ImageButton)findViewById(R.id.loginFbBtn);

        headerImgBtn[0] = homeBtn;
        headerImgBtn[1] = searchBtn;
        headerImgBtn[2] = searchTagBtn;
        headerImgBtn[3] = addPlaceBtn;
        headerImgBtn[4] = noticeBtn;
        headerImgBtn[5] = loginFbBtn;

        searchForm = (LinearLayout)findViewById(R.id.searchForm);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchForm.setVisibility(View.VISIBLE);

                for (int i = 0; i < headerImgBtn.length; i++) {
                    if(headerImgBtn[i] == searchBtn) {
                        headerImgBtn[i].setBackgroundColor(getResources().getColor(R.color.red));
                    }
                    else {
                        headerImgBtn[i].setBackgroundColor(getResources().getColor(R.color.cafe_color));
                    }
                }
            }
        });
    }

//    public void onSearchDE() {
//        searchForm.setEnabled(false);
//    }


    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    //search method on the search Button in activity_map.xml file
    public void onSearch(View v) {
        EditText location_tf = (EditText)findViewById(R.id.search_text);
        String location = location_tf.getText().toString();
        List<Address> addressList = null;

        if(location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
               addressList = geocoder.getFromLocationName(location, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        }
    }

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
