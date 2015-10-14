package com.gabbyberas.picassotest;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Android on 10/9/2015.
 */
public class StudentAdapter extends ArrayAdapter<Student> {
    private ArrayList<Student> arrayStudent;
    private LayoutInflater inflater;

    public StudentAdapter(Context context, int resource, ArrayList<Student> objects) {
        super(context, resource, objects);
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.arrayStudent = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolder holder;

        final Student student = arrayStudent.get(position);

        if(itemView == null) {
            itemView = inflater.inflate(R.layout.listview_element, null);
            holder = new ViewHolder();

            holder.imageView = (ImageView)itemView.findViewById(R.id.imageView);
            holder.textView = (TextView)itemView.findViewById(R.id.nameText);

            itemView.setTag(holder);
        }
        else {
            holder = (ViewHolder)itemView.getTag();
        }

        holder.imageView.setImageBitmap(student.getImageView());
        holder.textView.setText(student.getNameTxt());

        return itemView;
    }

    public class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
