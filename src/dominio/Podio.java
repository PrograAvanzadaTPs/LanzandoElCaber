package dominio;

import java.util.List;

public class Podio {
	
	private List<Competidor> consistencia;
	private List<Competidor> distancia;
	
	
	public List<Competidor> getConsistencia() {
		return consistencia;
	}
	
	
	public void setConsistencia(List<Competidor> consistencia) {
		this.consistencia = consistencia;
	}
	
	
	public List<Competidor> getDistancia() {
		return distancia;
	}
	
	
	public void setDistancia(List<Competidor> distancia) {
		this.distancia = distancia;
	}

}
