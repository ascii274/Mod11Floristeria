package com.floristeria.controller;

import java.time.Year;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import javax.swing.JLabel;

import com.floristeria.model.domain.Arbre;
import com.floristeria.model.domain.Decoracion;
import com.floristeria.model.domain.Flor;
import com.floristeria.model.domain.Producte;
import com.floristeria.model.domain.TipusMaterial;
import com.floristeria.model.persistance.ProductesRepository;


public class ProductesController {
	
	ProductesRepository productesRepository = new ProductesRepository();
	
	public ProductesController(){
		
	}
	// ###########################
	// #     Inici Nivell 1
	// ###########################
	
	/**
	 * Creació de Flor i ho agrega al List<Producte>
	 * @throws Exception 
	 */
	public void creaFlor(double preu, String color, int stock) throws Exception {
		try {
			Flor flor = new Flor(preu, color, stock);
			productesRepository.addProductes(flor);			
		} catch (Exception e) {
			System.out.println("Error al donar d'alta la Flor.");
		}
	}
	
	/**
	 * - Creació de decoració i ho agrega al List<Producte>
	 * @param preu
	 * @param tipusMaterial
	 * @throws Exception
	 */
	
	public void creaDecoracio(double preu, TipusMaterial tipusMaterial, int stock) throws Exception{
		try {
			Decoracion decoracion = new Decoracion(preu, tipusMaterial, stock);
			productesRepository.addProductes(decoracion);
			
		} catch (Exception e) {
			System.out.println("Error al donar d'alta la Decoració");
		}
	}
	
	/**
	 * - Creació d'arbre i ho agrega al List<Producte>
	 * @param preu
	 * @param alzada
	 * @throws Exception
	 */
	public void creaArbre(double preu, int alzada, int stock) throws Exception{
		try {
			Arbre arbre = new Arbre(preu, alzada, stock);			
			productesRepository.addProductes(arbre);
		} catch (Exception e) {
			System.out.print("Error al donar d'atal l'arbre.");
		}
	}
	
	/**
	 * - Mostrem tots el productes per pantalla
	 */
	public String mostraStockPerPantalla() {
		List<Producte> productes = productesRepository.getAllProductes();		
//		productes.stream().forEach(v->System.out.println(v));
//		productes.stream().forEach(System.out::println);
		String resultat = "";//					
		for (Producte m : productes) {
			resultat += m.toStringSenseStock() + "\n";
		}
		return resultat;
	}
	
	
	
	// ###########################	
	// #  Fi Nivell 1
	// ###########################
	
	// ###########################
	// # Inici Nivell 2
	// ###########################
	/*
	 * Una floristeria ha de tenir un stock de cada un dels productes (arbres, flors i decoració) ->ok
     * La floristria ara té un registre del valor total del stock que te.  ->ok
     * Les flors tenen un color.-> ok, en el nivel 1
     * Retirar arbre -> ok amb metode borraProducte();
     * Retirar flor -> ok
     * Retirar decoració  -> ok
     * Printar per pantalla stock amb quantitats   -> ok
     * Printar per pantalla valor total de la floristeria. 
	 */
	

	
	
	/**
	 * - Esborra producte ( arbre, flor, decoracio ) 
	 * @param producte
	 */
	//public void borraProducte(Producte producte) {
	public void borraProducte(int idProducte) {
		List<Producte> productes = productesRepository.getAllProductes();
		//productes.removeIf(existeixProducte(producte));
		productes.removeIf( x-> x.getIdProducte()== idProducte );
	}
	
	/**
	 * - Comprobació si existeix el producte através de @param producte i retorna un Predicate
	 * @param producte
	 * @return
	 */
	public Predicate<Producte> existeixProducte(Producte producte){		
		return sproducte -> sproducte.equals(producte);
		//return sproducte -> sproducte.getIdProducte() == producte.getIdProducte();
	}
	
	
	// pintar per pantalla stock amb quatntitas
	
	public String mostraStocAmbQuantitats() {
		String resultat = "";
		List<Producte> productes = productesRepository.getAllProductes();		
		for (Producte p : productes) {
			resultat += p.toString()+ "\n";
		}
		return resultat;		
	}
	
	
	/**
	 * - Printar per pantalla valor total de la floristeria. 
	 * @return
	 */
	public double mostraValorTotalFloristeria() {
		List<Producte> productes = productesRepository.getAllProductes();
		return productes.stream().mapToDouble(v -> v.getPreu()*v.getStock() ) .sum();
//		double resultat =0;
//		for(Producte p:productes) {
//			resultat += p.getPreu() * p.getStock();			
//		}
//		return resultat;		
	}
	
	// ###########################	
	// #  Fi Nivell 2
	// ###########################
	
	// ###########################
	// # Inici Nivell 3
	// ###########################
	/**
	 * -Buscar el producte en el List i ho retorn si el troba si no un Null.
	 * @param idProducte
	 * @return
	 */
	public Producte buscaProductePerIdProducte(int idProducte) {
		List<Producte> productes = productesRepository.getAllProductes();
		//return productes.stream().filter( existeixCodiProducte(codigoBuscar).  );
		return productes.stream().filter( v->v.getIdProducte()==idProducte ).findAny().orElse(null);		
	}

	
	/**
	 * 
	 * - Mostrem tots el productes
	 * [CFV] Versió que retorna un String amb tots els productes 
	 */
	public String obtenirStock_toString() {
		String resultat = "";		
		List<Producte> productes = productesRepository.getAllProductes();		
		for (Producte m : productes) {
			resultat += m.toString()+ "\n";
		}
		return resultat;
	}
	
	
}
