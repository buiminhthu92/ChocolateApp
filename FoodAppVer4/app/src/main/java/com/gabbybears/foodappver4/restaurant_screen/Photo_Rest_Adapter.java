package com.gabbybears.foodappver4.restaurant_screen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.profile_screen.Photo_User_Item;
import com.gabbybears.foodappver4.test_list_fragment.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SonNV1368 on 10/6/15.
 * Buoc4: xay dung adapter
 */
public class Photo_Rest_Adapter extends ArrayAdapter<Photo_Rest_Item>{
    private ArrayList<Photo_Rest_Item> arrayStudent;
    private LayoutInflater inflater;

    public Photo_Rest_Adapter(Context context, int resource, List<Photo_Rest_Item> objects) {
        super(context, resource, objects);

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.arrayStudent = (ArrayList<Photo_Rest_Item>) objects;
    }

    /*public Photo_Rest_Adapter(Context context, int resource, ArrayList<Photo_Rest_Item> objects) {
        super(context, resource, objects);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.arrayStudent = objects;
    }*/

    //day la phuong thuc dung de gan du lieu cho item cua list
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolder holder;
        if (itemView == null){
            //dinh nghia 1 item moi bang cach bien file xml cua item thanh view su dung LayoutInflater
            itemView = inflater.inflate(R.layout.photos_element_layout, null);
            holder = new ViewHolder();

            holder.imageViewPicture = (ImageView)itemView.findViewById(R.id.img_user_element_GV);

            //luu cac thanh phan tao item lai de lan sau kophai tao moi
            itemView.setTag(holder);
        }else {
            //lay nhung thanh phan cau tao item ma lan dau tien da tao roi
            holder = (ViewHolder)itemView.getTag();
        }

        //set du lieu cho tung item
        Photo_Rest_Item student = arrayStudent.get(position);
        //holder.imageViewPicture.setImageResource(student.getImageUserItem());
        Picasso.with(holder.imageViewPicture.getContext()).load(Constants.PHOTO_URL + student.photoNameRest).into(holder.imageViewPicture);

        return itemView;
    }

    //muon toi uu listview khi nguoi dung cuon len cuon xuong, nguoi ta se dung viewHolder de
    //luu tru nhung item khi an, hien
    public class ViewHolder{
        public ImageView imageViewPicture;
    }
}
