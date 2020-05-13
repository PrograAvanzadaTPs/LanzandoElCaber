package dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Competencia {
	
	private List<Competidor> competidores;
	
	public Competencia(List<Competidor> competidores) {
		super();
		this.competidores = competidores;
	}

	public Podio calcularGanadores() {
		//Podio Distancia
		Collections.sort(competidores);
		Collections.reverse(competidores);
		List<Competidor> podioDistancia = new ArrayList<Competidor>();
		podioDistancia.add(competidores.get(0));
		podioDistancia.add(competidores.get(1));
		podioDistancia.add(competidores.get(2));
		
		//Podio Consistencia
		return new Podio();
	}
	

}
