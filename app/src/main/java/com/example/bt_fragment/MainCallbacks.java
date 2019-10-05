package com.example.bt_fragment;

import java.util.List;

public interface MainCallbacks {

    public void onMsgFromFragToMain (String sender, List<Student> students, int position);
}
