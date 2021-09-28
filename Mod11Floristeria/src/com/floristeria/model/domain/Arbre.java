package com.floristeria.model.domain;

public class Arbre extends Productes {
	private int alzada;

	public Arbre(Double preu, int alzada) {
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
		return "Arbre[ Alçada:" + alzada + " , preu:" + super.getPreu() + "]";
	}
}
