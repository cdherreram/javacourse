package biblioteca.mundo;

/**
 * Clase que representa la fecha.
 * @author David Herrera
 *
 */
public class Fecha {
	
	//---------------
	// Atributos
	//---------------
	
	private int dia;
	private int mes;
	private int anho;
	
	
	//----------------------
	//Constructor
	//---------------------
	
	//TODO: Completar el constructor
	public Fecha(int dia, int mes, int anho) {
		this.dia = dia;
		this.mes = mes;
		this.anho = anho;
	}

	
	//-----------------
	//Métodos
	//-----------------
	
	//TODO: Completar los métodos getter y setter
	public int getDia() {
		return dia;
	}


	public void setDia(int dia) {
		this.dia = dia;
	}


	public int getMes() {
		return mes;
	}


	public void setMes(int mes) {
		this.mes = mes;
	}


	public int getAnho() {
		return anho;
	}


	public void setAnho(int anho) {
		this.anho = anho;
	}

}
