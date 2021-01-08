package cajon.interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class PanelFiguras extends JPanel {

	private JLabel labFigura;
	
	private InterfazCajonFiguras principal;

	/**
	 * Create the panel.
	 */
	public PanelFiguras(InterfazCajonFiguras interfaz) {
		principal = interfaz;
		setBackground(Color.WHITE);
		setVisible(true);
		
		TitledBorder border = BorderFactory.createTitledBorder( "Figura");
		border.setTitleColor(Color.LIGHT_GRAY);
		border.setBorder(new LineBorder(Color.BLACK, 2));
		setBorder(border);
		
	}
	
	public void paintComponent( Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		
		Graphics2D gG = (Graphics2D) g2D.create(20, 20, 250, 250);
		
		gG.setColor(Color.MAGENTA);
		gG.drawLine(0, 0, 250, 250);
		gG.setColor(Color.RED);
		int[] x = {100,200,100};
		int[] y = {150,50,100};
		gG.drawPolygon(x, y, 3);
		
//		gG.drawLine(0, 0, 100, 100);
		
	}
}
