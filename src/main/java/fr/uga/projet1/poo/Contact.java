package fr.uga.projet1.poo;

import java.io.Serializable;

/**
 * Repr&eacute;sentation d'un &eacute;tudiant
 * @author Mohamed
 *
 */
@SuppressWarnings("serial")
public class Contact implements Serializable, Cloneable {
	//Attributs __________________
	private int id;
	private String nom;
	

	/**
	 * code sur 14 chiffres
	 */
	private int codeEtudiant;
	private static int nbContacts;
	
	//bloc static pour initialiser le variables statiques
	static {
		nbContacts = 0;
		//on peut ajouter autant de lignes que l'on souhaite
	}
	
	//Constructeurs ________________
	public Contact() {
		nbContacts++;
	}
	
	/**
	 * Constructeur de classe
	 * @param id		identifiant en Bdd
	 * @param nom		fullname
	 * @throws Exception	si nom null ou &lt; 2 carac
	 */
	public Contact(int id, String nom) throws Exception {
		this();//appel au constructeur Contact()
		this.id = id;
		setNom(nom);
	}

	public Contact(int id, String nom, int codeEtudiant) throws Exception {
		this(id, nom); //appel au constructeur Contact(int,String)
		this.codeEtudiant = codeEtudiant;
	}
	
	//Méthodes _______________________
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) throws Exception {
		if(nom==null || nom.length()<2)
			throw new Exception("Erreur : nom obligatoire (2 carac min)");
		
		this.nom = nom;
	}
	public int getCodeEtudiant() {
		return codeEtudiant;
	}
	public void setCodeEtudiant(int codeEtudiant) {
		this.codeEtudiant = codeEtudiant;
	}
	public static int getNbContacts() {
		return nbContacts;
	}
	public static void setNbContacts(int nbContacts) {
		Contact.nbContacts = nbContacts;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) //if(!(obj instanceof Contact)
			return false;
		Contact other = (Contact) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Contact contactClone = new Contact();
		contactClone.setId(this.id+1);
		return contactClone;
	}
	
	
	
	
}
