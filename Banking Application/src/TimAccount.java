import java.util.Scanner;

public class TimAccount implements UserAccountImplementation {
	public void accountCheckingBalance() {
		
		String option1Ans = "a";
		String option2Ans = "b";
		String option3Ans = "c";
		String checkingAns = "a";
		int myMoneyChecking = 0;
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
		
	}
		
	}

	@Override
	public void accountID() {
		System.out.println(146278218);
		
	}
	
	public static void main(String [] args) {
		TimAccount [] accountBalanceChecking = {
				new TimAccount()
		};
		
		
		for(int i = 0; i < accountBalanceChecking.length; i++);
		
		int i = 0;
		accountBalanceChecking[i ].accountCheckingBalance();
	}
	
	
}
