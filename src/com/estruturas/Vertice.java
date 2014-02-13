package com.estruturas;

import java.util.ArrayList;

public class Vertice implements Comparable<Vertice> {
	private String nome;
	private int distancia = 0;
	private Vertice pai;
	private ArrayList<Aresta> incidentes = new ArrayList<Aresta>();
	private ArrayList<Vertice> vizinhos = new ArrayList<Vertice>();
	private boolean visitado = false;
	private String cor = "branco"; 
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Vertice(String nome){
		this.setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getDistancia() {
		return distancia;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public Vertice getPai() {
		return pai;
	}
	
	public void setPai(Vertice pai) {
		this.pai = pai;
	}
	
	public boolean isVisitado() {
		return visitado;
	}
	
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public ArrayList<Aresta> getIncidentes() {
		return incidentes;
	}
	
	public void addIncidentes(Aresta incide) {
		this.incidentes.add(incide);
		
		//adicionando vizinhos a lista
		if ( (incide.getOrigem().getNome().equals(this.getNome())) &&
				(!this.isVizinho(incide.getDestino())) ){
			
			this.addVizinhos(incide.getDestino());
			
		}else if ( (incide.getDestino().getNome().equals(this.getNome())) &&
				(!this.isVizinho(incide.getOrigem())) ){
			
			this.addVizinhos(incide.getOrigem());
		}
	}
	
	public void addVizinhos(Vertice vizinho) {
		this.vizinhos.add(vizinho);
	}

	public ArrayList<Vertice> getVizinhos() {
		return vizinhos;
	}
	
	public boolean isVizinho(Vertice vizinho){
		int i;
		
		for (i=0; i<this.vizinhos.size() ; i++)
			if (this.vizinhos.get(i).getNome().equals(vizinho.getNome()))
				return true;		
		
		return false;
	}
	

	@Override
	public int compareTo(Vertice vertice) {
		
        if(this.getDistancia() < vertice.getDistancia()) 
        	return -1;
        else if(this.getDistancia() == vertice.getDistancia()) 
        	return 0;

        return 1;  
	}

	@Override
	public String toString() {
		String s = " ";
		s+= this.getNome();
		return s;
	}
	 
}
