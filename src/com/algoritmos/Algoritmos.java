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
			System.out.println("6 - Obter Fecho Transitivo do Grafo");
			System.out.println("7 - Obter arvore de Busca em Largura");
			System.out.println("8 - Obter Ordenacao Topologica");
			System.out.println("9 - Obter Matriz do Algoritmo de Warshall");
			System.out.println("0 - fim");
			
			opcao = Keyboard.readInt();
			
			//dando um reset no grafo de resultado
			resultado.clearLists();
			
			//limpando verificadores booleanos
			inicial.limparArestaVisitada();
			inicial.limparVerticeVisitado();
			
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
				
				resultado.imprimeArvore();
				break;
			case 4:
				//Algoritmo de Dijkstra
				
				verticeAux1 = inicial.acharVertice(Keyboard.readString());
				verticeAux2 = inicial.acharVertice(Keyboard.readString());
				resultado.setVertices(inicial.encontrarMenorCaminhoDijkstra(verticeAux1, verticeAux2));
				
				System.out.println(resultado.getVertices());
				break;
				
			case 5:
				//Algoritmo de Busca em Profundidade
				
				origem = Keyboard.readString();
				destino = Keyboard.readString();
				resultado.setArestas(inicial.buscaEmProfundidade(origem, destino));
				
				resultado.imprimeArvore();
				break;
			case 6:
				//Algoritmo de Fecho Transitivo
				
				//para cada vertice do Grafo
				for(int i=0;i<inicial.getVertices().size();i++){
					//para cada vertice do seu fecho transitivo
					for(int j=0;j<inicial.fechoTransitivo(inicial.getVertices().get(i).getNome()).size();j++){
						arestaAux = resultado.acharAresta(inicial.getVertices().get(i), inicial.fechoTransitivo(inicial.getVertices().get(i).getNome()).get(j)); 
						//verifica se uma aresta com esse vertice e o vertice inicial ja existe
						//se nao existe
						if(arestaAux==null){
							//adiciona aresta
							resultado.addAresta(0,
									inicial.getVertices().get(i).getNome(),
									inicial.fechoTransitivo(inicial.getVertices().get(i).getNome()).get(j).getNome() );
						}
					}
				}
				
				System.out.println(resultado.getArestas());
				break;
			case 7:
				//Algoritmo de Busca em Largura
				
				origem = Keyboard.readString();
				destino = Keyboard.readString();
				resultado.setArestas(inicial.buscaEmLargura(origem, destino));
				
				resultado.imprimeArvore();
				break;
			case 8: 
				//Ordenacao Topologica
				
				ArrayList<Vertice> vertices = inicial.topologicalSort();
				int count = 1;
				for (Vertice vertice: vertices) {
					System.out.println(count + " " + vertice.getNome());
					count++;
				}
				break;
			case 9:
				//Algoritmo de Warshall
				
				int[][] dist = inicial.warshall();
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
