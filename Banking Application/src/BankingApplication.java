import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BankingApplication {
	
	private static void userLogin() {
	String createNewAccount = "a";
	String haveExistingAccount = "b";
	String deleteExistingAccount = "c";
	String editExistingAccount = "d";
	String filepath = "userBankingInformation.csv";
	
	System.out.println("a. Create new banking account");
	System.out.println("b. Login into existing banking account");
	System.out.println("c. Delete existing banking account");
	System.out.println("d. Edit account details");
	System.out.print("Select the letter that matches your selction: ");
	
	Scanner userLoginScreen = new Scanner(System.in);
	String loginScreenUserInput = userLoginScreen.nextLine();
	
	if(loginScreenUserInput.equals(createNewAccount)) {

		try {
			FileWriter fw = new FileWriter(filepath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			System.out.print("Enter your first name: ");
			Scanner firstName = new Scanner(System.in);
			String userFirstName = firstName.nextLine();
			System.out.print("Enter your last name: ");
			Scanner lastName = new Scanner(System.in);
			String userLastName = lastName.nextLine();
			System.out.print("Create a four digit pin to access your account in the future: ");
			Scanner pinCode = new Scanner(System.in);
			int userPinCode = pinCode.nextInt();
			
				System.out.println("Information Successfully Stored");
			
				pw.println(userPinCode + "," + userFirstName + "," + userLastName + "," + BankingApplication1.myMoneyChecking + "," + BankingApplication1.myMoneySavings); 
				pw.flush();
				pw.close();

		}
			 catch (IOException e) {
				 System.out.println("Error");
		}
} else if(loginScreenUserInput.equals(haveExistingAccount)) {
	ExistingCustomer existingCustomer = new ExistingCustomer();
	ExistingCustomer.existingCustomer();
} else if(deleteExistingAccount.equals(loginScreenUserInput)) {
	DeleteBankingAccount userDeleteBankingAccount = new DeleteBankingAccount();
	DeleteBankingAccount.deleteAccount();
	System.out.println("Account successfully deleted");
} else if(editExistingAccount.equals(loginScreenUserInput)) {
	EditAccountDetails userEditAccountDetails = new EditAccountDetails();
	EditAccountDetails.editAccount();
}
}
	public static void main(String [] args) {
		
		String option1Ans = "a";
		String option2Ans = "b";
		String option3Ans = "c";
		int myMoneyChecking = 0;
		int myMoneySavings = 0;
		int checkingBalance = 0;
		int savingsBalance = 0;
		int myTransactionChecking = 0;
		int myTransactionSavings = 0;
		String checkingAns = "a";
		String savingsAns = "b";
		int i = 0;
		
		do {
			System.out.println("a. Account Balance");
			System.out.println("b. Deposit into account");
			System.out.println("c. Withdraw from an account");
			
			Scanner keyboardInput = new Scanner(System.in);
			System.out.print("Enter the letter that matches your selection: ");
			String option = keyboardInput.nextLine();
			
			if(option.equals(option1Ans) || option.equals(option2Ans) || option.equals(option3Ans)) {
				System.out.println("a. Checking Account \nb. Savings Account");
				
			}
			
			Scanner keyboardInput1 = new Scanner(System.in);
			System.out.print("Enter the letter that matches your selection: ");
			String option_2 = keyboardInput1.nextLine();
			
			if(option_2.equals(checkingAns) && option.equals(option1Ans)) {
				System.out.println("The amount of money currently in your checking account is $" + myMoneyChecking);
			} else if(option.equals(option1Ans) && option_2.equals(savingsAns)) {
				System.out.println("The amount of money currently in your savings account is $" + myMoneySavings);
			}
			
			if(option.equals(option2Ans) && option_2.equals(checkingAns)) {
				Scanner checkingTransaction = new Scanner(System.in);
				System.out.print("Enter the amount you want to deposit in your checking account: ");
				myTransactionChecking = checkingTransaction.nextInt();
				myMoneyChecking = myMoneyChecking + myTransactionChecking;
				System.out.println("Now, the total amount of money in your checking account is $" + myMoneyChecking);
		} 
			
			else if (option.equals(option2Ans) && option_2.equals(savingsAns)) {
				Scanner savingsTransaction = new Scanner(System.in);
				System.out.print("Enter the amount you want to deposit in your savings account: ");
				myTransactionSavings = savingsTransaction.nextInt();
				myMoneySavings = myMoneySavings + myTransactionSavings;
				System.out.println("Now, the total amount of money in your savings account is $" + myMoneySavings);
			
			}
			
			if(option.equals(option3Ans) && option_2.equals(checkingAns)) {
				Scanner transactionChecking = new Scanner(System.in);
				System.out.print("Enter the amount you want to withdraw from your checking account: ");
				myTransactionChecking = transactionChecking.nextInt();
				myMoneyChecking = myMoneyChecking - myTransactionChecking;
				System.out.println("Now, the money currently in your checking account is $" + myMoneyChecking);
				
			} 
			
			else if(option.equals(option3Ans) && option_2.equals(savingsAns)) {
				Scanner transactionSavings = new Scanner(System.in);
				System.out.print("Enter the amount you want to withdraw from you savings account: ");
				myTransactionSavings = transactionSavings.nextInt();
				myMoneySavings = myMoneySavings - myTransactionSavings;
				System.out.println("Now, the money currently in your savings account is $" + myMoneySavings);
	}
	
			Scanner exit = new Scanner(System.in);
			String exitKeyWord = "exit";
			String exit1 = exit.nextLine();
			if(exit1.equals(exitKeyWord)) {
				System.exit(0);
			} else if(!exit1.equals(exitKeyWord)) {
			
			

} 
		} while(i<=0);
		
		
		

	
}
	}

