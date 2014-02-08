package com.estruturas;

import java.util.ArrayList;

public class Vertice {
	private String nome;
	private ArrayList<Aresta> incidentes = new ArrayList<Aresta>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Aresta> getIncidentes() {
		return incidentes;
	}
	public void addIncidentes(Aresta incide) {
		this.incidentes.add(incide);
	}
	
}
