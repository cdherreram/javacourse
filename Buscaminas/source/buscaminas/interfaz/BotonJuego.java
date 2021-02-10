package buscaminas.interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import buscaminas.mundo.*;

public class BotonJuego extends JButton {
	
	public final static int CASILLA_DESCUBIERTA = 0;
	public final static int CASILLA_CUBIERTA = 1;
	
	private int estado;
	private JLabel icono;
	private Casilla casillaBoton;
	
	public BotonJuego( Casilla casilla) {
		Dimension d = new Dimension(25,25);
		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);
		LineBorder borde = new LineBorder(Color.GRAY, 2, true);
		setBorder(borde);
		casillaBoton = casilla;
		icono = new JLabel();
		add(icono);
		inicializarCasilla();
	}
	
	public void inicializarCasilla ( ) {
		estado = CASILLA_CUBIERTA;
		icono = new JLabel("");
		setText("");
		setIcon(null);
		setEnabled(true);
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public JLabel getIcono() {
		return icono;
	}

	public void setIcono(JLabel icono) {
		this.icono = icono;
	}

	public Casilla getCasillaBoton() {
		return casillaBoton;
	}

	public void setCasillaBoton(Casilla casillaBoton) {
		this.casillaBoton = casillaBoton;
	}
	
	public void actualizarBoton( ) {
		if ( estado == CASILLA_DESCUBIERTA ) {
			this.setEnabled(false);
			if ( casillaBoton.isConBomba()) {
				setIcon( new ImageIcon("img/bomba.png"));
			} else {
				Font fuente = new Font("Calibri", 3, 18);
				setFont(fuente);
				setText(casillaBoton.getNumBombasAlrededor() + "");
			}
		} else if ( estado == CASILLA_CUBIERTA ){
			this.setEnabled(true);
		}
	}
	
	
}
