package dominio;

public class Lanzamiento {
	
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


}
