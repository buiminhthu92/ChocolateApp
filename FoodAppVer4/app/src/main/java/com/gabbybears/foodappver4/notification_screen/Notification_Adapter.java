package com.gabbybears.foodappver4.notification_screen;

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

public class Notification_Adapter extends BaseAdapter {

    Context context;
    List<Notification_Item> rowItem;
    private LayoutInflater inflater;

    RoundImage roundImage;

    public Notification_Adapter(Context context, List<Notification_Item> rowItem) {
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
            itemView = inflater.inflate(R.layout.notification_element_layout, null);
            holder = new ViewHolder();

            holder.avarUserNoticeHol = (ImageView) itemView.findViewById(R.id.avarUserNoticeImv);
            holder.nameUserNoticeHol = (TextView) itemView.findViewById(R.id.nameUserNoticeTv);
            holder.nameOfNoticeHol = (TextView) itemView.findViewById(R.id.nameOfNoticeTv);
            holder.stateReadNoticeHol = (ImageView) itemView.findViewById(R.id.stateReadNoticeImv);
            holder.timePostNoticeHol = (TextView) itemView.findViewById(R.id.timePostNoticeTv);

            itemView.setTag(holder);
        }
        else {
            holder = (ViewHolder)itemView.getTag();
        }

        Notification_Item row_pos = rowItem.get(position);
        // setting the image resource and title

        //setting round image
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), row_pos.getAvar_User_NoticeItem());
        roundImage = new RoundImage(bm);
        holder.avarUserNoticeHol.setImageDrawable(roundImage);
        //end round image

        //imgIcon.setImageResource(row_pos.getIcon());
        holder.nameUserNoticeHol.setText(row_pos.getName_User_NoticeItem());
        holder.stateReadNoticeHol.setImageResource(row_pos.getState_Read_NoticeItem());
        holder.nameOfNoticeHol.setText(row_pos.getName_Of_NoticeItem());
        holder.timePostNoticeHol.setText(row_pos.getTime_Post_NoticeItem());

        return itemView;

    }

    public class ViewHolder{
        public ImageView avarUserNoticeHol;
        public TextView nameUserNoticeHol;
        public TextView nameOfNoticeHol;
        public ImageView stateReadNoticeHol;
        public TextView timePostNoticeHol;
    }
}

