import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DeletingCSVRecords {
	
	private static Scanner x;
	
	public static void main(String [] args) {
		
		String filepath = "tutorial2.txt";
		String removeTerm = "4444";
		
		
		removeRecord(filepath, removeTerm);
		
		
	}
	
	public static void removeRecord(String filepath, String removeTerm) {
		
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
				
				if(!ID.equals(removeTerm)) {
					
					pw.println(ID + "," + name + "," + age);
				}
			}
				x.close();
				pw.flush();
				pw.close();
				
				oldFile.delete();
				
				File dump = new File(filepath);
				newFile.renameTo(dump);
			
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error");
		}
		
	}
}
