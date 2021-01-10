package cajon.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTitulo extends JPanel {

	private JLabel labTitulo;

	/**
	 * Create the panel.
	 */
	public PanelTitulo() {
		//setBackground(Color.BLACK);
		//setForeground(Color.WHITE);
		
		
		ImageIcon icono = new ImageIcon("data/imagen.jpg");
		Image image = icono.getImage();
		Image newimage = image.getScaledInstance(600, 80, java.awt.Image.SCALE_DEFAULT);
		icono = new ImageIcon(newimage);
		
		labTitulo = new JLabel("FIGURAS");
		labTitulo.setIcon(icono);
		labTitulo.setForeground(Color.BLACK);
		labTitulo.setFont(new Font("Arial", Font.BOLD, 60));
		labTitulo.setHorizontalTextPosition(JLabel.CENTER);
		labTitulo.setVerticalTextPosition(JLabel.CENTER);
		add(labTitulo);
		
	}

}
