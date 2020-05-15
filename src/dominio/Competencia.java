package dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		int cantCompConsistencia = 0;
		List<Competidor> podioConsistencia = new ArrayList<Competidor>();
		for(Competidor c : competidores) {
			if(!c.tieneLanzamientosDescalificados()) {
				cantCompConsistencia++;
				podioConsistencia.add(c);
			}
		}
		
		Collections.sort(podioConsistencia, new Comparator<Competidor>() {
			public int compare(Competidor c1, Competidor c2) {
				if(c1.getMayorDeltaLanzamiento().getDistancia() < c2.getMayorDeltaLanzamiento().getDistancia() && 
					c1.getMayorDeltaLanzamiento().getAngulo() < c2.getMayorDeltaLanzamiento().getAngulo())
					return -1;
				if(c1.getMayorDeltaLanzamiento().getDistancia() > c2.getMayorDeltaLanzamiento().getDistancia() && 
				c1.getMayorDeltaLanzamiento().getAngulo() > c2.getMayorDeltaLanzamiento().getAngulo())
					return 1;
				if(c1.getMayorDeltaLanzamiento().getDistancia() < c2.getMayorDeltaLanzamiento().getDistancia())
					return -1;
				return 1;
			}
		});
		if(cantCompConsistencia > 0) {
			podioConsistencia = podioConsistencia.subList(0, cantCompConsistencia);
		}
		
		return new Podio(podioConsistencia, podioDistancia);
	}
	

}
