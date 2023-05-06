package com.example.btvn_b2.Model;

public class Student {
    private int msv;
    private String name;
    private int age;
    private String major;

    public Student() {
        this.msv = 0;
        this.name = "";
        this.age = 0;
        this.major = "";
    }

    public Student(int msv, String name, int age, String major) {
        this.msv = msv;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public int getMsv() {
        return msv;
    }

    public void setMsv(int msv) {
        this.msv = msv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
