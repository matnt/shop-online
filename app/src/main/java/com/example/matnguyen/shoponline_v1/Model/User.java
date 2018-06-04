package com.example.matnguyen.shoponline_v1.Model;

import java.util.Date;

public class User {
    private int id;
    private String full_name;
    private boolean gender;
    private String email;
    private Date birth_date;
    private String avatar;
    private int password;
    private String sdt;

    public User(String full_name, int password) {
        this.full_name = full_name;
        this.password = password;
    }

    public User(int id, String full_name, boolean gender, String email, Date birth_date, String avatar, int password, String sdt) {
        this.id = id;
        this.full_name = full_name;
        this.gender = gender;
        this.email = email;
        this.birth_date = birth_date;
        this.avatar = avatar;
        this.password = password;
        this.sdt = sdt;
    }

    public User(String full_name, boolean gender, String email, Date birth_date, String sdt) {
        this.full_name = full_name;
        this.gender = gender;
        this.email = email;
        this.birth_date = birth_date;
        this.sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
