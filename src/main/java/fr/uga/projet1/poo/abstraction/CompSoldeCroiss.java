package fr.uga.projet1.poo.abstraction;

import java.util.Comparator;

import fr.uga.projet1.poo.heritage.CompteB;

public class CompSoldeCroiss implements Comparator<CompteB> {

	@Override
	public int compare(CompteB o1, CompteB o2) {
		if (o1.getSolde() == o2.getSolde())
			return 0;
		else if (o1.getSolde() > o2.getSolde())
			return 1;
		else
			return -1;
	}

}
