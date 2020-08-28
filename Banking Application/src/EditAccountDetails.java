import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class EditAccountDetails {
	private static Scanner x;
	
	public static void editAccount() {
		
		String url = "jdbc:mysql://localhost/BankingApplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //pointing to no database.
	    String username = "root";
	    String password = "qazwsxedcrfv";
		
		Scanner currentPinCode = new Scanner(System.in);
		System.out.print("Enter your current pincode: ");
		String editTerm = currentPinCode.nextLine();
		
		Scanner changeFirstName = new Scanner(System.in);
		System.out.print("Enter your new first name: ");
		String newFirstName = changeFirstName.nextLine();
		
		Scanner changeLastName = new Scanner(System.in);
		System.out.print("Enter your new last name: ");
		String newLastName = changeLastName.nextLine();
		
		Scanner changePinCode = new Scanner(System.in);
		System.out.print("Enter your new pin code: ");
		String newPinCode = changePinCode.nextLine();
		
		try {
			
			Connection myConn = DriverManager.getConnection(url, username, password);
	    	
	    	Statement myStmt = myConn.createStatement();
	    	
	    	String sql = "UPDATE userInformation SET pincode = " + newPinCode + "," + "first_name = " + "'" + newFirstName + "'" + "," + "last_name = " + "'" + newLastName + "'" + "WHERE pincode = " + editTerm + ";";
	    	
	    	myStmt.executeUpdate(sql);
	    	
	    	System.out.println("Update complete.");
			
			
		} catch(Exception e) {
			System.out.println("Error");
		}
		
		
	}
	

}
