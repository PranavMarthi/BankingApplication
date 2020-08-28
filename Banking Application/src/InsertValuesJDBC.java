import java.sql.*;
import java.util.Scanner;

public class InsertValuesJDBC {
	
	public static void main(String [] args) {
		
		Scanner firstName = new Scanner(System.in);
		System.out.print("Enter your first name: ");
		String userFirstName = firstName.nextLine();
		
		Scanner lastName = new Scanner(System.in);
		System.out.print("Enter your last name: ");
		String userLastName = lastName.nextLine();
		
		Scanner pincode = new Scanner(System.in);
		System.out.print("Enter a four digit pin code to use in the future: ");
		int userPincode = pincode.nextInt();
		
		String url = "jdbc:mysql://localhost:3306/BankingApplication"; //pointing to no database.
	    String username = "root";
	    String password = "qazwsxedcrfv";
	    
	    try {
	    	Connection myConn = DriverManager.getConnection(url, username, password);
	    	
	    	Statement myStmt = myConn.createStatement();
	    	
	    	String sql = "INSERT INTO userInformation(pincode, first_name, last_name) VALUES(" + userPincode + "," + "'" + userFirstName + "'" + "," + "'" + userLastName + "'" + ")";
	    	
	    	myStmt.executeUpdate(sql);
	    	
	    	System.out.println("Insert complete.");
	    } catch(Exception e) {
	    	System.out.println(e);
	    }
	}
}

