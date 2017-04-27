package IlhaJava;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
	
	private String nome;
	private List<Aresta> arestaAdjacente;
	
	public Vertice(String nome) {
		this.nome = nome;
		this.arestaAdjacente = new ArrayList<Aresta>();
	}
	
	public void addArestaAdjacente(Aresta aresta) {
		arestaAdjacente.add(aresta);
    }
	
	public List<Aresta> getArestaAdjacente() {
		return arestaAdjacente;
	}

	public void setArestaAdjacente(List<Aresta> arestaAdjacente) {
		this.arestaAdjacente = arestaAdjacente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
}
