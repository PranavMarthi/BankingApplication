import java.io.*;
import java.util.ArrayList;


public class JavaToCSVFile {
	public static void main(String [] args) {
		
		String ID = "1234";
		String name = "Bob";
		String age = "22";
		String filepath = "cake1.csv";
		
		saveRecord(ID, name, age, filepath);
		
		}
	
	public static void saveRecord(String ID, String name, String age, String filepath) {
		 
		try {
			
			FileWriter fw = new FileWriter(filepath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(ID + ", " + name + ", " + age);
			pw.flush();
			pw.close();
		}catch(Exception E) {
			System.out.println("Record saved");
		}
	}
	

	}

