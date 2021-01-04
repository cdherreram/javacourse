package cajon.mundo;

/**
 * Clase que modela un color en formato RGB.
 * @author Cristian David Herrera
 */

public class Color {
	
	//------------------
	// Atributos
	//------------------
	
	private int r;
	private int g;
	private int b;
	
	//------------------
	// Constructores
	//------------------
	
	/**
	 * Construye por defecto color RGB negro.
	 */
	public Color () {
		r = 0;
		g = 0;
		b = 0;
	}
	
	/**
	 * Construye un color en formato RGB de acuerdo a parámetros
	 * @param pR Rojo
	 * @param pG Verde
	 * @param pB Azul
	 */
	public Color(int pR, int pG, int pB) {
		r = pR;
		g = pG;
		b = pB;
	}
	
	//----------------
	// Métodos
	//----------------
	
	//TODO: Agregar métodos getter y setter y agregar un método que retorne 
	//     un array primitivo de tamaño 3 con los atributos r, g, b
	//     Para mayor información sobre el modelo RGB revisar
	//     https://es.wikipedia.org/wiki/RGB

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public int[] getRGB() {
		int[] rgb = new int[3]; //  ------>   |   |   |    |
		                                  //    0   1    2  
		rgb[0] = r;
		
		
		
		rgb[0] = r;
		rgb[1] = g;
		rgb[2] = b;
		return rgb;
	}
}
