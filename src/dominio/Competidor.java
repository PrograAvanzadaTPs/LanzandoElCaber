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
		double menorDistancia = 0;
		double mayorDistancia = 0;
		double menorAngulo = 0;
		double mayorAngulo = 0;
		for(Lanzamiento l : lanzamientos) {
			menorDistancia = l.getDistancia() < menorDistancia? l.getDistancia() : menorDistancia;
			mayorDistancia = l.getDistancia() > mayorDistancia? l.getDistancia() : mayorDistancia;
			menorAngulo = l.getAngulo() < menorAngulo? l.getAngulo() : menorAngulo;
			mayorAngulo = l.getAngulo() > mayorAngulo? l.getAngulo() : mayorAngulo;
		}
		
		return new Lanzamiento(mayorDistancia - menorDistancia, mayorAngulo - menorAngulo);
		
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
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(distanciaTotalLanzamientos);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((lanzamientos == null) ? 0 : lanzamientos.hashCode());
		result = prime * result + nroCompetidor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competidor other = (Competidor) obj;
		if (Double.doubleToLongBits(distanciaTotalLanzamientos) != Double
				.doubleToLongBits(other.distanciaTotalLanzamientos))
			return false;
		if (lanzamientos == null) {
			if (other.lanzamientos != null)
				return false;
		} else if (!lanzamientos.equals(other.lanzamientos))
			return false;
		if (nroCompetidor != other.nroCompetidor)
			return false;
		return true;
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

	public Lanzamiento getMayorDeltaLanzamiento() {
		return mayorDeltaLanzamiento;
	}
	
	
	
	

}
