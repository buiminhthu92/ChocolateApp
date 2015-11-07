package com.gabbybears.foodappver4.home_screen;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.gabbybears.foodappver4.api_retrofit.IApiMethods;
import com.gabbybears.foodappver4.api_retrofit.Curator;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Android on 10/17/2015.
 */
public class Map_With_Tag_Fragment extends Fragment implements AdapterView.OnItemSelectedListener, GoogleMap.OnMarkerClickListener {
    MapView mMapView;
    private GoogleMap googleMap;
    LatLng myPosition;

    String[] Languages;
    TypedArray images;
    private Spinner mySpinner;

    private static final String API_URL = "http://haiha711-001-site1.1tempurl.com";
    private static final String API_KEY = "";
    private Marker touchMarker;
    private Boolean firstZoom = true;

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
        mMapView = (MapView) view.findViewById(R.id.new_mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();

        //Enable my location on google map
        //googleMap.setMyLocationEnabled(true);
        centerMapOnMyLocation();

        /*googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                if(firstZoom) {
                    CameraUpdate center=CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude()));
                    CameraUpdate zoom=CameraUpdateFactory.zoomTo(11);
                    googleMap.moveCamera(center);
                    googleMap.animateCamera(zoom);
                    firstZoom = false;
                }
            }
        });*/

        googleMap.setOnMarkerClickListener(this);

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

        switch (position) {
            case 0:
                googleMap.clear();
                SetTagOnMap("0");
                break;
            case 1:
                googleMap.clear();
                SetTagOnMap("1");
                break;
            case 2:
                googleMap.clear();
                SetTagOnMap("2");
                break;
            case 3:
                googleMap.clear();
                SetTagOnMap("3");
                break;
            case 4:
                googleMap.clear();
                SetTagOnMap("4");
                break;
            case 5:
                googleMap.clear();
                SetTagOnMap("5");
                break;
            case 6:
                googleMap.clear();
                SetTagOnMap("6");
                break;
            case 7:
                googleMap.clear();
                SetTagOnMap("7");
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /*@Override
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

    }*/

    @Override
    public boolean onMarkerClick(Marker marker) {

        String str = marker.getTitle().toString();
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();

        touchMarker = marker;

        return false;
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


    public void SetTagOnMap(String i) {
        //Toast.makeText(getActivity(), "Co chay", Toast.LENGTH_SHORT).show();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();
        IApiMethods methods = restAdapter.create(IApiMethods.class);
        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                Curator curators = (Curator) o;

                for (Curator.Dataset restaurent : curators.restaurent) {
                    // latitude and longitude
                    double longitude = Double.parseDouble(restaurent.latitudeY);
                    double latitude = Double.parseDouble(restaurent.longitudeX);

                    createMarker(latitude, longitude, restaurent.restName, restaurent.address + " /" + restaurent.phone, R.drawable.location51);
                    Log.d("TAG_VALUE", latitude + ", " + longitude);
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        };

        switch (i) {
            case "0":
                methods.getCurators(API_KEY, callback);
                break;
            case "1":
                methods.getCurators1(API_KEY, callback);
                break;
            case "2":
                methods.getCurators2(API_KEY, callback);
                break;
            case "3":
                methods.getCurators3(API_KEY, callback);
                break;
            case "4":
                methods.getCurators4(API_KEY, callback);
                break;
            case "5":
                methods.getCurators5(API_KEY, callback);
                break;
            case "6":
                methods.getCurators6(API_KEY, callback);
                break;
            case "7":
                methods.getCurators7(API_KEY, callback);
                break;
        }
        //methods.getCurators(API_KEY, callback);
    }

    protected Marker createMarker(double latitude, double longitude, String title, String snippet, int iconResID) {

        return googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .anchor(0.5f, 0.5f)
                .title(title)
                .snippet(snippet)
        .icon(BitmapDescriptorFactory.fromResource(iconResID)));
    }

    public void CallTouch(View v) {
        if (touchMarker != null) {
            Toast.makeText(getActivity(), "Run in sub string", Toast.LENGTH_SHORT).show();
            String str = touchMarker.getSnippet().toString();
            String[] phoneNum = str.split("/");
            Log.d("PHONE", phoneNum[0]);
        }
    }

    private void centerMapOnMyLocation() {

        googleMap.setMyLocationEnabled(true);

        Location location = googleMap.getMyLocation();

        if (location != null) {
            LatLng myLocation = new LatLng(location.getLatitude(),
                    location.getLongitude());
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation,
                    12));
        }
    }
}
