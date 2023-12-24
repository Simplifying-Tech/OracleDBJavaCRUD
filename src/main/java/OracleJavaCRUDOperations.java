import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleJavaCRUDOperations {

	public static void main(String[] args) {
		
		Connection conn = null;
        try {
            // connection
            String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
            String USER = "sys as sysdba";
            String PASS = "<$$$$$>";
 
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if (conn != null) {
                System.out.println("Connected to the Oracle DB!");
            }
			/*
			 * String sql = "CREATE TABLE Customers (" + "    CustomerName varchar(255)," +
			 * "    ContactName varchar(255)," + "    Address varchar(500)," +
			 * "    City varchar(255)," + "    PostalCode int" + ")"; Statement stmt =
			 * conn.createStatement(); stmt.executeUpdate(sql);
			 * System.out.println("Created table in given database...");
			 */
            
			/*
			 * String sql =
			 * "INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode)"
			 * + "VALUES (?, ? ,?, ? , ?)";
			 * 
			 * PreparedStatement statement = conn.prepareStatement(sql);
			 * statement.setString(1, "Jack"); statement.setString(2, "Jack B. Sparrow");
			 * statement.setString(3, "Dale Street 21"); statement.setString(4, "Chicago");
			 * statement.setInt(5, 60611);
			 * 
			 * int rowsInserted = statement.executeUpdate(); if (rowsInserted > 0) {
			 * System.out.println("A new Customer was inserted successfully!"); }
			 */
            
          //Update
            
			/*
			 * String sql = "UPDATE Customers SET City=? WHERE CustomerName=?";
			 * 
			 * PreparedStatement statement = conn.prepareStatement(sql);
			 * statement.setString(1, "Oslo"); statement.setString(2, "Cardinal");
			 * 
			 * int rowsUpdated = statement.executeUpdate(); if (rowsUpdated > 0) {
			 * System.out.println("An existing user was updated successfully!"); }
			 */
            
			/*
			 * String sql = "DELETE FROM Customers WHERE CustomerName=?";
			 * 
			 * PreparedStatement statement = conn.prepareStatement(sql);
			 * statement.setString(1, "Cardinal");
			 * 
			 * int rowsDeleted = statement.executeUpdate(); if (rowsDeleted > 0) {
			 * System.out.println("A user was deleted successfully!"); }
			 */
            
            String sql = "SELECT * FROM Customers";
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
              
            int count = 0;
              
            while (result.next()){
                String customerName = result.getString("CustomerName");
                String contactName = result.getString("ContactName");
                String address = result.getString("Address");
                String city = result.getString("City");
                int postalCode = result.getInt("PostalCode");
              
                String output = "Customer #%d: %s - %s - %s - %s - %s";
                System.out.println(String.format(output, ++count, customerName,contactName, address,city,postalCode));
            }

} catch (SQLException ex) {
            System.out.println("Exception ::" + ex.getMessage());
            ex.printStackTrace();
        }
	}

}
