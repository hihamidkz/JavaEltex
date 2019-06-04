package ru.eltex.database;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import ru.eltex.users.User;
import ru.eltex.users.PhysUser;

public class DB {
	private final static Logger log = Logger.getLogger(DB.class);
	private final static String url = "jdbc:mysql://localhost:3306/phonebook";
	private final static String username = "root";
	private final static String password = "root";

	public static List<User> getUsers() {
		List<User> users = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement stmt = conn.createStatement();

			String query = "SELECT * FROM fizusers";
			log.debug("getUsers: " + query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String FIO = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				User user = new PhysUser(id, FIO, phone, address);
				users.add(user);
			}
			stmt.close();
		} catch (SQLException e) {
			log.error(e.getClass().getSimpleName() + " " + e.getMessage());
		}

		return users;
	}

	public static User getUserById(int id) {
		User user = null;

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement stmt = conn.createStatement();

			String query = "SELECT * FROM fizusers WHERE id=" + id + ";";
			log.debug("getUserById: " + query);
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			String FIO = rs.getString(2);
			String phone = rs.getString(3);
			String address = rs.getString(4);
			user = new PhysUser(id, FIO, phone, address);
			stmt.close();
		} catch (SQLException e) {
			log.error(e.getClass().getSimpleName() + " " + e.getMessage());
		}

		return user;
	}

	public static String getPhoneById(int id) {
		String phone = null;

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement stmt = conn.createStatement();

			String query = "SELECT phone FROM fizusers WHERE id=" + id + ";";
			log.debug("getPhoneById: " + query);
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			phone = rs.getString(1);
			stmt.close();
		} catch (SQLException e) {
			log.error(e.getClass().getSimpleName() + " " + e.getMessage());
		}

		return phone;
	}

	public static String getPhoneByName(String fio) {
		String phone = null;

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement stmt = conn.createStatement();

			String query = "SELECT phone FROM fizusers WHERE FIO='" + fio + "';";
			log.debug("getPhoneByName: " + query);
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			phone = rs.getString(1);
			stmt.close();
		} catch (SQLException e) {
			log.error(e.getClass().getSimpleName() + " " + e.getMessage());
		}

		return phone;
	}
}
