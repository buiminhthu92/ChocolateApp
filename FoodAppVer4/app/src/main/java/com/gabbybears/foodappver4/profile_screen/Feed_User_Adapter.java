package com.gabbybears.foodappver4.profile_screen;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.RoundImage;

public class Feed_User_Adapter extends BaseAdapter {

    Context context;
    List<Feed_User_Item> rowItem;
    private LayoutInflater inflater;

    RoundImage roundImage;

    public Feed_User_Adapter(Context context, List<Feed_User_Item> rowItem) {
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        View itemView = convertView;
        ViewHolder holder;

        if (itemView == null) {
            itemView = inflater.inflate(R.layout.feed_element_layout, null);
            holder = new ViewHolder();

            holder.imgIcon = (ImageView) itemView.findViewById(R.id.feed_User_Avar);
            holder.txtTitle = (TextView) itemView.findViewById(R.id.feed_User_Name);
            holder.timeWasPost = (TextView) itemView.findViewById(R.id.feed_User_Time_Post);
            holder.commentCnt = (TextView) itemView.findViewById(R.id.feed_User_Comment);
            holder.imgPostWall = (ImageView) itemView.findViewById(R.id.feed_User_Img_Post);
            holder.likeCmt = (TextView) itemView.findViewById(R.id.feed_User_Like_Num);
            holder.comtNum = (TextView) itemView.findViewById(R.id.feed_User_Comment_Num);
            holder.shareCmt = (TextView) itemView.findViewById(R.id.feed_User_Share_Num);

            itemView.setTag(holder);
        }
        else {
            holder = (ViewHolder)itemView.getTag();
        }

        Feed_User_Item row_pos = rowItem.get(position);
        // setting the image resource and title

        //setting round image
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), row_pos.getIcon());
        roundImage = new RoundImage(bm);
        holder.imgIcon.setImageDrawable(roundImage);
        //end round image

        //imgIcon.setImageResource(row_pos.getIcon());
        holder.txtTitle.setText(row_pos.getTitle());
        holder.timeWasPost.setText(row_pos.getTimePost());
        holder.commentCnt.setText(row_pos.getCommentContent());
        holder.imgPostWall.setImageResource(row_pos.getImgPost());
        holder.likeCmt.setText(row_pos.getNumLike());
        holder.comtNum.setText(row_pos.getNumCmt());
        holder.shareCmt.setText(row_pos.getNumShare());

        return itemView;

    }

    public class ViewHolder{
        public ImageView imgIcon;
        public TextView txtTitle;
        public TextView timeWasPost;
        public TextView commentCnt;
        public ImageView imgPostWall;
        public TextView likeCmt;
        public TextView comtNum;
        public TextView shareCmt;
    }
}
