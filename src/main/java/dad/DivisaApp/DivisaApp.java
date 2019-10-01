package dad.DivisaApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DivisaApp extends Application {
	
	private TextField cantidadDinero1;
	private TextField cantidadDinero2;
	private ComboBox<String> selectorDivisa1;
	private ComboBox<String> selectorDivisa2;
	private Button changeButton;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		cantidadDinero1 = new TextField();
		cantidadDinero1.setPromptText("Cantidad a cambiar");
		cantidadDinero1.setMaxWidth(80);
		
		cantidadDinero2 = new TextField();
		cantidadDinero2.setPromptText("Tu cambio caballero");
		cantidadDinero2.setMaxWidth(80);
		cantidadDinero2.setEditable(false);
		
		selectorDivisa1 = new ComboBox<String>();
		selectorDivisa1.getItems().addAll("Euro","Dolar","Yen","Libra");
		selectorDivisa1.setPromptText("Euro");
		
		selectorDivisa2 = new ComboBox<String>();
		selectorDivisa2.getItems().addAll("Euro","Dolar","Yen","Libra");
		selectorDivisa2.setPromptText("Dolares");
		
		changeButton = new Button("Change");
		changeButton.setDefaultButton(true);
		changeButton.setOnAction(e-> onLoginButtonAction(e));

		
		HBox divisa1Box= new HBox(5,cantidadDinero1,selectorDivisa1);
		divisa1Box.setAlignment(Pos.CENTER);
		
		HBox divisa2Box= new HBox(5,cantidadDinero2,selectorDivisa2);
		divisa2Box.setAlignment(Pos.CENTER);
		
		HBox botonButton = new HBox(5,changeButton);
		botonButton.setAlignment(Pos.CENTER);
		
		
		VBox root = new VBox(5,divisa1Box,divisa2Box,botonButton);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root,320,200);
		
		primaryStage.setTitle("CambiarDivisa");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main (String [] args) {
		launch(args);
	}

	private Object onLoginButtonAction(ActionEvent e) {
		// TODO Auto-generated method stub
		return null;
	}

}
