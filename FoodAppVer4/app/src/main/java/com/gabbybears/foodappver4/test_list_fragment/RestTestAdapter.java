package com.gabbybears.foodappver4.test_list_fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.home_screen.Map_With_Tag_Fragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RestTestAdapter extends RecyclerView.Adapter<RestTestAdapter.Holder> {

    public static String TAG = RestTestAdapter.class.getSimpleName();

    private List<Rest_Item_Test> mFlowers;

    public RestTestAdapter(List<Rest_Item_Test> flowers) {
        mFlowers = flowers;
    }

    public void addFlower(Rest_Item_Test flower) {
        mFlowers.add(flower);
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_by_distance_element_layout, parent, false);

        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Rest_Item_Test currentFlower = mFlowers.get(position);
        holder.nameRest.setText(currentFlower.nameRest);
        holder.addressRest.setText(currentFlower.addressRest);
        holder.nameTagRest.setText(currentFlower.nameTagRest);
        holder.distanceRest.setText(String.valueOf(CallDistance(currentFlower.longtitude, currentFlower.latitude)));

        Picasso.with(holder.itemView.getContext()).load(Constants.PHOTO_URL + currentFlower.nameCoverRest).into(holder.coverRest);
    }

    @Override
    public int getItemCount() {
        return mFlowers.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public TextView nameRest, addressRest, distanceRest, nameTagRest;
        public ImageView coverRest;

        public Holder(View itemView) {
            super(itemView);
            coverRest = (ImageView) itemView.findViewById(R.id.coverRestImg);
            nameRest = (TextView) itemView.findViewById(R.id.nameRestTv);
            addressRest = (TextView) itemView.findViewById(R.id.addressRestTv);
            distanceRest = (TextView) itemView.findViewById(R.id.distanceRestTv);
            nameTagRest = (TextView) itemView.findViewById(R.id.nameTagRestTv);
        }
    }

    public double CallDistance(double latitude, double longtitude) {
        double userLat = Map_With_Tag_Fragment.latLngOfUser.latitude;
        double userLong = Map_With_Tag_Fragment.latLngOfUser.longitude;

        double dist;
        double a1 = (userLat - latitude) * (userLat - latitude);
        double a2 = (userLong - longtitude) * (userLong - longtitude);
        dist = Math.sqrt(a1 + a2);
        return dist;
    }
}
