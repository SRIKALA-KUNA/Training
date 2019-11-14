package com.epam.GiftCreation;

public class Chocolate implements DairyMilk, MilkyBar {
	public String name;
	public int cost;
	public int weight;
	public int count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	Chocolate(String name, int count2)
	{
		this.count= count2;
		this.name=name;
		if(name.equals ("DairyMilk"))
		{
			this.cost=DairyMilk.cost;
			this.weight=DairyMilk.weight;
			
		}
		else if(name.equals("MilkyBar"))
		{
			this.cost=MilkyBar.cost;
			this.weight=MilkyBar.weight;
		}
	}
	

}
