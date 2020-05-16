package dominio;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import src.ManejoArchivos;

public class testCompetencia {
	
	ManejoArchivos manejo;
	Competencia comp;
	Podio podio;

	@Before
	public void setUp() throws Exception {
		manejo = new ManejoArchivos();
	}
	
	@Test
	public void testEnunciado() throws FileNotFoundException {
		comp = new Competencia(manejo.cargarArchivo("ArchivosEntrada/testEnunciado.in"));
		podio = comp.calcularGanadores();
		int[][] expected = {{1,2,0},{2,1,3}};
		assertArrayEquals(expected, podio.getCompetidoresGanadores());
		
	}

	@Test
	public void testNoGanadoresConsistencia() throws FileNotFoundException {
		comp = new Competencia(manejo.cargarArchivo("ArchivosEntrada/testNoGanadoresConsistencia.in"));
		podio = comp.calcularGanadores();
		int[][] expected = {{0,0,0},{2,3,1}};
		assertArrayEquals(expected, podio.getCompetidoresGanadores());
	}
	
	@Test
	public void testDesempateConsistencia() throws FileNotFoundException {
		comp = new Competencia(manejo.cargarArchivo("ArchivosEntrada/testDesempateConsistencia.in"));
		podio = comp.calcularGanadores();
		int[][] expected = {{1,2,0},{2,1,3}};
		assertArrayEquals(expected, podio.getCompetidoresGanadores());
	}

}
