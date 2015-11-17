package com.gabbybears.foodappver4.home_screen;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.api_retrofit.IApiMethods;
import com.gabbybears.foodappver4.api_retrofit.Curator;
import com.gabbybears.foodappver4.restaurant_screen.Restaurant_Page_Activity;
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

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Android on 10/17/2015.
 */
public class Map_With_Tag_Fragment extends Fragment implements AdapterView.OnItemSelectedListener, GoogleMap.OnMarkerClickListener, View.OnClickListener, LocationListener {
    MapView mMapView;
    private GoogleMap googleMap;

    String[] Languages;
    TypedArray images;
    private Spinner mySpinner;

    private static final String API_URL = "http://hungnt-001-site1.1tempurl.com";
    private static final String API_KEY = "";
    private Marker touchMarker;

    Button chiDuongBtn;
    Button goiRestBtn;

    LocationManager locationManager;
    Context con;
    public static LatLng latLngOfUser;
    private static Polyline polylineFinal;
    private static int countTouch = 0;
    private Marker oldMarker;
    private Marker newMarker;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_and_tag_fragment, container, false);

        chiDuongBtn = (Button) view.findViewById(R.id.ChiDuongBtn);
        goiRestBtn = (Button) view.findViewById(R.id.GoiDienBtn);
        chiDuongBtn.setOnClickListener(this);
        goiRestBtn.setOnClickListener(this);

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
        googleMap.setMyLocationEnabled(true);
        find_Location(getContext());

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

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        LatLng latLng = new LatLng(latitude, longitude);
        googleMap.addMarker(new MarkerOptions().position(latLng));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));
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

    @Override
    public boolean onMarkerClick(Marker marker) {
        countTouch = countTouch + 1;
        //Toast.makeText(getActivity(), String.valueOf(countTouch), Toast.LENGTH_SHORT).show();
        if (countTouch == 1) {
            oldMarker = marker;
        }

        if (countTouch == 2) {
            newMarker = marker;

            Toast.makeText(getActivity(), oldMarker.getTitle().toString() + ", " + newMarker.getTitle().toString(), Toast.LENGTH_SHORT).show();

            if(oldMarker.equals(newMarker)) {
                Intent intent = new Intent(getActivity(), Restaurant_Page_Activity.class);
                startActivity(intent);
                countTouch = 0;
            }
            else {
                countTouch = 0;
            }
        }

        touchMarker = marker;
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ChiDuongBtn:
                if (touchMarker != null) {
                    if(polylineFinal != null) {
                        polylineFinal.remove();
                    }

                    LatLng aLat = touchMarker.getPosition();

                    String url = getDirectionsUrl(latLngOfUser, aLat);

                    DownloadTask downloadTask = new DownloadTask();

                    downloadTask.execute(url);
                }
                else {
                    Toast.makeText(getActivity(), "Touch any marker to begin directions", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.GoiDienBtn:
                if (touchMarker != null) {
                    String str = touchMarker.getSnippet();
                    String[] phoneNum = str.split("-");
                    call(phoneNum[1]);

                }
                else {
                    Toast.makeText(getActivity(), "Touch any marker to begin call", Toast.LENGTH_SHORT).show();
                }
                break;
        }
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

                    switch (restaurent.tagId) {
                        case "1":
                            createMarker(latitude, longitude, restaurent.restName, restaurent.address + " -" + restaurent.phone, R.drawable.marker_sang_trong);
                            break;
                        case "2":
                            createMarker(latitude, longitude, restaurent.restName, restaurent.address + " -" + restaurent.phone, R.drawable.marker_van_phong);
                            break;
                        case "3":
                            createMarker(latitude, longitude, restaurent.restName, restaurent.address + " -" + restaurent.phone, R.drawable.marker_binh_dan);
                            break;
                        case "4":
                            createMarker(latitude, longitude, restaurent.restName, restaurent.address + " -" + restaurent.phone, R.drawable.marker_cafe);
                            break;
                        case "5":
                            createMarker(latitude, longitude, restaurent.restName, restaurent.address + " -" + restaurent.phone, R.drawable.marker_quan_nhau);
                            break;
                        case "6":
                            createMarker(latitude, longitude, restaurent.restName, restaurent.address + " -" + restaurent.phone, R.drawable.marker_an_nhanh);
                            break;
                        case "7":
                            createMarker(latitude, longitude, restaurent.restName, restaurent.address + " -" + restaurent.phone, R.drawable.marker_duong_pho);
                            break;
                    }

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

    //THIS FUNCTION SHOW CURRENT POSITION OF USER
    public void find_Location(Context con) {
        this.con = con;
        String location_context = Context.LOCATION_SERVICE;
        locationManager = (LocationManager) con.getSystemService(location_context);
        List<String> providers = locationManager.getProviders(true);
        for (String provider : providers) {
            locationManager.requestLocationUpdates(provider, 1000, 0,
                    new LocationListener() {

                        public void onLocationChanged(Location location) {}

                        public void onProviderDisabled(String provider) {}

                        public void onProviderEnabled(String provider) {}

                        public void onStatusChanged(String provider, int status,
                                                    Bundle extras) {}
                    });
            Location location = locationManager.getLastKnownLocation(provider);
            if (location != null) {

                double latitude = location.getLatitude();
                double longitude = location.getLongitude();

                LatLng latLng = new LatLng(latitude, longitude);
                latLngOfUser = new LatLng(latitude, longitude);
                googleMap.addMarker(new MarkerOptions().position(latLng));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));

            }
        }
    }


    private String getDirectionsUrl(LatLng origin,LatLng dest){

        // Origin of route
        String str_origin = "origin="+origin.latitude+","+origin.longitude;

        // Destination of route
        String str_dest = "destination="+dest.latitude+","+dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin+"&"+str_dest+"&"+sensor;

        // Output format
        String output = "json";

        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;

        return url;
    }

    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);

            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb  = new StringBuffer();

            String line = "";
            while( ( line = br.readLine())  != null){
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        }catch(Exception e){
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }finally{
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try{
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            }catch(Exception e){
                Log.d("Background Task",e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }


    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>>> {

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try{
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            }catch(Exception e){
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

            // Traversing through all the routes
            for(int i=0;i<result.size();i++){
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for(int j=0;j<path.size();j++){
                    HashMap<String,String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(4);
                lineOptions.color(Color.RED);
            }

            // Drawing polyline in the Google Map for the i-th route
            //googleMap.addPolyline(lineOptions);

            polylineFinal = googleMap.addPolyline (lineOptions);
        }
    }

    private void call(String phoneNum) {
        if(phoneNum.equals("?ang c?p nh?t")) {
            Toast.makeText(getActivity(), "S? ?ang c?p nh?t", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phoneNum));
            getActivity().startActivity(callIntent);
        }
    }
}
