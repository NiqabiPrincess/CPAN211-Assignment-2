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
		
		
		Label nameLabel = new Label("Customer Name: ");
		TextField nameField = new TextField();
		
		
		Label phoneNumberLabel = new Label("Customer Phone Number: ");
		TextField phoneNumberField = new TextField();
		
		
		Label cakeType = new Label("Cake Type Selected: ");
		ComboBox<String> cakeTypeComboBox = new ComboBox<>();
		cakeTypeComboBox.getItems().addAll("Apple", "Carrot", "Cheesecake", "Chocolate", "Coffee", "Opera", "Tiramisu");
		
		
		Label sizeLabel = new Label("Cake Size: ");
		ToggleGroup sizeGroup = new ToggleGroup();
		
		RadioButton smallRadioButton = new RadioButton("Small");
		smallRadioButton.setToggleGroup(sizeGroup);
		
		RadioButton mediumRadioButton = new RadioButton("Medium");
		mediumRadioButton.setToggleGroup(sizeGroup);
		
		RadioButton largeRadioButton = new RadioButton("Large");
		largeRadioButton.setToggleGroup(sizeGroup);
		
		HBox sizeBox = new HBox(10, smallRadioButton, mediumRadioButton, largeRadioButton);
		
		
		Button saveButton = new Button("Save");
		Button quitButton = new Button("Quit");
		HBox buttonBox = new HBox(10, saveButton, quitButton);
	
		
		
	}
	
	

}
