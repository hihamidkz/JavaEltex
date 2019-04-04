package ru.eltex.shoppingprocessing;

public abstract class ACheck implements Runnable {
    protected Orders orders;

    public ACheck() {}

    public void setOrders(Orders orders)
    {
        this.orders = orders;
    }

    public void run() {}
}
