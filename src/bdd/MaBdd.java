package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaBdd {

	static String url = "jdbc:mysql://localhost:3306/m2i"; // url de ma base de donnee
	static String user= "root";
	static String password = "";
	static Connection connexion = null;

	public static Connection LoadDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			connexion = DriverManager.getConnection(url, user, password);
			return connexion;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	static void CloseDatabase() {

		try {
			connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
