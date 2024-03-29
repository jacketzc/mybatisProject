package com.jac.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private int id;
    private String username;
    private String sex;
    private Date birthday;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String username,  Date birthday, String sex,String address) {
//        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
    }

    private String address;

}
