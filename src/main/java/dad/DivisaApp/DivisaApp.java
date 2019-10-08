package dad.DivisaApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
		selectorDivisa1.getSelectionModel().selectFirst();
		
		selectorDivisa2 = new ComboBox<String>();
		selectorDivisa2.getItems().addAll("Euro","Dolar","Yen","Libra");
		selectorDivisa2.setValue("Dolar");
		
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

	private void onLoginButtonAction(ActionEvent e) {
		
		Divisa euro = new Divisa("Euro", 1.0);
		Divisa libra = new Divisa("Libra", 0.8873);
		Divisa dolar = new Divisa("Dolar", 1.2007);
		Divisa yen = new Divisa("Yen", 133.59);
		String divisaOrigen = selectorDivisa1.getValue();
		String divisaDestino = selectorDivisa2.getValue();
		String cantidad = cantidadDinero1.getText();
		String dineroConvertido;
		
		if(divisaOrigen == "Euro") {
			switch(divisaDestino) {
			case "Euro":  dineroConvertido = String.valueOf(euro.fromEuro(euro.toEuro(Double.parseDouble(cantidad))));
						  cantidadDinero2.setText(dineroConvertido); 
						  break;
			case "Dolar": dineroConvertido = String.valueOf(dolar.fromEuro(euro.toEuro(Double.parseDouble(cantidad))));
			 			  cantidadDinero2.setText(dineroConvertido); 
			 			  break;
			case "Libra": dineroConvertido = String.valueOf(libra.fromEuro(euro.toEuro(Double.parseDouble(cantidad))));
						  cantidadDinero2.setText(dineroConvertido);
						  break;
			case "Yen":   dineroConvertido = String.valueOf(yen.fromEuro(euro.toEuro(Double.parseDouble(cantidad))));
			 			  cantidadDinero2.setText(dineroConvertido);
			 			  break;
			}
		}else if(divisaOrigen == "Dolar") {
			switch(divisaDestino) {
			case "Euro":  dineroConvertido = String.valueOf(euro.fromEuro(dolar.toEuro(Double.parseDouble(cantidad))));
						  cantidadDinero2.setText(dineroConvertido); 
						  break;
			case "Dolar": dineroConvertido = String.valueOf(dolar.fromEuro(dolar.toEuro(Double.parseDouble(cantidad))));
			 			  cantidadDinero2.setText(dineroConvertido); 
			 			  break;
			case "Libra": dineroConvertido = String.valueOf(libra.fromEuro(dolar.toEuro(Double.parseDouble(cantidad))));
						  cantidadDinero2.setText(dineroConvertido);
						  break;
			case "Yen":   dineroConvertido = String.valueOf(yen.fromEuro(dolar.toEuro(Double.parseDouble(cantidad))));
			 			  cantidadDinero2.setText(dineroConvertido);
			 			  break;
			}
			
		}else if(divisaOrigen == "Libra") {
			switch(divisaDestino) {
			case "Euro":  dineroConvertido = String.valueOf(euro.fromEuro(libra.toEuro(Double.parseDouble(cantidad))));
						  cantidadDinero2.setText(dineroConvertido); 
						  break;
			case "Dolar": dineroConvertido = String.valueOf(dolar.fromEuro(libra.toEuro(Double.parseDouble(cantidad))));
			 			  cantidadDinero2.setText(dineroConvertido); 
			 			  break;
			case "Libra": dineroConvertido = String.valueOf(libra.fromEuro(libra.toEuro(Double.parseDouble(cantidad))));
						  cantidadDinero2.setText(dineroConvertido);
						  break;
			case "Yen":   dineroConvertido = String.valueOf(yen.fromEuro(libra.toEuro(Double.parseDouble(cantidad))));
			 			  cantidadDinero2.setText(dineroConvertido);
			 			  break;
			}
			
		}else {
			switch(divisaDestino) {
			case "Euro":  dineroConvertido = String.valueOf(euro.fromEuro(yen.toEuro(Double.parseDouble(cantidad))));
						  cantidadDinero2.setText(dineroConvertido); 
						  break;
			case "Dolar": dineroConvertido = String.valueOf(dolar.fromEuro(yen.toEuro(Double.parseDouble(cantidad))));
			 			  cantidadDinero2.setText(dineroConvertido); 
			 			  break;
			case "Libra": dineroConvertido = String.valueOf(libra.fromEuro(yen.toEuro(Double.parseDouble(cantidad))));
						  cantidadDinero2.setText(dineroConvertido);
						  break;
			case "Yen":   dineroConvertido = String.valueOf(yen.fromEuro(yen.toEuro(Double.parseDouble(cantidad))));
			 			  cantidadDinero2.setText(dineroConvertido);
			 			  break;
			}
		}
		
		
	}

}
