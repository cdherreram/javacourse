/**
 * 
 */
package cajon.mundo;

import java.util.*;

/**
 * Clase que modela un cajón de figuras.
 * @author Cristian David Herrera
 *
 */
public class CajonFiguras {

	private ArrayList<Figura> figuras;
	
	//----------------
	// Constructor
	//----------------
	
	//TODO: Escribir el código del constructor que genere el ArrayList figuras
	// vacío. Se debe documentar. No debe recibir nada por parámetro.
	
	
	//----------------
	// Métodos
	//----------------
	
	//TODO: No es necesario crear métodos getter y setter en este caso.
	
	/**
	 * Determina la figura con mayor perímetro dentro del ArrayList figuras.
	 * @return Número de lados, perímetro y posición dentro del ArrayList.
	 */
	public String figuraConMayorPerimetro ( ) {
		//TODO: Completar el método de acuerdo a la documentación.
		return " ";
	}
	
	/**
	 * Determina la figura con mayor perímetro entre dos figuras dadas por
	 * parámetro.
	 * @param pFigura1, pFigura2 Figuras a comparar
	 * @return Número de lados, perímetro y número de figura (Figura 1 o Figura 2).
	 */
	public String figuraConMayorPerimetro ( Figura pFigura1, Figura pFigura2) {
		//TODO: Completar el método de acuerdo a la documentación.
		return "";
	}
	
	/**
	 * Calcula la cantidad de figuras que hay en el ArrayList figuras.
	 * @return Número de figuras.
	 */
	public int calcularNumFiguras() {
		//TODO: Completar el método de acuerdo a la documentación.
		return 0;
	}
	
	/**
	 * Calcula la cantidad de figuras de número de lados dado por parámetro
	 * que hay en el ArrayList figuras 
	 * @param pNumLados Número de lados de las figuras que se buscan
	 * @return Número de figuras.
	 */
	public int calcularNumFiguras(int pNumLados) {
		//TODO: Completar el método de acuerdo a la documentación.
		return 0;
	}
	
	/**
	 * Adiciona una figura al ArrayList figuras.
	 * @param pFigura Figura a adicionar
	 */
	public void adicionarFigura ( Figura pFigura) {
		//TODO: Completar el método de acuerdo a la documentación.
	}
	
	/**
	 * Adiciona una figura al ArrayList figuras.
	 * @param pNumLados Número de lados de la figura a adicionar
	 * @param puntos Array primitivo con la lista de vértices de la figura. Debe coincidir con el número de lados de la figura
	 */
	public void adicionarFigura (int pNumLados, Punto[] puntos) {
		//TODO: Completar el método de acuerdo a la documentación.
	}
	
	
	//-----------------
	// Main del proyecto
	//-----------------
	
	/**
	 * Main del proyecto CajonFiguras.
	 * @param args No es necesario.
	 */
	public static void main(String[] args) {
		CajonFiguras cajon = new CajonFiguras();
		Figura figura1 = new Figura();
		
	}

}
