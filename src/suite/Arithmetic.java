package suite;
import org.testng.annotations.Test;
public class Arithmetic {
	

		
		@Test(groups = {"arithmetic"},expectedExceptions = ArithmeticException.class)
		public void testException() {
			System.out.println("Exception defined");
			int a = 1 / 0;	
			System.out.println(a);
		}
	
	
}
