package com.algoritmos;

import com.IO.Keyboard;
import com.estruturas.Aresta;
import com.estruturas.Grafo;

public class Kruskal {
	
	
	public static void main(String arg[]) {

		Grafo arvoreKruskal = new Grafo();
		Grafo inicial = new Grafo();
		Aresta aux;
		int opcao = 5, peso;
		String origem , destino;
		
		while(opcao!=0){
			System.out.println("1 - Add aresta");
			System.out.println("2 - Obter arvore de Kruskal");
			System.out.println("3 - Imprimir arvore dada");
			System.out.println("4 - Imprimir arvore de Kruskal");
			System.out.println("0 - fim");
			
			opcao = Keyboard.readInt();
			switch (opcao){
			case 1:
				peso = Keyboard.readInt();
				origem = Keyboard.readString();
				destino = Keyboard.readString();
				aux = new Aresta(peso,origem,destino);
				inicial.addAresta(aux);
				break;
			case 2:
				//Algoritmo de Kruskal
				for(int i=0;i<inicial.getArestas().size();i++){
					aux= inicial.menorPeso();
					if(!arvoreKruskal.temCiclo(aux)){
						arvoreKruskal.addAresta(aux);
					}
				}
				inicial.limparPesoVerificado();
				arvoreKruskal.limparPesoVerificado();
				break;
			case 3:
				inicial.imprimeArvore();
				break;
			case 4:
				arvoreKruskal.imprimeArvore();
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
