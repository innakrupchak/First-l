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
		case 1 : stringhundred = "���";
				break;
		case 2 : stringhundred = "����";
				break;
		case 3 : stringhundred = "������";
				break;
		case 4 : stringhundred = "���������";
				break;
		case 5 : stringhundred = "�'����";
				break;
		case 6 : stringhundred = "س�����";
				break;
		case 7 : stringhundred = "ѳ����";
				break;
		case 8 : stringhundred = "³�����";
				break;
		case 9 : stringhundred = "���'�����";
		default : stringhundred="Not valid";
		}
		System.out.printf("%s",stringhundred);
		
		switch (decade)
		{
		case 1 : 
			{
				switch(unit)
				{
				case 1 : stringdecade = "����������";
					break;
				case 2 : stringdecade = "����������";
					break;
				case 3 : stringdecade = "����������";
					break;
				case 4 : stringdecade = "������������";
					break;
				case 5 : stringdecade = "�'���������";
					break;
				case 6 : stringdecade = "�����������";
					break;
				case 7 : stringdecade = "���������";
					break;
				case 8 : stringdecade = "����������";
					break;
				case 9 : stringdecade = "���'���������";
					break;
				}
			}
				
		case 2 : stringdecade = " �������� ";
				break;
		case 3 : stringdecade = " �������� ";
				break;
		case 4 : stringdecade = " ����� ";
				break;
		case 5 : stringdecade = " �'������� ";
				break;
		case 6 : stringdecade = " ��������� ";
				break;
		case 7 : stringdecade = " ������� ";
				break;
		case 8 : stringdecade = " �������� ";
				break;
		case 9 : stringdecade = " ���'������ ";
				break;
		default : stringdecade = "Not valid";
		
		}
		System.out.printf("%s",stringdecade);
		if(decade != 1)
		{
		switch(unit)
		{
		case 1 : stringunit = "����";
				break;
		case 2 : stringunit = "���";
				break;
		case 3 : stringunit = "���";
				break;
		case 4 : stringunit = "������";
				break;
		case 5 : stringunit = "�'���";
				break;
		case 6 : stringunit = "�����";
				break;
		case 7 : stringunit = "��";
				break;
		case 8 : stringunit = "���";
				break;
		case 9 : stringunit = "���'���";
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
