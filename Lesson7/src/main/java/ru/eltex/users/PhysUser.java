package ru.eltex.users;

/**
  * Класс физического лица
  * @author "Казимов Хамидулла hkasimov1998@inbox.ru"
  * @version "1.0"
  */
public class PhysUser extends User {
	/** Адрес пользователя */
    private String address;

	/** Создает новое физическое лицо с пустыми полями */
    public PhysUser() {
        super();
    }

	/**
	  * Создает физическое лицо с заданными полями
	  * @param id ID пользователя
	  * @param FIO ФИО пользователя
	  * @param phone Телефон пользователя
	  * @param address Адрес пользователя
	  */
    public PhysUser(int id, String FIO, String phone, String address) {
        super(id, FIO, phone);
        this.address = address;
    }

	/**
	  * Создает физическое лицо с заданными полями
	  * @param FIO ФИО пользователя
	  * @param phone Телефон пользователя
	  * @param address Адрес пользователя
	  */
    public PhysUser(String FIO, String phone, String address) {
        super(FIO, phone);
        this.address = address;
    }

	/**
	  * Возвращает адрес пользователя
	  * @return Адрес пользователя
	  */
    public String getAddress() {
        return this.address;
    }

	/** 
	  * Установливает адрес пользователя
	  * @param address Адрес пользователя
	  */
    public void setAddress(String address) {
        this.address = address;
    }

	/**
	  * Возвращает строку в формате CSV, содержащую данные пользователя
	  * @return CSV строка
	  */
    @Override
    public String toCSV() {
        return this.id + ";" + this.FIO + ";" + this.phone + ";" + this.address + "\n";
    }

	/**
	  * Установливает значения полей текущего пользователя, беря данные из CSV строки   
	  * @param csv CSV строка
	  */
	@Override
    public void fromCSV(String csv) {
        String[] arr = csv.split(";");
        this.id = Integer.valueOf(arr[0]);
        this.FIO = arr[1];
        this.phone = arr[2];
        this.address = arr[3];
    }
}
