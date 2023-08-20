package com.example.recycleadapter;


public class Student {
    private String name;
    private double rate;
    private int img;
    private  int imgDelete ;

    public Student(String name, double rate, int img , int imgDelete) {
        this.name = name;
        this.rate = rate;
        this.img = img;
        this.imgDelete = imgDelete ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getImgDelete() {
        return imgDelete;
    }

    public void setImgDelete(int imgDelete) {
        this.imgDelete = imgDelete;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", img=" + img +
                ", imgDelete=" + imgDelete +
                '}';
    }
}

