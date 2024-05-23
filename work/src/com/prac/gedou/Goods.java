package com.prac.gedou;

public class Goods {
    /*需求：
        定义数组存储3部汽车对象。
        汽车的属性：品牌，价格，颜色。
        创建三个汽车对象，数据通过键盘录入而来，并把数据存入到数组当中。*/
    private String brand;
    private int price;
    private String color;

    public Goods() {
    }

    public Goods(String brand, int price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
