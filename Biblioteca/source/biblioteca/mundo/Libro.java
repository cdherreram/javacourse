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
	//M�todos
	//-----------------
	
	//TODO: Completar los m�todos getter y setter
	
	
	/**
	 * M�todo que aumenta la cantidad de pr�stamos del libro.
	 */
	public void agregarPrestamo() {
		//TODO: Completar este m�todo.
	}
	
}
