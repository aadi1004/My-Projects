package minorsecond;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.DatabaseConnector;

public class MainDatabase {
    public static void main(String[] args) {
        Connection connection = null;
        
        try {
            connection = DatabaseConnector.getConnection();
            Statement statement = connection.createStatement();
            
            ResultSet notesTable = statement.executeQuery("SELECT * FROM PASSWORDS");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM NOTES");

            // Process the result set
            while (resultSet.next()) {
            	String password1 = resultSet.getString("PASSWORD");
                String PASSWORDS = resultSet.getString("password");
                String notes = resultSet.getString("notes");
                // ...
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
