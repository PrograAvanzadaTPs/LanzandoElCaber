package dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LanzamientoTest {
	Lanzamiento l1;
	Lanzamiento l2;
	Lanzamiento l3;

	@Before
	public void setUp() throws Exception {
		l1 = new Lanzamiento(2.5, 4.2);
		l2 = new Lanzamiento(1.5, 30.5);
		l3 = new Lanzamiento(3.4, 93.2);
	}

	@Test
	public void testMultiploDistancia1() {
		assertEquals(1, l1.getMultiploDistancia(),0);
	}
	
	@Test
	public void testMultiploDistancia08() {
		assertEquals(0.8, l2.getMultiploDistancia(),0);
	}
	
	@Test
	public void testMultiploDistancia0() {
		assertEquals(0, l3.getMultiploDistancia(),0);
	}
	
	@Test
	public void testNoEsDescalificado() {
		assertEquals(false, l1.esLanzamientoDescalificado());
	}
	
	@Test
	public void testEsLanzamientoDescalificado() {
		assertEquals(true, l3.esLanzamientoDescalificado());
	}
	
	@Test
	public void testCompareToMayor() {
		assertEquals(1, l1.compareTo(l2));
	}
	
	@Test
	public void testCompareToMenor() {
		assertEquals(-1, l2.compareTo(l1));
	}

}
