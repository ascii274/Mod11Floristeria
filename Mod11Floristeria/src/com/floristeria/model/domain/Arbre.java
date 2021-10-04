package com.floristeria.model.domain;

public class Arbre extends Producte {
	private  int idProducte;
	private int alzada;	
	

	public Arbre(double preu, int alzada, int stock) {		
		super(preu, stock);
		this.idProducte = super.getIdProducte();
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
		return "Arbre [ID:" + idProducte + " ,Alçada:" + alzada + " cm, Preu:" 
						+ super.getPreu() + " euros, Stock:" + super.getStock() + "]";
	}
}
