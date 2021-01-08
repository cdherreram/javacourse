package cajon.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import cajon.mundo.*;

public class PanelBotones extends JPanel implements ActionListener {
	/*
	 * Constantes
	 */
	
	public final static String FIGURA_MAYOR_PERIMETRO = "Figura Mayor Perímetro";
	public final static String FIGURA_MENOR_PERIMETRO = "Figura Menor Perímetro";
	public final static String TRES_FIGURAS_MAYOR_PERIMETRO = "Tres figuras con mayor perímetro";
	public final static String PERIMETRO_MAYOR_A = "Perímetro mayor a";
	
	/*
	 * Atributos
	 */
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	
	private InterfazCajonFiguras principal;

	/**
	 * Create the panel.
	 */
	public PanelBotones(InterfazCajonFiguras interfaz) {
		principal = interfaz;
		setLayout(new GridLayout(2,2));
		
		boton1 = new JButton("Figura Mayor Perímetro");
		boton1.setActionCommand(FIGURA_MAYOR_PERIMETRO);
		boton1.addActionListener(this);
		boton2 = new JButton("Figura Menor Perímetro");
		boton2.setActionCommand(FIGURA_MENOR_PERIMETRO);
		boton2.addActionListener(this);
		boton3 = new JButton("Opción 1");
		boton3.setActionCommand(TRES_FIGURAS_MAYOR_PERIMETRO);
		boton3.addActionListener(this);
		boton4 = new JButton("Opción 2");
		boton4.setActionCommand(PERIMETRO_MAYOR_A);
		boton4.addActionListener(this);
		
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand() == FIGURA_MAYOR_PERIMETRO) {
			JOptionPane.showMessageDialog(this, principal.getCajonFiguras().figuraConMayorPerimetro());
		}
		if ( e.getActionCommand() == FIGURA_MENOR_PERIMETRO) {
			JOptionPane.showMessageDialog(this, principal.getCajonFiguras().figuraConMenorPerimetro());
		}
		if ( e.getActionCommand() == TRES_FIGURAS_MAYOR_PERIMETRO) {
			JOptionPane.showMessageDialog(this, principal.getCajonFiguras().figurasConMayorPerimetro());
		}
		if ( e.getActionCommand() == PERIMETRO_MAYOR_A) {
			String recibido = JOptionPane.showInputDialog("Determine el perímetro mínimo:");
			try {
				double perimetro = Double.parseDouble(recibido);
				JOptionPane.showMessageDialog(this, principal.getCajonFiguras().contarFigurasConPerimetroMayorA(perimetro));
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "El valor recibido no es válido");
			}
		}
		
	}

}
