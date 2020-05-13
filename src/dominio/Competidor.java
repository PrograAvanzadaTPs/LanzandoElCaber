package dominio;

import java.util.ArrayList;
import java.util.List;

public class Competidor {
	private int nroCompetidor;
	private List <Lanzamiento> lanzamientos;
	
	
	public Competidor(int nroCompetidor) {
		super();
		this.nroCompetidor = nroCompetidor;
		this.lanzamientos = new ArrayList<Lanzamiento>();
	}
	
	public double obtenerDistanciaTotal() {
		double distanciaTotal = 0;
		for(Lanzamiento l : lanzamientos)
			distanciaTotal += l.getDistancia() * l.getMultiploDistancia();
		return distanciaTotal;
	}

	
	public boolean tieneLanzamientosDescalificados() {
		Lanzamiento[] lanzamiento = (Lanzamiento[]) lanzamientos.toArray();
		return lanzamiento[0].esLanzamientoDescalificado() ||
				lanzamiento[1].esLanzamientoDescalificado() ||
				lanzamiento[2].esLanzamientoDescalificado();
		
	}
	
	

	public int getNroCompetidor() {
		return nroCompetidor;
	}
	
	public void addLanzamiento(Lanzamiento l) {
		lanzamientos.add(l);
	}
	
	
	
	

}
