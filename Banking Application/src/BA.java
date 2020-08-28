import java.io.IOException;

public class BA {
	public static void main(String [] args) {
		BankingApplicationMathods userBankingApplicationMethods = new BankingApplicationMathods();
		try {
			userBankingApplicationMethods.userBankingApplication();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
