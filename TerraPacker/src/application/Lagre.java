
	package application;

	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectOutputStream;
	import java.util.ArrayList;

	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Alert.AlertType;
	import javafx.scene.control.ListView;
	import javafx.stage.FileChooser;
import pakker.Mod;
import pakker.Modpack;


	public class Lagre implements EventHandler<ActionEvent> {

	private ListView<Modpack> modpack; 	
	private ListView<Mod> mods;
	private ArrayList<Mod> modsmid = new ArrayList();
	private ArrayList<Modpack> packmid = new ArrayList();
	private FileChooser filvelger = new FileChooser();
	

		public Lagre(ListView<Modpack> modpack,ListView<Mod> mods) {
			this.mods=mods;
			this.modpack=modpack;
		}
		
		public void warn(String text) {
			Alert feil = new Alert (AlertType.ERROR);
			feil.setContentText(text);
			feil.show();
		}
		
		
		
		@Override
		public void handle(ActionEvent arg) {
		
			if(mods.getItems()!=null) {
				if(mods.getItems().size()>1)
			for(int i=0; i< mods.getItems().size(); i++) {
				modsmid.add(mods.getItems().get(i));
				
			}
				
			}
			if(modpack.getItems()!=null) {
				if(modpack.getItems().size()>1)
			for(int i=0; i< modpack.getItems().size(); i++) {
				packmid.add(modpack.getItems().get(i));
				packmid.get(i).Setmods(modpack.getItems().get(i).Getmods());;
			}
			}
			File filreferanse = filvelger.showSaveDialog(null); 
			if (filreferanse == null) return;
			try(FileOutputStream utstrom= new FileOutputStream(filreferanse)){
				ObjectOutputStream objectskriver = new ObjectOutputStream(utstrom);
				if(modsmid!=null && modsmid.size()>0)objectskriver.writeObject(modsmid);
				if(packmid!=null && packmid.size()>0) objectskriver.writeObject(packmid);
			}catch(FileNotFoundException e) {
				warn("klarer ikke å skape fila"+ filreferanse.getName());
			}catch(IOException e ) {
				warn("Feil Under lagring"+ e.getMessage());
				System.out.println(e.getCause().getStackTrace());
			}
					
		
		
		
		
		}
		
		
	

}
