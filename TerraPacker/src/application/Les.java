

	package application;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.util.ArrayList;

	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.scene.control.ListView;
	import javafx.stage.FileChooser;
import pakker.Mod;
import pakker.Modpack;

	public class Les implements EventHandler<ActionEvent> {

		private ListView<Modpack> modpack; 	
		private ListView<Mod> mods;
	private FileChooser filvelger = new FileChooser();
	private ArrayList<Modpack> packmid = new ArrayList();

	public Les(ListView<Modpack> modpack, ListView<Mod> mods){
		this.mods=mods;
		this.modpack=modpack;
	}


	public void handle(ActionEvent arg) {
		
		File filreferanse= filvelger.showOpenDialog(null);
		if (filreferanse == null) return;
		try(FileInputStream innstrom= new FileInputStream(filreferanse)){
			ObjectInputStream objektstrom = new ObjectInputStream(innstrom);
			
			try {
				ArrayList<Mod> modsmid = (ArrayList<Mod>)objektstrom.readObject();
				if(modsmid!=null&&modsmid.size()>0) {
				for(Mod  mod: modsmid) {
				if (mod instanceof Mod) {
					mods.getItems().add(mod);
				}
				}
				
				
				}
					
			ArrayList<Modpack> modpack1 =(ArrayList<Modpack>)objektstrom.readObject();
			if(modpack1!=null&&modpack1.size()>0) {
				for(Modpack  pack: modpack1) {
					if (pack instanceof Modpack) {
						modpack.getItems().add(pack);
					}
			
			}
			}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}



	

}
