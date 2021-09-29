package com.floristeria.model.domain;

public class Arbre extends Productes {
	private int alzada;

	public Arbre(double preu, int alzada) {
		super(preu);
		this.alzada = alzada;
	}

	public int getAlzada() {
		return alzada;
	}

	public void setAlsada(int alsada) {
		this.alzada = alsada;
	}
	
	/**
	 * Mostra les dades del arbre
	 */
	public String toString() {
		return "Arbre [ Alçada:" + alzada + " cm , preu:" + super.getPreu() + " euros]";
	}
}
