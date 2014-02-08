package com.estruturas;

public class Aresta {

	private int peso;
	private Vertice origem;
	private Vertice destino;
	private boolean pesoVerificado = false; // utilizada no método identificacao de pesos
	private boolean cicloVerificado = false; // utilizada no método identificacao de ciclos
	
	public Aresta(int peso, String origem, String destino) {
		this.setPeso(peso);
		this.setOrigem(origem);
		this.setDestino(destino);
	}
	
	public boolean isPesoVerificado() {
		return pesoVerificado;
	}

	public void setPesoVerificado(boolean verificado) {
		this.pesoVerificado = verificado;
	}

	public boolean isCicloVerificado() {
		return cicloVerificado;
	}

	public void setCicloVerificado(boolean cicloVerificado) {
		this.cicloVerificado = cicloVerificado;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Vertice getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		
		this.origem = new Vertice();
		this.origem.setNome(origem);
		this.origem.addIncidentes(this);
	}

	public Vertice getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		
		this.destino = new Vertice();
		this.destino.setNome(destino);
		this.destino.addIncidentes(this);
	}

}