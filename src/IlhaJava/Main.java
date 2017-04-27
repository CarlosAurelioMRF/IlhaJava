package IlhaJava;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ferrovia ferrovia = new Ferrovia();
		ferrovia.inserirRotas("BC4, AD5, DC8, CD8, DE6, CE2, AE7, EB3, AB5");
		
		int primeiraDistancia = ferrovia.calcularDistancia("A-B-C");
		System.out.println("Distancia da Rota A-B-C: " + String.valueOf(primeiraDistancia > 0 ? primeiraDistancia : "ROTA N�O EXISTE"));
		
		int segundaDistancia = ferrovia.calcularDistancia("A-D");
		System.out.println("Distancia da Rota A-D: " + String.valueOf(segundaDistancia > 0 ? segundaDistancia : "ROTA N�O EXISTE"));
		
		int terceiraDistancia = ferrovia.calcularDistancia("A-D-C");
		System.out.println("Distancia da Rota A-D-C: " + String.valueOf(terceiraDistancia > 0 ? terceiraDistancia : "ROTA N�O EXISTE"));
		
		int quartaDistancia = ferrovia.calcularDistancia("A-E-B-C-D");
		System.out.println("Distancia da Rota A-E-B-C-D: " + String.valueOf(quartaDistancia > 0 ? quartaDistancia : "ROTA N�O EXISTE"));
		
		int quintaDistancia = ferrovia.calcularDistancia("A-E-D");
		System.out.println("Distancia da Rota A-E-D: " + String.valueOf(quintaDistancia > 0 ? quartaDistancia : "ROTA N�O EXISTE"));
		
		List<Percurso> primeirosPercursos = ferrovia.getPercursos("C", "C", 3);
		System.out.println("Numero de Rotas: " + String.valueOf(primeirosPercursos.size()));
		for (int i = 0; i < primeirosPercursos.size(); i++) {
			System.out.println("Assinatura: " + primeirosPercursos.get(i).getAssinatura());
		}
		 
/*		N�O EST� FUNCIONANDO
		 
		List<Percurso> segundosPercursos = ferrovia.getPercursos("A", "C", 4, true);
		System.out.println("Numero de Rotas: " + String.valueOf(segundosPercursos.size()));
		for (int i = 0; i < segundosPercursos.size(); i++) {
			System.out.println("Assinatura: " + segundosPercursos.get(i).getAssinatura());
		}
		*/
		Percurso primeiroPercurso = ferrovia.getMenorPercurso("A", "C");
		System.out.println("Distancia mais curta entre: A-C: " + primeiroPercurso.getDistancia());
		
		Percurso segundoPercurso = ferrovia.getMenorPercurso("B", "B");
		System.out.println("Distancia mais curta entre: A-C: " + segundoPercurso.getDistancia());		
		
	}

}
