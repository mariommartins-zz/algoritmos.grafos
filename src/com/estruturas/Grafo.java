package com.estruturas;

import java.util.ArrayList;

public class Grafo {
	
	private ArrayList<Aresta> arestas = new ArrayList<Aresta>();
	
	public void addAresta(Aresta aresta){
		this.arestas.add(aresta);
	}
	
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
		String anterior = aresta.getDestino();
		
		for(int j=0; j<this.getArestas().size() ;j++){
			
			for(int i=0; i<this.getArestas().size() ;i++){
				
				if ((aresta==this.getArestas().get(i))&&(this.getArestas().get(i).isCicloVerificado()==false))
					this.getArestas().get(i).setCicloVerificado(true);
				else if (aresta!=this.getArestas().get(i)){
					
					if (anterior.equals(this.getArestas().get(i).getOrigem())){
						
						if	(aresta.getOrigem().equals(this.getArestas().get(i).getDestino())){
							this.limparCicloVerificado();
							return true;
						}else{
							anterior = this.getArestas().get(i).getDestino();
							this.getArestas().get(i).setCicloVerificado(true);
						}	
						
					}else if (anterior.equals(this.getArestas().get(i).getDestino())){
						
						if	(aresta.getOrigem().equals(this.getArestas().get(i).getOrigem())){
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

	public void limparPesoVerificado (){
		for(int i=0; i<this.getArestas().size() ;i++)
			this.getArestas().get(i).setPesoVerificado(false);
	}
	
	public void limparCicloVerificado (){
		for(int i=0; i<this.getArestas().size() ;i++)
			this.getArestas().get(i).setCicloVerificado(false);
	}

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}
	
	public void setArestas(Aresta aresta) {
		this.arestas.add(aresta);
	}
	
	public void imprimeArvore(){
		for (int i=0; i<arestas.size();i++)
			System.out.print(this.arestas.get(i).getOrigem() + this.arestas.get(i).getDestino() + " - " + this.arestas.get(i).getPeso() + " | ");
		System.out.println();
	}
	

}
