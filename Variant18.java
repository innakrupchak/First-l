package model;

public class Variant18 {
	
	int array18 (int[] array)
	{ int k = -1;
		for(int i=0; i<10;i++)
			{
			if(array[k]<array[9]) k =i;
				break;
			
			}
		if(k == -1) return 0;
		else return array[k];
	}
	
/*	void InputForBegin ()
	{
		while((C <= A) || (C >= B))
			{
			System.out.println("Input C > A and C < B");
	
			System.out.println("Input A , B , C");
			Scanner scanA = new Scanner (System.in);
			Scanner scanB = new Scanner (System.in);
			Scanner scanC = new Scanner (System.in);

			float A = scanA.nextFloat();
			float B = scanB.nextFloat();
			float C = scanC.nextFloat();
			}
	}
	
*/	
	public int begin18 (int A , int B , int C)
	{
	 int AC , BC;
		AC = C - A;
		BC = B - C;
		return AC*BC;
	}
	
	boolean boolean18 (int a , int b , int c)
	{
		if((a == b)||(a == c) || (b == c)) return true;
		else return false;
	}
	
	int if18(int a , int b , int c)
	{ 
		if((a == b) && (a!=c)) return 3;
		if ((a!=b)&&(b!=c)&&(a==c)) return 2;
		if ((a!=b)&&(b == c)) return 1;
		return -1;
	}
	
	float for18(float A , int N)
	{
		float suma = 0;
		for(int i=0 ; i<= N ; i++)
			{suma += Math.pow(-A, i);}
		return suma;
	}
	
	void case18(int[] a)
	{
		int hundred , decade , unit;
		hundred = a[1] ;
		decade = a[2];
		unit = a[3];
		String  stringhundred , stringdecade , stringunit;
		switch(hundred)
		{
		case 1 : stringhundred = "—то";
				break;
		case 2 : stringhundred = "ƒв≥ст≥";
				break;
		case 3 : stringhundred = "“риста";
				break;
		case 4 : stringhundred = "„отириста";
				break;
		case 5 : stringhundred = "ѕ'тсот";
				break;
		case 6 : stringhundred = "Ў≥стсот";
				break;
		case 7 : stringhundred = "—≥мсот";
				break;
		case 8 : stringhundred = "¬≥с≥мсот";
				break;
		case 9 : stringhundred = "ƒев'€тсот";
		default : stringhundred="Not valid";
		}
		System.out.printf("%s",stringhundred);
		
		switch (decade)
		{
		case 1 : 
			{
				switch(unit)
				{
				case 1 : stringdecade = "одинадц€ть";
					break;
				case 2 : stringdecade = "дванадц€ть";
					break;
				case 3 : stringdecade = "тринадц€ть";
					break;
				case 4 : stringdecade = "чотирнадц€ть";
					break;
				case 5 : stringdecade = "п'€тнадц€ть";
					break;
				case 6 : stringdecade = "ш≥стнадц€ть";
					break;
				case 7 : stringdecade = "с≥мнадц€ть";
					break;
				case 8 : stringdecade = "в≥с≥мнадц€ть";
					break;
				case 9 : stringdecade = "дев'€тнадц€ть";
					break;
				}
			}
				
		case 2 : stringdecade = " двадц€ть ";
				break;
		case 3 : stringdecade = " тридц€ть ";
				break;
		case 4 : stringdecade = " сорок ";
				break;
		case 5 : stringdecade = " п'€тдес€т ";
				break;
		case 6 : stringdecade = " ш≥стдес€т ";
				break;
		case 7 : stringdecade = " с≥мдес€т ";
				break;
		case 8 : stringdecade = " в≥с≥мдес€т ";
				break;
		case 9 : stringdecade = " дев'€носто ";
				break;
		default : stringdecade = "Not valid";
		
		}
		System.out.printf("%s",stringdecade);
		if(decade != 1)
		{
		switch(unit)
		{
		case 1 : stringunit = "один";
				break;
		case 2 : stringunit = "два";
				break;
		case 3 : stringunit = "три";
				break;
		case 4 : stringunit = "чотири";
				break;
		case 5 : stringunit = "п'€ть";
				break;
		case 6 : stringunit = "ш≥сть";
				break;
		case 7 : stringunit = "с≥м";
				break;
		case 8 : stringunit = "в≥с≥м";
				break;
		case 9 : stringunit = "дев'€ть";
				break;
		default : stringunit = "Not valid";
		}
		System.out.printf("%s",stringunit);
		}
		
		
		
	}
	

	public static void main(String[] args) {
		
		
		
		return ;
		
			
		

	}

}
