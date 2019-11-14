package com.epam.GiftCreation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Calculation {
	double chocolateWeight=0,sweetWeight=0;
	double calculate(ArrayList<Chocolate> chocolate, ArrayList<Sweets> sweets)
	{
		for(Chocolate c: chocolate )
		{
			chocolateWeight+= c.weight* c.count;

		}
		for(Sweets s: sweets )
		{
			sweetWeight+= s.weight* s.count;

		}
		return chocolateWeight+sweetWeight;

	}
	static void sortCandies(ArrayList<Chocolate> chocolate) 
	{
		System.out.println("Sort by\n 1.cost\n 2.weight\n");
		Scanner sc=new Scanner(System.in);
		int choice= sc.nextInt();
		switch(choice)
		{
		case 1: Collections.sort(chocolate,( c1,  c2)->c1.getCost()-c2.getCost());
		for(Chocolate c: chocolate )
		{
			System.out.println(c.name +" "+ c.cost);

		}
		break;

		case 2: Collections.sort(chocolate,( c1,  c2)->c1.getWeight()-c2.getWeight());
		for(Chocolate c: chocolate )
		{
			System.out.println(c.name +" "+ c.weight+" "+(c.count*c.weight));

		}

		break;
		default: System.out.println("enter appropriate number");

		}

	}
	public void filterCandies(ArrayList<Chocolate> chocolate, ArrayList<Sweets> sweets) throws IOException 
	{
		System.out.println("filter by \n 1.cost\n 2.weight\n");
		Scanner sc=new Scanner(System.in);
		int choice= sc.nextInt();
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		switch(choice)
		{
		case 1: 
			System.out.println("enter cost range");
			
			int costRangeLowerLimit= Integer.parseInt(br.readLine());
			
			int costRangeUpperLimit= Integer.parseInt(br.readLine());
			

			for(Chocolate c: chocolate )
			{
				if( c.cost*c.count>=costRangeLowerLimit && c.cost*c.count<= costRangeUpperLimit)
					System.out.println(c.name +" "+ c.cost+" "+(c.count*c.cost));

			}
			for(Sweets s: sweets )
			{
				if( s.cost*s.count>=costRangeLowerLimit && s.cost*s.count<= costRangeUpperLimit)
					System.out.println(s.name +" "+s.cost +" "+(s.cost* s.count));

			}
			break;

		case 2:
			System.out.println("enter weight range");
			int weightRangeLowerLimit= Integer.parseInt(br.readLine());
			
			int weightRangeUpperLimit= Integer.parseInt(br.readLine());
			
			for(Chocolate c: chocolate )
			{
				
				if( c.weight*c.count>=weightRangeLowerLimit && c.weight*c.count<= weightRangeUpperLimit)
					System.out.println(c.name +" "+ c.weight+""+(c.count*c.weight));

			}
			
			for(Sweets s: sweets )
			{
				if( s.weight*s.count>=weightRangeLowerLimit && s.weight*s.count<= weightRangeUpperLimit)
					System.out.println(s.name +" "+ s.weight+" "+(s.count*s.weight));

			}

			break;
		default: System.out.println("enter appropriate number");

		}

	}


}
