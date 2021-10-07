package com.floristeria.model.domain;

/**
 * 
 * @author Carles
 * @author Joel
 * 
 * @branch joel_01 
 *
 */

public class Decoracion extends Producte {
	
	private  int idProducte;
	private TipusMaterial tipusMaterial;
	private int stock;

	public Decoracion(double preu, TipusMaterial tipusMaterial, int stock) {
		super(preu, stock);
		this.idProducte = super.getIdProducte();
		this.tipusMaterial = tipusMaterial;
		this.stock = stock;
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
		return "Decoració [ID:" + idProducte + " ,Material:" +tipusMaterial + " ,Preu:" 
						+ super.getPreu() + " euros, Stock:" + super.getStock() + "]";
	}
	
	@Override
	// retorna string sense stock per el tickets
	public String toStringSenseStock() {
		return "Decoració [ID:" + idProducte + " ,Material:" +tipusMaterial + " ,Preu:" +super.getPreu();
	}
	
}
