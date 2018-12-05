package fr.uga.projet1.defaultItf;

public interface Interface1 {
	default void m1() {
		System.out.println("CC itf1::m1");
	}
	
	void m2();
}
