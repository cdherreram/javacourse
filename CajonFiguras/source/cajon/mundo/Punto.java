package cajon.mundo;

/**
 * Clase que modela un punto de una figura.
 * @author Cristian David Herrera
 *
 */
public class Punto {
	
	//---------------
	// Atributos
	//---------------
	
	private int dimensionEspacio;
	private int[] coordenadas;
	
	//---------------
	// Constructores
	//---------------
	/**
	 * Crea un punto por defecto con dimension 2 y coordenadas (0,0)
	 */
	public Punto( ) {
		dimensionEspacio = 2;
		coordenadas = new int[dimensionEspacio];
		for ( int i = 0; i < dimensionEspacio; i++) {
			coordenadas[i] = 0;
		}
	}
	
	public Punto( int x1, int x2) {
		dimensionEspacio = 2;
		coordenadas = new int[dimensionEspacio];
		coordenadas[0] = x1;
		coordenadas[1] = x2;
	}

	
			
	//TODO: (Opcional) Generar un constructor que reciba por parámetro la
	//      dimensión del espacio y un array primitivo con las coordenadas
	//      del punto y lo asigne al array de coordenadas.
	
	
	//-----------------------------
	// Métodos
	//---------------------------
	
	/**
	 * Retorna un array con las coordenadas de acuerdo a la dimensión del espacio.
	 * @return Array con coordenadas
	 */
	public int[] getCoordenadas() {
		return coordenadas;
	}
	
	/**
	 * Retorna la coordenada en la posición indicada.
	 * <b> Pre: </b> La coordenada indicada debe ser menor a la dimensión del espacio.
	 * @param pPosicionCoordenada Posición de coordenada que se desea retornar
	 * @return Coordenada de la posición pedida.
	 */
	public int getCoordenadas( int pPosicionCoordenada) {
		// TODO: Completar este método de acuerdo a la documentación.
		return 0;
	}
	
	/**
	 * Cambia las coordenadas de un punto con parámetro recibido.
	 * @param coordenadas Coordenadas a asignar
	 */
	public void setCoordenadas(int[] coordenadas) {
		this.coordenadas = coordenadas;
	}
	
	/**
	 * Cambia la coordenada indicada por pPosición con el valor dado en pCoordenada.
	 * @param pPosicion Posición de coordenada a cambiar
	 * @param pCoordenada Valor de coordenada a asignar
	 */
	public void setCoordenadas(int pPosicion, int pCoordenada) {
		//TODO: Completar este método de acuerdo a la documentación.
	}

	/**
	 * Retorna la dimensión del espacio.
	 * @return Dimensión del espacio
	 */
	public int getDimensionEspacio() {
		return dimensionEspacio;
	}
	
	/**
	 * Determina el cuadrante en que está el punto si la dimensión del
	 * espacio es 2. Retorna 0 si no es de dimensión 2.
	 * @return Cuadrante del punto o 0 en caso de tener dimension != 2.
	 */
	public int determinarCuadrante() {
		// Determina si la dimension del espacio es distinta de 2.
		if (getDimensionEspacio() != 2) {
			return 0;
		}
		
		//TODO: Completar el método para que retorne el cuadrante del punto.
		//      Leer la documentación.
		return 1;
	}
}