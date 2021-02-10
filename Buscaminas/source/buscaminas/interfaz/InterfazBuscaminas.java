package buscaminas.interfaz;

import javax.swing.*;
import java.awt.*;
import buscaminas.mundo.*;

public class InterfazBuscaminas extends JFrame {
	
	public final static Dimension NPRINCIPIANTE = new Dimension(350,250);
	public final static Dimension NINTERMEDIO = new Dimension(540,450);
	public final static Dimension NEXPERTO = new Dimension(890,450);
	public final static Point LOCACION = new Point(200,50);
	
	PanelJuego panelJuego;
	PanelBotones panelBotones;
	Buscaminas buscaminas;
	
	public InterfazBuscaminas() {
		setTitle("Buscaminas");
		setResizable(false);
		setSize(NPRINCIPIANTE);
		setLocation(LOCACION);
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		panelBotones = new PanelBotones(this);
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
	
	public void inicializarJuego() {
		buscaminas = new Buscaminas();
		panelJuego.setBuscaminas(buscaminas);
		panelJuego.reiniciarBotones();
	}
	
	public void inicializarJuego(Nivel pNivel) {
		panelJuego.removeAll();
		this.remove(panelJuego);
		this.repaint();
		this.revalidate();
		if (pNivel.equals(Nivel.PRINCIPIANTE))
			this.setSize(NPRINCIPIANTE);
		else if ( pNivel.equals(Nivel.INTERMEDIO))
			this.setSize(NINTERMEDIO);
		else if ( pNivel.equals(Nivel.EXPERTO))
			this.setSize(NEXPERTO);
		this.setLocation(LOCACION);
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
		this.repaint();
		this.revalidate();
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
