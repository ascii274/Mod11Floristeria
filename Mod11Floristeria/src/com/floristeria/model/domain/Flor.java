package com.floristeria.model.domain;

public class Flor extends Productes {
	private String color;

	public Flor(double preu, String color) {
		super(preu);
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
		return "Flor [ Color:" + color + " , preu:" + super.getPreu() + " euros]";
	}
	
	
}
