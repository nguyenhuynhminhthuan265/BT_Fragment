package com.example.bt_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;



public class FragmentRed extends Fragment implements FragmentCallback {
    MainActivity main;
    TextView edtMaso;
    TextView edtHoten;
    TextView edtLop;
    TextView edtDiem;
    Button btnFirst;
    Button btnPre;
    Button btnNext;
    Button btnLast;
    public static FragmentRed newInstance(String strArg1) {
        FragmentRed fragment = new FragmentRed();
        Bundle bundle = new Bundle();
        bundle.putString("arg1", strArg1);
        fragment.setArguments(bundle);
        return fragment;
    }// newInstance

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Activities containing this fragment must implement interface: MainCallbacks
        if (!(getActivity() instanceof MainCallbacks)) {
            throw new IllegalStateException( " Activity must implement MainCallbacks");
        }
        main = (MainActivity) getActivity(); // use this reference to invoke main callbacks
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// inflate res/layout_red.xml which includes a textview and a button
        LinearLayout view_layout_red = (LinearLayout) inflater.inflate(
                R.layout.layout_red, null);
// plumbing - get a reference to widgets in the inflated layout
        edtMaso = view_layout_red.findViewById(R.id.maso);
        edtHoten =  view_layout_red.findViewById(R.id.hoten);
        edtLop = view_layout_red.findViewById(R.id.lop);
        edtDiem = view_layout_red.findViewById(R.id.diemtb);
        try {
            Bundle arguments = getArguments();
            String redMessage = arguments.getString("arg1", "");
            edtMaso.setText(redMessage);
        } catch (Exception e) {
            Log.e("RED BUNDLE ERROR - ", "" + e.getMessage());
        }
// clicking the button changes the time displayed and sends a copy to MainActivity
        btnFirst = (Button) view_layout_red.findViewById(R.id.btnFirst);
        btnNext = (Button) view_layout_red.findViewById(R.id.btnNext);
        btnPre = (Button) view_layout_red.findViewById(R.id.btnPrev);
        btnLast = (Button) view_layout_red.findViewById(R.id.btnLast);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String redMessage = "Red clock:\n" + new Date().toString();
                edtMaso.setText(redMessage);
                //main.onMsgFromFragToMain("RED-FRAG", redMessage);
            }
        });
        return view_layout_red;

    }
    @Override
    public void onMsgFromMainToFragment(Student student) {
// receiving a message from MainActivity (it may happen at any point in time)
        //txtMaSo.setText("THIS MESSAGE COMES FROM MAIN:" + strValue);
        edtMaso.setText(student.get_id());
        edtHoten.setText(student.get_name());
        edtLop.setText(student.get_class());
        edtDiem.setText(String.valueOf(student.get_grade()));
    }
}