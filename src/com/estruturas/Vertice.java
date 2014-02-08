package com.estruturas;

import java.util.ArrayList;

public class Vertice implements Comparable<Vertice> {
	private String nome;
	private int distancia;
	private Vertice pai;
	private ArrayList<Aresta> incidentes = new ArrayList<Aresta>();
	private boolean visitado = false;
	
	//private String descricao;
    
    //private List<Aresta> arestas = new ArrayList<Aresta>();
    //private List<Vertice> vizinhos = new ArrayList<Vertice>();
	
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
