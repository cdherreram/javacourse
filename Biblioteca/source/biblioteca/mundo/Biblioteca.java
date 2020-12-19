package biblioteca.mundo;

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
	 * Este atributo modela el n�mero de usuarios de la biblioteca.
	 */
	private int numUsuarios;
	private int numLibros;
	private int numSalasDisponibles;
	
	private Sala[ ] salas;  // Arreglo de salas  |   | S  | S  | S  | S   | S  | 
	
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
		
		salas = new Sala[Biblioteca.NUM_MAX_SALAS]; //Contenedores de tama�o fijo.
		for( int i = 0; i < Biblioteca.NUM_MAX_SALAS; i++) {
			salas[i] = new Sala(1,10,true);
		}
	}
	
	//--------------------------
	//M�todos
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
	 * M�todo que adiciona un libro a la lista de libros
	 * Se debe verificar que el libro no exista en la lista ya. 
	 * @param pLibro Libro: libro a adicionar.
	 * @return Retorna true si se adicion� el libro.
	 */
	public boolean adicionarLibro(Libro pLibro) {
		//TODO: Completar el m�todo
		
		return true;
	}
	
	//TODO: C�mo ser�a un m�todo adicionarLibro que, en vez de recibir un objeto Libro recibiera
	// los datos del libro? Completar este m�todo y documentarlo.
	
	
	
	
	/**
	 * M�todo que ocupa una sala.
	 * @param pDisp Objeto Disponible: Objeto que tiene informaci�n de la ocupaci�n de la sala.
	 * @return Retorna true si se prest� la sala
	 */
	public boolean pedirPrestadaSala(Disponibilidad pDisp) {
		//TODO: Completar el m�todo
		
		return true;
	}
	
	/**
	 * M�todo que ocupa una sala. Crea un objeto de clase Disponibilidad
	 * @param pNombreResponsable Nombre Responsable: Nombre persona encargada de la sala.
	 * @param pCantidadPersonas Cantidad Personas: Cantidad de personas a ocupar la sala.
	 * @param pTiempoOcupado Tiempo Ocupado: Cantidad de tiempo que ocupar�n la sala.
	 * @return Retorna true si se prest� la sala
	 */
	
	public boolean pedirPrestadaSala(String pNombreResponsable, int pCantidadPersonas, 
			int pTiempoOcupado) {
		//TODO: Completar el m�todo
		
		return true;
	}
	
	/**
	 * M�todo que cuenta la cantidad total de libros que hay
	 * @return Cantidad de libros.
	 */
	public int contarLibros( ) {
		//TODO: Completar el m�todo
		
		return 0;
	}
	
	/**
	 * M�todo que busca un libro de acuerdo a su nombre.
	 * @param nombreLibro Nombre del libro: Nombre del libro.
	 * @return Retorna true si encuentra el libro.
	 */
	public boolean buscarLibro(String nombreLibro) {
		//TODO: Completar el m�todo
		
		return true;
	}
	
	/**
	 * M�todo que busca un libro de acuerdo a su id.
	 * @param idLibro Id libro: Identificador del libro
	 * @return Retorna true si encuentra el libro.
	 */
	public boolean buscarLibro(int idLibro) {
		//TODO: Completar el m�todo
		
		return true;
	}
	
	/**
	 * M�todo que desocupa una sala de acuerdo a su id.
	 * @param dSala Id Sala: Identificador de la sala a entregar
	 * @return 
	 */
	public boolean entregarSala(int dSala) {
		//TODO: Completar el m�todo
		
		return true;
	}
	
	/**
	 * M�todo que busca en la lista de salas si hay una sala disponible
	 * @return Retorna el id de la sala disponible o 0 si no encuentra.
	 */
	public int buscarSalaDisponible() {
		//TODO: Completar el m�todo
		
		return 0;
	}
	
	//-----------------------------
	// Main
	//-----------------------------
	
	public static void main(String[ ] args) {
		Biblioteca biblioteca1 = new Biblioteca("Biblioteca Nacional", 0, 0, Biblioteca.NUM_MAX_SALAS);
		System.out.println("El n�mero de salas disponibles es " + biblioteca1.contarSalasDisponibles());
	}
	
	
}