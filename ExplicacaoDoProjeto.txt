Salvador, BA 13 de fevereiro de 2014


Universidade Federal da Bahia
Instituto de Matemática
Departamento de Ciência da Computação
Autores: Mário Augusto Mota Martins
	 Caio Araujo Neponoceno de Lima


Relatório de Implementação de Algoritmos e suas Complexidades


Introdução
     	
        	Este trabalho consiste em apresentar 7 algoritmos que operam sobre estruturas de dados conhecidas como grafos. Para cada algoritmo, iremos apresentar uma breve descrição sobre o mesmo, uma análise de sua complexidade e detalhes da implementação. Os algoritmos implementados foram:
 
1.    Algoritmo de Kruskal;
2.    Algoritmo de Dijkstra;
3.    Busca em Largura;
4.    Busca em Profundidade;
5.    Ordenação topologica;
6.    Fecho transitivo;
7.    Algoritmo de Warshall;

-O projeto foi feito em java através da IDE Eclipse. Consta de 3 pacotes:

	1 com os algoritmos pedidos;
	1 com as estruturas necessárias;
	1 com a classe de entrada e saída de dados para Java;





-As estruturas encontradas no projeto e seus atributos são:

1º Vertice: 
1 String nome;
	1 String cor;
	1 int distancia;
1 ArrayList de Arestas incidentes;
1 ArrayList de Vertices vizinhos;
1 Vertice pai;
1 boolean visitado;

2º Aresta:
	1 int peso;
	2 Vertices;
	1 boolean visitado;

3º Grafo:
	1 ArrayList de Arestas;
	1 ArrayList de Vertices;
1 boolean hasCycle;

-A interação com o projeto é em console e seu sistema de entrada e saída funciona da seguinte forma:
>O projeto tem um menu básico inicial que informa as seguintes opções auto explicativas:
"1 - Add vertices e aresta";
"2 - Imprimir Grafo dado";
"3 - Obter arvore de Kruskal";
"4 - Obter caminho de Dijkstra";
"5 - Obter arvore de Busca em Profundidade";
"6 - Obter Fecho Transitivo de um vertice em tal Grafo";
"7 - Obter arvore de Busca em Largura";
"8 - Obter Ordenacao Topologica";
"9 - Obter Matriz do Algoritmo de Warshall";
"0 - fim";

>Para se inserir um Grafo através da opção “1” as ENTRADAS que devem ser dadas a partir do console sao:

	1º Peso (int);
	2º Origem (String) - Nome do primeiro vertice;
	3º Destino (String) - Nome do segundo vertice;

>O retorno de impressão do Grafo funciona da seguinte forma:

_Por Aresta:
Vértice de Origem + Vértice de Destino + “ - “ + Peso + “ | “;

Ex.: “ab - 2 | bc - 5 | cd - 10”;

_Por Vértice:
	[ vertice¹, vertice², vertice³, …, verticen];
			Para um grafo de “n” vértices.
		
		Ex.: “[a, b, c, d, e]”;

-A seguir veremos as descrições dos Algoritmos, as análises de cada complexidade e alguns detalhes da implementação anexa a este relatório.

1. Algoritmo de Kruskal
	
	O Algoritmo de Kruskal, que é um exemplo de um algoritmo guloso (sempre realizando a escolha que parece ser a melhor no momento), busca uma árvore geradora mínima para um grafo conexo com pesos. Isto significa que ele encontra um subconjunto das arestas que forma uma árvore que inclui todos os vértices, onde o peso total, dado pela soma dos pesos das arestas da árvore, é minimizado. Se o grafo não for conexo, então ele encontra uma floresta geradora mínima (uma árvore geradora mínima para cada componente conexo do grafo).



1.1 Complexidade do algoritmo

A complexidade do algoritmo de Kruskal é dada da seguinte forma:
Em um grafo com “n” vértices e “a” arestas, o número de operações é:
(i) O(a log a), para ordenar as arestas, que é equivalente a O(a log n);
(ii) O(n) para inicializar os conjuntos distintos de cada componente conexa;
(iii) No pior caso, O((2a + n - 1)lg*n) para determinar e misturar as componentes
conexas;
(iv) O(a) para o restante das operações.
• Conclui-se que o tempo total para o algoritmo de Kruskal é O (a log n)

