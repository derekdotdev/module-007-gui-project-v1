package application;

public interface SandwichConstants {

	// Sandwich Order Constants
	public String sandwichBread = null;
	public String sandwichBase = null;

	public double chickenPrice = 6.00;
	public double tofuPrice = 6.50;
	public double steakPrice = 7.00;

	public boolean chicken = false;
	public boolean tofu = false;
	public boolean steak = false;

	public boolean tomato = false;
	public boolean spinach = false;
	public boolean onion = false;
	public boolean salt = false;
	public boolean pepper = false;
	public boolean oldbay = false;


	// Method to determine cost of sandwich
	/*
	 * public static double sandwichPrice(int sandwichBase) { double value = 0.00;
	 * 
	 * if (sandwichBase == 1) { value = chickenPrice; } else if (sandwichBase == 2)
	 * { value = tofuPrice; } else if (sandwichBase == 3) { value = steakPrice; }
	 * else { value = 0.00; } return value; }
	 */


}
