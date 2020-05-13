package src;

import java.io.FileNotFoundException;
import java.util.List;

import dominio.Competidor;

public class Main {
	
	ManejoArchivos manejo;
	
	public static void main(String[] args) throws FileNotFoundException {
		ManejoArchivos manejo = new ManejoArchivos();
		List <Competidor> comp = manejo.cargarArchivo("archivo.in");
	}

}
