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
	 * @param capacidadMax Capacidad m�xima: Valor m�ximo de personas en la sala
	 * @param disponible Disponibilidad: Define si la sala est� o no disponible.
	 */
	public Sala(int idSala, int capacidadMax, boolean disponible) {
		this.idSala = idSala;
		this.capacidadMax = capacidadMax;
		this.disponible = disponible;
		this.disp = null;
	}
	
	public Sala(int idSala) {
		this.idSala = idSala;
		this.capacidadMax = 5;
		this.disponible = true;
		this.disp = null;
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
	 * M�todo que cambia la disponibilidad de la sala y asigna el par�metro al atributo disp
	 * @param disp Disponibilidad: Objeto de la clase Disponibilidad que informa c�mo se ocup�
	 * 								la sala
	 */
	public void ocuparSala(Disponibilidad pDisp ) {
		//TODO: Completar el m�todo que cambie la sala a ocupada y cree el objeto disp
		if ( this.disponible == true && pDisp.getCantidadPersonas() <= this.capacidadMax ) {
			this.disponible = false;
			this.disp = pDisp;
		} else {
			System.out.println("No se pudo hacer la reserva");
		}
	}
	
	/**
	 * M�todo que asigna un valor null al par�metro disp.
	 */
	public void desocuparSala() {
		//TODO: Cambiar el m�todo para que informe el cambio de disponibilidad de la sala.
		this.disponible = true;
		this.disp = null;
	}
	
	/**
	 * Este m�todo determina si se sobrepasa la capacidad de la sala o no.
	 * @param numPersonas N�mero de personas: cantidad de personas que van a entrar en la sala.
	 * @return True si la capacidad se sobrepasa.
	 */
	public boolean sobrepasaCapacidad(int numPersonas) {
		//TODO: Retornar true si la cantidad de personas a ingresar a la sala supera la capacidad.
		if( this.capacidadMax >= numPersonas)
			return false;
		
		return true;
	}
}
