import java.sql.*;

public class Driver {
	
	public static void main(String[] args) {
		
		try {  
			// 1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearningMySQL", "root", "qazwsxedcrfv");
			
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
			
			// 3. Execute SQL query
			ResultSet myRa = myStat.executeQuery("SELECT first_name FROM employee");
			
			// 4. Process the result set
			while(myRa.next()) {
				System.out.println(myRa.getString("last_name") + myRa.getString("first_name"));
			}
			
			myStat.close();
			myConn.close();
			
			
			
		} catch(Exception e) {
			System.out.println(e);
		}

	}

}
