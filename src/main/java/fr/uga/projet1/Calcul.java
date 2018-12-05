package fr.uga.projet1;

public class Calcul {

	public static int somme(int a, int b) {
		return a+b;
	}
	
	//surcharge de méthodes (overload)
	//plusieurs méthodes peuvent avoir le même nom mais différents paramètres
	
	//Arguments variables
	//1 seul var-arg par méthode et positionné à la fin
	//int r1 = Calcul.multiplier(tab1);
	//int r2 = Calcul.multiplier(12,34,67);
	//int r3 = Calcul.multiplier(tab);
	public static int multiplier(int... t) {
		int r = 1;
		for (int x : t) {
			r*=x ;
		}
		return r;
	}
}
