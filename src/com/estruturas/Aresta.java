package com.estruturas;

public class Aresta {

	private int peso;
	private String origem;
	private String destino;
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

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

}