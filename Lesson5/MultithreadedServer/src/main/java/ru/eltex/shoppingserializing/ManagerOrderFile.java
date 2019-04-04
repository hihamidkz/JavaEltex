package ru.eltex.shoppingserializing;

import ru.eltex.shoppingprocessing.Orders;
import ru.eltex.shoppingcustomer.Order;

import java.io.*;
import java.util.UUID;

public class ManagerOrderFile extends AManagerOrder {
    private final String filename = "store.bin";
    File file = new File(filename);

    public ManagerOrderFile(Orders orders)
    {
        super(orders);
    }

    @Override
    public void saveById(UUID id)
    {
        try {
            FileOutputStream fo = new FileOutputStream(file);
            ObjectOutputStream so = new ObjectOutputStream(fo);

            Order order = orders.get(id);
            if (order.equals(null)) {
                so.close();
                return;
            }
            so.writeObject(order);
            so.flush();
            so.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Order readById(UUID id)
    {
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream si = new ObjectInputStream(fi);
            while (true) {
                try {
                    Order order = (Order)si.readObject();
                    if (order.getId().equals(id)) {
                        si.close();
                        return order;
                    }
                } catch (EOFException e) {
                    si.close();
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void saveAll()
    {
        try {
            FileOutputStream fo = new FileOutputStream(file);
            ObjectOutputStream so = new ObjectOutputStream(fo);
            so.writeObject(orders);
            so.flush();
            so.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Orders readAll()
    {
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream si = new ObjectInputStream(fi);
            Orders newOrders = (Orders)si.readObject();
            si.close();
            return newOrders;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
