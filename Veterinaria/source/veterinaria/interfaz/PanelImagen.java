package veterinaria.interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelImagen extends JPanel {

	private JLabel labImagen;
	/**
	 * Create the panel.
	 */
	public PanelImagen() {
		FlowLayout layout = new FlowLayout();
		layout.setHgap( 0 );
        layout.setVgap( 0 );
		setLayout(layout);
		
		ImageIcon icono = new ImageIcon("data/imagen.jpg");
		Image image = icono.getImage();
		Image newimage = image.getScaledInstance(400, 150, java.awt.Image.SCALE_DEFAULT);
		icono = new ImageIcon(newimage);
		
		labImagen = new JLabel( "" );
		labImagen.setIcon(icono);
		add(labImagen);
		
		setBackground( Color.WHITE);
		setBorder(new LineBorder(Color.GRAY));
	}

}
