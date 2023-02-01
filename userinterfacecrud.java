package com.crud.ui;

import static com.crud.query.querycrud.*;
import java.util.Scanner;

public class userinterfacecrud {
	
	public static void main(String[] args) throws Exception
	{
		
		do
		{
			Scanner s1=new Scanner(System.in);
			
			System.out.println("Enter\t:\t1.insert\t2.delete\t3.update\t4.search\t5.displayall\t6.exit");
			int choice=s1.nextInt();
			int id=0;
			String name=null;
			double mark=0.0;
		
		switch(choice)
		{
			case 1:											//insert
				System.out.println("Enter sid : ");
				 id=s1.nextInt();
				System.out.println("Enter sname : ");
				 name=s1.next();
				System.out.println("Enter sperc : ");
				 mark=s1.nextDouble();
				insertdata(id,name,mark);
				break;
				
			case 2:											//delete
				System.out.println("Enter sid : ");
				id=s1.nextInt();
				deletedata(id);
				break;
			case 3:											//update
				System.out.println("Enter 1 to update only Sname : ");
				System.out.println("Enter 2 to update Sname and Sperc : ");
				System.out.println("Enter 3 to update only Sperc : ");
				System.out.println("Enter 4 to update value as null : ");
				int updatechoice=s1.nextInt();
				if(updatechoice==1)
				{
					System.out.println("whose data you will be update please Enter their Sid : ");
					id=s1.nextInt();
					System.out.println("Enter Update Sname : ");
					name=s1.next().toLowerCase();
					
					updatename(id,name);
				}
				else if(updatechoice==2)
				{
					System.out.println("whose data you will be update please Enter their Sid : ");
					id=s1.nextInt();
					System.out.println("Enter Update Sname : ");
					name=s1.next();
					System.out.println("Enter update Sperc : ");
					mark=s1.nextDouble();
					
					updatenameandmark(id,name,mark);
				}
				else if(updatechoice==3)
				{
					System.out.println("whose data you will be update please Enter their Sid : ");
					id=s1.nextInt();
					System.out.println("Enter Update Sprec : ");
					mark=s1.nextDouble();
					
					updatemark(id,mark);
					
				}
			
				else if(updatechoice==4)
				{
				System.out.println("Enter sid :  ");
				id=s1.nextInt();
				updatenull(id,name,mark);
				}
				break;
			case 4:											//search
				System.out.println("Enter sid : ");
				id=s1.nextInt();
				searchdata(id);
				break;
			case 5:											//display all
				displayalldata();
				break;
			case 6:	
				System.out.println("Thankyou exit successfully...!!!");  //exit
				System.exit(0);
				
				break;			
		}
		} while(true);

}

}
