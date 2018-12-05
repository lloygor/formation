package fr.uga.projet1.genericite;

//<T> : generic
//on peut ajouter des contraintes sur des génériques
public class PermutTool<T> {

	public T a;
	public T b;
	
	
	public void permuter() {
		T c = a;
		a = b;
		b = c;
	}
}
