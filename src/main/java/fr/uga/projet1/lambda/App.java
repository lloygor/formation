package fr.uga.projet1.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ArrayList<Etudiant> etus = new ArrayList<Etudiant>(3);
		etus.add(new Etudiant("durand","pierre",12.5));
		etus.add(new Etudiant("dupond","jacques",14));
		etus.add(new Etudiant("martin","eric",5));
		*/
		List<Etudiant> etudiants = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			etudiants.add(new Etudiant("etud"+i,"prenom"+i, i*2));
			etudiants.add(new Etudiant("etux"+i,"prenomx"+i, i*1.5));
		}
		
		List<Etudiant> luMoy = etudiants.stream()
			.sorted(Comparator.comparing(Etudiant::getMoyenne)).
				collect(Collectors.toList());
		luMoy.forEach(System.out::println);
		
		System.out.println("Etudiants qui ont eu la moyenne ");
		
		List<Etudiant> luEtuMoy = etudiants.stream()
				.filter(e -> e.getMoyenne() >= 10).
					collect(Collectors.toList());
			luEtuMoy.forEach(System.out::println);
			
		List<String> luEtuMoyNom = etudiants.stream()
				.filter(e -> e.getMoyenne() >= 10).
				map(e -> e.getNom()).collect(Collectors.toList());

		luEtuMoyNom.forEach(System.out::println);
		
		String luEtuMoyNomList = etudiants.stream()
				.filter(e -> e.getMoyenne() >= 10).
				map(e -> e.getNom()).collect(Collectors.joining(","));

		System.out.println(luEtuMoyNomList);
		
		Double moyenne = etudiants.stream().collect(Collectors.averagingDouble(e -> e.getMoyenne()));
		System.out.println(moyenne);
		
		String MeilleurEtudiant = etudiants.stream().collect(Collectors.maxBy(Comparator.comparing(Etudiant::getMoyenne))).get().getNom();
		System.out.println(MeilleurEtudiant);
		
		String MeilleurEtudiant2 = etudiants.stream().max(Comparator.comparing(Etudiant::getMoyenne)).map(Etudiant::getNom).get();
		System.out.println(MeilleurEtudiant2);
		
		Map<String, List<Etudiant>> listEtu = etudiants.stream().collect(Collectors
				.groupingBy(Etudiant::getMention));
		
		for(String cle : listEtu.keySet()){
			System.out.println(cle);
			List<Etudiant> etus = listEtu.get(cle);
			for(Etudiant et : etus) {
					System.out.println(et.getNom() + ", ");
			}
			System.out.println();
		}
		
		listEtu.forEach((cle,valeur)->{
			System.out.println(cle);
			valeur.forEach(e->System.out.println(e.getNom() + ", "));
			System.out.println();
		});
		//System.out.println(listEtu);
	}

}
