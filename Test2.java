package testflate;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


//import org.testng.annotations.Test;
import flate.Flate;

//import static org.testng.Assert.assertEquals;

public class Test2 {
	
	Flate fl = new Flate(210 , 3 , 12 , "Brown");

	@Test
	public void testNumber() throws Exception{
		assertEquals(fl.getNumber(),210);
	}
	
	@Test
	public void testF_Cost() {
		assertEquals(fl.cost(),2406.0);
	}
	
	@Test
	public void testOwner() {
		assertEquals(fl.getOwner(),"Brown");
	}
	
	@Test
	public void testRooms() {
		assertEquals(fl.getRoomsCount(),3);
	}
	
	@Test
	public void testSquare() {
		assertEquals(fl.getSquare(),12);
	}
	

}
