package com.example.macbook.listviewadvance.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbook.listviewadvance.R;
import com.example.macbook.listviewadvance.model.Student;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by SonNV1368 on 10/6/15.
 * Buoc4: xay dung adapter
 */
public class StudentAdapter extends ArrayAdapter<Student>{
    private ArrayList<Student> arrayStudent;
    private LayoutInflater inflater;

    public StudentAdapter(Context context, int resource, ArrayList<Student> objects) {
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
            //random view hien thi
            int min = 1;
            int max = 2;

            Random r = new Random();
            int i1 = r.nextInt(max - min + 1) + min;
            if(i1 == 1) {
                itemView = inflater.inflate(R.layout.item_view_small_layout, null);
            }
            else {
                itemView = inflater.inflate(R.layout.item_view_large_layout, null);
            }

            //itemView = inflater.inflate(R.layout.layout_item_listview, null);
            holder = new ViewHolder();

            holder.imageViewPicture = (ImageView)itemView.findViewById(R.id.imageStudent);
            //luu cac thanh phan tao item lai de lan sau kophai tao moi
            itemView.setTag(holder);
        }else {
            //lay nhung thanh phan cau tao item ma lan dau tien da tao roi
            holder = (ViewHolder)itemView.getTag();
        }

        //set du lieu cho tung item
        Student student = arrayStudent.get(position);
        holder.imageViewPicture.setImageBitmap(student.getImageStudent());

        return itemView;
    }

    //muon toi uu listview khi nguoi dung cuon len cuon xuong, nguoi ta se dung viewHolder de
    //luu tru nhung item khi an, hien
    public class ViewHolder{
        public ImageView imageViewPicture;
    }
}
