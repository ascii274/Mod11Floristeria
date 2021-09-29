package com.floristeria.view;

public class Utilities {

	
	public void checkField(String field, String input) {
		if (input.isEmpty()) {
			throw new RuntimeException("El camp " + field + ". No pot esta buit.");
		}
	}
	
}
