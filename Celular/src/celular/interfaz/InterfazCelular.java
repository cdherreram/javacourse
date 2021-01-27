package celular.interfaz;

import javax.swing.*;
import java.awt.*;

public class InterfazCelular extends JFrame {
	
	/*
	 * Atributos
	 */
	JLabel nombre;
	JTextField cuadroDeTexto;
	JButton boton;
	PanelNuevo nuevoPanel;
	
	/*
	 * Constructor
	 */
	public InterfazCelular() {
		
		this.setLayout(new GridLayout(2,3));
		this.setResizable(false);
		
		nuevoPanel = new PanelNuevo();
		
		nombre = new JLabel("Cristian");
		cuadroDeTexto = new JTextField("Aquí está el cuadro");
		cuadroDeTexto.setEditable(false);
		
		boton = new JButton();
		
		Dimension d = new Dimension(30,15);
		cuadroDeTexto.setPreferredSize(d);
		//cuadroDeTexto.setSize( d ); //  .setSize( new Dimension());
		this.add(nombre);
		this.add(cuadroDeTexto);
		this.add(boton);
		this.add(nuevoPanel);
	}

	public static void main(String[] args) {
		InterfazCelular i = new InterfazCelular();
		i.setVisible(true);
		i.setTitle("Celular");
		i.setBounds(200, 80, 500, 500);
	}
}
