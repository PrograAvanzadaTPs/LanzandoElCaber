package dominio;

import java.util.List;

public class Podio {
	
	private List<Competidor> consistencia;
	private List<Competidor> distancia;
	
	
	
	public Podio(List<Competidor> consistencia, List<Competidor> distancia) {
		super();
		this.consistencia = consistencia;
		this.distancia = distancia;
	}

	public List<Competidor> getConsistencia() {
		return consistencia;
	}
	
	public List<Competidor> getDistancia() {
		return distancia;
	}
	
	public int[][] getCompetidoresGanadores() {
		int[][]ganadores = new int[2][3];
		int i = 0;
		for(Competidor c : consistencia) 
			ganadores[0][i++] = c.getNroCompetidor();
		i = 0;
		for(Competidor c : distancia)
			ganadores[1][i++] = c.getNroCompetidor();
		return ganadores;
	}
}
