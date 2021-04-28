package com.example.tuan6;

import java.io.Serializable;

/////////////////////Chu y

public class Chair implements Serializable {
    private  int anh;
    private int price;
    private  String name;
    private int anhCong;

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnhCong() {
        return anhCong;
    }

    public void setAnhCong(int anhCong) {
        this.anhCong = anhCong;
    }

    public Chair(int anh, int price, String name, int anhCong) {
        this.anh = anh;
        this.price = price;
        this.name = name;
        this.anhCong = anhCong;
    }
}
