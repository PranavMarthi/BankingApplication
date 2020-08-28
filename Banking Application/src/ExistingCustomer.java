import java.sql.*;
import java.util.Scanner;

public class ExistingCustomer {
	
	public static void existingCustomer() {
		Scanner userPin = new Scanner(System.in);
		System.out.print("Enter your pin: ");
		String userInputPin = userPin.nextLine();
		
		System.out.println("Connecting to server ...");
		
		try {
			String url = "jdbc:mysql://localhost/BankingApplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //pointing to no database.
		    String username = "root";
		    String password = "qazwsxedcrfv";
		    
			Connection myConn = DriverManager.getConnection(url, username, password);
			
			Statement myStmt = myConn.createStatement();
			
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM userInformation WHERE userInformation.pincode = " + userInputPin);
			
			if(myRs.next()) {
				System.out.print("Hello, " + (myRs.getString("first_name")));
                System.out.print(" " + (myRs.getString("last_name")) + ".");
                
			} else {
				String createNewAccountYes = "a";
				String createNewAccountNo = "b";
				
				System.out.println("Account not found");
				System.out.println("Would you like to create a new account? ");
				System.out.println("a. Yes");
				System.out.println("b. No");
				
				Scanner createNewAccount = new Scanner(System.in);
				System.out.print("Enter the letter that matches your selection: ");
				String userCreateNewAccount = createNewAccount.nextLine();
				
				if(userCreateNewAccount.equals(createNewAccountYes)) {
					
					String userCreateNewAccount1 = createNewAccount.nextLine();
					CreateNewAccount createNewAccount1 = new CreateNewAccount();
					CreateNewAccount.userCreateNewAccount();
				} else {
					BankAccountLogin userBankAccountLogin = new BankAccountLogin();
					BankAccountLogin.userLogin();
				}
				
			}
			
		} catch(Exception e) {
			System.out.println("Error");
		}
		
	}
}



