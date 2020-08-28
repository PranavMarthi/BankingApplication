import java.sql.*;
import java.util.Scanner;

public class JDBCUpdateValues {
	
	public static void main(String [] args) {
		
		String url = "jdbc:mysql://localhost/BankingApplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //pointing to no database.
	    String username = "root";
	    String password = "qazwsxedcrfv";
	    
	    Scanner currentPincode = new Scanner(System.in);
	    System.out.print("Enter your current pincode: ");
	    int userCurrentPincode = currentPincode.nextInt();
	    
	    Scanner newFirstName = new Scanner(System.in);
	    System.out.print("Enter your new first name: ");
	    String userNewFirstName = newFirstName.nextLine();
	    
	    Scanner newLastName = new Scanner(System.in);
	    System.out.print("Enter your new last name: ");
	    String userNewLastName = newLastName.nextLine();
	    
	    Scanner newPincode = new Scanner(System.in);
	    System.out.print("Enter your new pincode: ");
	    int userNewPincode = newPincode.nextInt();
	    
	    try {
	    	
	    	Connection myConn = DriverManager.getConnection(url, username, password);
	    	
	    	Statement myStmt = myConn.createStatement();
	    	
	    	String sql = "UPDATE userInformation SET pincode = " + userNewPincode + "," + "first_name = " + "'" + userNewFirstName + "'" + "," + "last_name = " + "'" + userNewLastName + "'" + "WHERE pincode = " + userCurrentPincode + ";";
	    	
	    	myStmt.executeUpdate(sql);
	    	
	    	System.out.println("Update complete.");
	    } catch(Exception e) {
	    	System.out.println("Error");
	    }
	}
}
