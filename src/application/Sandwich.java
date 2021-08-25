package application;

public abstract class Sandwich implements SandwichConstants {

	private String customerName;
	private String sandwichBread;
	private String sandwichBase;
	private double sandwichPrice;
	protected boolean tomato;
	protected boolean spinach;
	protected boolean onion;
	protected boolean salt;
	protected boolean pepper;
	protected boolean oldbay;

	// Full Constructor
	public Sandwich(String customerName, String sandwichBread, String sandwichBase, boolean tomato, boolean spinach,
			boolean onion,
			boolean salt, boolean pepper, boolean oldbay, double sandwichPrice) {
		super();
		this.customerName = customerName;
		this.sandwichBread = sandwichBread;
		this.sandwichBase = sandwichBase;
		this.sandwichPrice = sandwichPrice;
		this.tomato = tomato;
		this.spinach = spinach;
		this.onion = onion;
		this.salt = salt;
		this.pepper = pepper;
		this.oldbay = oldbay;
	}

	// Getters, Setters, toString()
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSandwichBread() {
		return sandwichBread;
	}

	public void setSandwichBread(String sandwichBread) {
		this.sandwichBread = sandwichBread;
	}

	public String getSandwichBase() {
		return sandwichBase;
	}

	public void setSandwichBase(String sandwichBase) {
		this.sandwichBase = sandwichBase;
	}

	public double getSandwichPrice() {
		return sandwichPrice;
	}

	public void setSandwichPrice(double sandwichPrice) {
		this.sandwichPrice = sandwichPrice;
	}
	
	public boolean isTomato() {
		return tomato;
	}

	public void setTomato(boolean tomato) {
		this.tomato = tomato;
	}

	public boolean isSpinach() {
		return spinach;
	}

	public void setSpinach(boolean spinach) {
		this.spinach = spinach;
	}

	public boolean isOnion() {
		return onion;
	}

	public void setOnion(boolean onion) {
		this.onion = onion;
	}

	public boolean isSalt() {
		return salt;
	}

	public void setSalt(boolean salt) {
		this.salt = salt;
	}

	public boolean isPepper() {
		return pepper;
	}

	public void setPepper(boolean pepper) {
		this.pepper = pepper;
	}

	public boolean isOldbay() {
		return oldbay;
	}

	public void setOldbay(boolean oldbay) {
		this.oldbay = oldbay;
	}

	@Override
	public String toString() {
		return "Name: " + customerName + "\nBread: " + sandwichBread + "\nProtein: " + sandwichBase
				+ "\nToppings: " + "\nTomato: " + tomato + "\nSpinach: " + spinach + "\nOnion: " + onion + "\nSalt: "
				+ salt + "\nPepper: " + pepper + "\nOldBay: " + oldbay + "\n\nSubtotal: $" + sandwichPrice + "0 "
				+ "\n";
	}

}