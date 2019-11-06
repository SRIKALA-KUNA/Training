package com.epam.GiftCreation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
	public static void main(String args[]) throws Exception
	{
		ArrayList <Chocolate> chocolate=new ArrayList<Chocolate>();
		
		ArrayList <Sweets>sweets=new ArrayList<Sweets>();
		Calculation cal= new Calculation();
		Scanner sc=new Scanner(System.in);
		String type;
		int count;
		while(true)
		{
			System.out.println("what type of Chocolates do you want\n 1.DairyMilk \n 2.MilkyBar \n 3.exit\n");
			type=sc.nextLine();
			if(type.equals("exit"))
			{
				break;
			}
			System.out.println("enter count\n");
			count =sc.nextInt();
			sc.nextLine();
			chocolate.add(new Chocolate(type,count));
			
		}
		
		while(true)
		{
			System.out.println("what type of Sweets do you want\n 1.Laddu \n 2.KajuBarfi\n 3.exit\n");
			
			type=sc.nextLine();
			if(type.equals("exit"))
			{
				break;
			}
			System.out.println("enter count\n");
			count =sc.nextInt();
			sc.nextLine();
			sweets.add(new Sweets(type,count));
			
		}
		double totalWeight=cal.calculate(chocolate,sweets);
		System.out.println(totalWeight);
		cal.sortCandies(chocolate);
		cal.filterCandies(chocolate,sweets);
		sc.close();
		
		
	}

}
