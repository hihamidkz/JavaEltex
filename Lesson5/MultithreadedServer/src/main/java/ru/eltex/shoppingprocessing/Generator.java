package ru.eltex.shoppingprocessing;

import ru.eltex.shoppingcustomer.*;
import ru.eltex.shoppingitems.*;

public class Generator extends Thread {
    private int count;
    private DrinkType type;
    private Drink[] drinks;
    private ShoppingCart s;
    private Credentials data;
    private Order order;
    private Orders<Order> orders;

    public Generator(int count, DrinkType type, Credentials data, Orders orders) {
        this.count = count;
        this.type = type;
        this.data = data;
        drinks = new Drink[count];
        s = new ShoppingCart<>();
        this.orders = orders;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }

    public Order getOrder()
    {
        return order;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            if (type == DrinkType.Tea) {
                drinks[i] = new Tea();
            } else {
                drinks[i] = new Coffee();
            }
            drinks[i].create();
            s.add(drinks[i]);
        }
        order = new Order(s, data);
        orders.purchase(order);
    }
}
