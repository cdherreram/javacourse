/**
 * 
 */
package cajon.mundo;

/**
 * Clase que modela una figura.
 * @author Cristian David Herrera
 *
 */
public class Figura {
	
	public enum Tipo {
		EQUILATERO,
		ISOSCELES,
		ESCALENO,
		OTRO
	}
	
	private int numLados;
	private Color colorFigura;
	private Lado[] lados;
	private Punto[] puntos;
	
	//---------------------------
	// Constructores
	//--------------------------
	
	/**
	 * Construye por defecto un triangulo con color RGB negro con vértices fijos.
	 */
	public Figura ( ) {
		numLados = 3;
		colorFigura = new Color();
		
		//Primero, creo el array de puntos y le asigno tamaño
		puntos = new Punto[numLados];
		//Segundo, adiciono los puntos al array de acuerdo al número de lados.
		puntos[0] = new Punto(0,0);
		puntos[1] = new Punto(0,3);
		puntos[2] = new Punto(4,0);
		
		//En tercer lugar, creo el array de lados y le asigno tamaño.
		lados = new Lado[numLados];
		//Y en cuarto lugar, creo los lados de acuerdo a los puntos de la figura.
		lados[0] = new Lado(puntos[0], puntos[1]);
		lados[1] = new Lado(puntos[1], puntos[2]);
		lados[2] = new Lado(puntos[2], puntos[0]);
	}
	
	public Figura( int pNumLados, Punto[] pPuntos) {
		colorFigura = new Color();
		numLados = pNumLados;
		
		//Primero, creo el array de puntos y le asigno tamaño
		puntos = new Punto[numLados];
		//Segundo, adiciono los puntos al array de acuerdo al número de lados.
		puntos = pPuntos;
		//Tercero, creo el array de lados y le asigno tamaño
		lados = new Lado[numLados];
		//Cuarto, creo los lados de acuerdo a los puntos de la figura.
		//TODO: Asignar a cada uno de los lados de la figura dos puntos consecutivos
		//      en un ciclo for. Para no tener conflicto con los índices al iniciar
		//		de nuevo el conteo, use el operador módulo %
	}
	
	//TODO: (Opcional) Crear un constructor que cree un triángulo
	// 		con parámetros numLados y las coordenadas de cada uno de los puntos.
	//		
	

	//---------------------------
	// Métodos
	//--------------------------
	
	public int getNumLados() {
		return numLados;
	}

	public void setNumLados(int numLados) {
		this.numLados = numLados;
	}

	public Color getColorFigura() {
		return colorFigura;
	}

	public void setColorFigura(Color colorFigura) {
		this.colorFigura = colorFigura;
	}

	public Lado[] getLados() {
		return lados;
	}

	public void setLados(Lado[] lados) {
		this.lados = lados;
	}

	public Punto[] getPuntos() {
		return puntos;
	}

	public void setPuntos(Punto[] puntos) {
		this.puntos = puntos;
	}
	
	/**
	 * Calcula el perímetro de una figura con la distancia euclideana 
	 * @return Perímetro de la figura
	 */
	public double calcularPerimetro() {
		//TODO: Completar el método de acuerdo a la documentación.
		//      Recuerde que cada uno de los lados tiene un método
		//		para calcular su longitud.
		return 0;
	}
	
	/**
	 * Determina si la figura es un triángulo
	 * @return True si la figura es un triángulo
	 */
	public boolean esTriangulo() {
		//TODO: Completar el método de acuerdo a la documentacion.
		return true;
	}
	
	/**
	 * Determina el tipo de triángulo de acuerdo a la longitud de sus lados.
	 * Si la figura no es un triángulo, retorna el tipo OTRO.
	 * @return Tipo de triángulo según sus lados. Si no es triángulo, retorna Tipo.OTRO
	 */
	public Tipo determinarTipoTriangulo() {
		//TODO: Completar el método de acuerdo a la documentación.
		//      Antes de determinar qué tipo de triángulo es, debe determinar
		//      si la figura es un triángulo. Puede usar el método anterior.
		
		return null;
	}

	@Override
	/**
	 * Método toString() para la clase Figura.
	 */
	public String toString( ) {
		if ( esTriangulo( ) )
			return "La figura es un triángulo " + determinarTipoTriangulo().toString() + " de perímetro " + calcularPerimetro() + ".\n"; 
		else
			return "La figura tiene " + getNumLados() + " lados y tiene un perimetro de " + calcularPerimetro()  + ".\n";
	}
	
	
}
