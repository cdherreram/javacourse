package buscaminas.interfaz;

import javax.swing.*;
import java.awt.*;
import buscaminas.mundo.*;

public class InterfazBuscaminas extends JFrame {
	
	PanelJuego panelJuego;
	PanelBotones panelBotones;
	Buscaminas buscaminas;
	
	public InterfazBuscaminas() {
		inicializarVentana();
		inicializarJuego();
	}
	
	
	public void inicializarVentana() {
		buscaminas = new Buscaminas();
		panelBotones = new PanelBotones(this);
		panelJuego = new PanelJuego(buscaminas);
		setTitle("Buscaminas");
//		setResizable(false);
		setSize(400, 400);
		setLocation(100, 100);
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
	}
	
	public void inicializar(Nivel nivel) {
		buscaminas.inicializar();
	}
	
	public void inicializarJuego() {
		buscaminas = new Buscaminas();
		panelJuego = new PanelJuego(buscaminas);
		panelJuego.dibujarPanel();
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
	
	public void inicializarJuego(Nivel pNivel) {
		buscaminas = new Buscaminas(pNivel);
		panelJuego = new PanelJuego(buscaminas);
		panelJuego.dibujarPanel(pNivel);
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
	
	public Buscaminas getBuscaminas() {
		return buscaminas;
	}
	
	public static void main(String[] args) {
		InterfazBuscaminas juego = new InterfazBuscaminas();
		juego.setDefaultCloseOperation(EXIT_ON_CLOSE);
		juego.setVisible(true);
	}
	
}
