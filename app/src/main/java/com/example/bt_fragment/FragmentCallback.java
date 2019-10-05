package com.example.bt_fragment;

import java.util.List;

public interface FragmentCallback {
    // Hàm này để đưa dữ liệu từ main qua fragment
    void onMsgFromMainToFragment(List<Student> students, int position);
}
