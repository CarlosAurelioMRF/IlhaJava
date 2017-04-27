package IlhaJava;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Ferrovia {

	private List<Vertice> minhasRotas;

	public Ferrovia() {
		minhasRotas = new ArrayList<Vertice>();
	}

	public void inserirRotas(String cadeiaRotas){
		String rotas[] = cadeiaRotas.split(Pattern.quote(","));

		for (int i = 0; i < rotas.length; i++) {
			String node = rotas[i].trim();
			String origem = node.substring(0,1);
			String destino = node.substring(1,2);
			String distancia = node.substring(2,3);	

			Vertice verticeOrigem = new Vertice(origem);
			Vertice verticeDestino = new Vertice(destino);

			Aresta aresta = new Aresta(verticeDestino, Integer.parseInt(distancia));

			verticeOrigem.addArestaAdjacente(aresta);
			minhasRotas.add(verticeOrigem);
		}
	}


	public int calcularDistancia(String rota) {
		String pontoRota[] = rota.split(Pattern.quote("-"));
		int distancia = 0;
		int numeroRotas = 0;
		for (int i = 0; i < pontoRota.length; i++) {
			for(int j = 0; j < minhasRotas.size(); j++){
				if (minhasRotas.get(j).getNome().equals(pontoRota[i].trim())) {
					if (i+1 < pontoRota.length) {
						if (minhasRotas.get(j).getArestaAdjacente().get(0).getDestino().getNome().equals(pontoRota[i+1].trim())){
							distancia = distancia + minhasRotas.get(j).getArestaAdjacente().get(0).getDistancia();
							numeroRotas++;
						}
					}
				}
			}
		}

		if (pontoRota.length-1 != numeroRotas) {
			distancia = 0;
		}
		return distancia;
	}

	public List<Percurso> getPercursos(String origem, String destino, int numeroParadas) {
		List<Percurso> percursos = new ArrayList<Percurso>();
		String proximaRota = null;
		for (int i = 0; i < minhasRotas.size(); i++) {
			if (minhasRotas.get(i).getNome().equals(origem)) {
				String assinatura = origem;
				for (int j = 0; j < numeroParadas; j++) {
					if (j == 0) {
						proximaRota = percorerMinhasRotas(origem, i);
					} else {
						proximaRota = percorerMinhasRotas(proximaRota);
					}
					assinatura = assinatura + "-" + proximaRota;

					if (proximaRota.equals(destino)) {
						Percurso percurso = new Percurso(origem, destino, numeroParadas, assinatura);
						percursos.add(percurso);
						break;
					} 
				}
			}
		}
		return percursos;	
	}

	/*  Não está funcionando	
	public List<Percurso> getPercursos(String origem, String destino, int numeroParadas, boolean exatamente) {
		List<Percurso> percursos = new ArrayList<Percurso>();
		String proximaRota = null;
		for (int i = 0; i < minhasRotas.size(); i++) {
			if (minhasRotas.get(i).getNome().equals(origem)) {
				String assinatura = origem;
				for (int j = 0; j < numeroParadas; j++) {
					if (j == 0) {
						proximaRota = percorerMinhasRotas(origem, i);
					} else {
						proximaRota = percorerMinhasRotas(proximaRota);
					}
					assinatura = assinatura + "-" + proximaRota;
				}

				if (origem.equals(assinatura.substring(0,1)) && destino.equals(assinatura.substring(assinatura.length()-1, assinatura.length()))) {
					Percurso percurso = new Percurso(origem, destino, numeroParadas, assinatura);
					percursos.add(percurso);
				} 				
			}
		}
		return percursos;	
	}	*/

	public String percorerMinhasRotas(String origem) {
		String proximaRota = null;
		for (int i = 0; i < minhasRotas.size(); i++) {
			if (minhasRotas.get(i).getNome().equals(origem)) {
				proximaRota = minhasRotas.get(i).getArestaAdjacente().get(0).getDestino().getNome();
				break;
			}
		}
		return proximaRota;
	}

	public String percorerMinhasRotas(String origem, int index) {
		String proximaRota = null;
		for (int i = index; i < minhasRotas.size(); i++) {
			if (minhasRotas.get(i).getNome().equals(origem)) {
				proximaRota = minhasRotas.get(i).getArestaAdjacente().get(0).getDestino().getNome();
				break;
			}
		}

		return proximaRota;
	}	

	private Percurso buscarPercurso(String origem, Percurso percursoAtual) {
		for (int i = 0; i < minhasRotas.size(); i++) {
			if (minhasRotas.get(i).getNome().equals(origem)) {
				Percurso percurso = new Percurso(origem, 
						minhasRotas.get(i).getArestaAdjacente().get(0).getDestino().getNome(),
						minhasRotas.get(i).getArestaAdjacente().get(0).getDistancia());
				if (percursoAtual == null) {
					return percurso;
				} else if (!percursoAtual.compareTo(percurso)) {
					return percurso;
				}
			}
		}
		return null;
	}		

	public Percurso getMenorPercurso(String origem, String destino) {
		Percurso percurso = null;
		int menorDistancia = 1000;
		for (int i = 0; i < minhasRotas.size(); i++) {
			if (minhasRotas.get(i).getNome().equals(origem)) {
				String minhaRotaDestino = minhasRotas.get(i).getArestaAdjacente().get(0).getDestino().getNome(); 
				int distancia = minhasRotas.get(i).getArestaAdjacente().get(0).getDistancia();
				do {
					percurso = buscarPercurso(minhaRotaDestino, percurso);
					if (percurso != null) {
						distancia += percurso.getDistancia();
						if (percurso != null && percurso.getDestino().equals(destino) && distancia < menorDistancia) {
							menorDistancia = distancia;
							minhaRotaDestino = destino;
						} else if (distancia > menorDistancia) {
							break;
						}
					}
				} while (!minhaRotaDestino.equals(destino));
			}
		}

		percurso.setDistancia(menorDistancia);
		return percurso;
	}

}