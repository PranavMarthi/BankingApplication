import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;



public class RandomIDs {
	public static void main(String [] args) throws UnsupportedOperationException {
		
		
		UUID gfg1 = UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db");
		UUID gfg2 = UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db");
		
		UUID customerID = gfg1.randomUUID();
		
		System.out.println(gfg1.randomUUID());
		System.out.println(gfg2.randomUUID());
		
	}
}
