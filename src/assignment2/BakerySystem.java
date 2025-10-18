package assignment2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BakerySystem extends Application{

	@Override
	public void start(Stage primaryStage){
		primaryStage.setTitle("Bakery System");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);

		//Name
		Label nameLabel = new Label("Customer Name: ");
		TextField nameField = new TextField();

		//Phone Number
		Label phoneNumberLabel = new Label("Customer Phone Number: ");
		TextField phoneNumberField = new TextField();

		//Cake Type
		Label cakeTypeLabel = new Label("Cake Type Selected: ");
		ComboBox<String> cakeTypeComboBox = new ComboBox<>();
		cakeTypeComboBox.getItems().addAll("Apple", "Carrot", "Cheesecake", "Chocolate", "Coffee", "Opera", "Tiramisu");

		//Cake Size
		Label sizeLabel = new Label("Cake Size: ");
		ToggleGroup sizeGroup = new ToggleGroup();

		RadioButton smallRadioButton = new RadioButton("Small");
		RadioButton mediumRadioButton = new RadioButton("Medium");
		RadioButton largeRadioButton = new RadioButton("Large");

		smallRadioButton.setToggleGroup(sizeGroup);
		mediumRadioButton.setToggleGroup(sizeGroup);
		largeRadioButton.setToggleGroup(sizeGroup);

		HBox sizeBox = new HBox(10, smallRadioButton, mediumRadioButton, largeRadioButton);

		//Free delivery 
		Label freeDeliveryLabel = new Label("Eligible for Free Delivery: ");
		CheckBox freeDeliveryCheckBox = new CheckBox();

		//Save and Quit Buttons
		Button saveButton = new Button("Save");
		Button quitButton = new Button("Quit");
		HBox buttonBox = new HBox(10, saveButton, quitButton);

		// Event handling 
		saveButton.setOnAction(new SaveButtonClick(nameField, phoneNumberField, cakeTypeComboBox, sizeGroup, freeDeliveryCheckBox));
		quitButton.setOnAction(new QuitButtonClick());

		//adding elements to the grid
		grid.add(nameLabel, 0, 0);
		grid.add(nameField, 1, 0);

		grid.add(phoneNumberLabel, 0, 1);
		grid.add(phoneNumberField, 1, 1);

		grid.add(cakeTypeLabel, 0, 2);
		grid.add(cakeTypeComboBox, 1, 2);

		grid.add(sizeLabel, 0, 3);
		grid.add(sizeBox, 1, 3);

		grid.add(freeDeliveryLabel, 0, 4);	
		grid.add(freeDeliveryCheckBox, 1, 4);

		grid.add(buttonBox, 1, 5);

		//Scene and stage setup
		Scene scene = new Scene(grid, 450, 350);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

// Handlers
class SaveButtonClick implements EventHandler<ActionEvent> {
	private final TextField nameField;
	private final TextField phoneField;
	private final ComboBox<String> cakeBox;
	private final ToggleGroup sizeGroup;
	private final CheckBox freeCheck;

	public SaveButtonClick(TextField nameField, TextField phoneField,
	                       ComboBox<String> cakeBox, ToggleGroup sizeGroup,
	                       CheckBox freeCheck) {
		this.nameField = nameField;
		this.phoneField = phoneField;
		this.cakeBox = cakeBox;
		this.sizeGroup = sizeGroup;
		this.freeCheck = freeCheck;
	}

	@Override
	public void handle(ActionEvent event) {
		String name = nameField.getText();
		String phone = phoneField.getText();
		String cake = cakeBox.getValue();

		RadioButton selectedSize = (RadioButton) sizeGroup.getSelectedToggle();
		String size = (selectedSize != null) ? selectedSize.getText() : "";
		boolean free = freeCheck.isSelected();

		OrderFileHandler.saveOrder(name, phone, cake, size, free);

		nameField.clear();
		phoneField.clear();
		cakeBox.getSelectionModel().selectFirst();
		sizeGroup.selectToggle(null);
		freeCheck.setSelected(false);
	}
}

class QuitButtonClick implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
		System.exit(0);
	}
}
