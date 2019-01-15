package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import pakker.Modpack;

public class Pakkinn implements EventHandler<ActionEvent> {
	private ListView<Modpack> modpack;
	
	public Pakkinn(ListView<Modpack> modpack) {
		this.modpack=modpack;
	}
	
	
		public void pakkinn()throws IOException  {
			 File newFolder = new File(modpack.getSelectionModel().getSelectedItem().getnavn()+modpack.getSelectionModel().getSelectedItem().getver()+"\\mods\\");
		        newFolder.mkdirs();
		        
		        
		  
		        System.out.println("beggynner"+modpack.getSelectionModel().getSelectedItem().Getmods().size());
			for(int i=0; i<modpack.getSelectionModel().getSelectedItem().Getmods().size();i++){
			      File f = new File("./"+modpack.getSelectionModel().getSelectedItem().getnavn()+modpack.getSelectionModel().getSelectedItem().getver()+"/"+"/mods/"+(modpack.getSelectionModel().getSelectedItem().Getmods().get(i).getmodslug()+modpack.getSelectionModel().getSelectedItem().Getmods().get(i).getver()+".zip"));
			       if(f.exists()) {
			    	   f.delete();
			       }
				System.out.println("jobber 0");
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(modpack.getSelectionModel().getSelectedItem().Getmods().get(i).getmodslug()+modpack.getSelectionModel().getSelectedItem().Getmods().get(i).getver()+".zip"));
        System.out.println("jobber 1");
        FileInputStream fis = new FileInputStream(modpack.getSelectionModel().getSelectedItem().Getmods().get(i).getfile());
        zipOut.putNextEntry(new ZipEntry(modpack.getSelectionModel().getSelectedItem().Getmods().get(i).getfile().getName()));
        final byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();

        Files.move 
        (Paths.get(modpack.getSelectionModel().getSelectedItem().Getmods().get(i).getmodslug()+modpack.getSelectionModel().getSelectedItem().Getmods().get(i).getver()+".zip"),  
        Paths.get("./"+modpack.getSelectionModel().getSelectedItem().getnavn()+modpack.getSelectionModel().getSelectedItem().getver()+"/"+"/mods/"+(modpack.getSelectionModel().getSelectedItem().Getmods().get(i).getmodslug()+modpack.getSelectionModel().getSelectedItem().Getmods().get(i).getver()+".zip")));
	}
}


		@Override
		public void handle(ActionEvent arg0) {
			System.out.println("ok");
			try {
				pakkinn();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
