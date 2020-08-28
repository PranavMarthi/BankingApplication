import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;


public class DeleteBankingAccount {
	
	private static Scanner x;
	
	public static void deleteAccount() {
		
		String url = "jdbc:mysql://localhost/BankingApplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //pointing to no database.
	    String username = "root";
	    String password = "qazwsxedcrfv";
	    
		Scanner deleteAccount = new Scanner(System.in);
		System.out.print("Enter the pin for the account you want to delete: ");
		int deletePin = deleteAccount.nextInt();
		
		try {
			
			Connection myConn = DriverManager.getConnection(url, username, password);
	    	
	    	Statement myStmt = myConn.createStatement();
	    	
	    	String sql = "DELETE FROM userInformation WHERE pincode = " + deletePin + ";";
	    	
	    	myStmt.executeUpdate(sql);
	    	
	    	
		    System.out.println("Delete complete.");
		    System.exit(0);
			
		} catch(Exception e) {
			System.out.println("Error: " + e + "occured.");
		}
		
	}
}
