package com.algoritmos;

import java.util.ArrayList;

import com.IO.Keyboard;
import com.estruturas.Aresta;
import com.estruturas.Grafo;
import com.estruturas.Vertice;

public class Algoritmos {
	
	public static void main(String arg[]) {

		Grafo inicial = new Grafo();
		Grafo resultado = new Grafo();
		
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
			System.out.println("6 - Obter Fecho Transitivo de um vertice em tal Grafo");
			System.out.println("0 - fim");
			
			opcao = Keyboard.readInt();
			resultado.clearLists();
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
					if(!resultado.temCiclo(arestaAux)){
						resultado.addAresta(arestaAux.getPeso(),
												arestaAux.getOrigem().getNome(),
												arestaAux.getDestino().getNome());
					}
				}
				
				inicial.limparArestaVisitada();
				resultado.limparArestaVisitada();
				
				resultado.imprimeArvore();
				break;
			case 4:
				//Algoritmo de Dijkstra
				
				verticeAux1 = inicial.acharVertice(Keyboard.readString());
				verticeAux2 = inicial.acharVertice(Keyboard.readString());
				resultado.setVertices(inicial.encontrarMenorCaminhoDijkstra(verticeAux1, verticeAux2));
				
				inicial.limparVerticeVisitado();
				
				System.out.println(resultado.getVertices());
				break;
				
			case 5:
				//Algoritmo de Busca em Profundidade
				
				origem = Keyboard.readString();
				destino = Keyboard.readString();
				resultado.setArestas(inicial.buscaEmProfundidade(origem, destino));
				
				//limpando verificadores booleanos
				inicial.limparVerticeVisitado();
				inicial.limparArestaVisitada();
				resultado.limparVerticeVisitado();
				resultado.limparArestaVisitada();
				resultado.imprimeArvore();
				break;
			case 6:
				//Algoritmo de Fecho Transitivo
				
				origem = Keyboard.readString();
				resultado.setVertices(inicial.fechoTransitivo(origem));
				
				inicial.limparVerticeVisitado();
				
				System.out.println(resultado.getVertices());
				resultado.imprimeArvore();
				break;
			case 7:
				origem = Keyboard.readString();
				destino = Keyboard.readString();
				resultado.setArestas(inicial.buscaEmLargura(origem, destino));
				
				resultado.imprimeArvore();
				break;
			case 8: 
				//limpando verificadores booleanos
				inicial.limparVerticeVisitado();
				inicial.limparArestaVisitada();
				
				ArrayList<Vertice> vertices = inicial.topologicalSort();
				int count = 1;
				for (Vertice vertice: vertices) {
					System.out.println(count + " " + vertice.getNome());
					count++;
				}
				break;
			case 9:
				int[][] dist = inicial.wharshall();
				for(int i = 0; i < dist.length; i++){
					for(int j = 0; j < dist.length; j++){
						System.out.print(dist[i][j] + " ");
					}
					System.out.print("\n");
				}
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
