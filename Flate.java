package flate;


public class Flate {

	public static double PRICE_PER_METER = 200.5;

	private int number;
	private int roomsCount;
	private int square;
	private String ownerName;
	
	
	
	public  Flate()
	{
		number=0;
		roomsCount=0;
		square=0;
		ownerName = null;
	
		
		
	}
	
	public Flate(int n, int nr, int s, String str )
	{
		number=n;
		roomsCount=nr;
		square=s;
		ownerName = str;
		//f_cost = this.F_Cost();
	}
	
	
	
	public void setNumber(int n)
	{
		this.number=n;
	}
	
	public void setRoomsCount(int nr)
	{
		this.roomsCount=nr;
	}
	
	
	
	public void setSquare(int s)
	{
		this.square=s;
	}
	
	public void setOwnerName(String on)
	{
		this.ownerName=on;
	}
	
	public int getNumber()
	{ 
	return this.number;
	}
	
	public int getRoomsCount()
	{ 
	return this.roomsCount;
	}
	
	public int getSquare()
	{ 
	return this.square;
	}
	
	
	
	public String getOwner()
	{ 
	return this.ownerName;
	}
	
	
	public double cost()
	{
		double fCost=PRICE_PER_METER*square;
		return fCost;
	}

	@Override
	public String toString(){
		String s = "¹" + getNumber()+" " + getRoomsCount()+ " rooms " +"square:" + getSquare()+ " meters";
		s += " Owner: " + getOwner();
		return s;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		result = prime * result
				+ ((ownerName == null) ? 0 : ownerName.hashCode());
		result = prime * result + roomsCount;
		result = prime * result + square;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flate other = (Flate) obj;
		if (number != other.number)
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (roomsCount != other.roomsCount)
			return false;
		if (square != other.square)
			return false;
		return true;
	}
	
	

	public static void main(String[] args){
		System.out.println("Done");
		Flate fl = new Flate(215 , 3 , 12 , "Smith");
		Flate fl2 = new Flate(216, 3, 12, "Smith");
		System.out.println(fl);
		fl.equals(fl2);
		
	}
}
