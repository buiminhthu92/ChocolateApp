package com.gabbybears.foodappver4.friends_screen;

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
import com.gabbybears.foodappver4.profile_screen.Feed_User_Item;

public class Following_Adapter extends BaseAdapter {

    Context following_context;
    List<Feed_User_Item> following_rowItem;
    private LayoutInflater following_inflater;

    RoundImage roundImage;

    public Following_Adapter(Context context, List<Feed_User_Item> rowItem) {
        following_inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        following_context = context;
        following_rowItem = rowItem;
    }

    @Override
    public int getCount() {

        return following_rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return following_rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return following_rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolder holder;

        if (itemView == null) {
            itemView = following_inflater.inflate(R.layout.feed_element_layout, null);
            holder = new ViewHolder();

            holder.imgIconFrd = (ImageView) itemView.findViewById(R.id.following_User_Avar);
            holder.txtTitleFrd = (TextView) itemView.findViewById(R.id.following_User_Name);
            holder.timeWasPostFrd = (TextView) itemView.findViewById(R.id.following_User_Time_Post);
            holder.commentCntFrd = (TextView) itemView.findViewById(R.id.following_User_Comment);
            holder.imgPostWallFrd = (ImageView) itemView.findViewById(R.id.following_User_Img_Post);
            holder.likeCmtFrd = (TextView) itemView.findViewById(R.id.following_User_Like_Num);
            holder.comtNumFrd = (TextView) itemView.findViewById(R.id.following_User_Comment_Num);
            holder.shareCmtFrd = (TextView) itemView.findViewById(R.id.following_User_Share_Num);

            itemView.setTag(holder);
        }
        else {
            holder = (ViewHolder)itemView.getTag();
        }

        Feed_User_Item row_pos = following_rowItem.get(position);
        // setting the image resource and title

        //setting round image
        Bitmap bm = BitmapFactory.decodeResource(following_context.getResources(), row_pos.getIcon());
        roundImage = new RoundImage(bm);
        holder.imgIconFrd.setImageDrawable(roundImage);
        //end round image

        //imgIcon.setImageResource(row_pos.getIcon());
        holder.txtTitleFrd.setText(row_pos.getTitle());
        holder.timeWasPostFrd.setText(row_pos.getTimePost());
        holder.commentCntFrd.setText(row_pos.getCommentContent());
        holder.imgPostWallFrd.setImageResource(row_pos.getImgPost());
        holder.likeCmtFrd.setText(row_pos.getNumLike());
        holder.comtNumFrd.setText(row_pos.getNumCmt());
        holder.shareCmtFrd.setText(row_pos.getNumShare());

        return itemView;

    }

    public class ViewHolder{
        public ImageView imgIconFrd;
        public TextView txtTitleFrd;
        public TextView timeWasPostFrd;
        public TextView commentCntFrd;
        public ImageView imgPostWallFrd;
        public TextView likeCmtFrd;
        public TextView comtNumFrd;
        public TextView shareCmtFrd;
    }
}