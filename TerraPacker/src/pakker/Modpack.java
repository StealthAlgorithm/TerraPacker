package pakker;

import java.io.Serializable;
import java.util.ArrayList;

public class Modpack implements Serializable {
	public static final long serialVersionUID=1;
	private String navn;
	private double verision;
	private ArrayList<Mod> mods = new ArrayList(); 
	
	public Modpack(String navn, double version) {
		this.navn=navn;
		this.verision=version;
		
	}
	public void Setmods(ArrayList<Mod> mods) {
		this.mods=mods;
	}
	public ArrayList<Mod> Getmods() {
		return mods;
	}
	public void addmod(Mod mod) {
		mods.add(mod);
	}
	public String getnavn(){
		return navn;
	}
	 public String getver(){
		 return Double.toString(verision);
	 }
	public String toString() {
		return "Name: "+ navn;
	}
	
}
