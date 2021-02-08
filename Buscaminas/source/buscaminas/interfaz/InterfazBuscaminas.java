package buscaminas.interfaz;

import javax.swing.*;
import java.awt.*;
import buscaminas.mundo.*;

public class InterfazBuscaminas extends JFrame {
	
	PanelJuego panelJuego;
	PanelBotones panelBotones;
	Buscaminas buscaminas;
	
	public InterfazBuscaminas() {
		inicializarJuego();
	}
	
	private void inicializarJuego() {
		panelJuego = new PanelJuego(Nivel.PRINCIPIANTE);
		panelBotones = new PanelBotones();
		buscaminas = new Buscaminas(10);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Buscaminas");
		setVisible(true);
//		setResizable(false);
		setSize(400, 400);
		setLocation(100, 100);
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);

		GridBagConstraints constrains = new GridBagConstraints();
		constrains.insets = new Insets(3, 3, 3, 3);
		constrains.gridx = 0;
		constrains.gridy = 0;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		add(panelJuego,constrains);
		
		constrains.gridx = 1;
		constrains.gridy = 0;
		add(panelBotones,constrains);
	}
	
	
	public static void main(String[] args) {
		InterfazBuscaminas juego = new InterfazBuscaminas();
	}
	
}
