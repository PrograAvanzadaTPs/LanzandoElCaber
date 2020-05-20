package dominio;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import src.ManejoArchivos;

public class CompetenciaTest {
	
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
		manejo.guardarGanadores(podio, "ArchivosSalida/testEnunciado.out");
		int[][] expected = {{1,2,0},{2,1,3}};
		assertArrayEquals(expected, podio.getCompetidoresGanadores());
		
	}

	@Test
	public void testNoGanadoresConsistencia() throws FileNotFoundException {
		comp = new Competencia(manejo.cargarArchivo("ArchivosEntrada/testNoGanadoresConsistencia.in"));
		podio = comp.calcularGanadores();
		manejo.guardarGanadores(podio, "ArchivosSalida/testNoGanadoresConsistencia.out");
		int[][] expected = {{0,0,0},{2,3,1}};
		assertArrayEquals(expected, podio.getCompetidoresGanadores());
	}
	
	@Test
	public void testDesempateConsistencia() throws FileNotFoundException {
		comp = new Competencia(manejo.cargarArchivo("ArchivosEntrada/testDesempateConsistencia.in"));
		podio = comp.calcularGanadores();
		manejo.guardarGanadores(podio, "ArchivosSalida/testDesempateConsistencia.out");
		int[][] expected = {{2,3,0},{3,2,1}};
		assertArrayEquals(expected, podio.getCompetidoresGanadores());
	}
	
	@Test
	public void testLanzamientosNulos() throws FileNotFoundException {
		comp = new Competencia(manejo.cargarArchivo("ArchivosEntrada/testLanzamientosNulos.in"));
		podio = comp.calcularGanadores();
		manejo.guardarGanadores(podio, "ArchivosSalida/testLanzamientosNulos.out");
		int[][] expected = {{0,0,0},{0,0,0}};
		assertArrayEquals(expected, podio.getCompetidoresGanadores());
	}

}
