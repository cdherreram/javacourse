package biblioteca.mundo;

import java.util.*;
import java.io.*;


import biblioteca.mundo.Libro.Categoria;
// Crear una biblioteca con:
//1. Salas : Max 10    ----> Disponibilidad
//2. Libros.

/**
 * Clase que modela una biblioteca
 * @author Cristian David Herrera
 *
 */

public class Biblioteca {
	
	public final static int NUM_MAX_SALAS = 10;
	
	/**
	 * Este atributo modela el nombre de la biblioteca
	 */
	private String nombre;
	
	/**
	 * Este atributo modela el número de usuarios de la biblioteca.
	 */
	private int numUsuarios;
	private int numLibros;
	private int numSalasDisponibles;
	
	private Sala salas[ ];  // Arreglo de salas  |   | S  | S  | S  | S   | S  | 
	private ArrayList<Libro> libros;
	
	//--------------------------
	//Constructor
	//--------------------------
	
	/**
	 * Esta clase modela una biblioteca con salas y libros.
	 * 
	 * @param pNombre: Nombre de la biblioteca 
	 * @param pNumUsuarios
	 * @param pNumLibros
	 * @param pNumSalasDisponibles
	 */
	public Biblioteca (String pNombre, int pNumUsuarios, int pNumLibros, int pNumSalasDisponibles) {
		this.nombre = pNombre;
		this.numUsuarios = pNumUsuarios;
		this.numLibros = pNumLibros;
		this.numSalasDisponibles = pNumSalasDisponibles;
		
		salas = new Sala[Biblioteca.NUM_MAX_SALAS]; //Contenedores de tamaño fijo.
		for( int i = 0; i < Biblioteca.NUM_MAX_SALAS; i++) {
			salas[i] = new Sala(1 + i,10,true); //Los id de la sala irán de 1 a 10.
		}
		
		//Clase - referencia - new - constructor
		libros = new ArrayList<Libro>(); //Se inicializa el ArrayList
		
		// Libreria que tengo que importarla: java.io
		// BufferedReader - Para almacenar
		// FileReader - Para leer el archivo
		
		try {
			BufferedReader br = new BufferedReader( new FileReader("data/datos.csv") );
			String linea;
			
			linea = br.readLine(); // Leí la primera línea
			while( linea != null) {
				String[] datos = linea.split(";");     // 1;Zoro;Manuel ---> |  1   |  Zoro |  Manuel |
				int id = Integer.parseInt(datos[0]); //Vamos a sacar el primer número y a convertirlo en tipo int
				String nombre = datos[1];
				Libro l = new Libro(id, nombre);
				adicionarLibro(l);		
				linea = br.readLine(); //Lee la siguiente linea
			}
		} catch (Exception excepcion) {
			System.out.println("Hubo error en la carga de datos");
		}	
		
	}
	
	//--------------------------
	//Métodos
	//--------------------------
	
	public void setNombre (String pNombre) {
		this.nombre = pNombre;
	}
	
	public void setNumUsuarios (int pNumUsuarios) {
		this.numUsuarios = pNumUsuarios;
	}
	
	public void setNumLibros (int pNumLibros) {
		this.numLibros = pNumLibros;
	}
	
	public void setNumSalasDisponibles(int pNumSalasDisponibles) {
		this.numSalasDisponibles = pNumSalasDisponibles;
	}
	
	public String getNombre ( ) {
		return this.nombre;
	}
	
	public int getNumUsuarios( ) {
		return this.numUsuarios;
	}
	
	public int getNumSalasDisponibles() {
		return this.numSalasDisponibles;
	}
	
