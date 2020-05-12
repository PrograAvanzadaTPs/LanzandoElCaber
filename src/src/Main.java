package src;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Dominio.Competidor;

public class Main {
	
	ManejoArchivos manejo;
	
	public static void main(String[] args) throws FileNotFoundException {
		ManejoArchivos manejo = new ManejoArchivos();
		ArrayList <Competidor> comp = manejo.cargarArchivo("archivo.in");

	}

}
