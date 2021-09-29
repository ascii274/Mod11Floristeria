package com.floristeria.model.persistance;

import java.util.ArrayList;
import java.util.List;

import com.floristeria.model.domain.Productes;

public class ProductesRepository {
	private List<Productes> productes = new ArrayList<Productes>();
	
	public ProductesRepository() {
		
	}
	
	public List<Productes> getAllProductes(){
		return new ArrayList<>(productes);
	}
	
	public void addProductes(Productes producte) throws Exception{
		if(producte==null) throw new Exception();
		productes.add(producte);
		
	}

}
