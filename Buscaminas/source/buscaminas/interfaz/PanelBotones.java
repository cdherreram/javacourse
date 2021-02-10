package buscaminas.interfaz;

import javax.swing.*;
import javax.swing.border.*;
import buscaminas.mundo.*;
import java.awt.*;
import java.awt.event.*;

public class PanelBotones extends JPanel implements ActionListener{
	
	JButton iniciarJuego;
	JButton cambiarNivel;
	InterfazBuscaminas principal;
	
	public PanelBotones(InterfazBuscaminas interfaz) {
		GridLayout layout = new GridLayout(2,1, 5,5);
		setLayout(layout);
		
		principal = interfaz;
		
		iniciarJuego = new JButton("Reiniciar");
		iniciarJuego.addActionListener(this);
		cambiarNivel = new JButton("Cambiar nivel");
		cambiarNivel.addActionListener(this);
		
		add(iniciarJuego);
		add(cambiarNivel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == iniciarJuego) {
			principal.inicializarJuego(principal.getBuscaminas().getNivelJuego());
		}
		else if ( e.getSource() == cambiarNivel) {
			VentanaNivel ventana = new VentanaNivel(principal);
		}
		
	}
}
