package buscaminas.mundo;

import java.util.*;
import java.util.stream.Stream;

public class Buscaminas {
	
	private Casilla[][] tablero;
	private Nivel nivelJuego;
	private int semilla;
	private int numFilas;
	private int numColumnas;
	
	public Buscaminas(int semilla) {
		this.semilla = semilla;
		nivelJuego = Nivel.PRINCIPIANTE;
		numFilas = nivelJuego.getCasillasFilas();
		numColumnas = nivelJuego.getCasillasColumnas();
		
		tablero = new Casilla[numFilas][numColumnas];
		int conteoBombas = 0;
		
		//Creación de casillas y asignación de bombas
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
		
		//TODO: Mejorar implementación para elegir aleatoriamente las casillas de las bombas
		
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
		
		
		//Impresión del tablero
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
	
	public static void main(String[] args) {
		Buscaminas buscaminas = new Buscaminas(5);
	}
}
