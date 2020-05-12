package Dominio;

import java.util.ArrayList;

public class Competidor {
	private int nroCompetidor;
	private ArrayList <Lanzamiento> lanzamientos;
	
	
	public Competidor(int nroCompetidor, ArrayList<Lanzamiento> lanzamientos) {
		super();
		this.nroCompetidor = nroCompetidor;
		this.lanzamientos = lanzamientos;
	}
	
	public double obtenerDistanciaTotal() {
		double distanciaTotal = 0;
		for(Lanzamiento l : lanzamientos)
			distanciaTotal += l.getDistancia() * l.getMultiploDistancia();
		return distanciaTotal;
	}

	
	public boolean tieneLanzamientosDescalificados() {
		return false;
	}
	
	

}
