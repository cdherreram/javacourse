package biblioteca.mundo;

public class Sala {
	
	//----------------------
	//Atributos
	//----------------------
	
	public final static int TIEMPO_MAX_OCUPACION = 3;
	
	private int idSala;
	private int capacidadMax;
	private boolean disponible;
	
	private Disponibilidad disp;
	
	//----------------------
	//Constructor
	//----------------------
	
	/**
	 * Clase que modela una sala con o sin disponibilidad
	 * 
	 * @param idSala Id Sala: Valor principal que identifica a la sala.
	 * @param capacidadMax Capacidad máxima: Valor máximo de personas en la sala
	 * @param disponible Disponibilidad: Define si la sala está o no disponible.
	 */
	public Sala(int idSala, int capacidadMax, boolean disponible) {
		this.idSala = idSala;
		this.capacidadMax = capacidadMax;
		this.disponible = disponible;
	}

	//----------------------
	//Metodos
	//----------------------
	
	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public int getCapacidadMax() {
		return capacidadMax;
	}

	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}

	public boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
	
	/**
	 * Método que cambia la disponibilidad de la sala y asigna el parámetro al atributo disp
	 * @param disp Disponibilidad: Objeto de la clase Disponibilidad que informa cómo se ocupó
	 * 								la sala
	 */
	public void ocuparSala(Disponibilidad disp ) {
		//TODO: Completar el método que cambie la sala a ocupada y cree el objeto disp
	}
	
	
	/**
	 * Método que asigna un valor null al parámetro disp.
	 */
	public void desocuparSala() {
		//TODO: Cambiar el método para que informe el cambio de disponibilidad de la sala.
	}
	
	/**
	 * Este método determina si se sobrepasa la capacidad de la sala o no.
	 * @param numPersonas Número de personas: cantidad de personas que van a entrar en la sala.
	 * @return True si la capacidad se sobrepasa.
	 */
	public boolean sobrepasaCapacidad(int numPersonas) {
		//TODO: Retornar true si la cantidad de personas a ingresar a la sala supera la capacidad.
		
		return true;
	}
}
