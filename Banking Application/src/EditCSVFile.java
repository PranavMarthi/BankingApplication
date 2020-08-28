import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EditCSVFile {
	
	private static Scanner x;
	
	public static void main(String [] args) {
		String filepath = "records.txt";
		String editTerm = "4444";
		String newTerm = "2222";
		String newName = "Donald";
		String age = "69";
		
		
		editRecord(filepath, editTerm, newTerm, newName, age);
	}
	
	public static void editRecord(String filepath, String editTerm, String newID, String newName, String newAge) {
		
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String ID = ""; String name = ""; String age = "";
		
		try {
			
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				
				ID = x.next();
				name = x.next();
				age = x.next();
				if(ID.equals(editTerm)) {
					
					pw.println(newID + "," + newName + "," + newAge);
				} else {
					pw.println(ID + "," + name + "," + age);
					
				}
			}
			
			x.close();
			pw.close();
			pw.flush();
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
			
			
			
		} catch(Exception e) {
			System.out.println("Error");
		}
	}
}