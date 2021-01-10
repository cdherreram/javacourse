/**
 * 
 */
package cajon.mundo;

import java.io.*;
import java.util.*;
import java.text.*;

/**
 * Clase que modela un caj�n de figuras.
 * @author Cristian David Herrera
 *
 */

public class CajonFiguras {

	private ArrayList<Figura> figuras; //package -protected 
	DecimalFormat formato = new DecimalFormat("#.0");
	
	//----------------
	// Constructor
	//----------------
	
	//TODO: Escribir el c�digo del constructor que genere el ArrayList figuras
	// vac�o. Se debe documentar. No debe recibir nada por par�metro.
	
	public CajonFiguras ( ) {
		figuras = new ArrayList<Figura>();
		cargarTriangulos();
		cargarFiguras();
	}
	
	private void cargarFiguras() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/figuras.csv"));
			String linea;
			while ( (linea = br.readLine())!= null) {
				String[] datos = linea.split(";");
				int numLados = Integer.parseInt(datos[0]);
				Punto[] puntos = new Punto[numLados];
				for ( int i = 1; i < datos.length; i+=2) {
					int x = Integer.parseInt(datos[i]);
					int y = Integer.parseInt(datos[i+1]);
					Punto p = new Punto(x, y);
					puntos[(i-1)/2] = p;
				}
				Figura f = new Figura(numLados, puntos);
				figuras.add(f);
			}
		} catch (Exception e) {
			System.out.println("Hubo problema con la carga de datos.");
		}
	}

	private void cargarTriangulos() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/triangulos.csv"));
			String linea;
			while ( (linea = br.readLine())!= null) {
				String[] datos = linea.split(";");
				int numLados = Integer.parseInt(datos[0]);
				int x1 = Integer.parseInt(datos[1]);
				int y1 = Integer.parseInt(datos[2]);
				int x2 = Integer.parseInt(datos[3]);
				int y2 = Integer.parseInt(datos[4]);
				int x3 = Integer.parseInt(datos[5]);
				int y3 = Integer.parseInt(datos[6]);
				Figura f = new Figura(numLados, x1, y1, x2, y2, x3, y3);
				figuras.add(f);
			}
		} catch (Exception e) {
			System.out.println("Hubo problema con la carga de datos.");
		}
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
				+ formato.format(perimetroMayor) + " y est� en la posicion " + (indice +1);
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
	
	/**
	 * Retorna la lista de figuras
	 * @return Lista de figuras del caj�n
	 */
	public ArrayList darFiguras() {
		return figuras;
	}
	
	
	//TODO: Contar la cantidad de tri�ngulos en el caj�n de figuras.
	
	/**
	 * Retorna la cantidad de tri�ngulos que hay en el caj�n
	 * @return N�mero de tri�ngulos en el caj�n.
	 */
	public int darNumTriangulos() {
		int conteo = 0;
		for( Figura f : figuras) {
			if ( f.esTriangulo()) conteo++;
		}
		
		return conteo;
	}
	
	/**
	 * Determina la figura que tiene el menor per�metro
	 * @return Figura con el menor per�metro y su posici�n.
	 */
	public String figuraConMenorPerimetro( ) {
		if ( figuras.isEmpty()) return "No hay figuras";
		
		Figura figuraTmp = figuras.get(0);
		double perimetroMenor = figuraTmp.calcularPerimetro();
		int indice = 0;
		int lados = figuras.get(0).getNumLados();
		
		for ( int i = 0; i < figuras.size(); i++) {
			if(figuras.get(i).calcularPerimetro() < perimetroMenor) {
				figuraTmp = figuras.get(i);
				perimetroMenor = figuras.get(i).calcularPerimetro();
				indice = i;
				lados = figuras.get(i).getNumLados();
			}
		}
		return "La figura con menor per�metro tiene " + lados + " lados, perimetro de "
		+ formato.format(perimetroMenor) + " y est� en la posicion " + indice;
	}
	
	/**
	 * Retorna el per�metro de las tres figuras con el mayor per�metro
	 * en la lista figuras.
	 * @return String con los valores de los tres per�metros m�s grandes. Si no hay suficientes figuras, retorna que no pudo calcular.
	 */
	public String figurasConMayorPerimetro() {
		if ( figuras.size() <= 3)
			return "No se pudo determinar las figuras con mayor per�metro";
		
		List<Figura> figurasOrdenadas = (List<Figura>) figuras.clone();
		Collections.sort(figurasOrdenadas);
		
		// Sirve para hacer una iteraci�n e imprimir cada per�metro en la lista
		//figurasOrdenadas.stream().map(s -> s.calcularPerimetro()).forEach(System.out::println);
		
		return "Figura 1: " + formato.format(figurasOrdenadas.get(0).calcularPerimetro()) + "\n"
				+ "Figura 2: " + formato.format(figurasOrdenadas.get(1).calcularPerimetro()) + "\n"
				+ "Figura 3: " + formato.format(figurasOrdenadas.get(2).calcularPerimetro()) + "\n";
	}
	
	/**
	 * Cuenta la cantidad de figuras que tienen un per�metro mayor a un valor
	 * dado por par�metro.
	 * @param perimetroMin Per�metro m�nimo para comparar 
	 * @return Cantidad de figuras
	 */
	public int contarFigurasConPerimetroMayorA( double perimetroMin ){
		int contador = 0;
		for ( Figura f: figuras) {
			if ( f.calcularPerimetro() > perimetroMin) {
				contador++;
			}
		}
		
		return contador;
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
		System.out.println(cajon.figurasConMayorPerimetro());
		System.out.println("Hay " + cajon.contarFigurasConPerimetroMayorA(1000) +
				" figuras con un per�metro mayor a 1 000");
	}
}
