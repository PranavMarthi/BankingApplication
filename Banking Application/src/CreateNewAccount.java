import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CreateNewAccount {
	private static Scanner x;
	
	public static void userCreateNewAccount() {
		
		String url = "jdbc:mysql://localhost/BankingApplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //pointing to no database.
	    String username = "root";
	    String password = "qazwsxedcrfv";
		
		System.out.print("Enter your first name: ");
		Scanner firstName = new Scanner(System.in);
		String userFirstName = firstName.nextLine();
		System.out.print("Enter your last name: ");
		Scanner lastName = new Scanner(System.in);
		String userLastName = lastName.nextLine();
		System.out.print("Create a four digit pin to access your account in the future: ");
		Scanner pinCode = new Scanner(System.in);
		int userPinCode = pinCode.nextInt();
		
		try {
			
			Connection myConn = DriverManager.getConnection(url, username, password);
	    	
	    	Statement myStmt = myConn.createStatement();
	    	
	    	String sql = "INSERT INTO userInformation(pincode, first_name, last_name) VALUES(" + userPinCode + "," + "'" + userFirstName + "'" + "," + "'" + userLastName + "'" + ")";
	    	
	    	myStmt.executeUpdate(sql);
	    	
	    	System.out.println("Insert complete.");

		}
			 catch (Exception e) {
				 System.out.println("Error");
		}
		
		System.out.println("Hello, " + userFirstName + " " + userLastName);
	}
	
	public static void main(String [] args) {
		CreateNewAccount userCreateNewAccount = new CreateNewAccount();
		userCreateNewAccount.userCreateNewAccount();
	}
}
