package ru.eltex.shoppingitems;

import java.io.Serializable;
import java.util.UUID;

public abstract class Drink implements ICrudAction, Serializable {
    protected UUID id;
    protected String name;
    protected double price;
    protected String firmProvider;
    protected String manufacturer;
    static int productsCount;

    public Drink()
    {
        id = UUID.randomUUID();
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setFirmProvider(String firmProvider)
    {
        this.firmProvider = firmProvider;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public String getFirmProvider()
    {
        return firmProvider;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public UUID getId()
    {
        return id;
    }
}
