package fr.uga.projet1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.uga.projet1.poo.Contact;
import junit.framework.TestCase;

public class ContactTest extends TestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setupBC");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownBC");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testSetNom() {
		Contact c1 = new Contact();
		try {
			c1.setNom("A");
			fail("erreur setNom");
		} catch (Exception e) {
			assertEquals("Erreur : nom obligatoire (2 carac min)",e.getMessage());
		}
	}

	@Test
	public void testEqualsObject() {
		Contact c1 = new Contact();
		Contact c2 = new Contact();
		c1.setId(1);
		c2.setId(1);
		assertTrue(c1.equals(c2));
		
		c2.setId(56);
		assertFalse(c1.equals(c2));
	}

}
