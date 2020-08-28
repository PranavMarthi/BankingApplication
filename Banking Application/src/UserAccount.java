
public class UserAccount {
	public static String accountName;
	public static int accountID;
	
	
	public UserAccount(String accountName, int accountID) {
		this.accountName = accountName;
		this.accountID = accountID;
	}
		
		public static void main(String [] args) {
		UserAccount timUserAccount = new UserAccount("Tim", 12385031);
		System.out.println(accountName);
		System.out.println(accountID);
	
		}
	}

