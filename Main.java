package flate;
import java.util.ArrayList;
import java.util.Scanner;



import flate.Flate;
import flate.Build;


public class Main {

	public static void main(String[] args) {
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
		b.sortByArea();
		int c;
		c= b.countOfFlats(2);
		System.out.println("This build contains "+c+" flats with 2 rooms.");
		//Scanner in = new Scanner(System.in);
        //System.out.println("Enter surname ");
       // String surname = in.nextLine();
        Flate number;
        number= b.searchNumber("Jones");
        System.out.println( number);
        
		
		

	}

}
