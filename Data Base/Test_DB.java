package testflate;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import flate.*;
import DB.*;

public class Test_DB {
    @Test
    public void testGetNewConnection() throws Exception {
        new DB();
		DB.getNewConnection();
    }

   @Test(enabled = false)
    public void testSetDatabase() throws Exception {
        new DB();
		DB.setDatabase();;
    }


   @Test(enabled = false)
    public void testAddFlat() throws Exception {
        Flate flat1 = new Flate.Builder().setOwnerName("Smith").setRoomsCount(3).setNumber(210).createFlat();
        Build build=new BBuilder("Royal").createBuild();
        new DB();
		DB.addFlat(flat1,build);
    }

    //@Test(priority = 3)
    public void testAddGarage() throws Exception {
    	Flate fl1 = new Flate.Builder().setOwnerName("John").setNumber(2).setRoomsCount(2).setSquare(120).createFlat();
		Flate fl2 = new Flate.Builder().setOwnerName("Smith").setNumber(210).setRoomsCount(4).setSquare(100).createFlat();
		Flate fl3 = new Flate.Builder().setOwnerName("Colins").setNumber(508).setRoomsCount(3).setSquare(120).createFlat();
		Flate fl4 = new Flate.Builder().setOwnerName("Krupchak").setNumber(408).setRoomsCount(2).setSquare(130).createFlat();
		Flate fl5 = new Flate.Builder().setOwnerName("Litvinchuk").setNumber(508).setRoomsCount(3)
				.setSquare(65).createFlat();
		Flate fl6 = new Flate.Builder().setOwnerName("Kosovych").setNumber(509).setRoomsCount(2)
				.setSquare(50).createFlat();
		Flate fl7 = new Flate.Builder().setOwnerName("Lupashku").setNumber(33).setRoomsCount(3)
				.setSquare(100).createFlat();
		Flate fl8 = new Flate.Builder().setOwnerName("Hordiy").setNumber(407).setRoomsCount(2)
				.setSquare(55).createFlat();
		Flate fl9 = new Flate.Builder().setOwnerName("Smith").setNumber(307).setRoomsCount(3)
				.setSquare(155).createFlat();
		Flate fl10 = new Flate.Builder().setOwnerName("Colins").setNumber(210).setRoomsCount(2)
				.setSquare(90).createFlat();
		Build build = new BBuilder("Stasyuka").setNumberOfBuild("4a")
				.setNumberOfFlats(10).createBuild();
        
		build.add(fl1);
        build.add(fl2);
        build.add(fl3);
        build.add(fl4);
        build.add(fl5);
        build.add(fl6);
        build.add(fl7);
        build.add(fl8);
        build.add(fl9);
        build.add(fl10);
        new DB();
		DB.addBuild(build);
    }

    @Test(priority = 4)
    public void testGetFlat() throws Exception {
        Flate flat= new Flate.Builder().setNumber(308).setOwnerName("Rusnak").setRoomsCount(3)
        		.setSquare(120).createFlat();
        new DB();
		assertEquals(DB.getFlatByNumber(308),flat);
    }

    @Test(priority = 4)
    public void testGetBuild() throws Exception {
    	Flate fl5 = new Flate.Builder().setOwnerName("Litvinchuk").setNumber(508).setRoomsCount(3)
				.setSquare(65).createFlat();
		Flate fl6 = new Flate.Builder().setOwnerName("Kosovych").setNumber(509).setRoomsCount(2)
				.setSquare(50).createFlat();
		Flate fl7 = new Flate.Builder().setOwnerName("Lupashku").setNumber(33).setRoomsCount(3)
				.setSquare(100).createFlat();
		Flate fl8 = new Flate.Builder().setOwnerName("Hordiy").setNumber(407).setRoomsCount(2)
				.setSquare(55).createFlat();
		Flate fl9 = new Flate.Builder().setOwnerName("Smith").setNumber(307).setRoomsCount(3)
				.setSquare(155).createFlat();
		Flate fl10 = new Flate.Builder().setOwnerName("Colins").setNumber(210).setRoomsCount(2)
				.setSquare(90).createFlat();
		Build build = new BBuilder("Stasyuka").setNumberOfBuild("3b")
				.setNumberOfFlats(10).createBuild();
		build.add(fl5);
        build.add(fl6);
        build.add(fl7);
        build.add(fl8);
        build.add(fl9);
        build.add(fl10);
        new DB();
		assertEquals(DB.getBuildByNumber("3b"),build);
    }

    @Test(enabled = false)
    public void testDeleteFlat() throws Exception {
        new DB();
		DB.deleteFlat(407);
    }

    @Test(enabled = false)
    public void testDeleteGarage() throws Exception {
        new DB();
		DB.deleteBuild("3b");
    }
}