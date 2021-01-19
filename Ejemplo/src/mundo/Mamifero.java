package mundo;

public class Mamifero extends Animal{
	private String raza;

	public Mamifero(int edad, String nombreDuenho, String color, String raza) {
		super(edad, nombreDuenho, color);
		this.raza = raza;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	@Override
	public String getDatos ( ) {
		return super.getDatos() + ", " + raza;
	}
	
	@Override
	public String getDatos ( String cualidad) {
		return "Soy un perrito lindo y " + cualidad;
	}
}
