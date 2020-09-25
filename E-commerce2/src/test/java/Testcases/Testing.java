package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testing 
{
	@Test
 void testpass()
 {
	 System.out.println("Testing 1");
	 Assert.assertEquals("ram", "ram", "passed");
 }
	@Test
 void test2pass()
 {
		 System.out.println("Testing 2");
		 Assert.assertEquals("ram", "ram", "passed");
 }
	@Test
 void test3fail()
 {
		 System.out.println("Testing 3"); 
		 Assert.assertEquals("ram", "raam", "failed");
 }
	
	@Test(dependsOnMethods="test3fail")
void test4skip()
 {
	 
		 System.out.println("Testing 4"); 
		 Assert.assertEquals("ram", "ram", "failed");
 }
	
}
