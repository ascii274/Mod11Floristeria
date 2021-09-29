package com.floristeria.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.floristeria.model.domain.Floristeria;

public class ViewDades extends JPanel {
 
	Floristeria floristeria;

	public ViewDades(Floristeria floristeria) {
		this.floristeria = floristeria;
		
		Font miFuente = new Font("Arial", Font.BOLD, 20);
		

		// Creem la label/columna del noms de propulsors
		JLabel nomFloristeria = new JLabel("Floristeria " + floristeria.toString(), SwingConstants.LEFT);
		nomFloristeria.setFont(miFuente);
		nomFloristeria.setForeground(Color.BLACK);
		nomFloristeria.setBounds(10, 150, 140, 50);
		this.add(nomFloristeria);
		
		//fem visible el marc
		setVisible(true); 
	}

}
