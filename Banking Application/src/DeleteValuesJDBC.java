import java.sql.*;
import java.util.Scanner;

public class DeleteValuesJDBC {
	
	public static void main(String [] args) {
		
		String url = "jdbc:mysql://localhost/BankingApplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//pointing to no database.
	    String username = "root";
	    String password = "qazwsxedcrfv";
	    
	    Scanner deletePin = new Scanner(System.in);
	    System.out.print("Enter the pin for the account you want to delete: ");
	    int userDeletePin = deletePin.nextInt();
	    
	    try {
	    	Connection myConn = DriverManager.getConnection(url, username, password);
	    	
	    	Statement myStmt = myConn.createStatement();
	    	
	    	String sql = "DELETE FROM userInformation WHERE pincode = " + userDeletePin + ";";
	    	
	    	myStmt.executeUpdate(sql);
	    	
	    	
		    System.out.println("Delete complete.");
			
	    	
	    } catch(Exception e) {
	    	System.out.println(e);
	    }
	}
}
