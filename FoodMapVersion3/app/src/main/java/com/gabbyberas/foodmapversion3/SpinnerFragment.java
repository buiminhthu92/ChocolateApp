package com.gabbyberas.foodmapversion3;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Android on 10/6/2015.
 */
public class SpinnerFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    String[] Languages = { "Sang Trong", "Van Phong", "Binh Dan",
            "Via He", "Quan Nhau" };
    // Declaring the Integer Array with resourse Id's of Images for the Spinners
    Integer[] images = { R.drawable.sang_trong_icon, R.drawable.van_phong_icon, R.drawable.binh_dan_icon,
            R.drawable.duong_pho_icon, R.drawable.quan_nhau_icon};

    private Spinner mySpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.find_tag_layout, container, false);

        mySpinner = (Spinner) rootView.findViewById(R.id.tag_Spinner);
        mySpinner.setAdapter(new MyAdapter(getActivity(), R.layout.find_tag_layout,
                Languages));
        mySpinner.setOnItemSelectedListener(this);

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String pos = String.valueOf(position);
        Toast.makeText(getActivity(), pos, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
            left_icon.setImageResource(images[position]);

            return mySpinner;
        }
    }


}
