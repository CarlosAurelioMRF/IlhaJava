package IlhaJava;

public class Aresta {
	
	private int distancia;
	private Vertice destino;

	public Aresta(Vertice destino, int distancia) {
		this.destino = destino;
		this.distancia = distancia;
	}
	
	public Vertice getDestino() {
		return destino;
	}

	public void setDestino(Vertice destino) {
		this.destino = destino;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

}
