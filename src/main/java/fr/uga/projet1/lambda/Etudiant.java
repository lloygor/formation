package fr.uga.projet1.lambda;

public class Etudiant {

	private String nom;
	private String prenom;
	private double moyenne;

	public Etudiant(String nom, String prenom, double moyenne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.moyenne = moyenne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	public String toString() {
		return nom + " - " + prenom + " - " + moyenne;
	}

	public String getMention() {
		double moyenne = getMoyenne();
		if (moyenne < 10)
			return "recale";
		else if (moyenne >= 10 && moyenne < 12)
			return "Passable";
		else
			return "Bien";

	}
}
