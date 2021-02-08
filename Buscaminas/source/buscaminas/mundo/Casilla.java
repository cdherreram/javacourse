package buscaminas.mundo;

public class Casilla {
	
	private boolean conBomba;
	private int numBombasAlrededor;
	
	public Casilla( boolean conBomba, int numBombasAlrededor) {
		this.conBomba = conBomba;
		this.numBombasAlrededor = numBombasAlrededor;
	}

	public boolean isConBomba() {
		return conBomba;
	}

	public void setConBomba(boolean conBomba) {
		this.conBomba = conBomba;
	}

	public int getNumBombasAlrededor() {
		return numBombasAlrededor;
	}

	public void setNumBombasAlrededor(int numBombasAlrededor) {
		this.numBombasAlrededor = numBombasAlrededor;
	}

	@Override
	public String toString() {
		return "Casilla [conBomba=" + conBomba + ", numBombasAlrededor=" + numBombasAlrededor + "]";
	}
	
	
}
