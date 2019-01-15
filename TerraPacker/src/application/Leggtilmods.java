package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import pakker.Mod;
import pakker.Modpack;
import java.util.ArrayList;

public class Leggtilmods implements EventHandler<ActionEvent> {

	private ListView<Modpack> modpack;
	private ListView<Mod> mods;
	private ListView<Mod> imodpack = new ListView();
	public Leggtilmods(ListView<Modpack>modpack,ListView<Mod> mods) {
		this.modpack=modpack;
		this.mods=mods;
	}
	
	public void warn(String text) {
		Alert skriv = new Alert(AlertType.WARNING);
		skriv.setHeaderText(text);
		skriv.showAndWait();
	}
	
	public void handle(ActionEvent arg0) {
		Stage laggtil = new Stage();
		imodpack.getItems().clear();
		if(modpack.getItems().size()==0) {
			warn("Vennligst lag en modpack");
		}
		else {
			if(modpack.getSelectionModel().isEmpty()) {
				warn("Vennligst velg en modpack");
			}
			else {
	
		GridPane root = new GridPane();
		Scene scene = new Scene(root);
		
		Button leggtil = new Button("<--");
		Button trekkfra = new Button("REMOVE FROM PACK");
		Button delete = new Button ("Delete mod");
		root.add(imodpack,0,0,7,3);
		root.add(mods, 10, 0,17,3);
		imodpack.setPrefWidth(500);
		mods.setPrefWidth(500);
		root.add(leggtil, 8, 0);
		root.add(trekkfra, 9, 1);
		root.add(delete, 9, 3);
		if(modpack.getSelectionModel().getSelectedItem().Getmods().size()>0) {
			for(Mod mod: modpack.getSelectionModel().getSelectedItem().Getmods()) {
				imodpack.getItems().add(mod);
			}
		}	
		leggtil.setOnAction((event)->{
				if(mods.getItems().size()==0) {
					warn("There is no mod in the list");
					
				}
				else {
					if(mods.getSelectionModel().isEmpty()) {
						warn("No mods selected");
					}
					else {

						imodpack.getItems().add(mods.getSelectionModel().getSelectedItem());
						for (Mod mod: imodpack.getItems()) {
							modpack.getSelectionModel().getSelectedItem().addmod(mod);
						}
						
						}
					}
				
			});
		trekkfra.setOnAction((event)->{
			modpack.getSelectionModel().getSelectedItem().Getmods().remove(imodpack.getSelectionModel().getSelectedIndex());
			imodpack.getItems().remove(imodpack.getSelectionModel().getSelectedIndex());
		});
		delete.setOnAction(new Deletemod(mods));
		laggtil.setScene(scene);
		laggtil.sizeToScene();
		laggtil.setResizable(false);
		laggtil.show();
			}
	}
}}

