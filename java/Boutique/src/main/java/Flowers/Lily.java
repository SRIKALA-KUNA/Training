package Flowers;

public class Lily {
	private int lilyCost=3;
	Calculate c=new Calculate();
	public int lily(int numberOfFlowers)
	{
		return c.calculateCost(lilyCost,numberOfFlowers);
	}

}
