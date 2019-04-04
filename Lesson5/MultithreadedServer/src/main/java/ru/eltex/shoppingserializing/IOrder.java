package ru.eltex.shoppingserializing;

import ru.eltex.shoppingprocessing.Orders;
import ru.eltex.shoppingcustomer.Order;

import java.util.UUID;

public interface IOrder {
    void saveById(UUID id);
    Order readById(UUID id);
    void saveAll();
    Orders readAll();
}
