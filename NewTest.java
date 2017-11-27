package test;
import model.Variant18;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

public class NewTest {
	
  private Variant18 var = new Variant18();
 /* @DataProvider
  public Object[][] vidstan()
  {
 return new Object[][]{
 {63,var.begin18(0,16,9) },
 {6, var.begin18(-1,4,2) },
  };
}*/
  
  @Test//(dataProvider = "vidstan")
  public void testbegin() throws Exception {
	 assertEquals(63 , var.begin18(0,16,9));
  }
  
 
  
  
}
