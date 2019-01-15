package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pakker.Modpack;

public class Nymodpack implements EventHandler<ActionEvent> {
	private ListView<Modpack> modpack ;
	
	public void warn(String text) {
		Alert skriv = new Alert(AlertType.WARNING);
		skriv.setHeaderText(text);
		skriv.showAndWait();
	}
	public Nymodpack(ListView<Modpack> modpack) {
		this.modpack=modpack;
	}
	
	public void handle(ActionEvent arg0) {
	 Stage nypack = new Stage();
	 GridPane root = new GridPane();
	 Scene scene = new Scene(root);
	  
	 TextField packnavn = new TextField("name");
	 TextField Packver= new TextField("ver");
	 Button ok = new Button("Ok");
	 
	 root.add(packnavn, 1, 1);
	 root.add(Packver, 1, 2);
	 root.add(ok, 1, 3);
	 
	 
	 	ok.setOnAction((event)->{
	 		try {
	 		modpack.getItems().add(new Modpack(packnavn.getText().toString(),Double.parseDouble(Packver.getText())));
	 		nypack.close();
	 		}catch( NumberFormatException e) {
	 			warn("not a number");
	 		}
	 	});
	 	nypack.setScene(scene);
	 	nypack.sizeToScene();
		nypack.setResizable(false);
		nypack.show();
	}
	
}
