/**
 * 
 */
package cajon.mundo;

import java.io.*;
import java.util.*;

/**
 * Clase que modela un caj�n de figuras.
 * @author Cristian David Herrera
 *
 */

public class CajonFiguras {

	private ArrayList<Figura> figuras;
	
	//----------------
	// Constructor
	//----------------
	
	//TODO: Escribir el c�digo del constructor que genere el ArrayList figuras
	// vac�o. Se debe documentar. No debe recibir nada por par�metro.
	
	public CajonFiguras ( ) {
		figuras = new ArrayList<Figura>();
	}
	
	//----------------
	// M�todos
	//----------------
	
	//TODO: No es necesario crear m�todos getter y setter en este caso.
	
	/**
	 * Determina la figura con mayor per�metro dentro del ArrayList figuras.
	 * @return N�mero de lados, per�metro y posici�n dentro del ArrayList.
	 */
	public String figuraConMayorPerimetro ( ) {
		//TODO: Completar el m�todo de acuerdo a la documentaci�n.
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
		
		return "La figura con mayor per�metro tiene " + lados + " lados, perimetro de "
				+ perimetroMayor + " y est� en la posicion " + indice;
	}
	
	/**
	 * Determina la figura con mayor per�metro entre dos figuras dadas por
	 * par�metro.
	 * @param pFigura1, pFigura2 Figuras a comparar
	 * @return N�mero de lados, per�metro y n�mero de figura (Figura 1 o Figura 2).
	 */
	public String figuraConMayorPerimetro ( Figura pFigura1, Figura pFigura2) {
		//TODO: Completar el m�todo de acuerdo a la documentaci�n.
		if ( pFigura1.calcularPerimetro() > pFigura2.calcularPerimetro()) {
			return "La figura con mayor perimetro es la figura 1 y tiene " +
					pFigura1.calcularPerimetro() + " de perimetro y " +
					pFigura1.getNumLados() + " lados.";
		} else if ( pFigura1.calcularPerimetro() < pFigura2.calcularPerimetro() ) {
			return "La figura con mayor perimetro es la figura 2 y tiene " +
					pFigura2.calcularPerimetro() + " de perimetro y " +
					pFigura2.getNumLados() + " lados.";
		} else {
			return "Ambas figuras tienen el mismo per�metro.";
		}
	}
	
	/**
	 * Calcula la cantidad de figuras que hay en el ArrayList figuras.
	 * @return N�mero de figuras.
	 */
	public int calcularNumFiguras() {
		//TODO: Completar el m�todo de acuerdo a la documentaci�n.
		return figuras.size();
	}
	
	/**
	 * Calcula la cantidad de figuras de n�mero de lados dado por par�metro
	 * que hay en el ArrayList figuras 
	 * @param pNumLados N�mero de lados de las figuras que se buscan
	 * @return N�mero de figuras.
	 */
	public int calcularNumFiguras(int pNumLados) {
		//TODO: Completar el m�todo de acuerdo a la documentaci�n.
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
		//TODO: Completar el m�todo de acuerdo a la documentaci�n.
		figuras.add(pFigura);
	}
	
	/**
	 * Adiciona una figura al ArrayList figuras.
	 * @param pNumLados N�mero de lados de la figura a adicionar
	 * @param puntos Array primitivo con la lista de v�rtices de la figura. Debe coincidir con el n�mero de lados de la figura
	 */
	public void adicionarFigura (int pNumLados, Punto[] puntos) {
		//TODO: Completar el m�todo de acuerdo a la documentaci�n.
		Figura f = new Figura(pNumLados, puntos);
		if ( f != null) {
			figuras.add(f);
		} else {
			System.out.println("No se pudo adicionar figura.");
		}
	}
	
	
	//TODO: Contar la cantidad de tri�ngulos en el caj�n de figuras.
	
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
