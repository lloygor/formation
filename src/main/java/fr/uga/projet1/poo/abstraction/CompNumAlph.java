package fr.uga.projet1.poo.abstraction;

import java.util.Comparator;

import fr.uga.projet1.poo.heritage.CompteB;

public class CompNumAlph implements Comparator<CompteB> {

	@Override
	public int compare(CompteB o1, CompteB o2) {
		return o1.getNumero().compareTo(o2.getNumero());
	}

}
