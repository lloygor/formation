package fr.uga.projet1.genericite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.List;

public class ExportTools {

	public static <T> void exportCsv(String cheminFichier, List<T> lc) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(cheminFichier));
		Field[] fields = lc.get(0).getClass().getDeclaredFields();
		StringBuilder ligneEntete = new StringBuilder(); 
		for (Field fd : fields) {
			fd.setAccessible(true);
			ligneEntete.append(fd.getName()).append(";");
		}
		bw.write(ligneEntete.toString().substring(0, ligneEntete.length()-1));
		bw.newLine();
		for (T c : lc) {
			StringBuilder ligne= new StringBuilder();
			for (Field fd : fields) {
				fd.setAccessible(true);
				ligne.append(fd.get(c).toString()).append(";");
			}
			bw.write(ligne.toString().substring(0,ligne.length()-1));
			bw.newLine();
		}
		bw.close();
	}
}
