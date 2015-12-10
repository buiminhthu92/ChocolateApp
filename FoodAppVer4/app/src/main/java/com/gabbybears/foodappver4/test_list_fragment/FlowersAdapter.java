package com.gabbybears.foodappver4.test_list_fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gabbybears.foodappver4.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.Holder> {

    public static String TAG = FlowersAdapter.class.getSimpleName();

    private List<Flower> mFlowers;

    public FlowersAdapter(List<Flower> flowers) {
        mFlowers = flowers;
    }

    public void addFlower(Flower flower) {
        mFlowers.add(flower);
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Flower currentFlower = mFlowers.get(position);
        holder.mName.setText(currentFlower.mName);
        holder.mCategory.setText(currentFlower.mCategory);

        Picasso.with(holder.itemView.getContext()).load(Constants.PHOTO_URL + currentFlower.mPhoto).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mFlowers.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public TextView mName, mCategory;
        public ImageView mImage;

        public Holder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.flowerImage);
            mName = (TextView) itemView.findViewById(R.id.flowerName);
            mCategory = (TextView) itemView.findViewById(R.id.flowerCategory);
        }
    }
}

