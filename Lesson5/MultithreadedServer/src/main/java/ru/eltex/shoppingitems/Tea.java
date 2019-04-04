package ru.eltex.shoppingitems;

import java.util.Scanner;

public class Tea extends Drink {
    private String packageType;

    public Tea()
    {
        super();
    }

    public Tea(String name) {
        super();
        this.name = name;
    }

    public Tea(String name, double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public Tea(String name, String packageType) {
        super();
        this.name = name;
        this.packageType = packageType;
    }

    public void setPackageType(String packageType)
    {
        this.packageType = packageType;
    }

    public String getPackageType()
    {
        return packageType;
    }

    @Override
    public void create() {
        String[] names = {"Lipton", "AhmadTea", "Greenfield", "Akbar", "Candy"};
        String[] packageTypes = {"Paper", "CardBoard", "Tin", "Gift", "Wooden"};
        name = names[(int)(Math.random() * 5)];
        price = (int)(Math.random() * 200);
        firmProvider = "Provider" + String.valueOf((int)(Math.random() * 100));
        manufacturer = "Manufacturer" + String.valueOf((int)(Math.random() * 100));
        packageType = packageTypes[(int)(Math.random() * 5)];

        productsCount++;
    }

    @Override
    public void read() {
        System.out.println("\nID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Provider: " + firmProvider);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Package type: " + packageType);
    }

    @Override
    public void update() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nName: ");
        name = in.next();
        System.out.println("Price: ");
        price = in.nextDouble();
        System.out.println("Provider: ");
        firmProvider = in.next();
        System.out.println("Manufacturer: ");
        manufacturer = in.next();
        System.out.println("Package type: ");
        packageType = in.next();
    }

    @Override
    public void delete() {
        name = "";
        price = 0;
        firmProvider = "";
        manufacturer = "";
        packageType = "";

        productsCount--;
    }
}
