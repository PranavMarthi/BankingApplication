import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BankingApplicationMathods {
	
	private static Scanner x;
	
	public static void userBankingApplication()  {
	
		
		DepositintoChecking myCheckingDeposit = new DepositintoChecking();
		DepositintoSavings mySavingsDeposit = new DepositintoSavings();
		WithdrawfromChecking myCheckingWithdraw = new WithdrawfromChecking();
		WithdrawfromSavings mySavingsWithdraw = new WithdrawfromSavings();
		BankAccountLogin userBankAccountLogin = new BankAccountLogin();
		Exit userExit = new Exit();
		String option1Ans = "a";
		String option2Ans = "b";
		String option3Ans = "c";
		String checkingAns = "a";
		String savingsAns = "b";
		String url = "jdbc:mysql://localhost/BankingApplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //pointing to no database.
	    String username = "root";
	    String password = "qazwsxedcrfv";
	    String createNewAccount = "a";
		String reenterPassword = "b";
		String returnToMainMenu = "c";
		
		int p = 0;
		
		BankAccountLogin.userLogin();
		
		do {
			
		System.out.println(" What would you like to do today? ");
		System.out.println("a. Account Balance");
		System.out.println("b. Deposit into account");
		System.out.println("c. Withdraw from an account");
		System.out.print("Enter the letter that matches your selection: ");
		Scanner keyboardInput = new Scanner(System.in);
		String option = keyboardInput.nextLine();
		if(option.equals(option1Ans) || option.equals(option2Ans) || option.equals(option3Ans)) {
			System.out.println("a. Checking Account \nb. Savings Account");
	}
		
		System.out.print("Enter the letter that matches your selection: ");
		Scanner keyboardInput1 = new Scanner(System.in);
		String option_2 = keyboardInput1.nextLine();
			
			
		if(option_2.equals(checkingAns) && option.equals(option1Ans)) {
			Scanner confirmViewChecking = new Scanner(System.in);
			System.out.print("To view your checking account balance, enter your pin: ");
			String userConfirmViewChecking = confirmViewChecking.nextLine();
			
			
			
			try {
				
				Connection con = DriverManager.getConnection(url, username, password);
				
				Statement stmt = con.createStatement();
				
				String SQL = "SELECT checkingAccount_balance FROM userInformation WHERE pincode = " + "'" + userConfirmViewChecking + "'";
				
				ResultSet rs = stmt.executeQuery(SQL);
				
				
				if(rs.next()) {
					System.out.print("The amount of money currently in your checking account is $" + (rs.getString("checkingAccount_balance")));
	                
				} else {
					System.out.println("The pin you entered is invalid, please try again.");
					System.out.println("a. Create new account");
					System.out.println("b. Re-enter pincode");
					System.out.println("c. Return to main menu");
					
					Scanner invalidPincodeOptions = new Scanner(System.in);
					System.out.print("Select one of the options: ");
					String userInvalidPincodeOptions = invalidPincodeOptions.nextLine();
					
					if(userInvalidPincodeOptions.equals(createNewAccount)) {
						CreateNewAccount userCreateNewAccount = new CreateNewAccount();
						userCreateNewAccount.userCreateNewAccount();
					} else if(userInvalidPincodeOptions.equals(reenterPassword)) {
						ReenterPassword userReenterPassword = new ReenterPassword();
						userReenterPassword.reenterPassword();
					} else {
						BankAccountLogin userBankAccountLogin1 = new BankAccountLogin();
						userBankAccountLogin1.userLogin();
					}
				}
				
				
			} catch(Exception e) {
				System.out.println("Error");
			}
			
		} else if(option.equals(option1Ans) && option_2.equals(savingsAns)) {
			Scanner confirmViewSavings = new Scanner(System.in);
			System.out.print("To view your savings account balance, enter your pin: ");
			String userConfirmViewSavings = confirmViewSavings.nextLine();
			
			String filepath = "userBankingInformation.csv";
			String tempFile = "temp.csv";
			
			try {
				
				Connection con = DriverManager.getConnection(url, username, password);
				
				Statement stmt = con.createStatement();
				
				String SQL = "SELECT checkingAccount_balance FROM userInformation WHERE pincode = " + "'" + userConfirmViewSavings + "'";
				
				ResultSet rs = stmt.executeQuery(SQL);
				
				
				if(rs.next()) {
					System.out.print("The amount of money currently in your checking account is $" + (rs.getString("checkingAccount_balance")));
					
				} else {
					
					
					
					System.out.println("The pin you entered is invalid, please try again.");
					System.out.println("a. Create new account");
					System.out.println("b. Re-enter pincode");
					System.out.println("c. Return to main menu");
					
					Scanner invalidPincodeOptions = new Scanner(System.in);
					System.out.print("Select one of the options: ");
					String userInvalidPincodeOptions = invalidPincodeOptions.nextLine();
					
					if(userInvalidPincodeOptions.equals(createNewAccount)) {
						CreateNewAccount userCreateNewAccount = new CreateNewAccount();
						userCreateNewAccount.userCreateNewAccount();
					} else if(userInvalidPincodeOptions.equals(reenterPassword)) {
						ReenterPassword userReenterPassword = new ReenterPassword();
						userReenterPassword.reenterPassword();
					} else {
						BankAccountLogin userBankAccountLogin1 = new BankAccountLogin();
						userBankAccountLogin1.userLogin();
					}
					
					
				}
			} catch(Exception e) {
				System.out.println("Error");
			}
			
		}
		
		if(option.equals(option2Ans) && option_2.equals(checkingAns)) {
		DepositintoChecking.checkingDeposit();
		}
		if(option.equals(option2Ans) && option_2.equals(savingsAns)) {
		DepositintoSavings.savingsDeposit();
		}
		if(option.equals(option3Ans) && option_2.equals(checkingAns)) {
		WithdrawfromChecking.checkingWithdraw();
		}
		if(option.equals(option3Ans) && option_2.equals(savingsAns)) {
		WithdrawfromSavings.savingsWithdraw();
		}
		
		Exit exit = new Exit();
		Exit.exit();
		
		}while(p>=0);
	}
}


