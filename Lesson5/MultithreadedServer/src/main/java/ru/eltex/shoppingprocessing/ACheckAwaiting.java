package ru.eltex.shoppingprocessing;

import ru.eltex.shoppingcustomer.Order;
import ru.eltex.shoppingcustomer.Status;

public class ACheckAwaiting extends ACheck {

    public ACheckAwaiting()
    {
        super();
    }

    @Override
    public void run() {
        int currentIndex = 0;

        while (currentIndex < orders.size()) {
            Order next = orders.get(currentIndex);
            if (next.getOrderStatus().equals(Status.Awaiting)) {
                next.setOrderStatus(Status.Processed);
            }
            currentIndex++;
        }
        //orders.showOrders();
    }
}
