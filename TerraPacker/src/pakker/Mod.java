package pakker;

import java.io.File;
import java.io.Serializable;

public class Mod implements Serializable {
	public static final long serialVersionUID=1;
	private String modslug,version;

	private File fil;
 public Mod(String modslug,String version, File fil) {
		this.modslug=modslug;
		this.version=version;
		this.fil=fil;
	}
 public String filbane() {
	 if (fil!=null) {
		return " Filename "+fil.getName().toString()+" location " + fil.getPath().toString();
	}
 	else {
	 return "File not chosen";
 }	
 }
 
 public File getfile(){
	 return fil;
 }
 public String getmodslug(){
	 return modslug;
 }
 public String getver(){
	 return version;
 }
 public void setversion(String ver) {
	 this.version=ver;
 }
 	public String toString() {
 		return modslug + " "+ version ;
 	}
}
