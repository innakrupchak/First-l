package testflate;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import flate.Flate;
import flate.Build;

public class Test3 {
	Flate fl1 = new Flate(10 , 3 , 80 , "Brown");
	Flate fl2 = new Flate(20 , 3 , 100 , "Stewart");
	Flate fl3 = new Flate(30 , 2 , 60 , "Morris");
	Flate fl4 = new Flate(40 , 4 , 120 , "Rogers");
	Flate fl5 = new Flate(50 , 2 , 85 , "Morgan");
	Flate fl6 = new Flate(60 , 3 , 120 , "Cook");
	Flate fl7 = new Flate(70 , 3 , 126 , "Williams");
	Flate fl8 = new Flate(80 , 2 , 100 , "Jones");
	Flate fl9 = new Flate(90 , 4 , 140 , "Smith");
	
	ArrayList<Flate> list = new ArrayList<Flate>();
	Build b = new Build(list, "Baker Street" , "4a", 9);
	
	
	@Test
	public void testSearch() throws Exception{
		list.add(fl8);
		b.setAr(list);
		assertEquals(b.searchNumber("Jones"),fl8);
	}
	
	@Test
	public void testCount() throws Exception{
		list.add(fl1);
		list.add(fl2);
		list.add(fl3);
		list.add(fl4);
		list.add(fl5);
		list.add(fl6);
		list.add(fl7);
		list.add(fl8);
		list.add(fl9);
		b.setAr(list);
		assertEquals(b.countOfFlats(3),4);
	}
	
	@Test
	public void testStreet() throws Exception{
		assertEquals(b.getStreetName(),"Baker Street");
	}
	
	@Test
	public void testNumberBuild() {
		assertEquals(b.getNumberOfBuild(),"4a");
	}
	@Test
	public void testNumberFlats() {
		assertEquals(b.getNumberOfFlats(),9);
	}
	

	@Test
	public void testOwnerNameTrue() {
		Flate fl = new Flate.Builder().setName("Kroft").createFlat();
		assertEquals(fl.getOwner(), "Kroft");
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testNameFalse() {
		Flate fl = new Flate.Builder().setName("kroft").createFlat();
		assertEquals(fl.getOwner(), "kroft");
	}
	
	@Test
	public void testRCountTrue() {
		Flate fl = new Flate.Builder().setRoomsCount(4).createFlat();
		assertEquals(fl.getRoomsCount(), 4);
	}
	
	
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testRCountFalse() {
		Flate fl = new Flate.Builder().setRoomsCount(100).createFlat();
		assertEquals(fl.getRoomsCount(), 100);
	}
	
	@Test
	public void testSquareTrue() {
		Flate fl = new Flate.Builder().setSquare(90).createFlat();
		assertEquals(fl.getSquare(), 90);
	}
	
	
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testSquareFalse() {
		Flate fl = new Flate.Builder().setSquare(1000).createFlat();
		assertEquals(fl.getSquare(), 1000);
	}

	@Test
	public void testNumberTrue() {
		Flate fl = new Flate.Builder().setNumber(210).createFlat();
		assertEquals(fl.getNumber(), 210);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testNumberFalse() {
		Flate fl = new Flate.Builder().setNumber(0).createFlat();
		assertEquals(fl.getNumber(), 0);
	}

	
	
	
}
