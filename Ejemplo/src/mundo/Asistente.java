package mundo;

public class Asistente extends Empleado{

	private String puesto;

	public Asistente (int id, String horario, String nombre, String puesto) {
		super(id, horario, nombre);
		this.puesto = puesto;
	}
	
	public int getIdAsistente () {
		return super.id; //O(1)
	}
	
	public void setIdAsistente(int idNuevo) {
		super.setId(idNuevo);
	}
	
	@Override //Overloading
	public String getNombre() {
		//return super.getNombre() + ", asistente";
		return "Soy un asistente hermoso";
	}
	
	public String getDatos() {
		return super.getNombre() + " y mi horario es " + getHorario();
	}
	
	//Overloading
	public String getNombre ( String cualidad ) {
		return "Mi principal cualidad es " + cualidad;
	}
}