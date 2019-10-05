package com.example.bt_fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<Student> {
    Context context;
    ArrayList<Student> students;

    int layoutToBeInflated;

    public CustomListAdapter(Context context, int resource, ArrayList<Student> students)
    {
        super(context, R.layout.layout_list_item, students);
        this.context = context;
        this.students = students;
        layoutToBeInflated = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        View row = layoutInflater.inflate(R.layout.layout_list_item, null);

        TextView txtName = row.findViewById(R.id.textView2);
        ImageView imgIcon = row.findViewById(R.id.imageView);

        txtName.setText(students.get(position).get_name());
        imgIcon.setImageResource(students.get(position).getIcon());

        parent.setBackgroundColor(Color.TRANSPARENT);
        return row;
    }
}
