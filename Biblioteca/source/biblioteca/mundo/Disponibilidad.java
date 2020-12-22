package biblioteca.mundo;

/**
 * Clase que modela la ocupación de una sala.
 * @author Cristian David Herrera
 *
 */
public class Disponibilidad {

	//---------------
	// Atributos
	//---------------
	private String nombreResponsable;
	private int cantidadPersonas;
	private int tiempoOcupado;
	
	
	//----------------------
	//Constructor
	//---------------------
	
	//TODO: Completar el constructor
	public Disponibilidad(String nombreResponsable, int cantidadPersonas, int tiempoOcupado) {
		super();
		this.nombreResponsable = nombreResponsable;
		this.cantidadPersonas = cantidadPersonas;
		this.tiempoOcupado = tiempoOcupado;
	}

	//-----------------
	//Métodos
	//-----------------
	
	//TODO: Completar los métodos getter y setter

	public String getNombreResponsable() {
		return nombreResponsable;
	}


	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}


	public int getCantidadPersonas() {
		return cantidadPersonas;
	}


	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}


	public int getTiempoOcupado() {
		return tiempoOcupado;
	}


	public void setTiempoOcupado(int tiempoOcupado) {
		this.tiempoOcupado = tiempoOcupado;
	}
	
}
