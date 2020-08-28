import java.io.File;
import java.util.Scanner;

public class ReadFromACSVFile {
	
	private Scanner x;
	
	public void openFile() {
		try {
			x = new Scanner(new File("tutorial.txt"));
			
		} catch(Exception e){
			System.out.println("could not find file");

		}
		
		
	}
	
	public void readFile() {
		while(x.hasNext()) {
			String a = x.next();
			String b = x.next();
			String c = x.next();
			
			
			System.out.printf("%s %s %s\n", a, b, c);
		}
		
		
	}
	
	public void closeFile() {
		x.close();
	}
	
	public static void main(String [] args) {
		ReadFromACSVFile readFromCSVFile = new ReadFromACSVFile();
		readFromCSVFile.openFile();
		readFromCSVFile.readFile();
		readFromCSVFile.closeFile();
		
	}
}

