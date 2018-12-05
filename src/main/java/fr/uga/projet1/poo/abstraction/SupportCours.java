package fr.uga.projet1.poo.abstraction;

public abstract class SupportCours {

	private String titre;
	private String auteur;
	
	
	public SupportCours() {
		super();
	}
	public SupportCours(String titre, String auteur) {
		super();
		this.titre = titre;
		this.auteur = auteur;
	}
	
	
	public abstract void imprimer();
	
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
}
