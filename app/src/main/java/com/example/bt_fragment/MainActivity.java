package com.example.bt_fragment;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity implements MainCallbacks {
    FragmentTransaction ft;
    FragmentBlue blueFragment;
    FragmentRed redFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ft = getFragmentManager().beginTransaction();
        blueFragment = FragmentBlue.newInstance("");
        ft.replace(R.id.framentA, blueFragment);
        ft.commit();
// create a new RED fragment - show it
        ft = getFragmentManager().beginTransaction();
        redFragment = FragmentRed.newInstance("");
        ft.replace(R.id.framentB, redFragment);
        ft.commit();

    }



    @Override
    public void onMsgFromFragToMain(String sender, List<Student> students, int position) {
        // show message arriving to MainActivity
        Toast.makeText(getApplication(),
                students.get(position).toString(), Toast.LENGTH_LONG)
                .show();
        if (sender.equals("RED-FRAG")) {
// TODO: if needed, do here something on behalf of the RED fragment
        }
        if (sender.equals("BLUE-FRAG")) {
            try {
// forward blue-data to redFragment using its callback method
                redFragment.onMsgFromMainToFragment(students, position);
            } catch (Exception e) {
                Log.e("ERROR", "onStrFromFragToMain " + e.getMessage());
            }
        }
    }
    }

