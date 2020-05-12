package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import Dominio.Competidor;
import Dominio.Lanzamiento;
import Dominio.Podio;

public class ManejoArchivos {
	
	public ArrayList<Competidor> cargarArchivo(String path) throws FileNotFoundException {
			
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		ArrayList<Competidor> competidores = new ArrayList<Competidor>();
		int cantParticipantes = sc.nextInt();
		for(int i = 1; i <= cantParticipantes; i++) {
			//Creo un competidor
			Lanzamiento lanzamiento1 = new Lanzamiento(sc.nextDouble(), sc.nextDouble());
			Lanzamiento lanzamiento2 = new Lanzamiento(sc.nextDouble(), sc.nextDouble());
			Lanzamiento lanzamiento3 = new Lanzamiento(sc.nextDouble(), sc.nextDouble());
			ArrayList <Lanzamiento> lanzamientos = new ArrayList<Lanzamiento>();
			lanzamientos.add(lanzamiento1);
			lanzamientos.add(lanzamiento2);
			lanzamientos.add(lanzamiento3);
			//Agrego el competidor al ArrayList
			Competidor competidor = new Competidor(i, lanzamientos);
			competidores.add(competidor);
		}
		sc.close();
		return competidores;	
	}
	
	public void guardarGanadores(Podio podio) {
		
	}

}
