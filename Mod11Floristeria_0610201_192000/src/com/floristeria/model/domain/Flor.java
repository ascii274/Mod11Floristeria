package com.floristeria.model.domain;

public class Flor extends Producte {
	private  int idProducte;
	private String color;
	
	

	public Flor(double preu, String color, int stock) {
		super(preu , stock);
		this.idProducte = super.getIdProducte();
		this.color = color;
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	/**
	 * Mostra les dades de la flor
	 */
	public String toString() {
		return "Flor [ID: " + idProducte + " ,Color:" + color + " ,Preu:" 
							+ super.getPreu() + " euros, Stock:" +super.getStock() + "]";
	}
	
	@Override
	// retorna string sense stock per el tickets
	public String toStringSenseStock() {
		return "Flor [ID: " + idProducte + " ,Color:" + color + " ,Preu:" 
				+ super.getPreu() + " euros";
	}
	
	
	
}
