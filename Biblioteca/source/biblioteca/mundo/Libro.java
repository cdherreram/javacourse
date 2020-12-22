package biblioteca.mundo;

/**
 * Clase que modela un libro
 * @author Cristian David Herrera
 *
 */
public class Libro {

	public enum Categoria{
		 FANTASIA, AVENTURA, POLICIACA, DISTOPICA, SIN_DETERMINAR
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
	private Categoria categoria; //Enumeraciones.
	
	//----------------------
	//Constructor
	//---------------------
	
	// Overloading 
	public Libro ( int id, String nombre ) {
		this.id = id;
		this.nombre = nombre;
		this.numPrestamos = 0;
		this.numPaginas = 300;
		this.peso = 100;
		
		//Cómo adicionar fecha:
		//1.
		Fecha fecha1 = new Fecha(1,1,2000);
		this.fechaLlegada = fecha1;
		
		//2.
		//this.fechaLlegada = new Fecha(1,1,2000);
		
		this.categoria = Categoria.SIN_DETERMINAR;
	}
	
	
	// Libro ( int, String, int)
	public Libro( int id, String nombre, int numPaginas) {
		this.id = id;
		this.nombre = nombre;
		this.numPaginas = numPaginas;
		this.numPrestamos = 0;
		this.peso = 300;
		Fecha fecha1 = new Fecha(1,1,2000);
		this.fechaLlegada = fecha1;
		
		this.categoria = Categoria.SIN_DETERMINAR;
	}
	
	public Libro(int id, String nombre, int numPrestamos, int numPaginas, float peso, Fecha fechaLlegada,
			Categoria categoria) {
		this.id = id;
		this.nombre = nombre;
		this.numPrestamos = numPrestamos;
		this.numPaginas = numPaginas;
		this.peso = peso;
		this.fechaLlegada = fechaLlegada;
		this.categoria = categoria;
	}
	
	//-----------------
	//Métodos
	//-----------------
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumPrestamos() {
		return numPrestamos;
	}

	public void setNumPrestamos(int numPrestamos) {
		this.numPrestamos = numPrestamos;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Fecha getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Fecha fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Método que aumenta la cantidad de préstamos del libro en 1.
	 */
	public void agregarPrestamo() {
		//TODO: Completar este método.
		//numPrestamos = numPrestamos + 1;
		numPrestamos++;
	}
	
}
