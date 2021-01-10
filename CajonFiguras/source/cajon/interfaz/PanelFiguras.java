package cajon.interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.util.*;
import java.awt.*;
import cajon.mundo.*;
import java.awt.Color;

public class PanelFiguras extends JPanel {

	private JLabel labFigura;
	
	private InterfazCajonFiguras principal;
	
	private Graphics g;
	
	private ArrayList<Integer> x;
	
	private ArrayList<Integer> y;

	private int numLados;

	private int[] xPrim;

	private int[] yPrim;

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
		
		x = new ArrayList<Integer>();
		y = new ArrayList<Integer>();
		numLados = 0;
	}
	
	public Graphics getG () {
		return g;
	}

//	@Override
//	protected void paintComponent(Graphics g) {
//		// TODO Auto-generated method stub
//		int[] xPrim = new int [numLados];
//		int[] yPrim = new int [numLados];
//		for ( int i = 0 ; i < numLados; i++) {
//			xPrim[i] = x.get(i);
//			yPrim[i] = y.get(i);
//		}
//		
//		super.paintComponent(g);
//		Graphics2D gG = (Graphics2D) g.create(20, 20, 250, 250);
//		
//		gG.setColor(Color.RED);
//		gG.drawPolygon(xPrim, yPrim, numLados);
//
//	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

//		Graphics2D gG = (Graphics2D) g.create(20, 20, 250, 250);
//		gG.setColor(Color.RED);
//		if ( numLados != 0) gG.drawPolygon(xPrim, yPrim, numLados);
		g.setColor(Color.RED);
		g.create(20, 20, 250, 250);
		
		if ( numLados != 0) {
			g.drawPolygon(xPrim, yPrim, numLados);
		}
	}

	public void actualizarFiguras( Figura f ) {
		x.clear();
		y.clear();
		numLados = f.getNumLados();
		
		Punto[] puntos = f.getPuntos();
		for ( int i = 0; i < f.getNumLados(); i++) {
			int[] coord = (int[]) puntos[i].getCoordenadas();
			int xCurrent = coord[0];
			int yCurrent = coord[1];
			x.add(xCurrent);
			y.add(yCurrent);
		}
		
		xPrim = new int [numLados];
		yPrim = new int [numLados];
		for ( int i = 0 ; i < numLados; i++) {
			xPrim[i] = x.get(i);
			yPrim[i] = y.get(i);
		}
	}
}
