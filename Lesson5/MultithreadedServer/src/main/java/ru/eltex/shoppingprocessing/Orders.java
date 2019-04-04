package ru.eltex.shoppingprocessing;

import ru.eltex.shoppingcustomer.*;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.locks.*;

public class Orders<T extends Order> implements Serializable {
    private List<T> orders;

    private Lock l = new ReentrantLock();

    public Orders()
    {
        orders = new LinkedList<>();
    }

    public void purchase(T order) {
        order.setCreationTime();
        order.setAwaitingTime(1000);
        order.setOrderStatus(Status.Awaiting);

        l.lock();
        try {
            orders.add(order);
        } finally {
            l.unlock();
        }
    }

    public void check() {
        Iterator<T> iterator = orders.iterator();

        while (iterator.hasNext()) {
            Order next = iterator.next();
            if (next.timeIsUp() || next.getOrderStatus() == Status.Processed) {
                orders.remove(next);
            }
        }
    }

    public void showOrders() {
        l.lock();
        Iterator<T> iterator = orders.iterator();

        try {
            System.out.println("/////////////////////////////////////////////");
            if (!iterator.hasNext()) {
                System.out.println("No orders");
            }
            while (iterator.hasNext()) {
                Order order = iterator.next();
                Credentials client = order.getCredentials();
                ShoppingCart cart = order.getShoppingCart();
                client.showData();
                cart.showObjects();
                System.out.println("Status: " + order.getOrderStatus().toString());
            }
        } finally {
            l.unlock();
        }
    }

    public void remove(int index) {
        l.lock();

        try {
            if (index < orders.size()) {
                orders.remove(index);
            }
        } finally {
            l.unlock();
        }
    }

    public Order get(int index) {
        l.lock();

        try {
            if (index < orders.size()) {
                return orders.get(index);
            }
        } finally {
            l.unlock();
        }

        return null;
    }

    public Order get(UUID id) {
        l.lock();

        try {
            Iterator<T> iterator = orders.iterator();

            while (iterator.hasNext()) {
                Order next = iterator.next();
                if (next.getId().equals(id)) {
                    return next;
                }
            }
        } finally {
            l.unlock();
        }

        return null;
    }

    public int size() {
        l.lock();

        try {
            return orders.size();
        } finally {
            l.unlock();
        }
    }

    public List<T> getOrders()
    {
        return orders;
    }

    public void setOrders(List<T> orders)
    {
        this.orders = orders;
    }
}
