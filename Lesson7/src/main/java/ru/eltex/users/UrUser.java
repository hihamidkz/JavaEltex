package ru.eltex.users;

/**
  * Класс юридического лица
  * @author "Казимов Хамидулла hkasimov1998@inbox.ru"
  * @version "1.0"
  */
public final class UrUser extends User {
	/** Дата регистрации */
    private String registrationDate;

	/** Создает новое юридическое лицо с пустыми полями */
    public UrUser() {
        super();
    }

	/**
	  * Создает новое юридическое лицо с заданными полями
	  * @param id ID пользователя
	  * @param FIO ФИО пользователя
	  * @param phone Телефон пользователя
	  * @param registrationDate Дата регистрации
	  */
    public UrUser(int id, String FIO, String phone, String registrationDate) {
        super(id, FIO, phone);
        this.registrationDate = registrationDate;
    }

	/**
	  * Создает новое юридическое лицо с заданными полями
	  * @param FIO ФИО пользователя
	  * @param phone Телефон пользователя
	  * @param registrationDate Дата регистрации
	  */
    public UrUser(String FIO, String phone, String registrationDate) {
        super(FIO, phone);
        this.registrationDate = registrationDate;
    }

	/** 
	  * Возвращает дату регистрации
	  * @return Дата регистрации
	  */
    public String getRegistrationDate() {
        return registrationDate;
    }

	/** 
	  * Устанавливает дату регистрации
	  * @param registrationDate Дата регистрации
	  */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

	/**
	  * Возвращает строку в формате CSV, содержащую данные пользователя
	  * @return CSV строка
	  */
    @Override
    public String toCSV() {
        return this.id + "; " + this.FIO + "; " + this.phone + "; " + this.registrationDate + "\n";
    }

	/**
	  * Устанавливает значения полей текущего пользователя, беря данные из CSV строки   
	  * @param csv CSV строка
	  */
    @Override
    public void fromCSV(String csv) {
        String[] arr = csv.split(";");
        this.id = Integer.valueOf(arr[0]);
        this.FIO = arr[1];
        this.phone = arr[2];
        this.registrationDate = arr[3];
    }
}
