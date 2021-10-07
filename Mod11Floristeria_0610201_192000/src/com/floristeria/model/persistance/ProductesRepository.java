package com.floristeria.model.persistance;

import java.util.ArrayList;
import java.util.List;

import com.floristeria.model.domain.Producte;

public class ProductesRepository {
	private List<Producte> productes = new ArrayList<Producte>();// para que acceder desde ticketCotnroller
	
	public ProductesRepository() {
		
	}
	
	public List<Producte> getAllProductes(){
		return new ArrayList<>(productes);
	}
	
	public void addProductes(Producte producte) throws Exception{
		if(producte==null) throw new Exception();
		productes.add(producte);		
	}

	public void setAllProductes(List<Producte> productes) {
		this.productes = productes;
	}
	
	

}
