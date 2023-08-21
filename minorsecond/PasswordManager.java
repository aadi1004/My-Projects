package minorsecond;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.DatabaseConnector;

public class PasswordManager {

	private List<String> passwords;

	public PasswordManager() {
		passwords = new ArrayList<>();
	}

	public void savePassword(String password) {
		passwords.add(password);

		try (Connection connection = DatabaseConnector.getConnection()) {

			String query = "INSERT INTO PASSWORDS (password) VALUES (?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, password);
				statement.executeUpdate();
			}
			System.out.println("Password saved successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletePassword(int index) {
		if (index >= 0 && index < passwords.size()) {
			passwords.remove(index);
			System.out.println("Password deleted successfully.");
		} else {
			System.out.println("Invalid password index.");
		}

		try (Connection connection = DatabaseConnector.getConnection()) {
			String query = "DELETE FROM passwords WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, index);
				statement.executeUpdate();
			}
			System.out.println("Password deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showSavedPasswords() {
		System.out.println("Saved Passwords:");
		if (passwords.isEmpty()) {
			System.out.println("No passwords found.");
		} else {
			for (int i = 0; i < passwords.size(); i++) {
				System.out.println((i + 1) + ". " + passwords.get(i));
			}
		}

		try (Connection connection = DatabaseConnector.getConnection()) {
			String query = "SELECT * FROM passwords";
			try (PreparedStatement statement = connection.prepareStatement(query);
					ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					System.out.println(resultSet.getInt("id") + ". " + resultSet.getString("password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
