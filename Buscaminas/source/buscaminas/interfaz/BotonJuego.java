package buscaminas.interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class BotonJuego extends JButton {
	
	public final static int CASILLA_DESCUBIERTA = 0;
	public final static int CASILLA_CUBIERTA = 1;
	
	private int estado;
	private JLabel icono;
	
	public BotonJuego() {
		Dimension d = new Dimension(30,30);
		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);
		LineBorder borde = new LineBorder(Color.GRAY, 2, true);
		setBorder(borde);
		inicializarBoton();
	}

	private void inicializarBoton() {
		estado = CASILLA_CUBIERTA;
		icono = new JLabel("");
		setEnabled(true);
	}
	
	
}
