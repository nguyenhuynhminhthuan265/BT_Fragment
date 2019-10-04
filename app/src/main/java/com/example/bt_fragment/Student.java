package com.example.bt_fragment;

public class Student {
    private String _id;
    private String _name;
    private String _class;
    private float _grade;
    private int icon;

    public Student(){}

    public Student(String _id, String _name, String _class, float _grade, int icon) {
        this._id = _id;
        this._name = _name;
        this._class = _class;
        this._grade = _grade;
        this.icon = icon;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public float get_grade() {
        return _grade;
    }

    public void set_grade(float _grade) {
        this._grade = _grade;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
