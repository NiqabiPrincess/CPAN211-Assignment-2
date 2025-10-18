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
		
		//Save and Quit Buttons
		Button saveButton = new Button("Save");
		Button quitButton = new Button("Quit");
		HBox buttonBox = new HBox(10, saveButton, quitButton);

        // Save Event Handling
          saveButton.setOnAction(e -> {
            String name = nameField.getText();
            String phone = phoneNumberField.getText();
            String cake = cakeTypeComboBox.getValue();

            RadioButton selectedSize = (RadioButton) sizeGroup.getSelectedToggle();
            String size = (selectedSize != null) ? selectedSize.getText() : "";

			// Write to Orders
            OrderFileHandler.saveOrder(name, phone, cake, size, false);

            nameField.clear();
            phoneNumberField.clear();
            cakeTypeComboBox.getSelectionModel().selectFirst();
            sizeGroup.selectToggle(null);
        });
		// Quit Event Handling
        quitButton.setOnAction(e -> System.exit(0));

		
		
		//adding elements to the grid
		grid.add(nameLabel, 0, 0);
		grid.add(nameField, 1, 0);
		
		grid.add(phoneNumberLabel, 0, 1);
		grid.add(phoneNumberField, 1, 1);
		
		grid.add(cakeTypeLabel, 0, 2);
		grid.add(cakeTypeComboBox, 1, 2);
		
		grid.add(sizeLabel, 0, 3);
		grid.add(sizeBox, 1, 3);
		
		grid.add(buttonBox, 1, 4);
		
		
		//Scene and stage setup
		Scene scene = new Scene(grid, 450, 350);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		primaryStage.setScene(scene);

		
		
	}
	
	

}
