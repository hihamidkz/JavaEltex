package ru.eltex;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "myuser", "123");
            stmt = conn.createStatement();
            for (int i = 0; i < 10; i++) {
                String phone = (int)(Math.random() * 100) + "-" + (int)(Math.random() * 1000) + "-" + (int)(Math.random() * 1000);
                PhysUser p = new PhysUser("user" + i, phone, "address" + i);
                String query = "INSERT INTO fizusers (id, fullname, phone, address) VALUES ("
                                                                                             + p.getId() + ", '"
                                                                                             + p.getFIO() + "', '"
                                                                                             + p.getPhone() + "', '"
                                                                                             + p.getAddress() + "');";
                stmt.executeUpdate(query);
            }
            String query = "SELECT * FROM fizusers";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("id\tfullname\tphone\taddress");
            while (rs.next()) {
                int id = rs.getInt(1);
                String FIO = rs.getString(4);
                String phone = rs.getString(2);
                String address = rs.getString(3);
                System.out.println(id + "\t" + FIO + "\t" + phone + "\t" + address);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            conn.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
