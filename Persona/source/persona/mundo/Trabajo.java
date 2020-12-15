package persona.mundo;

public class Trabajo {
	
	//Atributos
	private String nombreOficioRealizado;
	private String nombreEmpresa;
	private int duracion;
	private int salario;
	
	//Constructor
	public Trabajo(String nombreOficioRealizado, String pNombreEmpresa, int pDuracion) {
		this.nombreOficioRealizado = nombreOficioRealizado;
		nombreEmpresa = pNombreEmpresa;
		duracion = pDuracion;
	}
	
	//Métodos getter y setter
	
	public String darNombreOficioRealizado() {
		return this.nombreOficioRealizado;
	}
	
	public String darNombreEmpresa() {
		return nombreEmpresa;
	}
	
	public int darDuracion() {
		return duracion;
	}
	
//	public int darSalario() {
//		return salario;
//	}
	
	public void cambiarNombreOficioRealizado( String pNombreOficioRealizado) {
		nombreOficioRealizado = pNombreOficioRealizado;
	}
	
	public void cambiarNombreEmpresa( String pNombreEmpresa) {
		nombreEmpresa = pNombreEmpresa;
	}
	
	public void cambiarDuracion(int pDuracion) {
		duracion = pDuracion;
	}
	
	
}
