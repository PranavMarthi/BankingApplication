import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReenterPassword {
	
	private static Scanner x;
	public static void reenterPassword() {
		
		String url = "jdbc:mysql://localhost/BankingApplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //pointing to no database.
	    String username = "root";
	    String password = "qazwsxedcrfv";
	    
		try {
			
			
			
			Connection 	con = DriverManager.getConnection(url, username, password);
			
			
			Statement stmt = con.createStatement();
			
			Scanner pincode = new Scanner(System.in);
			System.out.print("Enter your pin: ");
			String userPincode = pincode.next();
			
			String SQL = "SELECT * FROM userInformation WHERE pincode = " + "'" + userPincode + "'";
			
			ResultSet rs = stmt.executeQuery(SQL);
			
			
			if(rs.next()) {
				System.out.print("Hello, " + (rs.getString("first_name")));
                System.out.print(" " + (rs.getString("last_name")) + ".");
			} else {
				System.out.println("Account does not exist");
				BankingApplicationMathods userBankingApplicationMethods = new BankingApplicationMathods();
				userBankingApplicationMethods.userBankingApplication();
			}
		
		} catch (Exception e) {
			System.out.println("Error");
		}
		
	}
	
	
	
	     
}

