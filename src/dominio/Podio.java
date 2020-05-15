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

}
