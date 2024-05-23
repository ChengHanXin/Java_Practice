package com.prac.gedou;

import java.util.Scanner;

public class GoodTest {
    public static void main(String[] args) {
        Goods[] goods = new Goods[3];
        for (int i = 0; i < goods.length; i++) {
            goods[i] = new Goods();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the brand of the good: ");
            String brand = scanner.next();
            goods[i].setBrand(brand);

            System.out.print("Enter the price of the good: ");
            int price = scanner.nextInt();
            goods[i].setPrice(price);

            System.out.print("Enter the color of the good: ");
            String color = scanner.next();
            goods[i].setColor(color);
        }

        for (int i = 0; i < goods.length; i++) {
            System.out.println("品牌为：" + goods[i].getBrand() + "，价格为：" + goods[i].getPrice() + "，颜色为：" + goods[i].getColor());
        }
    }

}
