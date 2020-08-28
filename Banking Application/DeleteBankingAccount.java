import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class DeleteBankingAccount {
	private static Scanner x;
	
	public static void deleteAccount() {
		String filepath = "userBankingInformation.csv";
		Scanner deleteAccount = new Scanner(System.in);
		System.out.print("Enter the pincode for the account you want to delete: ");
		String deletePin = deleteAccount.nextLine();
		
		String tempFile = "temp.csv";
		
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		
		String pinCode = ""; String firstName = ""; String lastName = ""; String checkingBalance = ""; String savingsBalance = "";
		
		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				
				pinCode = x.next();
				firstName =x.next();
				lastName = x.next();
				checkingBalance = x.next();
				savingsBalance = x.next();
				
				if(!pinCode.equals(deletePin)) {
					
					pw.println(pinCode + "," + firstName + "," + lastName + "," + checkingBalance + "," + savingsBalance);
				}
			}
			
			x.close();
			pw.flush();
			pw.close();
			
			oldFile.delete();
			
			File dump = new File(filepath);
			newFile.renameTo(dump);
			
			
		} catch(Exception e) {
			System.out.println("Error");
		}
	}
}
