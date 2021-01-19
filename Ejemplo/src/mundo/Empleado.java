package mundo;


public class Empleado {
	protected int id;
	private String horario;
	private String nombre;
	
	public Empleado(int id, String horario, String nombre) {
		this.id = id;
		this.horario = horario;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre ( int edad) {
		return this.nombre + edad;
	}
	
	
	
}
