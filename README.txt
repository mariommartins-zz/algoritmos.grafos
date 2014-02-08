Algoritmos a serem implementados:

	-Algoritmo de Kruskal; OK
	-Algoritmo de Dijkstra;
	-Busca em Largura;
	-Busca em Profundidade;
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
		1 ArrayList de Arestas incidentes;
	
	2º Aresta: Compostas por:
		1 peso;
		2 vertices;
		2 variáveis verificadoras;

	3º Grafo: Composta por uma ArrayList de Arestas.


___Algoritmo de Kruskal___

Recebe árvores dadas pelo usuário da forma:

	1º Peso (int);
	2º Origem (String) - Nome do primeiro vertice;
	3º Destino (String) - Nome do segundo vertice;

Os métodos que tal algoritmo mais utiliza da classe Grafo são:
	1º "menorPeso" (retorna o menor peso ainda não verificado da árvore dada);
	2º "temCiclo" (retorna se inserindo determinada aresta a arvore terá um ciclo ou não);
	
___Algoritmo de Dijkstra___

