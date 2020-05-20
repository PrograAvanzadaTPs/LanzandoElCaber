package dominio;

import java.util.ArrayList;
import java.util.List;

public class Competidor implements Comparable<Competidor>{
	
	private int nroCompetidor;
	private List <Lanzamiento> lanzamientos;
	private double distanciaTotalLanzamientos;
	private Lanzamiento mayorDeltaLanzamiento;
	
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
	
	public Lanzamiento obtenerDeltaLanzamientos() {
		double menorDistancia = Double.MAX_VALUE;
		double menorAngulo = Double.MAX_VALUE;
		double mayorDistancia = 0;		
		double mayorAngulo = 0;
		for(Lanzamiento l : lanzamientos) {
			menorDistancia = l.getDistancia() < menorDistancia? l.getDistancia() : menorDistancia;
			mayorDistancia = l.getDistancia() > mayorDistancia? l.getDistancia() : mayorDistancia;
			menorAngulo = l.getAngulo() < menorAngulo? l.getAngulo() : menorAngulo;
			mayorAngulo = l.getAngulo() > mayorAngulo? l.getAngulo() : mayorAngulo;
		}
		
		return new Lanzamiento(mayorDistancia - menorDistancia, Math.abs(mayorAngulo - menorAngulo));
		
	}

	public boolean tieneLanzamientosDescalificados() {
		for(Lanzamiento l : lanzamientos) {
			if(l.esLanzamientoDescalificado())
				return true;
		}
		return false;
		
	}

	public int getNroCompetidor() {
		return nroCompetidor;
	}
	
	public void addLanzamiento(Lanzamiento l) {
		lanzamientos.add(l);
	}
	
	public double getDistanciaTotalLanzamientos() {
		return distanciaTotalLanzamientos;
	}

	public void setDistanciaTotalLanzamientos(double distanciaTotalLanzamientos) {
		this.distanciaTotalLanzamientos = distanciaTotalLanzamientos;
	}

	public void setMayorDeltaLanzamiento(Lanzamiento mayorDeltaLanzamiento) {
		this.mayorDeltaLanzamiento = mayorDeltaLanzamiento;
	}

	public Lanzamiento getMayorDeltaLanzamiento() {
		return mayorDeltaLanzamiento;
	}
	
	@Override
	public int compareTo(Competidor c) {
		if(this.distanciaTotalLanzamientos < c.distanciaTotalLanzamientos)
			return -1;
		if(this.distanciaTotalLanzamientos > c.distanciaTotalLanzamientos)
			return 1;
		// TODO Auto-generated method stub
		return 0;
	}
	

}
