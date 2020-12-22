package biblioteca.mundo;

import java.util.*;

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
	
	private Sala[ ] salas;  // Arreglo de salas  |   | S  | S  | S  | S   | S  | 
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
			salas[i] = new Sala(1,10,true);
		}
		
		//Clase - referencia - new - constructor
		libros = new ArrayList<Libro>(); //Se inicializa el ArrayList
		Fecha fecha1 = new Fecha(20,5,1995);
		Libro libro1 = new Libro( 1 , "Zoro" , 0 , 250 , 300, fecha1, Categoria.SIN_DETERMINAR);
		adicionarLibro(libro1);
		Libro libro2 = new Libro(2, "Juanito Alimaña");
		adicionarLibro(libro2);
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
	 * Se debe verificar que el libro no exista en la lista ya. 
	 * @param pLibro Libro: libro a adicionar.
	 * @return Retorna true si se adicionó el libro.
	 */
	public boolean adicionarLibro(Libro pLibro) {
		//TODO: Completar el método
		libros.add(pLibro);
		return true;
	}
	
	//TODO: Cómo sería un método adicionarLibro que, en vez de recibir un objeto Libro recibiera
	// los datos del libro? Completar este método y documentarlo.
	
	
	
	
	/**
	 * Método que ocupa una sala.
	 * @param pDisp Objeto Disponible: Objeto que tiene información de la ocupación de la sala.
	 * @return Retorna true si se prestó la sala
	 */
	public boolean pedirPrestadaSala(Disponibilidad pDisp) {
		//TODO: Completar el método
		
		return true;
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
	 * @param dSala Id Sala: Identificador de la sala a entregar
	 * @return 
	 */
	public boolean entregarSala(int dSala) {
		//TODO: Completar el método
		
		return true;
	}
	
	/**
	 * Método que busca en la lista de salas si hay una sala disponible
	 * @return Retorna el id de la sala disponible o 0 si no encuentra.
	 */
	public int buscarSalaDisponible() {
		//TODO: Completar el método
		
		return 0;
	}
	
	//-----------------------------
	// Main
	//-----------------------------
	
	public static void main(String[ ] args) {
		Biblioteca biblioteca1 = new Biblioteca("Biblioteca Nacional", 0, 0, Biblioteca.NUM_MAX_SALAS);
		System.out.println("El número de salas disponibles es " + biblioteca1.contarSalasDisponibles());
	}
	
	
}