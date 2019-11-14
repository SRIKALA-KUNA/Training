package com.epam.Boutique;

import java.util.Scanner;
import Flowers.*;

public class User {
	public static void main(String args[])
	{
		System.out.println("What type of flowers do you want 1.rose 2 .lily 3.jasmine 4.exit ");
		Scanner sc= new Scanner(System.in) ;
		int typeOfFlower, numOfFlowers;
		int totalBouquitCost=20;
		Rose r=new Rose();
		Jasmine j=new Jasmine();
		Lily l=new Lily();
		typeOfFlower =sc.nextInt();
		while (typeOfFlower !=4)
		{
			
			System.out.println("how many do you want");
			numOfFlowers=sc.nextInt();
			switch(typeOfFlower)
			{
			case 1: totalBouquitCost += r.rose(numOfFlowers);
			break;
			
			case 2:totalBouquitCost+= l.lily(numOfFlowers);
			break;
			case 3: totalBouquitCost+= j.jasmine(numOfFlowers);
			break;
		
			default: System.out.println("enter valid option");
				
			}
			System.out.println("What type of flowers do you want 1.rose 2 .lily 3.jasmine 4.exit ");
			typeOfFlower =sc.nextInt();
		}
		
		System.out.println(totalBouquitCost);
		
	}
	

}
