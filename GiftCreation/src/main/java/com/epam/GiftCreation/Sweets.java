package com.epam.GiftCreation;

public class Sweets {
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
	public double getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public double getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	Sweets(String name,int  count2)
	{
		this.count= count2;
		this.name=name;
		if(name.equals ("Laddu"))
		{
			this.cost=Laddu.cost;
			this.weight=Laddu.weight;
			
		}
		else if(name.equals("KajuBarfi"))
		{
			this.cost=KajuBarfi.cost;
			this.weight=KajuBarfi.weight;
		}
	}

}
