package src;

import java.io.FileNotFoundException;
import java.util.List;

import dominio.Competencia;
import dominio.Competidor;
import dominio.Podio;

public class Main {
	
	ManejoArchivos manejo;
	
	public static void main(String[] args) throws FileNotFoundException {
		ManejoArchivos manejo = new ManejoArchivos();
		Competencia comp = new Competencia(manejo.cargarArchivo("ArchivosEntrada/testEnunciado.in"));
		Podio p = comp.calcularGanadores();
		manejo.guardarGanadores(p, "ArchivosSalida/testEnunciado.out");
	}

}
