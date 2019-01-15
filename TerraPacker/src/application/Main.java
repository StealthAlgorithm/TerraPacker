package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import pakker.Mod;
import pakker.Modpack;
import pakker.SQL;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.scene.layout.GridPane;


public class Main extends Application {
	private ListView<Modpack> modpack = new ListView();
	private ListView<Mod> mods = new ListView();
	private String modnavn = new String();

	
	public void modnavner() {
		String navn="Mods:";
		if(modpack.getSelectionModel().getSelectedItem().Getmods().size()>0) {
			
			for(Mod mod: modpack.getSelectionModel().getSelectedItem().Getmods()) {
				 navn+="\n"+mod.getmodslug()+" "+mod.getver();
			}
			modnavn= navn;
		}
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			ArrayList<Mod>modstring = new ArrayList<>(); 
			SQL.getmods();
			modstring=SQL.getmodver();
			
			for(Mod mod: modstring) {
				mods.getItems().add(mod);
			}
			ArrayList<String>modpacktring = new ArrayList<>(); 
			modpacktring=SQL.getmodpack();
			for(String streng: modpacktring) {
				modpack.getItems().add(new Modpack(streng, 0));
			}
			
			GridPane root = new GridPane();
			Label mos= new Label();
			Button nymodbut = new Button("New Mod");
			Button nymodpack = new Button("New Modpack");
			Button leggtil= new Button("Add mods");
			Button pakkinn = new Button("Pakk inn");
			Button Backup = new Button("Backup");
			Button lesb = new Button("Read Backup");
			Button delete = new Button("Delete");
			root.add(modpack, 0, 0,7,3);
			
			root.add(nymodbut, 0, 4);
			root.add(nymodpack, 1, 4);
			root.add(leggtil, 2, 4);
			root.add(pakkinn, 3, 4);
			root.add(Backup, 4, 4);
			root.add(lesb, 5, 4);
			root.add(delete, 6, 4);
			root.add(mos, 7, 0);
			modpack.setOnMouseClicked(e->{
				modnavner();
				mos.setText(modnavn);});
			leggtil.setOnAction(new Leggtilmods(modpack,mods));
			nymodpack.setOnAction(new Nymodpack(modpack));
			nymodbut.setOnAction(new Nymod(mods));
			pakkinn.setOnAction(new Pakkinn(modpack));
			Backup.setOnAction(new Lagre(modpack,mods));
			lesb.setOnAction(new Les(modpack,mods));
			delete.setOnAction(new Deletepack(modpack));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
