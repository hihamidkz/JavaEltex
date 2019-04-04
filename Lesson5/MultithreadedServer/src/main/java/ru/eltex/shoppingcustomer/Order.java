package ru.eltex.shoppingcustomer;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Order implements Serializable {
    private UUID id;
    private Status orderStatus;
    private Date creationTime;
    private Date awaitingTime;
    private ShoppingCart cart;
    private Credentials data;

    public Order() {
        id = UUID.randomUUID();
    }

    public Order(ShoppingCart cart, Credentials data) {
        id = UUID.randomUUID();
        this.cart = cart;
        this.data = data;
    }

    public void setCreationTime()
    {
        creationTime = new Date();
    }

    public void setAwaitingTime(int time)
    {
        awaitingTime = new Date(creationTime.getTime() + time);
    }

    public void setOrderStatus(Status s)
    {
        orderStatus = s;
    }

    public UUID getId()
    {
        return id;
    }

    public Status getOrderStatus()
    {
        return orderStatus;
    }

    public ShoppingCart getShoppingCart()
    {
        return cart;
    }

    public Credentials getCredentials()
    {
        return data;
    }

    public boolean timeIsUp() {
        Date newDate = new Date();

        return newDate.after(awaitingTime);
    }

    public void showOrder() {
        System.out.println("Order ID: " + id);
        System.out.println("Status: " + orderStatus.toString());
        cart.showObjects();
        data.showData();
    }
}
