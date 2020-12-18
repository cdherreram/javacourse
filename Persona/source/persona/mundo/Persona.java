package persona.mundo;

/**
 * Clase que crea una persona.
 */
public class Persona {
	
	//----------------------------------------------
	//Atributos - Características que tiene la persona
	//----------------------------------------------
	
	private int edad; //la edad es de tipo entero. Se escribe int
	private char genero; // el genero puede ser m y f --- 
	private boolean esSoltero; // ser soltero es verdadero o falso
	private String colorDePiel; //
	private Trabajo trabajoActual;
	
	//----------------------------------------------
	//Constructor	
	// El constructor necesita (eventualmente) parámetros
	//----------------------------------------------
	
	public Persona (int pEdad, char pGenero, boolean pEsSoltero, String pColorDePiel,
			String pNombreOficio, String pNombreEmpresa, int pDuracion) {
		edad = pEdad;
		genero = pGenero;
		esSoltero = pEsSoltero;
		colorDePiel = pColorDePiel;
		trabajoActual = new Trabajo(pNombreOficio, pNombreEmpresa, pDuracion);
	}
	
	//----------------------------------------------
	//Métodos - Cosas que hace la persona
	//----------------------------------------------
	
	public int darEdad( ) {
		return edad; 
	}
	
	public char darGenero() {
		return genero;
	}
	
	public boolean darEsSoltero() {
		return esSoltero;
	}
	
	public String darColorDePiel() {
		return colorDePiel;
	}
	
	public Trabajo darTrabajoActual() {
		return trabajoActual;
	}
	
	public void cambiarEsSoltero(boolean nuevoEstado) {
		esSoltero = nuevoEstado;
	}
	
	public void imprimirNombreTrabajo() {
		System.out.println(trabajoActual.darNombreOficioRealizado());
	}
	
	public boolean esMayorDeEdad( ) {
		if ( edad >= 18 )
			return true;
		else
			return false;
	}	
	
	//Aquí pongo el main
	
	public static void main(String[] args) {
		//¿Cómo crear un objeto?
		
		//1. De qué clase es
		//2. Cómo lo vamos a llamar (referencia)
		//3. crear el objeto
		
		Persona persona1 = new Persona( 21, 'f', true, "Trigueño", "Contador", "IBM", 4);
		Persona persona2 = new Persona( 40, 'f', false, "Albino", "Tejedor", "Lanas S.A.", 15);
		
		//Cómo le pedimos a un objeto que nos entregue una cierta información?
		//Llamamos a la referencia del objeto y luego un punto.
		System.out.println(persona1.darColorDePiel());
		System.out.println( "El trabajo actual de la persona 2 es " + 
				persona2.darTrabajoActual().darNombreEmpresa() );
		if ( persona1.esMayorDeEdad() == true) {
			System.out.println("La persona 1 es mayor de edad");
		} else {
			System.out.println("La persona 1 NO  es mayor de edad");
		}
	}
}