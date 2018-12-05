package fr.uga.projet1.poo.abstraction;

public class Chaise implements Pliable {

	private String modele;
	
	
	public void deplier() {
		System.out.println("deplier...");
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

}
