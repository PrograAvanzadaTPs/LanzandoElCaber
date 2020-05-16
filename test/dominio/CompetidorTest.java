package dominio;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompetidorTest {
	
	Competidor c1;
	Competidor c2;

	@Before
	public void setUp() throws Exception {
		c1 = new Competidor(1);
		c2 = new Competidor(2);
		Lanzamiento l1c1 = new Lanzamiento(1.3, -3.2);
		Lanzamiento l2c1 = new Lanzamiento(2.5, 4.2);
		Lanzamiento l3c1 = new Lanzamiento(4.3, 3.1);
		c1.addLanzamiento(l1c1);
		c1.addLanzamiento(l2c1);
		c1.addLanzamiento(l3c1);
	}

	@Test
	public void testDistanciaCompleta() {
		c1.setDistanciaTotalLanzamientos(c1.obtenerDistanciaTotal());
		assertEquals(8.1, c1.getDistanciaTotalLanzamientos(),0);
	}
	
	@Test
	public void testNoTirosDescalificados() {
		assertEquals(false, c1.tieneLanzamientosDescalificados());
	}
	
	@Test
	public void testMayorDeltaLanzamientos() {
		c1.setMayorDeltaLanzamiento(c1.obtenerDeltaLanzamientos());
		double[] expected = {3.0, 7.4};
		Assert.assertArrayEquals(expected, c1.getMayorDeltaLanzamiento().getValoresLanzamiento(), 0);
	}

}
