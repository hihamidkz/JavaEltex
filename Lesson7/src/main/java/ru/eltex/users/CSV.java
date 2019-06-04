package ru.eltex.users;

/**
  * Интерфейс, содержащий методы для работы с CSV 
  * @author "Казимов Хамидулла hkasimov1998@inbox.ru"
  * @version "1.0"
  */
public interface CSV {
	/**
	  * Возвращает строку в формате CSV, содержащую данные объекта
	  * @return CSV строка
	  */
    public String toCSV();

	/**
	  * Устанавливает значения полей текущего объекта, беря данные из CSV строки   
	  * @param csv CSV строка
	  */
    public void fromCSV(String csv);
}
