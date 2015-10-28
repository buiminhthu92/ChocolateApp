package com.gabbybears.foodappver4.test_list_fragment;

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

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<RowItem> rowItem;

    CustomAdapter(Context context, List<RowItem> rowItem) {
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
            convertView = mInflater.inflate(R.layout.test_row_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.feed_User_Avar);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.feed_User_Name);
        TextView timeWasPost = (TextView) convertView.findViewById(R.id.feed_User_Time_Post);
        TextView commentCnt = (TextView) convertView.findViewById(R.id.feed_User_Comment);
        ImageView imgPost = (ImageView) convertView.findViewById(R.id.feed_User_Img_Post);
        TextView numLike = (TextView) convertView.findViewById(R.id.feed_User_Like_Num);
        TextView numComment = (TextView) convertView.findViewById(R.id.feed_User_Comment_Num);
        TextView numShare = (TextView) convertView.findViewById(R.id.feed_User_Share_Num);

        RowItem row_pos = rowItem.get(position);
        // setting the image resource and title
        imgIcon.setImageResource(row_pos.getIcon());
        txtTitle.setText(row_pos.getTitle());
        timeWasPost.setText(row_pos.getTimePost());
        commentCnt.setText(row_pos.getCommentContent());
        imgPost.setImageResource(row_pos.getImgPost());
        numLike.setText(row_pos.getNumLike());
        numComment.setText(row_pos.getNumComment());
        numShare.setText(row_pos.getNumShare());

        return convertView;

    }

}
