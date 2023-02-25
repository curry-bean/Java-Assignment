import java.sql.*;

public class HospitalDatabase {
    

    private Connection conn;

    public HospitalDatabase(String url, String username, String password) throws SQLException {
        
        conn = DriverManager.getConnection(url, username, password);
    }

    public void close() throws SQLException {
        conn.close();
    }

    public void addPatient(String name, int age, String diagnosis) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO patients (name, age, diagnosis) VALUES (?, ?, ?)");
        stmt.setString(1, name);
        stmt.setInt(2, age);
        stmt.setString(3, diagnosis);
        stmt.executeUpdate();
    }

    public void updatePatient(int id, String name, int age, String diagnosis) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("UPDATE patients SET name = ?, age = ?, diagnosis = ? WHERE id = ?");
        stmt.setString(1, name);
        stmt.setInt(2, age);
        stmt.setString(3, diagnosis);
        stmt.setInt(4, id);
        stmt.executeUpdate();
    }

    public void deletePatient(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM patients WHERE id = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public ResultSet getAllPatients() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM patients");
        return rs;
    }
    
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "password";
        try {
            HospitalDatabase db = new HospitalDatabase(url, username, password);
            db.addPatient("John Doe", 45, "Flu");
            db.updatePatient(1, "Jane Doe", 35, "Cold");
            db.deletePatient(2);
            ResultSet rs = db.getAllPatients();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String diagnosis = rs.getString("diagnosis");
                System.out.println(id + " " + name + " " + age + " " + diagnosis);
            }
            db.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
