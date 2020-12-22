package cajon.mundo;

/**
 * Clase que modela un lado de una figura.
 * @author Cristian David Herrera
 *
 */
public class Lado {
	
	//------------------
	// Atributos
	//------------------
	private double longitud;
	private Color color;
	private Punto[] puntos;
	
	
	//---------------
	// Constructores
	//---------------
	/**
	 * Construye un lado de color negro con los puntos (0,0) y (1,1).
	 */
	public Lado() {
		color = new Color();
		
		//TODO: Todo lado tiene dos puntos. Cree una constante llamada
		//      PUNTOS_POR_LADO y asígnela al crear el array de puntos.
		puntos = new Punto[2];
		puntos[0] = new Punto(0,0);
		puntos[1] = new Punto(1,1);
		longitud = calcularLongitud();
	}
	
	/**
	 * Construye un lado de color negro con los puntos recibidos por parámetros
	 * <b> Pre: </b> Los puntos recibidos por parámetro deben ser de la misma dimensión.
	 * @param pPuntos Vértices del lado
	 */
	public Lado(Punto[] pPuntos) {
		color = new Color();
		//TODO: Aquí falta algo por hacer para el array puntos. ¿Qué será?
		//      Hint: Mi error en la clase al construir el array.
		puntos = pPuntos;
		longitud = calcularLongitud();
	}
	
	/**
	 * Construye un lado con el color y los puntos indicados por parámetro.
	 * <b> Pre: </b> Los puntos recibidos por parámetro deben ser de la misma dimensión.
	 * @param pPuntos Vértices del lado
	 * @param pColor Color en código RGB
	 */
	public Lado(Punto[] pPuntos, Color pColor) {
		//TODO: Aquí falta algo por hacer para el array puntos. ¿Qué será?
		//      Hint: Mi error en la clase al construir el array.
		puntos = pPuntos;
		color = pColor;
		longitud = calcularLongitud();
	}
	
	/**
	 * Construye un lado con el color y los puntos indicados por parámetro.
	 * <b> Pre: </b> Los puntos recibidos por parámetro deben ser de la misma dimensión.
	 * @param punto1 Vértice del lado
	 * @param punto2 Vértice del lado
	 */
	public Lado(Punto punto1, Punto punto2) {
		//TODO: Aquí falta algo por hacer para el array puntos. ¿Qué será?
		//      Hint: Mi error en la clase al construir el array.
		puntos[0] = punto1;
		puntos[1] = punto2;
		color = new Color();
		//TODO: Aquí falta hacer algo con longitud. Hint: revise los métodos anteriores.
	}
	
	/**
	 * Construye un lado con el color y los puntos indicados por parámetro.
	 * <b> Pre: </b> Los puntos recibidos por parámetro deben ser de la misma dimensión.
	 * @param punto1 Vértice del lado
	 * @param punto2 Vértice del lado
	 */
	public Lado(Punto punto1, Punto punto2, Color pColor) {
		//TODO: Aquí falta algo por hacer para el array puntos. ¿Qué será?
		//      Hint: Mi error en la clase al construir el array.
		puntos[0] = punto1;
		puntos[1] = punto2;
		color = pColor;
		//TODO: Aquí falta hacer algo con longitud. Hint: revise los métodos anteriores.
	}
	//------------------------
	// Métodos
	//------------------------
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setPuntos(Punto[] puntos) {
		this.puntos = puntos;
		this.longitud = calcularLongitud();
	}
	
	//Calcula la longitud euclideana del lado.
	private double calcularLongitud( ) {
		//TODO: Calcular la longitud del lado de acuerdo a la distancia euclideana.
		//      Para calcular potencias, use la función Math.pow y para raíces use
		//      Math.sqrt. Con el fin de hacerlo lo más general posible, trate de usar
		//      un ciclo for sobre la dimension del espacio.
		return 0.0;
	}
}
