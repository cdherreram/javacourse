package buscaminas.interfaz;

import javax.swing.*;
import buscaminas.mundo.*;
import java.awt.*;
import java.awt.event.*;

public class PanelJuego extends JPanel implements ActionListener{
	
	public final static int JUEGO_INICIADO = 0;
	public final static int JUEGO_FINALIZADO = 1;
	
	private int estadoPanel;
	private Nivel nivel;
	private Buscaminas buscaminas;
	private int numFilas;
	private int numColumnas;
	private BotonJuego[][] mallaBotones;
	
	public PanelJuego(Buscaminas busc) {
		setFocusable(true);
		requestFocusInWindow();
		buscaminas = busc;
		estadoPanel = JUEGO_INICIADO;
		this.nivel = buscaminas.getNivelJuego();
	}
	
	public Buscaminas getBuscaminas() {
		return buscaminas;
	}

	public void setBuscaminas(Buscaminas buscaminas) {
		this.buscaminas = buscaminas;
	}

	public void dibujarPanel() {
		numFilas = nivel.getCasillasFilas();
		numColumnas = nivel.getCasillasColumnas();
		
		//Se configura el layout
		GridLayout layout = new GridLayout(numFilas, numColumnas);
		setLayout(layout);
		mallaBotones = new BotonJuego[numFilas][numColumnas];
		for ( int i = 0; i < numFilas; i++) {
			for ( int j = 0; j < numColumnas; j++) {
				mallaBotones[i][j] = new BotonJuego(buscaminas.getCasilla(i, j));
				mallaBotones[i][j].addActionListener(this);
				mallaBotones[i][j].setActionCommand(i + "," + j);
				add(mallaBotones[i][j]);
			}
		}
		reiniciarBotones();
	}
	
	public void reiniciarBotones() {
		for (int i = 0; i < numFilas; i++) {
			for (int j = 0; j < numColumnas; j++) {
				mallaBotones[i][j].setCasillaBoton(buscaminas.getCasilla(i, j));
				mallaBotones[i][j].inicializarCasilla();
			}
		}
	}
	
	public void dibujarPanel(Nivel nivel) {
		this.removeAll();
		this.nivel = nivel;
		numFilas = nivel.getCasillasFilas();
		numColumnas = nivel.getCasillasColumnas();
		
		//Se configura el layout
		GridLayout layout = new GridLayout(numFilas, numColumnas);
		setLayout(layout);
		mallaBotones = new BotonJuego[numFilas][numColumnas];
		for ( int i = 0; i < numFilas; i++) {
			for ( int j = 0; j < numColumnas; j++) {
				mallaBotones[i][j] = new BotonJuego(buscaminas.getCasilla(i, j));
				mallaBotones[i][j].addActionListener(this);
				mallaBotones[i][j].setActionCommand(i + "," + j);
				add(mallaBotones[i][j]);
			}
		}
		reiniciarBotones();
		actualizarPanel();
	}
	
	private void finalizarJuego() {
		for ( int i = 0; i < numFilas; i++) {
			for ( int j = 0; j < numColumnas ; j++) {
				mallaBotones[i][j].setEstado(BotonJuego.CASILLA_DESCUBIERTA);
			}
		}
	}
	
	private void actualizarPanel() {
		for ( int i = 0; i < numFilas; i++) {
			for ( int j = 0; j < numColumnas ; j++) {
				mallaBotones[i][j].actualizarBoton();
			}
		}
	}

	private void cambiarEstadosCasillas(int fila, int columna) {
		if ( fila >= 0 && fila < numFilas && columna >= 0 && columna < numColumnas && mallaBotones[fila][columna].getEstado() != BotonJuego.CASILLA_DESCUBIERTA) {
			BotonJuego botonActual = mallaBotones[fila][columna];
			botonActual.setEstado(BotonJuego.CASILLA_DESCUBIERTA);
			if ( botonActual.getCasillaBoton().getNumBombasAlrededor() == 0) {
				botonActual.setEstado(BotonJuego.CASILLA_DESCUBIERTA);
				cambiarEstadosCasillas(fila,columna+1); //Derecha
				cambiarEstadosCasillas(fila+1,columna); //Abajo
				cambiarEstadosCasillas(fila,columna-1); //Izquierda
				cambiarEstadosCasillas(fila-1,columna); //Superior
			} else {
				botonActual.setEstado(BotonJuego.CASILLA_DESCUBIERTA);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] casillas = e.getActionCommand().split(",");
		int fila = Integer.parseInt(casillas[0]);
		int columna = Integer.parseInt(casillas[1]);
		Casilla casillaActual = buscaminas.getCasilla(fila, columna);
		if ( casillaActual.isConBomba() ) {
			this.estadoPanel = JUEGO_FINALIZADO;
			finalizarJuego();
		} else {
			if ( casillaActual.getNumBombasAlrededor() > 0) {
				mallaBotones[fila][columna].setEstado(BotonJuego.CASILLA_DESCUBIERTA);
			} else {
				cambiarEstadosCasillas ( fila, columna);
			}
		}
		actualizarPanel();
	}
}
