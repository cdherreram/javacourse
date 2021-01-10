/**
 * 
 */
package cajon.mundo;

import java.io.*;
import java.util.*;
import java.text.*;

/**
 * Clase que modela un cajón de figuras.
 * @author Cristian David Herrera
 *
 */

public class CajonFiguras {

	private ArrayList<Figura> figuras; //package -protected 
	DecimalFormat formato = new DecimalFormat("#.0");
	
	//----------------
	// Constructor
	//----------------
	
	//TODO: Escribir el código del constructor que genere el ArrayList figuras
	// vacío. Se debe documentar. No debe recibir nada por parámetro.
	
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
				+ formato.format(perimetroMayor) + " y está en la posicion " + (indice +1);
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
	
	/**
	 * Retorna la lista de figuras
	 * @return Lista de figuras del cajón
	 */
	public ArrayList darFiguras() {
		return figuras;
	}
	
	
	//TODO: Contar la cantidad de triángulos en el cajón de figuras.
	
	/**
	 * Retorna la cantidad de triángulos que hay en el cajón
	 * @return Número de triángulos en el cajón.
	 */
	public int darNumTriangulos() {
		int conteo = 0;
		for( Figura f : figuras) {
			if ( f.esTriangulo()) conteo++;
		}
		
		return conteo;
	}
	
	/**
	 * Determina la figura que tiene el menor perímetro
	 * @return Figura con el menor perímetro y su posición.
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
		return "La figura con menor perímetro tiene " + lados + " lados, perimetro de "
		+ formato.format(perimetroMenor) + " y está en la posicion " + indice;
	}
	
	/**
	 * Retorna el perímetro de las tres figuras con el mayor perímetro
	 * en la lista figuras.
	 * @return String con los valores de los tres perímetros más grandes. Si no hay suficientes figuras, retorna que no pudo calcular.
	 */
	public String figurasConMayorPerimetro() {
		if ( figuras.size() <= 3)
			return "No se pudo determinar las figuras con mayor perímetro";
		
		List<Figura> figurasOrdenadas = (List<Figura>) figuras.clone();
		Collections.sort(figurasOrdenadas);
		
		// Sirve para hacer una iteración e imprimir cada perímetro en la lista
		//figurasOrdenadas.stream().map(s -> s.calcularPerimetro()).forEach(System.out::println);
		
		return "Figura 1: " + formato.format(figurasOrdenadas.get(0).calcularPerimetro()) + "\n"
				+ "Figura 2: " + formato.format(figurasOrdenadas.get(1).calcularPerimetro()) + "\n"
				+ "Figura 3: " + formato.format(figurasOrdenadas.get(2).calcularPerimetro()) + "\n";
	}
	
	/**
	 * Cuenta la cantidad de figuras que tienen un perímetro mayor a un valor
	 * dado por parámetro.
	 * @param perimetroMin Perímetro mínimo para comparar 
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
				" figuras con un perímetro mayor a 1 000");
	}
}
