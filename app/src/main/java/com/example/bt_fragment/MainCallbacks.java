package com.example.bt_fragment;

import java.util.List;

public interface MainCallbacks {

    // Hàm này để đưa dữ liệu từ fragment lên hàm main , hàm main có vai trò trung gian trong truyền dữ liệu
    void onMsgFromFragToMain(String sender, List<Student> students, int position);
}
