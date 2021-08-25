package application;

public class Order extends Sandwich {

	public Order(String customerName, String sandwichBread, String sandwichBase, boolean tomato, boolean spinach,
			boolean onion, boolean salt,
			boolean pepper, boolean oldbay, double sandwichPrice) {
		super(customerName, sandwichBread, sandwichBase, tomato, spinach, onion, salt, pepper, oldbay, sandwichPrice);
		}
}
