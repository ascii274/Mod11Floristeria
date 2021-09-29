package com.floristeria.model.domain;

/**
 * 
 * @author Carles
 * @author Joel
 * 
 * @branch joel_01 
 *
 */

public class Decoracion extends Productes {
	private TipusMaterial tipusMaterial;

	public Decoracion(double preu, TipusMaterial tipusMaterial) {
		super(preu);
		this.tipusMaterial = tipusMaterial;
	}

	public TipusMaterial getTipusMaterial() {
		return tipusMaterial;
	}

	public void setTipusMaterial(TipusMaterial tipusMaterial) {
		this.tipusMaterial = tipusMaterial;
	}
	
	/**
	 * Mostra les dades del arbre
	 */
	public String toString() {
		return "Decoració [ Material:" +tipusMaterial + " , preu:" + super.getPreu() + " euros]";
	}
	
}
