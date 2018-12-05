package fr.uga.projet1;

import org.junit.Test;

import junit.framework.TestCase;

public class CalculTest extends TestCase {

	@Test
	public void testSomme() {
		assertEquals(5, Calcul.somme(2, 3));
	}
	
	

}
