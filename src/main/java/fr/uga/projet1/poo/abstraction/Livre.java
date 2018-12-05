package fr.uga.projet1.poo.abstraction;

public class Livre extends SupportCours {

	@Override
	public void imprimer() {
		// TODO code d'impression
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	private String isbn;
	
	

}
