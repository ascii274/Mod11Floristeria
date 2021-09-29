package com.floristeria.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ViewFloristeria extends JFrame {

	private JLabel nameLabel;
	JTextField nomFloristeria;
	private JButton afegirFloristeria = new JButton("Crear Floristeria");

	public ViewFloristeria() {
		
		
		this.setBounds(100, 100, 500, 500);
		setTitle("Floristeria");
		
		
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
		//Creem els camps per informar 
		Font miFuente = new Font("Arial", Font.BOLD, 20);
		setLayout(null);				

		//Creem el text que posa el nom del rocket
		nameLabel = new JLabel( "Nombre Floristeria ", SwingConstants.CENTER);
		nameLabel.setFont(miFuente);
		nameLabel.setForeground(Color.RED);
		nameLabel.setBounds(0, 0, 600, 100);				
		this.add(nameLabel);
		
		 nomFloristeria = new JTextField();
		nomFloristeria.setFont(miFuente);
		nomFloristeria.setForeground(Color.BLACK);
		nomFloristeria.setBounds(50, 100, 300, 50);			
		this.add(nomFloristeria);

		
		
		//*************** Disseny Boton ***************
		// Pintem el botó d'arrancar
		afegirFloristeria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				accioBotons(e);
			}
		});
		afegirFloristeria.setBounds(100, 40, 100, 40);
		add(afegirFloristeria);
		
	}
	
	protected void accioBotons(ActionEvent e) {
		if (e.getSource() == afegirFloristeria) {
			String nomFloris= nomFloristeria.getText();
			System.out.println(nomFloris);
			this.setTitle("Floristeria "+ nomFloris);
			

		}
		
		
	}
}
