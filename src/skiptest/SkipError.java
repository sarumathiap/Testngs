package skiptest;



import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipError {
	
	 
	
	 @Test (groups = {"skip"})
	 public void aSkipTest(){
	 String condition ="Skip Test";
	 if(!condition.equals("Skip Test")){
	 	throw new SkipException("Skipping - This is not ready for testing ");
	 }else{
	 System.out.println("I am in else condition"); 
	 }
	 System.out.println("I am out of the if else condition");
	 }
	 
	 @Test (groups = {"smokeTest"})
	 public void nonSkipTest(){
	 System.out.println("No need to skip this test");
	 }
	 

	}