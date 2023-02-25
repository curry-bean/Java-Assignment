import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.*;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";
    
    public static void main(String[] args) {
        // Start the RMI server
        try {
            Server server = new Server();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Server", server);
            System.out.println("RMI server started");
        } catch (Exception e) {
            System.err.println("RMI server exception: " + e.getMessage());
            e.printStackTrace();
        }
        
        // Connect to the database
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Connected to database");
            
            // Create a statement and execute a query
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM patients";
            ResultSet rs = stmt.executeQuery(query);
            
            // Print out the results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String condition = rs.getString("condition");
                System.out.printf("Patient ID: %d, Name: %s, Condition: %s\n", id, name, condition);
            }
            
            // Close the statement and result set
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Database exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
