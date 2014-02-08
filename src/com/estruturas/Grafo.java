package com.estruturas;

import java.util.ArrayList;
import java.util.Collections;

public class Grafo {
	
	private ArrayList<Aresta> arestas = new ArrayList<Aresta>();
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	
	
	public void addAresta(int peso, String origem, String destino){
		int i,j,k;
		
		//adiciona vertices e retorna posicao
		i = this.addVertice(origem);
		j = this.addVertice(destino);
		
		//adiciona aresta na lista
		this.arestas.add(new Aresta(peso,
									this.vertices.get(i),
									this.vertices.get(j)) );
		k = this.arestas.size();
		
		//adiciona aresta na lista de arestas incidentes em cada vertice
		this.vertices.get(i).addIncidentes(this.arestas.get(k-1));
		this.vertices.get(j).addIncidentes(this.arestas.get(k-1));
	}
	
	public void setArestas(ArrayList<Aresta> arestas) {		
		for (int i=0; i<arestas.size() ; i++)
			this.addAresta(arestas.get(i).getPeso(), 
							arestas.get(i).getOrigem().getNome(), 
							arestas.get(i).getDestino().getNome() );
	}

	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}

	public int addVertice(String nome){
		int i= 0;
		
		if(this.vertices.size()==i){
			this.vertices.add(new Vertice(nome));
		}else{
			i = this.posicaoVertice(nome);
			if(i!=this.vertices.size())
				return i;
			else{
				this.vertices.add(new Vertice(nome));						
			}			
		}
		return i;
	}
	
	public void limparPesoVerificado (){
		for(int i=0; i<this.getArestas().size() ;i++)
			this.getArestas().get(i).setPesoVerificado(false);
	}
	
	public void limparCicloVerificado (){
		for(int i=0; i<this.getArestas().size() ;i++)
			this.getArestas().get(i).setCicloVerificado(false);
	}
	
	public void imprimeArvore(){
		for (int i=0; i<arestas.size();i++)
			System.out.print(this.arestas.get(i).getOrigem().getNome() + this.arestas.get(i).getDestino().getNome() + " - " + this.arestas.get(i).getPeso() + " | ");
		System.out.println();
	}

	public ArrayList<Vertice> getVertices() {
		return vertices;
	}
	
	public int posicaoVertice(String nome){
		int i;
		
		for (i=0; i<this.vertices.size() ; i++)
			if (this.vertices.get(i).getNome().equals(nome))
				return i;
		
		return this.vertices.size();
	
	}
	
	public Vertice acharVertice(String nome){
		return this.vertices.get(this.posicaoVertice(nome));
	}
	
	public ArrayList<Aresta> getArestas() {
		return arestas;
	}
	
//----------------------KRUSKAL--------------------------------------------
	//metodo que permite retorno de aresta com menor peso ainda nao verificado
	public Aresta menorPeso(){
		int j;
		
		for(j=0; j<this.getArestas().size() ;j++){
			if((this.getArestas().get(j).isPesoVerificado()==false)){
				this.getArestas().get(j).setPesoVerificado(true);
				
				for(int i=(j+1); i<this.getArestas().size() ;i++){
					
					if ((this.getArestas().get(i).isPesoVerificado()==false) && 
							(this.getArestas().get(j).getPeso() > this.getArestas().get(i).getPeso())){
						

						this.getArestas().get(j).setPesoVerificado(false);
						j = i;
						this.getArestas().get(j).setPesoVerificado(true);
					}
				}
				
				break;
			}
		}
		
		return this.getArestas().get(j);
	}
	
	//metodo que informa se ao adicionar certa aresta a arvore que vai receber tera ciclo ou nao
	public boolean temCiclo(Aresta aresta){
		
		Vertice anterior = aresta.getDestino();
		
		for(int j=0; j<this.getArestas().size() ;j++){
			
			for(int i=0; i<this.getArestas().size() ;i++){
				
				if ((aresta==this.getArestas().get(i))&&(this.getArestas().get(i).isCicloVerificado()==false))
					this.getArestas().get(i).setCicloVerificado(true);
				else if (aresta!=this.getArestas().get(i)){
					
					if (anterior.getNome().equals(this.getArestas().get(i).getOrigem().getNome())){
						
						if	(aresta.getOrigem().getNome().equals(this.getArestas().get(i).getDestino().getNome())){
							this.limparCicloVerificado();
							return true;
						}else{
							anterior = this.getArestas().get(i).getDestino();
							this.getArestas().get(i).setCicloVerificado(true);
						}	
						
					}else if (anterior.getNome().equals(this.getArestas().get(i).getDestino().getNome())){
						
						if	(aresta.getOrigem().getNome().equals(this.getArestas().get(i).getOrigem().getNome())){
							this.limparCicloVerificado();
							return true;
						}else{
							anterior = this.getArestas().get(i).getOrigem();
							this.getArestas().get(i).setCicloVerificado(true);
						}
					}
				}
			}
		}
		this.limparCicloVerificado();
		return false;
	}
	
