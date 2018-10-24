package groups;


import org.testng.annotations.Test;
public class Group {







 @Test (groups = { "smokeTest", "functionalTest" })
 public void loginTest(){
 System.out.println("Logged in successfully");
 }
}