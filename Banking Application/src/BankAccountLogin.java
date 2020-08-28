import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BankAccountLogin {

	private static Scanner x;
	public static void userLogin() {
		

		String createNewAccount = "a";
		String haveExistingAccount = "b";
		String deleteExistingAccount = "c";
		String editExistingAccount = "d";
		String filepath = "userBankingInformation.csv";
		
		System.out.println("a. Create new banking account");
		System.out.println("b. Login into existing banking account");
		System.out.println("c. Delete existing banking account");
		System.out.println("d. Edit account details");
		
		
		Scanner userLoginScreen = new Scanner(System.in);
		System.out.print("Select the letter that matches your selction: ");
		String loginScreenUserInput = userLoginScreen.nextLine();
		
		String url = "jdbc:mysql://localhost/BankingApplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //pointing to no database.
	    String username = "root";
	    String password = "qazwsxedcrfv";
	    
		
		
		if(loginScreenUserInput.equals(createNewAccount)) {

			try {
				
				System.out.print("Enter your first name: ");
				Scanner firstName = new Scanner(System.in);
				String userFirstName = firstName.nextLine();
				System.out.print("Enter your last name: ");
				Scanner lastName = new Scanner(System.in);
				String userLastName = lastName.nextLine();
				System.out.print("Create a four digit pin to access your account in the future: ");
				Scanner pinCode = new Scanner(System.in);
				int userPinCode = pinCode.nextInt();
				
				
				Connection myConn = DriverManager.getConnection(url, username, password);
		    	
		    	Statement myStmt = myConn.createStatement();
		    	
		    	String sql = "INSERT INTO userInformation(pincode, first_name, last_name) VALUES(" + userPinCode + "," + "'" + userFirstName + "'" + "," + "'" + userLastName + "'" + ")";
		    	
		    	myStmt.executeUpdate(sql);
		    	
		    	System.out.println("Insert complete.");
		    	System.out.println("Hello, " + userFirstName + " " + userLastName + ".");
			}catch (Exception e) {
					 System.out.println("Error");
				
				 }
			
		} else if(loginScreenUserInput.equals(haveExistingAccount)) {
			ExistingCustomer existingCustomer = new ExistingCustomer();
			existingCustomer.existingCustomer();
		} else if(deleteExistingAccount.equals(loginScreenUserInput)) {
			DeleteBankingAccount userDeleteBankingAccount = new DeleteBankingAccount();
			DeleteBankingAccount.deleteAccount();
		System.out.println("Account successfully deleted");
		} else if(editExistingAccount.equals(loginScreenUserInput)) {
			EditAccountDetails userEditAccountDetails = new EditAccountDetails();
			EditAccountDetails.editAccount();
	} else {
		System.out.println("Invalid input, please try again.");
	}
	}
		
	
	public static void main(String [] args) {
		BankAccountLogin userBankAccountLogin = new BankAccountLogin();
		userBankAccountLogin.userLogin();
		
	}
}
		


	
	

