Algoritmos a serem implementados:

	-Algoritmo de Kruskal; OK
	-Algoritmo de Dijkstra; OK
	-Busca em Largura;	
	-Busca em Profundidade; EM_DESENVOLVIMENTO
	-Ordenação topologica;
	-Fecho transitivo;
	-Algoritmo de Warshall;

Produto: Implementação e relatório.

Data de entrega: 11/02/2014

__________________________________________________________
Relatório

O projeto foi feito em java e a interação é em console, consta de 3 pacotes:

	1 com os algoritmos pedidos;
	1 com as estruturas necessárias;
	1 com a classe de entrada e saída de dados para Java;

As estruturas encontradas no projeto são:

	1º Vertice: Composto por:
		1 nome;
		1 distancia; (que é a soma dos pesos de um grafo ponderado em um determinado caminho)
		1 ArrayList de Arestas incidentes;
		1 pai; (vertice anterior a ele em um determinado caminho)
		1 visitado; (booleano para determinar se o vertice ja foi visitado em determinado caminho)
	
	2º Aresta: Compostas por:
		1 peso;
		2 vertices; (origem, destino)
		2 variáveis verificadoras; (sao usadas para controle de fluxo nas buscas de ciclo e de aresta de menor Peso)

	3º Grafo: Composta por:
		1 ArrayList de Arestas
		1 ArrayList de Vertices

___________Main___________

-Para se inserir um Grafo as ENTRADAS que devem ser dadas a partir do console sao:

	1º Peso (int);
	2º Origem (String) - Nome do primeiro vertice;
	3º Destino (String) - Nome do segundo vertice;

___Algoritmo de Kruskal___

-Busca uma arvore formada de menores custos em um grafo ponderado.
-Recebe Grafo dado pelo usuario tratando prioritariamente das arestas como principal objeto de fluxo.

-Os métodos de tal algoritmo estão na classe Grafo e são:
	1º "menorPeso" (retorna o menor peso ainda não verificado da árvore dada);
	2º "temCiclo" (retorna se inserindo determinada aresta a arvore terá um ciclo ou não);
	
___Algoritmo de Dijkstra___

-Busca um caminho de menor custo em um grafo ponderado entre 2 vertices do mesmo.
-Recebe Grafo dado pelo usuario tratando prioritariamente dos vertices como principal objeto de fluxo.
-A ENTRADA que deve ser dada ao se chamar tal Algoritmo a partir do console e:

	1º Origem (String) - Nome do primeiro vertice do caminho;
	2º Destino (String) - Nome do segundo vertice;

-O metodo de tal algoritmo esta na classe Grafo, sendo:
	1º "encontrarMenorCaminhoDijkstra"
	

