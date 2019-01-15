package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pakker.Mod;

public class Nymod implements EventHandler<ActionEvent> {

	private File fil=null;
	private ListView<Mod> mods;
	
	public Nymod(ListView<Mod> mods) {
		this.mods=mods;
	}
	public void warn(String text) {
		Alert skriv = new Alert(AlertType.WARNING);
		skriv.setHeaderText(text);
		skriv.showAndWait();
	}
	public File filen() {
		FileChooser filvelger = new FileChooser();
		fil = filvelger.showOpenDialog(null);
		if(fil==null) warn("No File choosen");
         if(fil!=null) {
         System.out.println(fil.getPath().toString());
         } 
        return fil;

	}
	public void handle(ActionEvent arg0) {
		Stage nymodstage=new Stage();
		GridPane root = new GridPane();
		Scene scene = new Scene(root); 
		
		TextField modsl = new TextField("Modslug");
		TextField ver = new TextField("x.x");
		Button ok = new Button("OK");
		Button filknapp = new Button("Choose File"); 
		
		root.add(modsl, 1, 1);
		root.add(ver, 1, 2);
		root.add(ok, 1, 3);
		root.add(filknapp, 2, 3);
		
		filknapp.setOnAction((event)-> filen());
		ok.setOnAction((event)-> {
			try {
				if (fil==null) {
					warn("Choose file first");
				}
				else {
				if(modsl.getText().toString().equals("")|| ver.getText().toString().equals("")) {
					warn("Some Fields are not filled out ");
				}
				else {
					
					mods.getItems().add(new Mod(modsl.getText().toString(),ver.getText(),fil));
				
					nymodstage.close();
				}
			}
				}
			catch(java.lang.NumberFormatException n) {
				warn("s");
			}
			
			catch (Exception e){
				System.out.println(e);
			}
			
		});
		nymodstage.setScene(scene);
		nymodstage.sizeToScene();
		nymodstage.setResizable(false);
		nymodstage.show();
	}
}
