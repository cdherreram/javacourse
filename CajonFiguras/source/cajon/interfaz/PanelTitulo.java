package cajon.interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTitulo extends JPanel {

	private JLabel labTitulo;

	/**
	 * Create the panel.
	 */
	public PanelTitulo() {
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		
		labTitulo = new JLabel("FIGURAS");
		labTitulo.setForeground(Color.WHITE);
		labTitulo.setFont(new Font("Arial", Font.BOLD, 60));
		add(labTitulo);
		
	}

}
