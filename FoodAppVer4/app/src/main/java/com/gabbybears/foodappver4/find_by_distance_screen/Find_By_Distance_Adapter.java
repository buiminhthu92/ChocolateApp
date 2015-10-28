package com.gabbybears.foodappver4.find_by_distance_screen;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gabbybears.foodappver4.R;

public class Find_By_Distance_Adapter extends BaseAdapter {

    Context context;
    List<Find_By_Distance_Item> rowItem;

    Find_By_Distance_Adapter(Context context, List<Find_By_Distance_Item> rowItem) {
        this.context = context;
        this.rowItem = rowItem;

    }

    @Override
    public int getCount() {

        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.find_by_distance_element_layout, null);
        }

        ImageView coverRest = (ImageView) convertView.findViewById(R.id.coverRestImg);
        TextView nameRest = (TextView) convertView.findViewById(R.id.nameRestTv);
        TextView addressRest = (TextView) convertView.findViewById(R.id.addressRestTv);
        TextView distanceRest = (TextView) convertView.findViewById(R.id.distanceRestTv);
        TextView nameTagRest = (TextView) convertView.findViewById(R.id.nameTagRestTv);
        TextView numCmtRest = (TextView) convertView.findViewById(R.id.numCmtRestTv);
        TextView numImgRest = (TextView) convertView.findViewById(R.id.numImgRestTv);
        TextView numLikeRest = (TextView) convertView.findViewById(R.id.numLikeRestTv);

        Find_By_Distance_Item row_pos = rowItem.get(position);
        // setting the image resource and title
        coverRest.setImageResource(row_pos.getCoverRestItem());
        nameRest.setText(row_pos.getNameRestItem());
        addressRest.setText(row_pos.getAddressRestItem());
        distanceRest.setText(row_pos.getDistanceRestItem());
        nameTagRest.setText(row_pos.getNameTagRestItem());
        numCmtRest.setText(row_pos.getNumCmtRestItem() + " COMMENT");
        numImgRest.setText(row_pos.getNumImgRestItem() + " IMAGE");
        numLikeRest.setText(row_pos.getNumLikeRestItem() + " LIKE");

        return convertView;

    }

}
