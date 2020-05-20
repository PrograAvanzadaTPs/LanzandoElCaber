package dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PodioTest {
	
	Podio p;
	Competidor c1;
	Competidor c2;
	Competidor c3;

	@Before
	public void setUp() throws Exception {
		c1 = new Competidor(1);
		c2 = new Competidor(2);
		c3 = new Competidor(3);
	}

	@Test
	public void testGetCompetidoresGanadores() {
		List<Competidor> consistencia = new ArrayList<Competidor>();
		consistencia.add(c1);
		consistencia.add(c2);
		consistencia.add(c3);
		List<Competidor> distancia = new ArrayList<Competidor>();
		distancia.add(c1);
		distancia.add(c2);
		distancia.add(c3);
		p = new Podio(consistencia, distancia);
		int[][] expected = {{1,2,3},{1,2,3}};
 		assertArrayEquals(expected, p.getCompetidoresGanadores());
	}
	
	@Test
	public void testUnSoloGanador() {
		List<Competidor> consistencia = new ArrayList<Competidor>();
		consistencia.add(c1);
		List<Competidor> distancia = new ArrayList<Competidor>();
		distancia.add(c2);
		p = new Podio(consistencia, distancia);
		int[][] expected = {{1,0,0},{2,0,0}};
 		assertArrayEquals(expected, p.getCompetidoresGanadores());
	}
	
	@Test
	public void testDosGanadores() {
		List<Competidor> consistencia = new ArrayList<Competidor>();
		consistencia.add(c1);
		consistencia.add(c2);
		List<Competidor> distancia = new ArrayList<Competidor>();
		distancia.add(c2);
		distancia.add(c1);
		p = new Podio(consistencia, distancia);
		int[][] expected = {{1,2,0},{2,1,0}};
 		assertArrayEquals(expected, p.getCompetidoresGanadores());
	}
	
	@Test
	public void testSinGanadores() {
		List<Competidor> consistencia = new ArrayList<Competidor>();
		List<Competidor> distancia = new ArrayList<Competidor>();
		p = new Podio(consistencia, distancia);
		int[][] expected = {{0,0,0},{0,0,0}};
 		assertArrayEquals(expected, p.getCompetidoresGanadores());
	}

}
