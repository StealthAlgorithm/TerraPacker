package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pakker.Modpack;

public class Deletepack implements EventHandler<ActionEvent> {

	private ListView<Modpack> modpack;
	public Deletepack(ListView<Modpack> modpack) {
		this.modpack=modpack;
	}
	@Override
	public void handle(ActionEvent arg0) {
		Stage varsel = new Stage(); 
		GridPane root = new GridPane();
		Scene scene = new Scene(root);
		Label tekst =new Label("Are you sure you want to delete selected modpack?");
		Button cancel = new Button("Cancel");
		Button ok = new Button("ok");
		root.add(tekst, 1, 1);
		root.add(ok, 1, 2);
		root.add(cancel, 2, 2);
		ok.setOnAction((event)->{
			modpack.getItems().remove(modpack.getSelectionModel().getSelectedIndex());
			varsel.close();
		});
		
		cancel.setOnAction((event)->{varsel.close();});
		varsel.show();
		varsel.setScene(scene);
		varsel.sizeToScene();
		varsel.setAlwaysOnTop(true);
	}

}
