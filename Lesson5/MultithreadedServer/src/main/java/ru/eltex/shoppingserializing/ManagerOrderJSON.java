package ru.eltex.shoppingserializing;

import ru.eltex.shoppingprocessing.Orders;
import ru.eltex.shoppingcustomer.Order;
import ru.eltex.shoppingcustomer.ShoppingCart;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

public class ManagerOrderJSON extends AManagerOrder {
    private final String filename = "store.json";
    private final GsonBuilder gsonBuilder = new GsonBuilder();
    private File jsonFile = new File(filename);;
    private Gson gson;

    public ManagerOrderJSON(Orders orders)
    {
        super(orders);
        gsonBuilder.registerTypeAdapter(ShoppingCart.class, new ShoppingCartTypeAdapter());
        gson = gsonBuilder.create();
    }

    @Override
    public void saveById(UUID id)
    {
        Order order = orders.get(id);
        String json = gson.toJson(order);

        try {
            if (!jsonFile.exists()) {
                jsonFile.createNewFile();
            }

            try (PrintWriter jsonWriter = new PrintWriter(jsonFile.getAbsoluteFile())) {
                jsonWriter.println(json);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Order readById(UUID id)
    {
        try (BufferedReader jsonReader = new BufferedReader(new FileReader(jsonFile.getAbsoluteFile()))) {
            if (!jsonFile.exists()) {
                jsonFile.createNewFile();
            }

            while (true) {
                String json = jsonReader.readLine();
                if (json == null)
                    break;
                Order order = (Order)gson.fromJson(json, Order.class);
                if (order.getId().equals(id)) {
                    return order;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void saveAll()
    {
        String json = gson.toJson(orders.getOrders());

        try {
            if (!jsonFile.exists()) {
                jsonFile.createNewFile();
            }

            try (PrintWriter jsonWriter = new PrintWriter(jsonFile.getAbsoluteFile())) {
                jsonWriter.println(json);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Orders readAll()
    {
        try (BufferedReader jsonReader = new BufferedReader(new FileReader(jsonFile.getAbsoluteFile())) ){
            if (!jsonFile.exists()) {
                jsonFile.createNewFile();
            }

            String json = jsonReader.readLine();
            Type type = new TypeToken<List<Order>>(){}.getType();
            List<Order> ordersList = gson.fromJson(json, type);
            Orders newOrders = new Orders();
            newOrders.setOrders(ordersList);
            return newOrders;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
