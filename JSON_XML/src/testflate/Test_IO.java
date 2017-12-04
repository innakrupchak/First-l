package testflate;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import flate.BBuilder;
import flate.Build;
import flate.Flate;

import org.testng.AssertJUnit;
//import static org.testng.Assert.assertEquals;



import flate.*;
import InputOutput.*;

public class Test_IO {
	@Test
	public void TestFlateJson() throws IOException {

		Flate fl1 = new Flate(10 , 3 , 80 , "Brown");		

		new FlateJson().serialize(fl1, "FlatJson.json");
		Flate res = new FlateJson().deserialize("FlatJson.json");

		AssertJUnit.assertEquals(res.toString(), res.toString());
	}

	@Test
	public void TestFlateXML() throws IOException {

		Flate fl1 = new Flate.Builder().setOwnerName("John").setNumber(2).setRoomsCount(2).setSquare(120).createFlat();
		Flate fl2 = new Flate.Builder().setOwnerName("Smith").setNumber(210).setRoomsCount(4).setSquare(100).createFlat();
		Flate fl3 = new Flate.Builder().setOwnerName("Colins").setNumber(508).setRoomsCount(3).setSquare(120).createFlat();
		Flate fl4 = new Flate.Builder().setOwnerName("Krupchak").setNumber(408).setRoomsCount(2).setSquare(130).createFlat();
		Flate fl5 = new Flate(10 , 3 , 80 , "Brown");
		
		new FlateXML().serialize(fl1, "FlatXML.xml");
		Flate res = new FlateXML().deserialize("FlatXML.xml");

		AssertJUnit.assertEquals(fl1.toString(), res.toString());
	}

	@Test
	public void TestBuildXML() throws IOException {

		Flate fl1 = new Flate.Builder().setOwnerName("Krupchak").setNumber(408).setRoomsCount(2)
				.setSquare(50).createFlat();
	
		Flate fl2 = new Flate.Builder().setOwnerName("Litvinchuk").setNumber(508).setRoomsCount(3)
				.setSquare(65).createFlat();
		Flate fl3 = new Flate.Builder().setOwnerName("Kosovych").setNumber(509).setRoomsCount(2)
				.setSquare(50).createFlat();
		Flate fl4 = new Flate.Builder().setOwnerName("Lupashku").setNumber(33).setRoomsCount(3)
				.setSquare(100).createFlat();
		Flate fl5 = new Flate.Builder().setOwnerName("Hordiy").setNumber(407).setRoomsCount(2)
				.setSquare(55).createFlat();
		Flate fl6 = new Flate.Builder().setOwnerName("Smith").setNumber(307).setRoomsCount(3)
				.setSquare(155).createFlat();
		Flate fl7 = new Flate.Builder().setOwnerName("Colins").setNumber(210).setRoomsCount(2)
				.setSquare(90).createFlat();

		

		ArrayList<Flate> list1 = new ArrayList<Flate>();
		list1.add(fl1);
		list1.add(fl2);
		list1.add(fl3);
		list1.add(fl4);
		list1.add(fl5);

		ArrayList<Flate> list2 = new ArrayList<Flate>();
		list2.add(fl6);
		list2.add(fl7);

		Build b1 = new BBuilder("Stasyuka").setFlats(list1).setNumberOfBuild("4a")
				.setNumberOfFlats(80).createBuild();
		Build b2 = new BBuilder("Independent").setFlats(list2).setNumberOfBuild("12b")
				.setNumberOfFlats(9).createBuild();
		new BuildXML().serialize(b1, "BuildXML.xml");

		Build b3 = new BuildXML().deserialize("BuildXML.xml");


		AssertJUnit.assertEquals(b3.getStreetName(), b1.getStreetName());
	}
	
	@Test
	public void TestBuildJson() throws IOException {

		Flate fl1 = new Flate.Builder().setOwnerName("John").setNumber(2).setRoomsCount(2).setSquare(120).createFlat();
		Flate fl2 = new Flate.Builder().setOwnerName("Smith").setNumber(210).setRoomsCount(4).setSquare(100).createFlat();
		Flate fl3 = new Flate.Builder().setOwnerName("Colins").setNumber(508).setRoomsCount(3).setSquare(120).createFlat();
		Flate fl4 = new Flate.Builder().setOwnerName("Krupchak").setNumber(408).setRoomsCount(2).setSquare(130).createFlat();

		ArrayList<Flate> list = new ArrayList<Flate>();
		list.add(fl1);
		list.add(fl2);
		list.add(fl3);
		list.add(fl4);

		ArrayList<Flate> list2 = new ArrayList<Flate>();
		list2.add(fl2);
		list2.add(fl3);

		Build b1 = new BBuilder("Royal").setNumberOfBuild("12a").setNumberOfFlats(9).setFlats(list).createBuild();
		Build b2 = new BBuilder("Baker").setNumberOfBuild("4a").setNumberOfFlats(80).setFlats(list2).createBuild();

		new BuildJson().serialize(b1, "BuildJson.json");

		Build b3 = new BuildJson().deserialize("BuildJson.json");


		AssertJUnit.assertEquals(b3.getStreetName(), b1.getStreetName());
	}


}
