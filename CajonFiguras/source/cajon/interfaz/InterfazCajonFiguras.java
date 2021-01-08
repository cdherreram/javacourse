package cajon.interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import cajon.mundo.*;

public class InterfazCajonFiguras extends JFrame {

	private PanelListaFiguras panelListaFiguras;
	private PanelFiguras panelFiguras;
	private PanelBotones panelBotones;
	private PanelDatosFiguras panelDatosFiguras;
	private PanelTitulo panelTitulo;
	private CajonFiguras cajonFiguras;
	
	/**
	 * Create the frame.
	 */
	public InterfazCajonFiguras() {
		
		/*
		 * Configuración de la interfaz
		 */
		configuracionFrame(this);
		
		/*
		 * Generación de Paneles
		 */
		
		generacionPaneles(this);
		
		/*
		 * Creación del cajón de figuras
		 */
		cajonFiguras = new CajonFiguras();
		actualizarLista();
	}
	
	
	public void verDatos( Figura figura) {
		panelDatosFiguras.mostrarDatos(figura);
	}
	
	private void actualizarLista ( ) {
		panelListaFiguras.refrescarLista( cajonFiguras.darFiguras());
	}
	
	
	public CajonFiguras getCajonFiguras () {
		return cajonFiguras;
	}
	/**
	 * Generación de paneles en el frame
	 * @param f Frame
	 */
	private void generacionPaneles(JFrame f) {

		/*
		 * Panel Título
		 */
		panelTitulo = new PanelTitulo();
		panelTitulo.setPreferredSize(new Dimension(600,70));
		f.add(panelTitulo, BorderLayout.NORTH);
		
		/*
		 * Panel Central
		 */
		JPanel panelCentral = new JPanel();
		configuracionPanel(panelCentral, 600, 250);
		//Configuro elementos en el panel Central
		panelListaFiguras = new PanelListaFiguras(this);
		panelFiguras = new PanelFiguras(this);
		panelCentral.add(panelListaFiguras);
		panelCentral.add(panelFiguras);
		//Adiciono panel central al JFrame
		f.add(panelCentral, BorderLayout.CENTER);
		
		/*
		 * Panel inferior
		 */
		JPanel panelInferior = new JPanel();
		configuracionPanel(panelInferior, 600, 70);
		//Configuro elementos en el panel Inferior
		panelBotones = new PanelBotones(this);
		panelDatosFiguras = new PanelDatosFiguras();
		panelInferior.add(panelBotones);
		panelInferior.add(panelDatosFiguras);
		//Adiciono panel Inferior al JFrame
		f.add(panelInferior, BorderLayout.SOUTH);
	}


	private void configuracionPanel (JPanel p, int ancho, int alto) {
		GridLayout gl = new GridLayout(1,2);
		gl.setHgap(5);
		p.setLayout(gl);
		p.setPreferredSize(new Dimension(ancho,alto));
	}
	
	private void configuracionFrame (JFrame f ) {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(new Dimension(600,500));
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setVgap(5);
		borderLayout.setHgap(10);
		f.setLayout(borderLayout);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazCajonFiguras frame = new InterfazCajonFiguras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
