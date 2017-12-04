package flate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
//import java.util.Comparator; 
import flate.Build;

public  class BBuilder {
	List<Flate> flats = new ArrayList<Flate>();
	String streetName;
	String numberOfBuild;
	int numberOfFlats;
	final static String STREET_NAME_PATERN = "^[A-Z][A-z]+";
	final static String NUBER_OF_BUILD_PATERN = "^[0-9]+[A-z-]$";
	


	public BBuilder(String streetname) {
		Pattern p1 = Pattern.compile(STREET_NAME_PATERN);
		if (p1.matcher(streetname).matches())
			this.streetName = streetname;
		else
			throw new IllegalArgumentException("Street name is incorrect");
	}

	public BBuilder setFlats(ArrayList <Flate> flats) {
		for (Flate f : flats) {
			this.flats.add(f);
		}
		return this;
	}
	
	public BBuilder setNumberOfBuild(String number) {
		Pattern p2 = Pattern.compile(NUBER_OF_BUILD_PATERN);
		if(p2.matcher(number).matches())
			this.numberOfBuild = number;
		else
			throw new IllegalArgumentException("Number is incorrect");
		return this;
	}
	public BBuilder setNumberOfFlats(int number) {
		if(number>0 && number < 500)
			this.numberOfFlats = number;
		else
			throw new IllegalArgumentException("Number of flats is incorrect");
		return this;
	}

	public Build createBuild() {
		return new Build(this);
	}

	public BBuilder getBuilder() {
		return this;
	}

	@Override
	public String toString() {
		
		String result = null;
		
		for(Flate f : flats) {
			result = "["+f.toString()+"],";
		}
		
		return result;
	}}
	

