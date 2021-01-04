/**
 * 
 */
package cajon.mundo;

import java.io.*;
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
	
	public CajonFiguras ( ) {
		figuras = new ArrayList<Figura>();
	}
	
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
		if ( figuras.isEmpty()) return "No hay figuras";
		
		Figura figuraTmp = figuras.get(0);
		double perimetroMayor = figuraTmp.calcularPerimetro();
		int indice = 0;
		int lados = figuras.get(0).getNumLados();
		
		for ( int i = 0; i < figuras.size(); i++) {
			if(figuras.get(i).calcularPerimetro() > perimetroMayor) {
				figuraTmp = figuras.get(i);
				perimetroMayor = figuras.get(i).calcularPerimetro();
				indice = i;
				lados = figuras.get(i).getNumLados();
			}
		}
		
		return "La figura con mayor perímetro tiene " + lados + " lados, perimetro de "
				+ perimetroMayor + " y está en la posicion " + indice;
	}
	
	/**
	 * Determina la figura con mayor perímetro entre dos figuras dadas por
	 * parámetro.
	 * @param pFigura1, pFigura2 Figuras a comparar
	 * @return Número de lados, perímetro y número de figura (Figura 1 o Figura 2).
	 */
	public String figuraConMayorPerimetro ( Figura pFigura1, Figura pFigura2) {
		//TODO: Completar el método de acuerdo a la documentación.
		if ( pFigura1.calcularPerimetro() > pFigura2.calcularPerimetro()) {
			return "La figura con mayor perimetro es la figura 1 y tiene " +
					pFigura1.calcularPerimetro() + " de perimetro y " +
					pFigura1.getNumLados() + " lados.";
		} else if ( pFigura1.calcularPerimetro() < pFigura2.calcularPerimetro() ) {
			return "La figura con mayor perimetro es la figura 2 y tiene " +
					pFigura2.calcularPerimetro() + " de perimetro y " +
					pFigura2.getNumLados() + " lados.";
		} else {
			return "Ambas figuras tienen el mismo perímetro.";
		}
	}
	
	/**
	 * Calcula la cantidad de figuras que hay en el ArrayList figuras.
	 * @return Número de figuras.
	 */
	public int calcularNumFiguras() {
		//TODO: Completar el método de acuerdo a la documentación.
		return figuras.size();
	}
	
	/**
	 * Calcula la cantidad de figuras de número de lados dado por parámetro
	 * que hay en el ArrayList figuras 
	 * @param pNumLados Número de lados de las figuras que se buscan
	 * @return Número de figuras.
	 */
	public int calcularNumFiguras(int pNumLados) {
		//TODO: Completar el método de acuerdo a la documentación.
		int contador = 0;
		
		for ( int i = 0; i < figuras.size(); i++) {
			if ( figuras.get(i).getNumLados() == pNumLados) {
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * Adiciona una figura al ArrayList figuras.
	 * @param pFigura Figura a adicionar
	 */
	public void adicionarFigura ( Figura pFigura) {
		//TODO: Completar el método de acuerdo a la documentación.
		figuras.add(pFigura);
	}
	
	/**
	 * Adiciona una figura al ArrayList figuras.
	 * @param pNumLados Número de lados de la figura a adicionar
	 * @param puntos Array primitivo con la lista de vértices de la figura. Debe coincidir con el número de lados de la figura
	 */
	public void adicionarFigura (int pNumLados, Punto[] puntos) {
		//TODO: Completar el método de acuerdo a la documentación.
		Figura f = new Figura(pNumLados, puntos);
		if ( f != null) {
			figuras.add(f);
		} else {
			System.out.println("No se pudo adicionar figura.");
		}
	}
	
	
	//TODO: Contar la cantidad de triángulos en el cajón de figuras.
	
	//-----------------
	// Main del proyecto
	//-----------------
	
	/**
	 * Main del proyecto CajonFiguras.
	 * @param args No es necesario.
	 */
	public static void main(String[] args) {
		CajonFiguras cajon = new CajonFiguras();
		System.out.println(cajon.figuraConMayorPerimetro());
		Figura figura1 = new Figura();
		System.out.println(figura1);
		cajon.adicionarFigura(figura1);
		figura1 = new Figura(3, 0,0, 0, 5, 5,0);
		System.out.println(figura1);
		cajon.adicionarFigura(figura1);
		figura1 = new Figura(3, 0,3,6,-3,-2,-5);
		System.out.println(figura1);
		cajon.adicionarFigura(figura1);
		System.out.println("Hay " + cajon.calcularNumFiguras() + " figuras.");
		System.out.println(cajon.figuraConMayorPerimetro());
	}
}
