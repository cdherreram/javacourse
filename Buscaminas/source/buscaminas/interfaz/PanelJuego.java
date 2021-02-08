package buscaminas.interfaz;

import javax.swing.*;

import buscaminas.mundo.Nivel;

import java.awt.*;

public class PanelJuego extends JPanel {
	
	private Nivel nivel;
	
	public PanelJuego(Nivel nivel) {
		setFocusable(true);
		requestFocusInWindow();
		
		this.nivel = nivel;
		dibujarPanel(this.nivel);
	}


	private void dibujarPanel(Nivel nivel) {
		int numFilas = nivel.getCasillasFilas();
		int numColumnas = nivel.getCasillasColumnas();
		
		//Se configura el layout
		GridLayout layout = new GridLayout(numFilas, numColumnas);
		setLayout(layout);
		
		for ( int i = 0; i < numFilas; i++) {
			for ( int j = 0; j < numColumnas; j++) {
				BotonJuego boton = new BotonJuego();
				add(boton);
			}
		}
	}
	
	
}
