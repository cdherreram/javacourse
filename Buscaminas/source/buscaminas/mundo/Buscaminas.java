package buscaminas.mundo;

import java.util.*;
import java.util.stream.Stream;

public class Buscaminas {
	
	private Casilla[][] tablero;
	private Nivel nivelJuego;
	private int numFilas;
	private int numColumnas;
	
	public Buscaminas() {
		nivelJuego = Nivel.PRINCIPIANTE;
		numFilas = nivelJuego.getCasillasFilas();
		numColumnas = nivelJuego.getCasillasColumnas();
		
		tablero = new Casilla[numFilas][numColumnas];
		
		//Inicializar el juego
		inicializar();
	}
	
	public Buscaminas(Nivel pNivel) {
		nivelJuego = pNivel;
		numFilas = nivelJuego.getCasillasFilas();
		numColumnas = nivelJuego.getCasillasColumnas();
		
		tablero = new Casilla[numFilas][numColumnas];
		
		//Inicializar el juego
		inicializar();
	}
	
	/*
	 * M�todos
	 */
	
	public Casilla getCasilla ( int fila, int columna) {
		return tablero[fila][columna];
	}

	public Nivel getNivelJuego() {
		return nivelJuego;
	}

	public void setNivelJuego(Nivel nivelJuego) {
		this.nivelJuego = nivelJuego;
	}

	public int getNumFilas() {
		return numFilas;
	}

	public int getNumColumnas() {
		return numColumnas;
	}
	
	public void inicializar() {
		inicializarBombas();

		//TODO: Mejorar implementaci�n para elegir aleatoriamente las casillas de las bombas

		//Conteo de bombas para inicializar el tablero
		for ( int i = 0; i < numFilas; i++) {
			for ( int j = 0; j < numColumnas; j++) {
				if ( !tablero[i][j].isConBomba()) {
					int conteo = 0; //Conteo de bombas alrededor de la casilla
					//Realiza conteo
					conteo += conteo(i,j+1); //Derecha
					conteo += conteo(i+1,j+1); //Inferior derecha
					conteo += conteo(i+1,j); //Abajo
					conteo += conteo(i+1,j-1); //Inferior izquierda
					conteo += conteo(i,j-1); //Izquierda
					conteo += conteo(i-1, j-1); //Superior izquierda
					conteo += conteo(i-1,j); //Superior
					conteo += conteo(i-1,j+1); //Superior derecha 
					tablero[i][j].setNumBombasAlrededor(conteo);
				}
			}
		}
//		imprimirTablero();
	}
	
	private void inicializarBombas() {
		int conteoBombas = 0;
		//Creaci�n de casillas y asignaci�n de bombas
		for(int i = 0; i < numFilas; i++) {
			for ( int j = 0; j < numColumnas; j++) {
				tablero[i][j] = new Casilla(false, 0);
				double numCasillasTotal = numFilas * numColumnas;
				double aleatorio = Math.random();
				if (conteoBombas < nivelJuego.getNumBombas() ) {
					if (aleatorio > 0.75) {
						tablero[i][j].setConBomba(true);
						conteoBombas++;
					}
				}
			}
		}
	}

	private void imprimirTablero() {
		for ( int i = 0; i < numFilas;i++) {
			for ( int j = 0; j < numColumnas; j++) {
				int num = tablero[i][j].getNumBombasAlrededor();
				boolean hayBomba = tablero[i][j].isConBomba();
				if ( hayBomba ) {
					System.out.print("*" + " | ");
				} else {
					System.out.print(num + " | ");
				}
			}
			System.out.println();
		}
	}
	
	private int conteo(int posFilas, int posColumnas) {
		if ( posFilas >= 0 && posFilas < numFilas && posColumnas >= 0 && posColumnas < numColumnas)
			return tablero[posFilas][posColumnas].isConBomba() ? 1 : 0;
		return 0;
	}
	
	
}
