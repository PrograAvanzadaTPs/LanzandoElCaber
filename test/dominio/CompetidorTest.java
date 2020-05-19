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
	public void testDistanciaAl80() {
		Lanzamiento l1c2 = new Lanzamiento(1.3, -50.0);
		Lanzamiento l2c2 = new Lanzamiento(2.5, 34.5);
		Lanzamiento l3c2 = new Lanzamiento(4.3, 49.5);
		c2.addLanzamiento(l1c2);
		c2.addLanzamiento(l2c2);
		c2.addLanzamiento(l3c2);
		c2.setDistanciaTotalLanzamientos(c2.obtenerDistanciaTotal());
		assertEquals(6.48, c2.getDistanciaTotalLanzamientos(), 0.1);
	}
	
	@Test
	public void testDistanciaNula() {
		Lanzamiento l1c2 = new Lanzamiento(1.3, -93.0);
		Lanzamiento l2c2 = new Lanzamiento(2.5, 93.5);
		Lanzamiento l3c2 = new Lanzamiento(4.3, 96.5);
		c2.addLanzamiento(l1c2);
		c2.addLanzamiento(l2c2);
		c2.addLanzamiento(l3c2);
		c2.setDistanciaTotalLanzamientos(c2.obtenerDistanciaTotal());
		assertEquals(0, c2.getDistanciaTotalLanzamientos(), 0);
	}
	
	@Test
	public void testDistanciasMezcladas() {
		Lanzamiento l1c2 = new Lanzamiento(1.3, -3.2);
		Lanzamiento l2c2 = new Lanzamiento(2.5, 34.5);
		Lanzamiento l3c2 = new Lanzamiento(4.3, 96.5);
		c2.addLanzamiento(l1c2);
		c2.addLanzamiento(l2c2);
		c2.addLanzamiento(l3c2);
		c2.setDistanciaTotalLanzamientos(c2.obtenerDistanciaTotal());
		assertEquals(3.3, c2.getDistanciaTotalLanzamientos(), 0);
	}
	
	@Test
	public void testNoLanzamientosDescalificados() {
		assertEquals(false, c1.tieneLanzamientosDescalificados());
	}
	
	@Test
	public void testLanzamientosDescalificados() {
		Lanzamiento l1c2 = new Lanzamiento(1.3, -3.2);
		Lanzamiento l2c2 = new Lanzamiento(2.5, 34.5);
		Lanzamiento l3c2 = new Lanzamiento(4.3, 96.5);
		c2.addLanzamiento(l1c2);
		c2.addLanzamiento(l2c2);
		c2.addLanzamiento(l3c2);
		assertEquals(true, c2.tieneLanzamientosDescalificados());
	}
	
	@Test
	public void testMayorDeltaLanzamientos() {
		c1.setMayorDeltaLanzamiento(c1.obtenerDeltaLanzamientos());
		double[] expected = {3.0, 7.4};
		Assert.assertArrayEquals(expected, c1.getMayorDeltaLanzamiento().getValoresLanzamiento(), 0);
	}

}
