package com.floristeria.model.view;

import javax.swing.plaf.metal.MetalTabbedPaneUI;

import com.floristeria.controller.ProductesController;
import com.floristeria.model.domain.Floristeria;
import com.floristeria.model.domain.TipusMaterial;

public class Main {

	public static void main(String[] args) {
		ProductesController productesController = new ProductesController();
		Floristeria floristeria;
		try {
			// alta floristeria
			floristeria = new Floristeria("Floristeria Java");
			
			// alta arbre
			productesController.creaArbre(20.30, 180);
			productesController.creaArbre(17.30, 110);
			productesController.creaArbre(10.15, 165);
			
			// alta flor
			productesController.creaFlor(3.60, "Rosa");
			productesController.creaFlor(1.50, "Blanc");
			productesController.creaFlor(2.00, "Groc");
			
			// alta decoracio
			productesController.creaDecoracio(36.30, TipusMaterial.FUSTA);
			productesController.creaDecoracio(3.80, TipusMaterial.PLASTIC);
			productesController.creaDecoracio(12.39, TipusMaterial.PLASTIC);
			
			
			// mostrem dades 
			System.out.println(floristeria.toString());
			productesController.obtenirStock();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
