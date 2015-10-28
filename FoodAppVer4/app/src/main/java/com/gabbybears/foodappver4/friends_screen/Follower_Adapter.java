package com.gabbybears.foodappver4.friends_screen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.RoundImage;

import java.util.ArrayList;

/**
 * Created by SonNV1368 on 10/6/15.
 * Buoc4: xay dung adapter
 */
public class Follower_Adapter extends ArrayAdapter<Follower_Item>{
    private ArrayList<Follower_Item> arrayStudent;
    private LayoutInflater inflater;

    RoundImage roundImage;

    public Follower_Adapter(Context context, int resource, ArrayList<Follower_Item> objects) {
        super(context, resource, objects);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.arrayStudent = objects;
    }

    //day la phuong thuc dung de gan du lieu cho item cua list
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolder holder;
        if (itemView == null){
            //dinh nghia 1 item moi bang cach bien file xml cua item thanh view su dung LayoutInflater
            itemView = inflater.inflate(R.layout.follower_element_layout, null);
            holder = new ViewHolder();

            holder.avarFriend = (ImageView)itemView.findViewById(R.id.avar_Friends);
            holder.nameFriend = (TextView)itemView.findViewById(R.id.name_Friends);
            holder.numFlFriend = (TextView)itemView.findViewById(R.id.numfl_Friends);

            //luu cac thanh phan tao item lai de lan sau kophai tao moi
            itemView.setTag(holder);
        }else {
            //lay nhung thanh phan cau tao item ma lan dau tien da tao roi
            holder = (ViewHolder)itemView.getTag();
        }

        //set du lieu cho tung item
        Follower_Item student = arrayStudent.get(position);

        //setting round image
        Bitmap bm = BitmapFactory.decodeResource(getContext().getResources(), student.getAvarFriends());
        roundImage = new RoundImage(bm);
        holder.avarFriend.setImageDrawable(roundImage);
        //end round image

        holder.nameFriend.setText(student.getNameFriends());
        holder.numFlFriend.setText(student.getNumFollowFriends() + " followers");

        return itemView;
    }

    //muon toi uu listview khi nguoi dung cuon len cuon xuong, nguoi ta se dung viewHolder de
    //luu tru nhung item khi an, hien
    public class ViewHolder{
        public ImageView avarFriend;
        public TextView nameFriend;
        public TextView numFlFriend;
    }
}
