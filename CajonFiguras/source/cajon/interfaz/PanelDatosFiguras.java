package cajon.interfaz;

import java.awt.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import cajon.mundo.*;
import cajon.mundo.Figura.Tipo;

public class PanelDatosFiguras extends JPanel {

	private JLabel labNumLados;
	private JLabel labPerimetro;
	private JLabel labTipoTriangulo;
	private JTextField txtTipoTriangulo;
	private JTextField txtNumLados;
	private JTextField txtEsTriangulo;

	/**
	 * Create the panel.
	 */
	public PanelDatosFiguras() {
		setVisible(true);
		setLayout(new GridLayout(3,2));
		
		labNumLados = new JLabel("Número de lados");
		labPerimetro = new JLabel("Perímetro");
		labTipoTriangulo = new JLabel("Tipo de triángulo");
		
		txtNumLados = new JTextField();
		txtNumLados.setEditable(false);
		txtEsTriangulo = new JTextField();
		txtEsTriangulo.setEditable(false);
		txtTipoTriangulo = new JTextField();
		txtTipoTriangulo.setEditable(false);
		
		add(labNumLados);
		add(txtNumLados);
		add(labPerimetro);
		add(txtEsTriangulo);
		add(labTipoTriangulo);
		add(txtTipoTriangulo);
	}
	
	public void mostrarDatos( Figura figura) {
		txtNumLados.setText(figura.getNumLados() + "");
		txtEsTriangulo.setText( figura.calcularPerimetro()+ " " );
		txtTipoTriangulo.setText(figura.determinarTipoTriangulo().toString());
	}
}
