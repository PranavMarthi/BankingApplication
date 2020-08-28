import java.sql.*;
import java.util.Scanner;

public class ValueAlreadyExists {
	
	public static void main(String [] args) {
		
		String url = "jdbc:mysql://localhost:3306/BankingApplication"; //pointing to no database.
	    String username = "root";
	    String password = "qazwsxedcrfv";
	    
		try {
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			Statement stmt = con.createStatement();
			
			Scanner valueExists = new Scanner(System.in);
			System.out.print("Name: ");
			String name = valueExists.next();
			
			String SQL = "SELECT * FROM userInformation WHERE first_name = " + "'" + name + "'";
			
			ResultSet rs = stmt.executeQuery(SQL);
			
			
			if(rs.next()) {
				System.out.print("Hello, " + (rs.getString("first_name")));
                System.out.print(" " + (rs.getString("last_name")) + ".");
			} else {
				System.out.println("Account does not exist");
			}
			
		} catch(Exception e) {
			System.out.println("Error");
		}
	}
}
