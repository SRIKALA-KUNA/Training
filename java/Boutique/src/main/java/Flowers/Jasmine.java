package Flowers;

public class Jasmine {
	private int jasmineCost=5;
	Calculate c=new Calculate();
	public int jasmine(int numberOfFlowers)
	{
		return c.calculateCost(jasmineCost,numberOfFlowers);
	}


}
