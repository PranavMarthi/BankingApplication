import java.util.Scanner;

public class Exit {
	public static void exit() {
		Scanner keyboardInput5 = new Scanner(System.in);
		String exitKeyWord = "exit";
		String keyboardInput2 = keyboardInput5.nextLine();
		if(keyboardInput2.equals(exitKeyWord)) {
			System.exit(0);
		
		}
		}
	}

