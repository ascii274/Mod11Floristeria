package com.floristeria.model.domain;

public class Producte {
	
	private int idProducte=0;
	private static int idSiguiente=1;
	private double preu;
	private int stock;
	public Producte(double preu, int stock) {
		
		this.idProducte = idSiguiente;
		this.preu = preu;
		this.stock = stock;
		idSiguiente ++;
	}

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	public int getIdProducte() {
		return idProducte;
	}

	public int getStock() {
		return stock;
	}
}
