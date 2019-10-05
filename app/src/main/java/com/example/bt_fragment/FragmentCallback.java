package com.example.bt_fragment;

import java.util.List;

public interface FragmentCallback {
    public void onMsgFromMainToFragment(List<Student> students, int position);
}
