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
		Competencia comp = new Competencia(manejo.cargarArchivo("archivo.in"));
		Podio p = comp.calcularGanadores();
		System.out.println(p);
	}

}
