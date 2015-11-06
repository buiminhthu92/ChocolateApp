package com.gabbybears.foodappver4.home_screen;

import android.content.Context;
import android.content.res.TypedArray;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gabbybears.foodappver4.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Android on 10/17/2015.
 */
public class Map_With_Tag_Fragment extends Fragment implements AdapterView.OnItemSelectedListener, LocationListener{
    MapView mMapView;
    private GoogleMap googleMap;
    LatLng myPosition;

    String[] Languages;
    TypedArray images;
    private Spinner mySpinner;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_and_tag_fragment, container, false);

        //Spinner
        Languages = getResources().getStringArray(R.array.name_of_tag);
        images = getResources().obtainTypedArray(R.array.img_of_tag);

        mySpinner = (Spinner) view.findViewById(R.id.new_tag_Spinner);
        mySpinner.setAdapter(new MyAdapter(getActivity(), R.layout.map_and_tag_fragment,
                Languages));
        mySpinner.setOnItemSelectedListener(this);

        //Mapview
        mMapView = (MapView)view.findViewById(R.id.new_mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();

        //Enable my location on google map
        googleMap.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(provider);
        if(location != null) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();

            myPosition = new LatLng(latitude, longitude);

            //create maker
            MarkerOptions maker = new MarkerOptions().position(
                    myPosition).title("Hello Map");

            //Change maker icon
            maker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

            //adding maker
            googleMap.addMarker(maker);
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(myPosition).zoom(12).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }

        // latitude and longitude
        /*double latitude = 17.385044;
        double longitude = 78.486671;

        //create maker
        MarkerOptions maker = new MarkerOptions().position(
                new LatLng(latitude, longitude)).title("Hello Map");

        //Change maker icon
        maker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

        //adding maker
        googleMap.addMarker(maker);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(17.385044, 78.486671)).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));*/

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String pos = String.valueOf(position);
        Toast.makeText(getActivity(), pos, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public class MyAdapter extends ArrayAdapter<String> {
        public MyAdapter(Context ctx, int txtViewResourceId, String[] objects) {
            super(ctx, txtViewResourceId, objects);
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
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View mySpinner = inflater.inflate(R.layout.find_tag_element, parent, false);
            TextView main_text = (TextView) mySpinner.findViewById(R.id.text_tag_Tv);
            main_text.setText(Languages[position]);

            ImageView left_icon = (ImageView) mySpinner.findViewById(R.id.icon_tag_Img);
            left_icon.setImageResource(images.getResourceId(position, -1));

            return mySpinner;
        }
    }
}
