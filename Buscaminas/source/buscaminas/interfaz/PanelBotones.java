package buscaminas.interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;

import buscaminas.mundo.Nivel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBotones extends JPanel implements ActionListener{
	
	JButton iniciarJuego;
	JButton cambiarNivel;
	InterfazBuscaminas interfaz;
	
	public PanelBotones(InterfazBuscaminas principal) {
		GridLayout layout = new GridLayout(2,1, 5,5);
		setLayout(layout);
		
		interfaz = principal;
		
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
			interfaz.inicializarJuego();
		}
//		else if ( e.getSource() == cambiarNivel) {
//			VentanaNivel ventana = new VentanaNivel();
//			if ( ventana.getDefaultCloseOperation() == 1) {
//				interfaz.inicializar(ventana.getInfo());				
//			}
//		}
		
	}
}
