package buscaminas.mundo;

public enum Nivel {
	PRINCIPIANTE(8, 8, 10), INTERMEDIO(16, 16, 40), EXPERTO(16, 30,99);
	
	private int casillasFilas;
	private int casillasColumnas;
	private int numBombas;
	Nivel ( int casillasFilas, int casillasColumnas, int numBombas) {
		this.casillasFilas = casillasFilas;
		this.casillasColumnas = casillasColumnas;
		this.numBombas = numBombas;
	}
	
	public int getCasillasFilas () {
		return casillasFilas;
	}
	
	public int getCasillasColumnas() {
		return casillasColumnas;
	}
	
	public int getNumBombas () {
		return numBombas;
	}
}
