package computerstore;

import java.sql.Connection;

public class COMPUTERSTORE {

    public static void main(String[] args) {
        // Create an instance of DBConnector
        dbcon dbConnector = new dbcon();

        // Obtain a database connection
        Connection connection = dbConnector.connect();

        // Use the 'connection' object for further database operations
     

            // Note: No need to call disconnect in this example
        }
    
}
