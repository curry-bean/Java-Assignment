import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcExample {
    public static void main(String[] args) {
        // JDBC driver and database URL
        String jdbcDriver = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/hospital";

        // Database credentials
        String user = "root";
        String password = "";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Register JDBC driver
            Class.forName(jdbcDriver);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(dbUrl, user, password);

            // Prepare statement to insert a new patient record
            String sql = "INSERT INTO patients (patient_id, name, age, gender, phone_number) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 1);
            stmt.setString(2, "John Smith");
            stmt.setInt(3, 30);
            stmt.setString(4, "Male");
            stmt.setString(5, "123-456-7890");

            // Execute the statement
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " rows");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Clean-up environment
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        System.out.println("Goodbye!!!");
    }
}
