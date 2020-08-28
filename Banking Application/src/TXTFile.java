import java.io.*;
import java.util.Scanner;




public class TXTFile {
	public static void main(String [] args) throws IOException {
		
		
		Scanner keyboardInput = new Scanner(System.in);
		String option = keyboardInput.nextLine();
		
		
	File file = new File("userInput.txt");
	FileWriter fw = new FileWriter(file);
	PrintWriter pw = new PrintWriter(fw);
	
	pw.println("Line 1");
	pw.println("Line 2");
	pw.println("Line 3");
	pw.println(option);
	
	pw.close();
	
}
}