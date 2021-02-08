package buscaminas.interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class PanelBotones extends JPanel{
	
	JButton iniciarJuego;
	JButton cambiarNivel;
	
	public PanelBotones() {
		GridLayout layout = new GridLayout(2,1, 5,5);
		setLayout(layout);
		
		iniciarJuego = new JButton("Reiniciar");
		cambiarNivel = new JButton("Cambiar nivel");
		
		add(iniciarJuego);
		add(cambiarNivel);
	}
}
