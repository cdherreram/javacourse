package prueba.mundo;

public class Figura {
	
	int numLados;
	
	public Figura (int pNumLados) {
		numLados = pNumLados;
	}
	
	public int darNumLados() {
		return numLados;
	}
	
	public static void main(String[] args) {
		Figura unaFigura;
		unaFigura = new Figura(4);
		System.out.println("Esta figura tiene " + Integer.toString(unaFigura.darNumLados())+ " lados.");
	}
}