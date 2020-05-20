package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import dominio.Competidor;
import dominio.Lanzamiento;
import dominio.Podio;

public class ManejoArchivos {
	
	public List<Competidor> cargarArchivo(String path) throws FileNotFoundException {
			
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		List<Competidor> competidores = new ArrayList<Competidor>();
		int cantParticipantes = sc.nextInt();
		for(int i = 1; i <= cantParticipantes; i++) {
			//Cargo los lanzamientos del competidor i
			Lanzamiento lanzamiento1 = new Lanzamiento(sc.nextDouble(), sc.nextDouble());
			Lanzamiento lanzamiento2 = new Lanzamiento(sc.nextDouble(), sc.nextDouble());
			Lanzamiento lanzamiento3 = new Lanzamiento(sc.nextDouble(), sc.nextDouble());
			
			//Creo el competidor i...
			Competidor competidor = new Competidor(i);
			
			//... le agrego sus lanzamientos...
			competidor.addLanzamiento(lanzamiento1);
			competidor.addLanzamiento(lanzamiento2);
			competidor.addLanzamiento(lanzamiento3);
			
			//... calculo el mayor delta de sus lanzamientos...
			competidor.setMayorDeltaLanzamiento(competidor.obtenerDeltaLanzamientos());
			
			//... y calculo su distancia total alcanzada con los lanzamientos
			competidor.setDistanciaTotalLanzamientos(competidor.obtenerDistanciaTotal());
			
			//Finalmente, añado el competidor a la lista de competidores
			competidores.add(competidor);
		}
		sc.close();
		return competidores;	
	}
	
	public void guardarGanadores(Podio podio, String pathArchivo) {
		int[][] ganadores = podio.getCompetidoresGanadores();
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(pathArchivo);
			pw = new PrintWriter(fichero);
			for(int i = 0; i < 2; i++) { 
				for(int j = 0; j < 3 && ganadores[i][j] != 0; j++) {
					pw.print(ganadores[i][j]+"  ");
				}
				pw.print("\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(null != fichero)
					fichero.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
