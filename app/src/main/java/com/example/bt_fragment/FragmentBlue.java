package com.example.bt_fragment;


import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;


public class FragmentBlue extends Fragment implements FragmentCallback{
    MainActivity main;
    Context context = null;
    // data to fill-up the ListView
    ArrayList<Student> students = new ArrayList<Student>();
    Integer[] icon={R.drawable.ntitled1,R.drawable.ntitled2,R.drawable.ntitled3,R.drawable.ntitled4,
            R.drawable.ntitled5,R.drawable.ntitled6,R.drawable.ntitled7,R.drawable.ntitled8,R.drawable.ntitled9,
            R.drawable.ntitled10,R.drawable.ntitled1,R.drawable.ntitled2,R.drawable.ntitled3,R.drawable.ntitled4,
            R.drawable.ntitled5};
    LinearLayout layout_blue;
    TextView txtBlue;
    ListView listView;
    CustomListAdapter adapter;
    int oldPos=0;

    private void readResource() throws IOException
    {
        int idResource = R.raw.students;
        InputStream is = this.getResources().openRawResource(idResource);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));


        for (int i = 0; i < 15; i++) {
            Student student = new Student();
            student.set_id(reader.readLine());
            student.set_name(reader.readLine());
            student.set_class(reader.readLine());
            student.set_grade(Float.parseFloat((reader.readLine())));
            student.setIcon(icon[i]);
            students.add(student);
        }
        reader.close();
        is.close();
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
            readResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        layout_blue = (LinearLayout) inflater.inflate(R.layout.layout_blue,null);

        txtBlue = (TextView) layout_blue.findViewById(R.id.textViewBlue);
        listView = (ListView) layout_blue.findViewById(R.id.listViewBlue);
        listView.setBackgroundColor(Color.parseColor("#ffccddff"));

        adapter = new CustomListAdapter(context,R.layout.layout_list_item, students);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                main.onMsgFromFragToMain("BLUE-FRAG", students, position);
                Toast.makeText(main,"Selected:!" + position, LENGTH_SHORT).show();
                txtBlue.setText("Mã số: " + students.get(position).get_id());

                if (position!=oldPos)
                {

                    listView.getChildAt(oldPos).setBackgroundColor(Color.TRANSPARENT);
                    listView.getChildAt(position).setBackgroundColor(Color.GREEN);
                }

                oldPos=position;
            }
        });



        return layout_blue;

    }

    @Override
    public void onMsgFromMainToFragment(List<Student> students, int position)
    {
        listView.performItemClick(listView,position,listView.getAdapter().getItemId(position));

        Toast.makeText(main,"Selected:!" + position, LENGTH_SHORT).show();
    }
}
