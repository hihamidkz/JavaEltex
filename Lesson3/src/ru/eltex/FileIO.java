package ru.eltex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
	private final String PHYS_FILE = "physpersons.csv";
	private final String UR_FILE = "urpersons.csv";
	private final int AMOUNT = 10;
	 
	public void writePhysPersons() throws IOException {
		FileWriter fw = new FileWriter(PHYS_FILE);

		fw.write("ID;FullName;Phone;Address\n");
		
		for (int i = 0; i < AMOUNT; i++) {
			String phone = (int)(Math.random() * 100) + "-" + (int)(Math.random() * 1000) + "-" + (int)(Math.random() * 1000);
			User p = new PhysUser(i, "user" + i, phone, "address" + i);
			String csv = p.toCSV();

			fw.write(csv);
			fw.flush();
		}
		
		fw.close();
	}
	
	public List<User> readPhysPersons() throws IOException {
		List<User> userList = new ArrayList<>();

		FileReader fr = new FileReader(PHYS_FILE);

		Scanner in = new Scanner(fr);
		in.nextLine();
		for (int i = 0; i < AMOUNT; i++) {
			String csv = in.nextLine();
			User p = new PhysUser();
			p.fromCSV(csv);
			userList.add(p);
		}
		
		fr.close();
		
		return userList;
	}
	
	public void writeUrPersons() throws IOException {
		FileWriter fw = new FileWriter(UR_FILE);

		fw.write("ID;FullName;Phone;RegistrationDate\n");
		
		for (int i = 0; i < AMOUNT; i++) {
			String phone = (int)(Math.random() * 100) + "-" + (int)(Math.random() * 1000) + "-" + (int)(Math.random() * 1000);
			User u = new PhysUser(i, "user" + i, phone, "date" + i);
			String csv = u.toCSV();

			fw.write(csv);
			fw.flush();
		}
		
		fw.close();
	}
	
	public List<User> readUrPersons() throws IOException {
		List<User> userList = new ArrayList<>();

		FileReader fr = new FileReader(UR_FILE);

		Scanner in = new Scanner(fr);
		in.nextLine();
		for (int i = 0; i < AMOUNT; i++) {
			String csv = in.nextLine();
			User u = new PhysUser();
			u.fromCSV(csv);
			userList.add(u);
		}
		
		fr.close();
		
		return userList;
	}
}
