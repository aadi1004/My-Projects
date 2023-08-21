package minorsecond;

import java.util.ArrayList;
import java.util.List;

import jdbc.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotesManager {
	private List<String> notes;

	public NotesManager() {
		notes = new ArrayList<>();
	}

	public void saveNote(String note) {
		notes.add(note);
		try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO NOTES (note) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, note);
                statement.executeUpdate();
            }
            System.out.println("Note saved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
		}
		
	}

	public void deleteNote(int index) {
		if (index >= 0 && index < notes.size()) {
			notes.remove(index);
			System.out.println("Note deleted successfully.");
		} else {
			System.out.println("Invalid note index.");
		}
		try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "DELETE FROM notes WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, index);
                statement.executeUpdate();
            }
            System.out.println("Note deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void showSavedNotes() {
		System.out.println("Saved Notes:");
		if (notes.isEmpty()) {
			System.out.println("No notes found.");
		} else {
			for (int i = 0; i < notes.size(); i++) {
				System.out.println((i + 1) + ". " + notes.get(i));
			}
		}
		 try (Connection connection = DatabaseConnector.getConnection()) {
	            String query = "SELECT * FROM notes";
	            try (PreparedStatement statement = connection.prepareStatement(query);
	                 ResultSet resultSet = statement.executeQuery()) {
	                while (resultSet.next()) {
	                    System.out.println(resultSet.getInt("id") + ". " + resultSet.getString("note"));
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	
}
