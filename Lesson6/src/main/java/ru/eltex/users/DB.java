package ru.eltex.users;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class DB {
	public static List<User> getUsers() {
		List<User> users = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "myuser", "123");
			stmt = conn.createStatement();

			String query = "SELECT * FROM fizusers";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String FIO = rs.getString(4);
				String phone = rs.getString(2);
				String address = rs.getString(3);
				User user = new PhysUser(id, FIO, phone, address);
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return users;
	}
}
