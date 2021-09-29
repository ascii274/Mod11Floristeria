package com.floristeria.controller;

import java.util.List;

import com.floristeria.model.domain.Arbre;
import com.floristeria.model.domain.Decoracion;
import com.floristeria.model.domain.Flor;
import com.floristeria.model.domain.Productes;
import com.floristeria.model.domain.TipusMaterial;
import com.floristeria.model.persistance.ProductesRepository;

public class ProductesController {
	/*
	 * - Aquí crearem les instancies:
	 * - afegirArbre
	 * - afegirFlor
	 * - afegirDecoracio
	 * - mostrarDadesProductes (arbres, flores i decoració)
	 */
	
	ProductesRepository productesRepository = new ProductesRepository();
	
	public ProductesController(){
		
	}
	
	/**
	 * Creacio 
	 * @throws Exception 
	 */
	public void creaFlor(double preu, String color) throws Exception {
		try {
			Flor flor = new Flor(preu, color);
			productesRepository.addProductes(flor);			
		} catch (Exception e) {
			System.out.println("Error al donar d'alta la Flor.");
		}
	}
	
	public void creaDecoracio(double preu,TipusMaterial tipusMaterial) throws Exception{
		try {
			Decoracion decoracion = new Decoracion(preu, tipusMaterial);
			productesRepository.addProductes(decoracion);
			
		} catch (Exception e) {
			System.out.println("Error al donar d'alta la Decoració");
		}
	}
	
	public void creaArbre(double preu, int alzada) throws Exception{
		try {
			Arbre arbre = new Arbre(preu,alzada);			
			productesRepository.addProductes(arbre);
		} catch (Exception e) {
			System.out.print("Error al donar d'atal l'arbre.");
		}
	}
	
	/**
	 * - Mostrem tots el productes
	 */
	public void obtenirStock() {
		List<Productes> productes = productesRepository.getAllProductes();		
		productes.stream().forEach(v->System.out.println(v));
//		productes.stream().forEach(System.out::println);
	}
	
	

}
