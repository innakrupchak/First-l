package flate;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import flate.Flate;



public  class Build implements Comparator<Flate> {
	private List<Flate> flats = new ArrayList<Flate>();
	private String streetName;
	private String numberOfBuild;
	private int numberOfFlats;
	
	public Build(){
		flats= null;
		streetName=null;
		numberOfBuild=null;
		numberOfFlats=0;
		
		
	}
	
	public Build(ArrayList<Flate> flate, String streetName, String numberOfBuild, int n)
	{
		this.flats= flate;
		this.streetName=streetName;
		this.numberOfBuild=numberOfBuild;
		this.numberOfFlats=n;
		
		
	}
	
	public void setStreetName(String streetN){
		this.streetName=streetN;
		
	}
	
	public void setNumberOfBuild(String numberOfB){
		this.numberOfBuild=numberOfB;
		
	}
	
	public void setNumberOfFlates(int numberOfF){
		this.numberOfFlats=numberOfF;
		
	}

	public String getStreetName(){
		return this.streetName;
		
	}
	public String getNumberOfBuild(){
		return this.numberOfBuild;
		
	}
	
	public int getNumberOfFlats(){
		return this.numberOfFlats;
		
	}
	public void add(Flate f) {
		this.flats.add(f);
		numberOfFlats++;
	}

	
	public List<Flate> getAr() {
		return flats;
	}

	public void setAr(List<Flate> flats) {
		this.flats = flats;
		this.numberOfFlats=flats.size();
	}
	
	public Flate searchNumber(String ownerName){
		
		for(Flate f: flats)
		{
			if( f.getOwner() == ownerName) return f;
		}
		return null;
	}
	
	public void sortByArea(){
		Collections.sort(flats, new Comparator<Flate>(){
			public int compare(Flate ob1, Flate ob2)
			{
				int comp;
				if(ob1.getSquare()>ob2.getSquare()) comp=1;
				if(ob1.getSquare()==ob2.getSquare()) comp=0;
				else comp=-1;
				return comp;
			}
			
		});
	}
	
	public int countOfFlats(int rooms){
		int count=0;
		for(Flate f: flats)
		{
			if( f.getRoomsCount() == rooms) count++;
		}
		return count;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	


	@Override
	public int compare(Flate arg0, Flate arg1) {

		return 0;
	}

}
