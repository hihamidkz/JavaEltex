package ru.eltex.shoppingitems;

import java.util.Scanner;

public class Coffee extends Drink {
    private String beansType;

    public Coffee()
    {
        super();
    }

    Coffee(String name) {
        super();
        this.name = name;
    }

    public Coffee(String name, double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public Coffee(String name, String beansType) {
        super();
        this.name = name;
        this.beansType = beansType;
    }

    public void setBeansType(String beansType)
    {
        this.beansType = beansType;
    }

    public String getBeansType()
    {
        return beansType;
    }

    @Override
    public void create() {
        String[] names = {"Jardin", "Jacobs", "MaxwellHouse", "Nescafe", "Bushido"};
        String[] beansTypes = {"Arabica", "Robusta"};
        name = names[(int)(Math.random() * 5)];
        price = 100 + (int)(Math.random() * 500);
        firmProvider = "Provider" + String.valueOf((int)(Math.random() * 100));
        manufacturer = "Manufacturer" + String.valueOf((int)(Math.random() * 100));
        beansType = beansTypes[(int)(Math.random() * 2)];

        productsCount++;
    }

    @Override
    public void read() {
        System.out.println("\nID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Provider: " + firmProvider);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Beans type: " + beansType);
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
        System.out.println("Beans type: ");
        beansType = in.next();
    }

    @Override
    public void delete() {
        name = "";
        price = 0;
        firmProvider = "";
        manufacturer = "";
        beansType = "";

        productsCount--;
    }
}
