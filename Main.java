import java.util.Scanner;
class Main{
	
	// code for clear function
public static void cls()
{
	try
	{	
		new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
	}catch(Exception E)
		{
			System.out.println(E);
		}
}


	
public static void main(String args[]) 
{

	CoordinateList2D a=new CoordinateList2D();
	
	Scanner input = new Scanner(System.in); 

	int select=-1;

	while(select != 8)
	{
		switch(select)
		{
			
		case -1:
		{
	System.out.print("\n-----------------------Main-----------------------\n");
	System.out.print("\n	1- Read from file \n");
	System.out.print("\n	2- Add Point in back -append- \n");
	System.out.print("\n	3- scaleUp \n");
	System.out.print("\n	4- ToString -just 5 points- \n");
	System.out.print("\n	5- Display -all soints- \n");
	System.out.print("\n	6- Output -depends on the number of points- \n");
	System.out.print("\n	7- Clear the screen \n");
	System.out.print("\n	8- Exit from Program \n");
			select=0;
			 break;
		}
		
		case 0:
		{
			System.out.print("\n-------------------------------------------------------------\n");
			System.out.print("\n	Enter select : ");
			select=input.nextInt();
			 break;
		}
		
		case 1:
		{
			System.out.print("\n	Enter path or name of  file : ");
			String file_=input.next();
			System.out.print("\n	");
			 a.populateFromFile(file_);
			 select=0;
			 break;
		}
		
		case 2:
		{
			System.out.print("\n	Enter x axis: "); double x = input.nextDouble();
			System.out.print("	Enter Y axis: "); double y = input.nextDouble();
			a.addPoint(x,y);
			 select=0;
			 break;
		}
		
		case 3:
		{
			System.out.print("\n	Enter factor: "); double factor = input.nextDouble();
			a.scaleUp(factor);
			if(factor <= 1){select=3;}
			else{select=0;}
			 break;
		}
		
		case 4:
		{
			System.out.print("\n	ToString -just 5 points- : \n");System.out.print(a.toString());
			 select=0;
			 break;
		}
		
		case 5:
		{
			System.out.print("\n	Display -all soints- : \n"); a.display();
			 select=0;
			 break;
		}
		
		case 6:
		{
			int i=a.getSize();
			if(i <= 5)select=4;
			else select=5;
			 break;
		}
		
		case 7:
		{
			cls();
			select=-1;
			 break;
		}
		
		default:{ System.out.print("\n	error in select ,reselect -> \n"); select=0;}
		}
	}
	
	      System.out.println("\nPress Any Key To Continue...");
          new java.util.Scanner(System.in).nextLine();
		  cls();  System.exit(0); 
	
}



}
