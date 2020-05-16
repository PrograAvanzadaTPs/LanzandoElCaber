package dominio;

import java.util.Comparator;

public class Lanzamiento implements Comparable<Lanzamiento>{
	
	private double distancia;
	private double angulo;
	
	
	public Lanzamiento(double distancia, double angulo) {
		super();
		this.distancia = distancia;
		this.angulo = angulo;
	}
	
	public double getMultiploDistancia() {
		if(Math.abs(this.angulo) <= 30)
			return 1;
		if(Math.abs(this.angulo) > 30 && Math.abs(this.angulo) <= 90)
			return 0.8;
		return 0;
	}
	
	public boolean esLanzamientoDescalificado() {
		if(Math.abs(this.angulo) <= 90)
			return false;
		return true;
	}
	
	


	public double getDistancia() {
		return distancia;
	}


	public double getAngulo() {
		return angulo;
	}
	
	public double[] getValoresLanzamiento() {
		double[] valores = {this.distancia, this.angulo};
		return valores;
	}

	//Si hay uno que tiene mayor distancia y otro mayor ángulo,
	//Desempata sólo con la distancia.
	@Override
	public int compareTo(Lanzamiento l) {
		if(this.distancia < l.distancia && this.angulo < l.angulo)
			return -1;
		if(this.distancia > l.distancia && this.angulo > l.angulo)
			return 1;
		if(this.distancia < l.distancia)
			return -1;
		return 1;
	}
	

}
