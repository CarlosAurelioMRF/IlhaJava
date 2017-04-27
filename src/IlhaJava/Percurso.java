package IlhaJava;

import java.lang.reflect.Field;

public class Percurso {
	
	private String origem;
	private String destino;
	private int numeroParadas;
	private String assinatura;
	private int distancia;
	
	public Percurso(String origem, String destino, int distancia) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
	}

	public Percurso(String origem, String destino, int numeroParadas, String assinatura) {
		this.origem = origem;
		this.destino = destino;
		this.numeroParadas = numeroParadas;
		this.assinatura = assinatura;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public int getNumeroParadas() {
		return numeroParadas;
	}
	
	public void setNumeroParadas(int numeroParadas) {
		this.numeroParadas = numeroParadas;
	}

	public String getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}
	
	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public boolean compareTo(Percurso percurso) {
		if (this.getOrigem().equals(percurso.getOrigem()) &&
				this.getDestino().equals(percurso.getDestino()) &&
				this.getDistancia() == percurso.getDistancia()) {
			return true;
		} else {
			return false;
		}
	}
	
}
