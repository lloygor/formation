package fr.uga.projet1;


import org.junit.Test;

import fr.uga.projet1.genericite.PermutTool;
import fr.uga.projet1.poo.Contact;
import junit.framework.TestCase;

public class PemutTest extends TestCase {

	@Test
	public void testPermuter() {
		PermutTool<Integer> p = new PermutTool<>();
		int v1 = 2, v2 = 5;
		p.a = v1;
		p.b = v2;
		p.permuter();
		assertTrue(p.a.equals(v2));
		assertTrue(p.b.equals(v1));
		
		PermutTool<Contact> pCo = new PermutTool<>();
		try {
			pCo.a = new Contact(1, "toto");
			pCo.b = new Contact(2, "tata");
			pCo.permuter();
			assertEquals("tata", pCo.a.getNom());
			assertEquals("toto", pCo.b.getNom());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
