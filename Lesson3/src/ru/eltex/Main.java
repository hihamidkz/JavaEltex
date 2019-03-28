package ru.eltex;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileIO io = new FileIO();
        List<User> userList = null;
        
        try {
        	io.writeUrPersons();
        	userList = io.readUrPersons();
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }
        
        for (User u : userList) {
        	System.out.println(u.getFIO() + " " + u.getPhone());
        }
    }
}
