//import java.io.*;
import java.io.File;
import java.util.Scanner;
public class CoordinateList2D
{

// basic data members
private double[] xPts;
private double[] yPts;	
private int ct;

private int capacity;// i use this to resize arrays"xPts,yPts" to a larger size

 public CoordinateList2D()
 {
	 ct=0; capacity=100;
	 xPts=yPts=null;
	 this.reSize(); 
 }
 
public int getSize(){ return this.ct; }
public int getCapacity(){ return this.capacity; }

private void reSize()
{
		if( ( xPts == null ) && ( yPts == null )) // for use in a default constructor // capcity=100
	{
		xPts=new double[capacity];
		yPts=new double[capacity];
		
		for(int i=0; i<capacity ; i++){ xPts[i]=yPts[i]=0; }
		
	}
	
	else
	{
		
		int temp = capacity;
		capacity *=2; 
		
		double[] xt=new double[temp];
		double[] yt=new double[temp];
		
		for(int i=0; i<temp; i++){ xt[i]=xPts[i]; yt[i]=yPts[i]; }	

		xPts=new double[capacity];
		yPts=new double[capacity];
		
		for(int i=0; i<capacity ; i++){ xPts[i]=yPts[i]=0; }	

		for(int i=0; i<temp; i++){ xPts[i]=xt[i]; yPts[i]=yt[i]; }	
	}
}

public void scaleUp(double factor)
{
	if(factor <= 1)
	{  
	System.out.print("	error in value of factor ,will be reset value of factor to be >= 2 "); 
	if(factor == 1){System.out.println("\n	,note( factor == 1 :No change in the value of the data )");}
	if(factor < 1){System.out.println("\n	,note( factor < 1 : scaleDown )");}
	return; } 
	
	if( this.ct == 0 ){ System.out.println("\n	error empty point (no point) "); return; }
	
	for(int i=0; i<ct ; i++){ xPts[i] *=factor; yPts[i] *=factor; }
}

public void addPoint(double x , double y) // addPoint in back "append"
{
	if( ct == capacity )
	{
		this.reSize();
	}
	
	xPts[ct]=x;
	yPts[ct]=y;
	ct++;
}

public void populateFromFile(String filename)
{
	File fptr = null;//create object from type file
	Scanner read = null;//create object for read
	
	try 
	{ 
		//open file 
		fptr = new File(filename);//path of file which the object file point
		read=new Scanner(fptr);//select read from file
		
		//if file successfully open(read points from file)
		while (read.hasNext())
		{
		String x=read.next();
		String y=read.next();
		this.addPoint(Double.parseDouble(x),Double.parseDouble(y));
		}

		System.out.println("read file is done ");		
		
	}
	
	catch(Exception e) 
	{ //if file not open 
		if((fptr == null) || (read == null)){ System.out.println("File not exists!");} //if(!fptr.exist()){......}
	}
	
	finally //close file
	{
     int i=((fptr == null) || (read == null))?0:1;
	 if(i==1){read.close();}
	 fptr=null; read=null;
    }
}

public String toString()//just 5 points
{
	if(ct == 0)return "\n	no point \n";
	
	String result="\n";
	
	int tempC=0;
	
	if(this.ct >= 5){tempC=5;}else{tempC=this.ct;}
	for(int i=0; i<tempC ; i++)
	{
		// simple Double Format
		/*
		String temp=" ( ";
		temp +=Double.toString(xPts[i]);  
		temp +=" , ";
		temp +=Double.toString(yPts[i]); 
		if(i==(tempC-1))
		temp +=" ) \n";
		else temp +=" ),\n";
		result +=temp; 
		*/                   
		
		
		//  Format with 2 decimal place "#,##" , #:Number
		String temp="	( ";
		temp +=String.format("%.2f",xPts[i]);  
		temp +=" , ";
		temp +=String.format("%.2f",yPts[i]); 
		if(i==(tempC-1))
		temp +=" ) \n";
		else temp +=" ),\n";
		result +=temp; 
	}
	
	/*
	for(int i=tempC;i<5;i++){result +=("there is no point "+(i+1)+"\n");}
	if(tempC < 5){ result +=("\n Note: number of points just :"+tempC+"\n");}
	*/
	
	return result;
}

private String full_toString()
{
	if(ct == 0)return "\n	no point \n";
	
	String result="\n";
	
	for(int i=0; i<this.ct ; i++)
	{
		// simple Double Format
		/*
		String temp=" ( ";
		temp +=Double.toString(xPts[i]);  
		temp +=" , ";
		temp +=Double.toString(yPts[i]); 
		if(i==(ct-1))
		temp +=" ) \n";
		else temp +=" ),\n";
		result +=temp; 
		*/                   
		
		
		//  Format with 2 decimal place "#,##" , #:Number
		String temp="\t(\t";
		temp +=String.format("%.2f",xPts[i]);  
		temp +="\t,\t";
		temp +=String.format("%.2f",yPts[i]); 
		if(i==(ct-1))
		temp +="\t)\t\n";
		else temp +="\t),\n";
		result +=temp; 
	}
	
	return result;
}

public void display(){ System.out.print(this.full_toString()); }

/*
protected void finalize(){}
*/

}