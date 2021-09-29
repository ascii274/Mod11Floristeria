package com.floristeria.model.domain;

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
	
	
	
}
