package fr.uga.projet1.genericite;

import java.util.List;

public interface Dao<T> {

	List<T> lister();
	int inserer(T obj);
}
