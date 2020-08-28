import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class UniqueIdentifier {
	
	private static Scanner x;
	public static void userUniqueIdentifier() {
		String filepath = "userBankingInformation.csv";
		String tempFile = "temp.csv";
		
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		
		int customerIdentifer = 0; String pinCode = ""; String firstName = ""; String lastName = ""; String checkingAccount = ""; String savingsAccount = "";
		
		
		try {
			
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(fw);
			
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				
				customerIdentifer = x.nextInt();
				pinCode = x.next();
				firstName = x.next();
				lastName = x.next();
				checkingAccount = x.next();
				savingsAccount = x.next();
				
				
				pw.println((customerIdentifer + 1) + "," + pinCode + "," + firstName + "," + lastName + "," + checkingAccount + "," + savingsAccount);
				
			}
			
			
			x.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
			
		}catch(Exception e) {
			System.out.println("Error");
		}
	}
	
	
	
}
