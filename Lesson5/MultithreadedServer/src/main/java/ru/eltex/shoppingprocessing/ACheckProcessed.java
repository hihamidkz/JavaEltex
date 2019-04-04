package ru.eltex.shoppingprocessing;

import ru.eltex.shoppingcustomer.Order;
import ru.eltex.shoppingcustomer.Status;

public class ACheckProcessed extends ACheck {
    public ACheckProcessed()
    {
        super();
    }

    @Override
    public void run() {
        int currentIndex = 0;

        while (currentIndex < orders.size()) {
            Order next = orders.get(currentIndex);
            if (next.getOrderStatus().equals(Status.Processed)) {
                orders.remove(currentIndex);
            }
            currentIndex++;
        }
    }
}
