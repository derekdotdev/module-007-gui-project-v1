package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/* A JavaFX application for the Valencia Sandwich Shop. 
 * User can order sandwiches by using list boxes and the 
 * application displays the price. Each sandwich should allow 
 * a choice of at least three main ingredients (chicken, for example)
 * at three different prices. The user should also be able to choose 
 * between three different bread types. Use CheckBoxes for 
 * additional ingredients - lettuce, tomato, etc.

   Create an ArrayList to hold all of the sandwiches associated with an order.
   Display information about all the sandwiches that were ordered. 
 * */

public class Main extends Application {

	// Application Launch Area
	public static void main(String[] args) {
		Application.launch(args);
	}

	// Local UI Controls
	final Button button = new Button("Add To Order");
	final Label notification = new Label();
	final Label customerLabel = new Label("Customer Name ");
	final TextField customerNameTF = new TextField();
	// final TextField specialInstruction = new TextField();
	final Label order = new Label("Order:");

	// TextArea For Printing Order Info to GUI
	private static final TextArea textArea = new TextArea();

	// Method to send Order info to textArea
	public static void println(Sandwich s) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				textArea.setText(textArea.getText() + s);
				System.out.println(s); // echo to console
			}
		});
	}

	// Overloaded method to send totalPrice String to textArea
	public static void println(String s) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				textArea.setText(textArea.getText() + s);
				System.out.println(s); // echo to console
			}
		});
	}

	// Overloaded method to send totalPrice Double to textArea
	public static void print(Double d) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				textArea.setText(textArea.getText() + d + "0");
				System.out.print(d); // echo to console
			}
		});
	}

	// Object variables
	protected int counter = 0;
	protected String customerName;
	protected String sandwichBase;
	protected String sandwichBread;
	protected String specialInstructions;
	protected double sandwichPrice;
	protected double totalPrice = 0;

	// Placeholders for Sandwich constructor
	public boolean tomat;
	public boolean spinac;
	public boolean onio;
	public boolean sal;
	public boolean peppe;
	public boolean oldba;

	// Create Array of Sandwiches
	Sandwich[] orderList = new Sandwich[10];

	@Override
	public void start(Stage stage) throws Exception {

		// Set Stage Title
		stage.setTitle("Valencia Sandwich Shop");

		// Set Scene Title and add to grid
		Text sceneTitle = new Text("Welcome");

		// Set sceneTitle ID for CSS
		sceneTitle.setId("welcome-text");

		// Labels for Base and Bread options
		final Label baseOptions = new Label("Base Options: ");
		final Label breadOptions = new Label("Bread Options: ");

		// Combo Box (List Box) for sandwich base (protein)options
		final ComboBox<String> baseComboBox = new ComboBox<String>();
		baseComboBox.getItems().addAll("Choose One:", "Chicken - $6.00", "Tofu - $6.50", "Steak - $7.00");

		// Combo Box (List Box) for bread options
		final ComboBox<String> breadComboBox = new ComboBox<String>();
		breadComboBox.getItems().addAll("Choose One:", "White", "Wheat", "Italian Five Grain");

		// Set Default Values for List Boxes
		baseComboBox.setValue("Choose One:");
		breadComboBox.setValue("Choose One:");

		// Create Topping Option CheckBoxes
		CheckBox cb1 = new CheckBox("Tomato");
		CheckBox cb2 = new CheckBox("Spinach");
		CheckBox cb3 = new CheckBox("Onion");
		CheckBox cb4 = new CheckBox("Salt");
		CheckBox cb5 = new CheckBox("Pepper");
		CheckBox cb6 = new CheckBox("Old Bay");

		//Labels and Text Areas
		final Label name = new Label("Customer Name:");
		final Label orderLabel = new Label("Orders:");
		
		// Adding the toggle button to the pane
		VBox vBox = new VBox(10);

		vBox.setPadding(new Insets(5, 5, 5, 5));

		vBox.getChildren().addAll(sceneTitle, baseOptions, baseComboBox, breadOptions, breadComboBox, cb1, cb2, cb3,
				cb4, cb5, cb6, name, customerNameTF, button, notification, orderLabel, textArea);

		Group root = new Group();
		root.getChildren().addAll(vBox);

		Scene scene = new Scene(root, 600, 700);

		// Add Labels, TextFields and Order Printout TextArea

		// "Add To Order" Button Action
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				// Ensure each sandwich has both bread AND base (protein) selected
				if (baseComboBox.getValue() != "Choose One:" && breadComboBox.getValue() != "Choose One:") {

					// Determine sandwich price & set sandwichBase appropriately
					if (baseComboBox.getValue().toString() == "Chicken - $6.00") {
						sandwichPrice = SandwichConstants.chickenPrice;
						sandwichBase = "Chicken";
					} else if (baseComboBox.getValue().toString() == "Tofu - $6.50") {
						sandwichPrice = SandwichConstants.tofuPrice;
						sandwichBase = "Tofu";
					} else if (baseComboBox.getValue().toString() == "Steak - $7.00") {
						sandwichPrice = SandwichConstants.steakPrice;
						sandwichBase = "Steak";
					} else {
						System.out.println("Error!");
					}

					// Gather variables for Order Constructor
					sandwichBread = breadComboBox.getValue().toString();
					customerName = customerNameTF.getCharacters().toString();


					// Set topping placeholders according to CheckBox selections
					tomat = cb1.isSelected();
					spinac = cb2.isSelected();
					onio = cb3.isSelected();
					sal = cb4.isSelected();
					peppe = cb5.isSelected();
					oldba = cb6.isSelected();

					// Create an order and add to Array
					orderList[counter] = new Order(customerName, sandwichBread, sandwichBase, tomat, spinac, onio, sal,
							peppe,
							oldba, sandwichPrice);

					// Order Success GUI notification
					notification.setText("Order successfully created!");

					// Increment counter
					counter++;

					// Reset choice options for next entry
					baseComboBox.setValue("Choose One:");
					breadComboBox.setValue("Choose One:");
					customerNameTF.clear();

					// Extracted Method below
					clearCheckBoxes(cb1, cb2, cb3, cb4, cb5, cb6);


				} else {
					// If both bread and base (protein) are not chosen, notify.
					notification.setText("Please choose base and\nbread for your sandwich!");
				}
				
				// Clear totalPrice
				totalPrice = 0;

				// Print Order Info to textArea
				for (int i = 0; i < counter; i++) {
					// Avoid repeat information (1, 1/2, 1/2/3, etc.)
					textArea.clear();
					// Print order list up to current index position
					Main.println(orderList[i]);
					// Sum prices of all sandwiches thus far
					totalPrice += orderList[i].getSandwichPrice();
					// Print it out!
					Main.println("Total: $");
					Main.print(totalPrice);
					Main.println("\n");
					Main.println("\n");
				}
			}

			private void clearCheckBoxes(CheckBox cb1, CheckBox cb2, CheckBox cb3, CheckBox cb4, CheckBox cb5,
					CheckBox cb6) {
				cb1.setSelected(false);
				cb2.setSelected(false);
				cb3.setSelected(false);
				cb4.setSelected(false);
				cb5.setSelected(false);
				cb6.setSelected(false);
			}
		});

		// Set root, scene, stage
		stage.setScene(scene);

		// Load CSS
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());

		// Show stage
		stage.show();

	}

}