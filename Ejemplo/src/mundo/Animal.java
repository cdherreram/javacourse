package mundo;

public class Animal {
  // Tres subclases:
	// Pez
	// Mamifero
	// Ave
	
	//En la clase Animal (edad, nombreDuenho, color)
	// getDatos ( ) : edad + color
	// getDatos ( cualidad ) : edad + color + nombreDuenho + cualidad
	
	// En las subclases:
	// nuevo atributo: raza
	// getDatos ( ) : 
	
	private int edad;
	private String nombreDuenho;
	private String color;
	
	public Animal(int edad, String nombreDuenho, String color) {
		this.edad = edad;
		this.nombreDuenho = nombreDuenho;
		this.color = color;
	}
	
	
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombreDuenho() {
		return nombreDuenho;
	}

	public void setNombreDuenho(String nombreDuenho) {
		this.nombreDuenho = nombreDuenho;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDatos() {
		return getEdad() + ", " + getColor();
	}
	
	public String getDatos ( String cualidad) {
		return edad + ", " + color + " , " + nombreDuenho + ", " + cualidad;
	}
	
	public int imprimirNumeros (String h, double d, int ... v) {
		
		for ( int i = 0; i < v.length; i++) {
			System.out.println("Soy el numero " + v[i]);
		}
		System.out.println(h);
		return 0;
	}

	public static void main(String[] args) { 
		Animal animal1 = new Animal(5, "Juan Pablo", "Café");
		System.out.println(animal1.getDatos());
		Mamifero mamifero1 = new Mamifero(5, "Dario", "Blanco", "golden");
		System.out.println(mamifero1.getDatos()); // mamifero1 es Mamifero pero también es Animal
		Animal animal2 = (Animal) mamifero1; // Polimorfismo
		System.out.println( animal2.getDatos() ); // 
		//Animal animal3 = new Mamifero(6, "Diago", "amarillo", "poddle");
		animal2.imprimirNumeros("Hola", 3.0, 3,4,5,6,7,8,9,6,5,3,2,4,6,6,5,4,3,2);
		animal2.imprimirNumeros("Hola2", 5);
	}
}
