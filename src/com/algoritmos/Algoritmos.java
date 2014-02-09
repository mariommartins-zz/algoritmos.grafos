package com.algoritmos;

import com.IO.Keyboard;
import com.estruturas.Aresta;
import com.estruturas.Grafo;
import com.estruturas.Vertice;

public class Algoritmos {
	
	public static void main(String arg[]) {

		Grafo inicial = new Grafo();
		Grafo arvoreKruskal = new Grafo();
		Grafo caminhoDijkstra = new Grafo();
		Grafo arvoreBuscaProfundidade = new Grafo();
		Aresta arestaAux;
		Vertice verticeAux1, verticeAux2;
		int opcao = 5, peso;
		String origem , destino;
		
		while(opcao!=0){
			System.out.println("1 - Add vertices e aresta");
			System.out.println("2 - Imprimir Grafo dado");
			System.out.println("3 - Obter arvore de Kruskal");
			System.out.println("4 - Obter caminho de Dijkstra");
			System.out.println("5 - Obter arvore de Busca em Profundidade");
			System.out.println("0 - fim");
			
			opcao = Keyboard.readInt();
			switch (opcao){
			case 1:
				peso = Keyboard.readInt();
				origem = Keyboard.readString();
				destino = Keyboard.readString();
				inicial.addAresta(peso,origem,destino);
				
				inicial.imprimeArvore();
				break;
			case 2:
				inicial.imprimeArvore();
				break;
			case 3:
				//Algoritmo de Kruskal
				for(int i=0;i<inicial.getArestas().size();i++){
					//busca aresta com menor peso ainda nao verificado no grafo inicial
					arestaAux= inicial.menorPeso();
					//se tal aresta nao formar um ciclo ao ser adicionada, ela eh adicionada a arvore de Kruskal
					if(!arvoreKruskal.temCiclo(arestaAux)){
						arvoreKruskal.addAresta(arestaAux.getPeso(),
												arestaAux.getOrigem().getNome(),
												arestaAux.getDestino().getNome());
					}
				}
				
				inicial.limparPesoVerificado();
				arvoreKruskal.limparPesoVerificado();
				
				arvoreKruskal.imprimeArvore();
				break;
			case 4:
				//Algoritmo de Dijkstra
				verticeAux1 = inicial.acharVertice(Keyboard.readString());
				verticeAux2 = inicial.acharVertice(Keyboard.readString());
				caminhoDijkstra.setVertices(inicial.encontrarMenorCaminhoDijkstra(verticeAux1, verticeAux2));
				
				inicial.limparVerticeVisitado();
				break;
				
			case 5:
				//Algoritmo de Busca em Profundidade
				origem = Keyboard.readString();
				destino = Keyboard.readString();
				arvoreBuscaProfundidade.setArestas(inicial.buscaEmProfundidade(origem, destino));
				
				inicial.limparVerticeVisitado();
				arvoreBuscaProfundidade.limparVerticeVisitado();
				
				arvoreBuscaProfundidade.imprimeArvore();
				break;
			case 0:
				break;
			default:
				System.out.println("invalido");
				break;
			}
			
		}
	}
}
