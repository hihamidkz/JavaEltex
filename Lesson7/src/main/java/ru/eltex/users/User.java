package ru.eltex.users;

/**
  * Класс пользователя
  * @author "Казимов Хамидулла hkasimov1998@inbox.ru"
  * @version "1.0"
  */
public abstract class User implements CSV {
	/** ID пользователя */
    protected int id;
	/** ФИО пользователя */
    protected String FIO;
	/** Телефон пользователя */
    protected String phone;
	/** Максимальный ID пользователей */
    protected static int lastId = 0;

	/**
	  * Создает нового пользователя с пустыми полями
	  */
    public User() {
        this.id = lastId;
        lastId++;
    }

	/**
	  * Создает пользователя с заданными полями
	  * @param id ID пользователя
	  * @param FIO ФИО пользователя
	  * @param phone Телефон пользователя
	  */
    public User(int id, String FIO, String phone) {
        this.id = id;
        this.FIO = FIO;
        this.phone = phone;
    }

	/**
	  * Создает пользователя с заданными полями
	  * @param FIO ФИО пользователя
	  * @param phone Телефон пользователя
	  */
    public User(String FIO, String phone) {
        this.id = lastId;
        this.FIO = FIO;
        this.phone = phone;
        lastId++;
    }

	/**
	  * Возвращает ID пользователя
	  * @return ID пользователя
	  */
    public int getId() {
        return this.id;
    }

	/** 
	  * Установливает ID пользователя
	  * @param id ID пользователя
	  */
    public void setId(int id) {
        this.id = id;
    }

	/**
	  * Возвращает ФИО пользователя
	  * @return ФИО пользователя
	  */
    public String getFIO() {
        return this.FIO;
    }

	/** 
	  * Установливает ФИО пользователя
	  * @param FIO ФИО пользователя
	  */
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

	/**
	  * Возвращает телефон пользователя
	  * @return Телефон пользователя
	  */
    public String getPhone() {
        return this.phone;
    }

	/** 
	  * Устанавливает телефон пользователя
	  * @param phone Телефон пользователя
	  */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