1.2 Detalhes da Implementação

Nossa implementação consta de 2 métodos que podem ser encontrados no arquivo src/com/estruturas/Grafo.java na linha 158:
1º "menorPeso" (retorna o menor peso ainda não verificado da árvore dada);
	2º "temCiclo" (retorna se inserindo determinada aresta a arvore terá um ciclo ou não);
Funciona da seguinte forma, a partir de cada interação de uma estrutura de repetição presente no arquivo src/com/algoritmos/Algoritmos.java na linha 48, são analisadas as arestas do Grafo dado por entrada e é retornada a aresta com menor peso no grafo, ainda não visualizada anteriormente em outra interação da mesma estrutura de repetição, após isso é chamado um método que verifica se adicionando essa aresta no novo grafo de resultado vai haver algum ciclo, se não houver a aresta é adicionada e outra interação da estrutura de repetição é chamada até que se acabem as arestas do Grafo dado originalmente como entrada no console.

2. Algoritmo de Dijkstra

O Algoritmo de Dijkstra é um algoritmo também do tipo “guloso” que soluciona o problema do caminho mais curto entre dois vértices num grafo ponderado dirigido ou não dirigido.

2.1 Complexidade do algoritmo

Sendo |V| o número de vértices do Grafo e |E| o número de Arestas temos:
(i) Inicialização: T(V);
(ii) Ciclo “while” é executado |V| vezes;
(ii.1) Todos os arcos do grafo são visitados, de vértices e de arestas;
- Total = O(V lg V + E lg V) = O ((V + E) lg V).

2.2 Detalhes da Implementação

As entradas que devem ser dadas ao se chamar tal Algoritmo a partir do console são:
	1º Origem (String) - Nome do primeiro vertice do caminho;
	2º Destino (String) - Nome do segundo vertice;
Nossa implementação consta de 1 métodos que pode ser encontrado no arquivo src/com/estruturas/Grafo.java na linha 229:
1º "encontrarMenorCaminhoDijkstra" (retorna uma lista do tipo Aresta com todas as arestas do caminho encontrado);
Funciona da seguinte forma, o método recebe dois vértices que devem estar presentes no grafo, sendo assim o vértice da origem do Caminho de Dijkstra é marcado como o primeiro “atual” e seu atributo distância é valorado como “0”, em seguida todas as distâncias sem ser a desse vértice de origem são valoradas com infinito, dado no algoritmo como “9999” e adicionados em uma lista de vértices ainda não visitados. A partir daí os vertices entram em um “while” que decrementa a lista dos vértices não visitados até que ela esteja vazia, a decrementação é feita de forma a encontrar todos os próximo vértices do caminho após se calcular as suas respectivas distâncias a partir dos pesos das arestas que estão entre eles e verificar se é o menor caminho possível, a cada entrada nessa estrutura de repetição o vertice tido como “atual” é alterado pelo próximo e cada “atual” de cada interação é o pai do próximo “atual” e filho do anterior. Quando não há mais vértices no grafo que não foram visitados, sendo a lista de vértices não visitados vazia, o método acaba e retorna a lista do menor caminho de Dijkstra entre os dois vértices dados.



3. Busca em Largura

Uma busca em largura (também conhecido em inglês por Breadth-First Search (BFS)) é um método de busca que expande e examina sistematicamente todos os vértices de um grafo direcionado ou não-direcionado. O algoritmo garante que nenhum vértice ou aresta seja visitado mais de uma vez. Para isso, utiliza uma fila que garante a ordem de análise de cada vértice. A idéia desse algoritmo é que, dado uma raiz a mesma é analisada e os seus visinhos diretos são enfileirados. Após isso, aplicamos os mesmos passos para o próximo item da fila, repetindo até que a fila esteja vazia. Uma analogia muito conhecida para demonstrar o funcionamento do algoritmo é pintando os vértices de branco, cinza e preto. Os vértices na cor branca representam os vétcies que ainda não foram marcados e nem enfileirados, os da cor cinza são os vértices que estão na estrutura fila e os pretos são aqueles que já tiveram todos os seus vértices vizinhos enfileirados e marcados pelo algoritmo.

