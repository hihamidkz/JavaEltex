package ru.eltex.shoppingserializing;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import ru.eltex.shoppingitems.*;
import ru.eltex.shoppingcustomer.ShoppingCart;

import java.io.IOException;
import java.util.UUID;

public class ShoppingCartTypeAdapter extends TypeAdapter<ShoppingCart> {
    @Override
    public ShoppingCart read(final JsonReader in) throws IOException
    {
        final ShoppingCart<Drink> cart = new ShoppingCart();

        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "arrayList":
                    in.beginArray();
                    Drink drink = null;
                    while (in.hasNext()) {
                        in.beginObject();
                        while (in.hasNext()) {
                            switch (in.nextName()) {
                                case "beansType":
                                    drink = new Coffee();
                                    ((Coffee) drink).setBeansType(in.nextString());
                                    break;
                                case "packageType":
                                    drink = new Tea();
                                    ((Tea) drink).setPackageType(in.nextString());
                                    break;
                                case "id":
                                    drink.setId(UUID.fromString(in.nextString()));
                                    break;
                                case "name":
                                    drink.setName(in.nextString());
                                    break;
                                case "price":
                                    drink.setPrice(in.nextDouble());
                                    break;
                                case "firmProvider":
                                    drink.setFirmProvider(in.nextString());
                                    break;
                                case "manufacturer":
                                    drink.setManufacturer(in.nextString());
                                    break;
                            }
                        }
                        in.endObject();
                    }
                    cart.add(drink);
                    in.endArray();
                    break;
                case "idSet":
                    in.beginArray();
                    while (in.hasNext()) {
                        in.nextString();
                    }
                    in.endArray();
                    break;
            }
        }
        in.endObject();

        return cart;
    }

    @Override
    public void write(final JsonWriter out, final ShoppingCart order) throws IOException
    {
        out.beginObject();
        out.name("arrayList");
        out.beginArray();
        for (Object drink : order.getArrayList()) {
            out.beginObject();
            if (drink.getClass().equals(Tea.class)) {
                out.name("packageType").value(((Tea) drink).getPackageType());
            } else {
                out.name("beansType").value(((Coffee) drink).getBeansType());
            }
            out.name("id").value(((Drink) drink).getId().toString());
            out.name("name").value(((Drink) drink).getName());
            out.name("price").value(((Drink) drink).getPrice());
            out.name("firmProvider").value(((Drink) drink).getFirmProvider());
            out.name("manufacturer").value(((Drink) drink).getManufacturer());
            out.endObject();
        }
        out.endArray();
        out.name("idSet");
        out.beginArray();
        for (Object drink : order.getArrayList()) {
            out.value(((Drink) drink).getId().toString());
        }
        out.endArray();
        out.endObject();
    }
}
