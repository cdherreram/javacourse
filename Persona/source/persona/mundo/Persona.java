package persona.mundo;

public class Persona {
	
	//Atributos - Características que tiene la persona
	private int edad; //la edad es de tipo entero. Se escribe int
	private char genero; // el genero puede ser m y f --- 
	private boolean esSoltero; // ser soltero es verdadero o falso
	private String colorDePiel; //
	
	Trabajo trabajoActual;
	
	//Constructor
	// El constructor necesita eventualmente parámetros
	public Persona (int pEdad, char pGenero, boolean pEsSoltero, String pColorDePiel, String pNombreOficio, String pNombreEmpresa, int pDuracion) {
		edad = pEdad;
		genero = pGenero;
		esSoltero = pEsSoltero;
		colorDePiel = pColorDePiel;
		trabajoActual = new Trabajo(pNombreOficio, pNombreEmpresa, pDuracion);
	}
	
	//Métodos - Cosas que hace la persona
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
	
	public void cambiarEsSoltero(boolean nuevoEstado) {
		esSoltero = nuevoEstado;
	}
	
	public void imprimirNombreTrabajo() {
		System.out.println(trabajoActual.darNombreOficioRealizado());
	}
}
