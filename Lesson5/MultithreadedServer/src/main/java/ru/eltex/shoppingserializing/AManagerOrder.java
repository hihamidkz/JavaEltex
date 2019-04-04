package ru.eltex.shoppingserializing;

import ru.eltex.shoppingprocessing.Orders;

public abstract class AManagerOrder implements IOrder {
    protected Orders orders;

    public AManagerOrder(Orders orders)
    {
        this.orders = orders;
    }
}
