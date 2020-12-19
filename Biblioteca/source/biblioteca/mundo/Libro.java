package biblioteca.mundo;

/**
 * Clase que modela un libro
 * @author Cristian David Herrera
 *
 */
public class Libro {

	public enum Categoria{
		SIN_DETERMINAR,
		FANTASIA,
		AVENTURA,
		POLICIACA,
		DISTOPICA
	}
	//---------------
	// Atributos
	//---------------
	
	private int id;
	private String nombre;
	private int numPrestamos;
	private int numPaginas;
	private float peso;
	private Fecha fechaLlegada;
	private Categoria categoria;
	
	//----------------------
	//Constructor
	//---------------------
	
	//TODO: Completar el constructor
	
	//-----------------
	//Métodos
	//-----------------
	
	//TODO: Completar los métodos getter y setter
	
	
	/**
	 * Método que aumenta la cantidad de préstamos del libro.
	 */
	public void agregarPrestamo() {
		//TODO: Completar este método.
	}
	
}
