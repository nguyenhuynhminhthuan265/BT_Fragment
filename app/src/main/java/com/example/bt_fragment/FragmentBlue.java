package com.example.bt_fragment;


import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class FragmentBlue extends Fragment {
    MainActivity main;
    Context context = null;
    String message = "";
    // data to fill-up the ListView
    ArrayList<Student> students = new ArrayList<Student>();
    Student stu1 = new Student("1","name","class", 9.5f,1);
    Student stu2 = new Student("2","name2","class2", 9.5f,2);

    public FragmentBlue() {
        main = null;
        students.add(stu1);
        students.add(stu2);
    }

    // convenient constructor(accept arguments, copy them to a bundle, binds bundle to fragment)
    public static FragmentBlue newInstance(String strArg) {
        FragmentBlue fragment = new FragmentBlue();
        Bundle args = new Bundle();
        args.putString("strArg1", strArg);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            context = getActivity(); // use this reference to invoke main callbacks
            main=(MainActivity) getActivity();
        } catch (IllegalStateException e) {
            throw new IllegalStateException(
                    "MainActivity must implement callbacks");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        LinearLayout layout_blue = (LinearLayout) inflater.inflate(R.layout.layout_blue,null);

        final TextView txtBlue = (TextView) layout_blue.findViewById(R.id.textViewBlue);
        ListView listView = (ListView) layout_blue.findViewById(R.id.listViewBlue);
        listView.setBackgroundColor(Color.parseColor("#ffccddff"));

        CustomListAdapter adapter = new CustomListAdapter(context,
                R.layout.layout_list_item, students);
        listView.setAdapter(adapter);

//        listView.setSelection(0);
//        listView.smoothScrollToPosition(0);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                main.onMsgFromFragToMain("BLUE-FRAG", students.get(position));
                txtBlue.setText("Blue selected row=" + position);
            }
        });

        return layout_blue;

    }

}
