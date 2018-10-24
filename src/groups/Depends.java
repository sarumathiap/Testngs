package groups;

import org.testng.annotations.Test;

public class Depends {

 @Test(groups ="skip",dependsOnMethods = {"testCase2"})
 public void testCase1(){
 System.out.println("Test Case 1");
 }
 @Test(enabled=false)
 public void testCase2(){
 System.out.println("Test Case 2");
 }
 //@Test(groups = {"FirstGroup"}) 

 //public void testCase1(){ 

 //System.out.println("Test Case 1"); 

 //} 

 //@Test(groups = {"SecondGroup"}) 

 //public void testCase2(){ 

 //System.out.println("Test Case 2"); 

 //}
}

