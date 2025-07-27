package javapackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question_02 {

	public static void main(String[] args) {
		// JDBC URL, username and password
		String url = "jdbc:mysql://localhost:3306/employees";
		String username = "root";
		String password = "Abcd1234#";

		// SQL Insert Statement
		String sql = "INSERT INTO Employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

		// Sample data
		Object[][] employees = { { 101, "Jenny", 25, 10000 }, { 102, "Jacky", 30, 20000 }, { 103, "Joe", 20, 40000 },
				{ 104, "John", 40, 80000 }, { 105, "Shameer", 25, 90000 } };

		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			for (Object[] emp : employees) {
				stmt.setInt(1, (int) emp[0]);
				stmt.setString(2, (String) emp[1]);
				stmt.setInt(3, (int) emp[2]);
				stmt.setDouble(4, (double) ((int) emp[3])); // Cast salary to double
				stmt.executeUpdate();
			}

			System.out.println("Data inserted successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
