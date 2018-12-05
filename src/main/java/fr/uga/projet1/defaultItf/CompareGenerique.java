package fr.uga.projet1.defaultItf;

public interface CompareGenerique<T> extends Comparable<T> {
	
	default boolean identique(T t2) {
		return this.compareTo(t2) == 0;
	}
	
	default boolean plusGrandQue(T t2) {
		return this.compareTo(t2) == 1;
	}
	
	default boolean plusPetitQue(T t2) {
		return this.compareTo(t2) == -1;
	}
}
