package ru.eltex;

public abstract class User implements CSV {
    protected int id;
    protected String FIO;
    protected String phone;
    protected static int lastId = 0;

    public User() {
        this.id = lastId;
        lastId++;
    }

    public User(int id) {
        this.id = id;
    }

    public User(String FIO, String phone) {
        this.id = lastId;
        this.FIO = FIO;
        this.phone = phone;
        lastId++;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return this.FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