3.1 Complexidade do algoritmo
	
Considerando um grafo G(V, E) onde V é o conjunto de vértices e E o conjunto das arestas do grafo, o pior caso desse algoritmo representa um custo de  O(|V| + |E|), onde |E| significa o total de todas as arestas, e |V| que significa o número dos vértices. A característica do pior caso acontece quando o algoritmo passa por todas os vértices e todas as arestas do grafo. É preciso perceber que que |V| representa as operações efetuadas nos vértices, que é sempre constante(normalmente é uma operação que verifica se é o vértice procurado, marca como visitado e desenfileira) para cada vértice, e |E| representa as operações efetuadas em cada aresta (normalmente é a operação de pegar o vizinho da aresta "a" do grafo).

3.2 Detalhes da Implementação
	
	O algoritmo pode ser encontrado no arquivo src/com/estruturas/Grafo.java na linha 418. Nossa implementação recebe de entrada um nó raiz e o nome do nó a ser procurado. O algoritmo retorna qual o caminho efetuado até que o nó procurado fosse encontrado. Para garantir que cada vértice e aresta seja visitada apenas uma vez, utilizamos a idéia de pintar cada nó com as cores "branca", "cinza" e "preta", como foi apresentado anteriormente. A fila de processamento foi representada pela variável queue.

4. Busca em Profundidade

O Algoritmo de Busca em profundidade é usado para realizar uma busca ou travessia numa árvore, estrutura de árvore ou grafo. Intuitivamente, o algoritmo começa num nó raiz (como nosso caso é um grafo tal nó é o informado anteriormente pelo usuário) e explora tanto quanto possível cada um dos seus ramos. Ao encontrar o fim do caminho ele retrocede para o vértice anterior para avaliar se é possível dele continuar a busca para outro dos seus vizinhos. Tal processo é repetido até que ou o vértice buscado seja encontrado, ou todos os vértices do grafo sejam verificados.

4.1 Complexidade do algoritmo

A complexidade espacial do algoritmo de busca em profundidade é bem menor que a de um algoritmo de busca em largura. Já a complexidade temporal é igual, pois é proporcional ao número de vértices somado ao número de arestas dos grafos que eles atravessam. Contudo, quando ocorrem buscas em grafos muito grandes, a busca em profundidade pode não terminar, pois o artifício de lembrar quais nós foram visitados não funciona por falta de espaço na memória. Analisando tal complexidade temos que o custo total desse algoritmo é O(V + E), sendo V a quantidade de vértices e E a quantidade de arestas, ou seja, a mesma complexidade da Busca em Largura. 

4.2 Detalhes da Implementação

As entradas que devem ser dadas ao se chamar tal Algoritmo a partir do console são:
	1º Origem (String) - Nome do vertice raiz do grafo;
	2º Destino (String) - Nome do vertice buscado;
Nossa implementação consta de 2 métodos que podem ser encontrados no arquivo src/com/estruturas/Grafo.java na linha 340:
1º "buscaEmProfundidade" (metodo que chama a busca recursiva e retorna a arvore da busca em profundidade)
	2º "buscaRecursiva" (metodo recursivo que retorna um booleano como resposta da busca pelo vertice e seta como true os vertices e arestas que estarao na arvore de Busca em Profundidade)
Funciona da seguinte forma, o sistema manda ao método “buscaEmProfundidade” qual o vértice raiz e qual o vértice buscado, ambos informados pelo usuário, tal método chama o método “buscaRecursiva” passando os dados que lhes foram entregues, esse método vai buscar recursivamente o valor chamando a sí próprio e entregando como parâmetros o próximo valor vizinho da raiz atual como a nova raiz e o valor buscado, sendo que o método para se encontrar o vértice buscado ou retorna ao acabar o caminho atual para que seja aplicado novamente a recursão para o próximo vizinho do vértice anterior. Tal processo retorna um booleano informando se o vértice foi encontrado ou não e marca as arestas pelas quais passou como visualizadas, tal marcação possibilita ao método “buscaEmProfundidade” criar uma lista do tipo Aresta, com todas as arestas que foram utilizadas em tal busca.

