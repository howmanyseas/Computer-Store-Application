package computerstore;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbcon {

    private Connection connection;

    public Connection connect() {
        try {
            // Load the JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Replace the following with your actual database connection details
            String connectionUrl = "jdbc:sqlserver://SADIRACOMPUTER:1433;"
                    + "databaseName=COMPUTERSTORE;"
                    + "user=sa;"
                    + "password=sado;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;";
            connection = DriverManager.getConnection(connectionUrl);

            JOptionPane.showMessageDialog(null, "Database connected successfully");
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            handleException(ex);
            return null; // Return null if connection fails
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private void handleException(Exception ex) {
        JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(ex.toString());
    }

    public static void main(String[] args) {
        // Example usage in the main method
        dbcon dbConnector = new dbcon();
        Connection connection = dbConnector.connect();

        // Use the 'connection' object for further database operations
        if (connection != null) {
            // Perform database operations or any other tasks
            System.out.println("Performing database operations...");

            // Close the connection when done
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException ex) {
                dbConnector.handleException(ex);
            }
        }
    }
}
