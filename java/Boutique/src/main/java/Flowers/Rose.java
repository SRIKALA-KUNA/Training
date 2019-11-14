package Flowers;

public class Rose {
	private int roseCost=10;
	Calculate c=new Calculate();
	public int rose(int numberOfFlowers)
	{
		return c.calculateCost(roseCost,numberOfFlowers);
	}

}