	public int getNumLibros () {
		return this.numLibros;
	}

	
	
	
	/**
	 * Cuenta la cantidad de salas disponibles
	 * 
	 * @return Cantidad de salas disponibles
	 */
	public int contarSalasDisponibles( ) {
		int contador = 0;
		
		// Clase -  nombre provisional - vector
		for ( Sala i : salas) {
			if ( i.getDisponible() == true ) {
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * Método que adiciona un libro a la lista de libros
	 * <pre:> Se debe verificar que el libro no exista en la lista ya.
	 * @param pLibro Libro: libro a adicionar.
	 * @return Retorna true si se adicionó el libro.
	 */
	public boolean adicionarLibro(Libro pLibro) {
		//TODO: Completar el método
		boolean seAdicionoLibro = false;
		
		if( buscarLibro ( pLibro.getNombre()) == false ) {
			libros.add(pLibro);
			numLibros++;
			seAdicionoLibro = true;
		}
		
		//numLibros = numLibros +1;
		//this.numLibros = this.numLibros + 1;
		//setNumLibros(this.numLibros + 1);
		return seAdicionoLibro;
	}
	
	//TODO: Cómo sería un método adicionarLibro que, en vez de recibir un objeto Libro recibiera
	// los datos del libro? Completar este método y documentarlo.
	
	//overloading
	public boolean adicionarLibro( int id , String nombre ) {
		
		Libro mi_libro = new Libro(id, nombre);
		adicionarLibro( mi_libro );
		
		return true;
	}
	
	
	/**
	 * Método que ocupa una sala.
	 * @param pDisp Objeto Disponible: Objeto que tiene información de la ocupación de la sala.
	 * @return Retorna true si se prestó la sala
	 */
	public boolean pedirPrestadaSala(Disponibilidad pDisp) {
		//TODO: Completar el método
		//Escribir un método para buscar sala disponible
		int salaDisponible = buscarSalaDisponible(); // Id van de 1 a 10
		if ( salaDisponible != 0) {
			boolean seOcupoSala = salas[ salaDisponible - 1 ].ocuparSala(pDisp);    // Posicion de 0 a 9
			if ( seOcupoSala == true ) 
				numSalasDisponibles -= 1;
			return seOcupoSala;
		} else {
			return false;
		}
	}
	
	/**
	 * Método que ocupa una sala. Crea un objeto de clase Disponibilidad
	 * @param pNombreResponsable Nombre Responsable: Nombre persona encargada de la sala.
	 * @param pCantidadPersonas Cantidad Personas: Cantidad de personas a ocupar la sala.
	 * @param pTiempoOcupado Tiempo Ocupado: Cantidad de tiempo que ocuparán la sala.
	 * @return Retorna true si se prestó la sala
	 */
	
	public boolean pedirPrestadaSala(String pNombreResponsable, int pCantidadPersonas, 
			int pTiempoOcupado) {
		//TODO: Completar el método
		
		
		return true;
	}
	
	/**
	 * Método que cuenta la cantidad total de libros que hay
	 * @return Cantidad de libros.
	 */
	public int contarLibros( ) {
		//TODO: Completar el método
//		int contador = 0;
//		for( Libro libro : libros) {
//			contador++;
//		}
//		return contador;
		
//		int contador = libros.size();
//		return contador;
		return libros.size();
	}
	
	
	/**
	 * Método que busca un libro de acuerdo a su nombre.
	 * @param nombreLibro Nombre del libro: Nombre del libro.
	 * @return Retorna true si encuentra el libro.
	 */
	//Overloading
	public boolean buscarLibro(String nombreLibro) {
		//TODO: Completar el método
		for (Libro libro : libros) {
			if(libro.getNombre().equalsIgnoreCase(nombreLibro)) {
				return true;
			}
		}
		return false;
	}
	
	// No se pueden diferenciar métodos solamente por lo que retornar
	// public int buscarLibro(int idLibro) 
	
	/**
	 * Método que busca un libro de acuerdo a su id.
	 * @param idLibro 
	 * @return True si encontró el libro.
	 */
	//Overloading
	public boolean buscarLibro(int idLibro) {
		//TODO: Completar el método
		for (Libro libro : libros) {
			if(libro.getId() == idLibro) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que desocupa una sala de acuerdo a su id.
	 * @param idSala Id Sala: Identificador de la sala a entregar
	 * @return 
	 */
	public boolean entregarSala(int idSala) {     //1. Ponerle null a disp en la clase Sala
												 //2. numSalasDisponibles aumenta
		//TODO: Completar el método
		salas[idSala - 1].desocuparSala();
		this.numSalasDisponibles--;
		
		return true;
	}
	
	/**
	 * Método que busca en la lista de salas si hay una sala disponible
	 * @return Retorna el id de la sala disponible o 0 si no encuentra.
	 */
	public int buscarSalaDisponible( ) {
		//TODO: Completar el método
		
		if ( numSalasDisponibles >= 1 ) {
			for ( int i = 0; i < salas.length; i++) {
				if ( salas[i].getDisponible() == true) {
					return salas[i].getIdSala();
				}
			}
		}
		
		return 0;
	}
	
	//-----------------------------
	// Main
	//-----------------------------
	
	public static void main(String[ ] args) {
		
		Biblioteca biblioteca1 = new Biblioteca("Biblioteca Nacional", 0, 0, Biblioteca.NUM_MAX_SALAS);
		
		System.out.println("El número de salas disponibles es " + biblioteca1.contarSalasDisponibles());
		
		//JUnit para probar clases.
		
		System.out.println("El número de libros en la biblioteca es " + biblioteca1.contarLibros());
		
		System.out.println("El nombre del libro en la posicion 10 es " + biblioteca1.libros.get(9).getNombre());
		// Si tengo un array primitivo, uso [ ]
		// Si tengo un ArrayList, necesito llamar al método get
		//System.out.println("El nombre del primer libro es: " + biblioteca1.libros.get(0).getNombre() );
		
		biblioteca1.adicionarLibro(40, "La insoportable levedad del ser");
		System.out.println("El libro con id 40 es " + biblioteca1.libros.get(30).getNombre());
		
		
	}
}