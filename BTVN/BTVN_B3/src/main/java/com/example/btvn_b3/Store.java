package com.example.btvn_b3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Store {
    public static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("admin","a123"));
    }

    public static List<User> getUserList() {
        return userList;
    }

    public static void setUserList(List<User> userList) {
        Store.userList = userList;
    }
}
