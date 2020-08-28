import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DepositintoSavings {
	
	private static Scanner x;
	public static void savingsDeposit() {
		
		Scanner transactionConfirmation = new Scanner(System.in);
		System.out.print("Enter your pin to confirm your deposit: ");
		int userTransactionConfirmation = transactionConfirmation.nextInt();
		
		String url = "jdbc:mysql://localhost/BankingApplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //pointing to no database.
	    String username = "root";
	    String password = "qazwsxedcrfv";
	    
		
		try {
			
			Scanner savingsTransaction = new Scanner(System.in);
			System.out.print("Enter the amount you want to deposit in your checking account: ");
			BankingApplication1.myTransactionSavings = savingsTransaction.nextInt();
			
			Connection myConn = DriverManager.getConnection(url, username, password);
			
			Statement myStmt = myConn.createStatement();
			
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM userInformation WHERE userInformation.pincode = " + userTransactionConfirmation);
			
			if(myRs.next()) {
				int savingsBalance = myRs.getInt("savingsAccount_balance") + BankingApplication1.myTransactionSavings;
				
				Connection conn = DriverManager.getConnection(url, username, password);
		    	
		    	Statement stmt = myConn.createStatement();
		    	
		    	String sql = "UPDATE userInformation SET savingsAccount_balance = " + "'" + savingsBalance + "'" + "WHERE userInformation.pincode = " + userTransactionConfirmation + ";";
		    	
		    	System.out.print("Now, the amount of money currently in your savings account is $" + savingsBalance);
                
		    	myStmt.executeUpdate(sql);
				
                
			} else {
				String userInputCreateNewAccount = "a";
				String userInputReenterPassword = "b";
				String userInputMainMenu = "c";
				
				System.out.println("The pin you entered does not match your account pin");
				
				System.out.println("a. Create new account");
				System.out.println("b. Re-enter your password");
				System.out.println("c. Return to the main menu");
				
				Scanner passwordMisMatch = new Scanner(System.in);
				System.out.print("Enter your selection: ");
				String userPasswordMisMatch = passwordMisMatch.nextLine();
				
				if(userPasswordMisMatch.equals(userInputCreateNewAccount)) {
					CreateNewAccount userCreateAccount = new CreateNewAccount();
					userCreateAccount.userCreateNewAccount();
				} else if(userPasswordMisMatch.equals(userInputReenterPassword)) {
					ReenterPassword userReenterPassword = new ReenterPassword();
					userReenterPassword.reenterPassword();
				} else if(userPasswordMisMatch.equals(userInputMainMenu)) {
					BankingApplicationMathods userBankingApplicationMethods1 = new BankingApplicationMathods();
					userBankingApplicationMethods1.userBankingApplication();
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
		
		
		


}
}