//----------------------DIJKSTRA--------------------------------------------
	
    public ArrayList<Vertice> encontrarMenorCaminhoDijkstra(Vertice v1,Vertice v2) {

    	// Atributos usados na funcao encontrarMenorCaminho

        // Lista que guarda os vertices pertencentes ao menor caminho encontrado
    	ArrayList<Vertice> menorCaminho = new ArrayList<Vertice>();

        // Variavel que recebe os vertices pertencentes ao menor caminho
        Vertice verticeCaminho;

        // Variavel que guarda o vertice que esta sendo visitado
        Vertice atual;

        // Variavel que marca o vizinho do vertice atualmente visitado
        Vertice vizinho;

        // Lista dos vertices que ainda nao foram visitados
        ArrayList<Vertice> naoVisitados = new ArrayList<Vertice>();

        // Algoritmo de Dijkstra
        
    	// Adiciona a origem na lista do menor caminho
        menorCaminho.add(v1);

        // Colocando a distancias iniciais 
        for (int i = 0; i < this.getVertices().size(); i++) {

                // Vertice atual tem distancia zero, e todos os outros,
                // 9999("infinita")
                if (this.getVertices().get(i).getNome()
                                .equals(v1.getNome())) {

                        this.getVertices().get(i).setDistancia(0);
                } else {
                        this.getVertices().get(i).setDistancia(9999);
                }
                // Insere o vertice na lista de vertices nao visitados
                naoVisitados.add(this.getVertices().get(i));
        }

        Collections.sort(naoVisitados);

        // O algoritmo continua ate que todos os vertices sejam visitados
        while (!naoVisitados.isEmpty()) {

                // Toma-se sempre o vertice com menor distancia, que eh o primeiro
                // da
                // lista

                atual = naoVisitados.get(0);
                System.out.println("Pegou esse vertice:  " + atual);
                /*
                 * Para cada vizinho (cada aresta), calcula-se a sua possivel
                 * distancia, somando a distancia do vertice atual com a da aresta
                 * correspondente. Se essa distancia for menor que a distancia do
                 * vizinho, esta eh atualizada.
                 */
                for (int i = 0; i < atual.getIncidentes().size(); i++) {

                        vizinho = atual.getIncidentes().get(i).getDestino();
                        System.out.println("Olhando o vizinho de " + atual + ": "
                                        + vizinho);
                        if (!vizinho.isVisitado()) {

                                // Comparando a distância do vizinho com a possível
                                // distância
                                if (vizinho.getDistancia() > (atual.getDistancia() + atual
                                                .getIncidentes().get(i).getPeso())) {

                                        vizinho.setDistancia(atual.getDistancia()
                                                        + atual.getIncidentes().get(i).getPeso());
                                        vizinho.setPai(atual);

                                        /*
                                         * Se o vizinho eh o vertice procurado, e foi feita uma
                                         * mudanca na distancia, a lista com o menor caminho
                                         * anterior eh apagada, pois existe um caminho menor
                                         * vertices pais, ateh o vertice origem.
                                         */
                                        if (vizinho == v2) {
                                                menorCaminho.clear();
                                                verticeCaminho = vizinho;
                                                menorCaminho.add(vizinho);
                                                while (verticeCaminho.getPai() != null) {

                                                        menorCaminho.add(verticeCaminho.getPai());
                                                        verticeCaminho = verticeCaminho.getPai();

                                                }
                                                // Ordena a lista do menor caminho, para que ele
                                                // seja exibido da origem ao destino.
                                                Collections.sort(menorCaminho);

                                        }
                                }
                        }

                }
                // Marca o vertice atual como visitado e o retira da lista de nao
                // visitados
                atual.setVisitado(true);
                naoVisitados.remove(atual);
                /*
                 * Ordena a lista, para que o vertice com menor distancia fique na
                 * primeira posicao
                 */

                Collections.sort(naoVisitados);
                System.out.println("Nao foram visitados ainda:"+naoVisitados);

        }
        System.out.println("Menor caminho: " + menorCaminho);
        return menorCaminho;
    }
	
//--------------------------------------------------------------------------
}
