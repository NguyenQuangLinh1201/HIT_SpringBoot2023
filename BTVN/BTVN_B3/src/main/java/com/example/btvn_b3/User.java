package com.example.btvn_b3;

public class User {
    private static int cnt = 0;

    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
        this.id = ++cnt;
    }

    public User(String username, String password) {
        this.id = ++cnt;
        this.username = username;
        this.password = password;
    }
//    @Override
//    public  boolean equals(Object o){
//        if(this == o)
//            return true;
//        if(!(o instanceof User))
//            return false;
//        User that = (User) o;
//        return Object.equals(getUsername(), that.getUsername()) && Object.equals(getPassword(), that.getPassword());
//
//    }
}
