package fr.uga.projet1.poo.abstraction;

public interface Pliable {

	default void plier() {
		System.out.println("plier...");
	}
	
	void deplier();
	
	
}