5. Ordenação Topológica
	
	O algoritmo de ordenação topológica é responsável por dar uma ordem linear dos vértices, tal que o critério da ordenação é que qualquer vértice que seja filho de um outro vértice, deve está em uma ordem menor do que o seu vértice "pai". Com isso, é possível perceber que um grafo possui mais do que uma ordem topológica, dado que existem vértices que não são relacionados. A grande utilidade desse algoritmo é para o desenvolvimento de um escalonador de tarefas, dado que existem algumas tarefas que só podem ser concluídas se outras tarefas forem concluídas. Caso o grafo G(V, E) contenha ciclos, não é possível definir uma ordem topolódica.

5.1 Análise de complexidade
 
	A complexidade do algoritmo de ordenação topológica é dada pela complexidade do algoritmo de busca em profundidade que é O(|V| + |E|) como explicado anteriormente. No caso da nossa implementação, temos O(|V| + |E|)  para o método DFS e O(|V|) para a operação de reverter a ordem da lista. com isso a complexidade ainda é O(|V| + |E|) = O(|V| + |E|) + O(|V|).

5.2 Detalhes da implementação
	
A ordem topológica pode ser obtida se executarmos uma busca em profundidade e a cada final de passada nos vértices deve-se adicionar o mesmo no início de uma lista ligada. Ao final do processamento da busca em profundidade, a ordem topológica estará formada. Em nossa implementação, nós criamos o método DFS (linha 461) no arquivo src/com/estruturas/Grafo.java para executar a busca em profundidade. Passamos como parametro uma lista, que é usada para adicionar um vértice ao final do processamento de cada vértice. Finalizando o DFS, invertemos a ordem da lista e obtemos a ordem topológica como retorno.

6. Fecho transitivo

	O Algoritmo de Fecho Transitivo aplicado a um Grafo direcional irá retornar um novo grafo com todas as arestas iniciais e com as arestas que dado que tenha um caminho entre dois vertices do grafo uma aresta entre esses dois vertices é também adicionada ao Grafo.

6.1 Análise de complexidade

	A complexidade é de O(n3) devido as 3 estruturas de de repetição envolvidas no algoritmo para interação com os vertices que tem caminhos entre si.

6.2 Detalhes da Implementação

Nossa implementação consta de 2 métodos que podem ser encontrados no arquivo src/com/estruturas/Grafo.java na linha 386:
1º "fechoTransitivo" (metodo que chama o metodo recursiva em que se busca os vertices que podem ser encontrados a partir do vertice de Origem dado)
	2º "marcaVerticesFechoTransitivo" (metodo recursivo sem retorno que seleciona como visualizado todos os vertices que podem ser vizualizados pelo vertice dado pelo usuário)
Funciona da seguinte forma, para cada vértice do grafo é verificado cada vértice do seu fecho transitivo e uma aresta é adicionada ao Grafo resultante se essa aresta não existir ainda em sua lista.

7. Algoritmo de Warshall

	O algoritmo de Warshall é um algoritmo aplicado a um grafo para calcular a distância do caminho mais curto entre todos os vértices de um grafo, dois-a-dois. A entrada desse algoritmo é um grafo G(V, E) e a saída dele é uma matriz |V| x |V| que contém a menor distância ente cada vértice. Nesse caso, essa matriz possui a diagonal zerada, dado que a  distância de um vértice para ele mesmo é zero(a não ser que exista uma distância para o próprio vértice no grafo G de entrada).

7.1 Detalhes da implementação
	
O algoritmo de Warshall utiliza uma técnica de programação dinâmica para calcular a distância entre todos os vértices. Nesse caso, a matriz vai sendo criada do baixo pra cima, ou seja, vai se calculando a distância gradativamente quando novos vértices vai sendo adicionados no grafo. Para cada novo vértice k, é verificado se o caminho atual entre i, j cálculado é menor do que um caminho para o outro vértice passando por k. Caso não seja menor, a distância entre i e j é modificada.
Nossa implementação pode ser encontrada no arquivo src/com/estruturas/Grafos.java na linha 485.

7.2 Análise de complexidade
	
	A complexidade de tempo do algoritmo de Warshall é definida pelos 3 loops aninhados que passam por todos os vértices. Nesse caso, a complexidade desse algoritmo é O(n3). O algoritmo é simples, porém prático em algumas entradas de tamanho médio.
