package veterinaria.interfaz;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

public class PanelMascotas extends JPanel implements ActionListener {

	/*
	 * Constantes
	 */
	public final static String BOTON1 = "Botón 1";
	public final static String BOTON2 = "Botón 2";
	public final static String BOTON3 = "Botón 3";
	public final static String BOTON4 = "Botón 4";
	
	/*
	 * Atributos
	 */	
	private JButton but1;
	private JButton but2;
	private JButton but3;
	private JButton but4;
		
	private JScrollPane scrMascotas;
	private JList listaMascotas;

	
	/*
	 * Constructor
	 */
	
	
	/**
	 * Construye el panel donde se manejan las principales características de las mascotas
	 */
	public PanelMascotas( ) {
		
		setLayout(new GridLayout(1,2));
		setPreferredSize( new Dimension(0,130));
		
		TitledBorder border = BorderFactory.createTitledBorder( "Mascotas");
		border.setTitleColor(Color.LIGHT_GRAY);
		setBorder(border);
		
		JPanel panelScrMascotas = new JPanel();
		GridLayout gl_panelScrMascotas = new GridLayout(1,1);
		gl_panelScrMascotas.setVgap(30);
		panelScrMascotas.setLayout(gl_panelScrMascotas);
		panelScrMascotas.setSize(new Dimension(this.getWidth()/2, HEIGHT));
		
		listaMascotas = new JList();
		listaMascotas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrMascotas = new JScrollPane(listaMascotas);
		scrMascotas.setBorder(new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ));
		
		panelScrMascotas.add(scrMascotas);
		
		JPanel panelBotones = new JPanel();
		GridLayout gl_panelBotones = new GridLayout(4,1);
		gl_panelBotones.setVgap(8);
		panelBotones.setLayout(gl_panelBotones);
		panelBotones.setSize(new Dimension(this.getWidth()/2, HEIGHT));
		
		but1 = new JButton("Botón 1");
		but1.setActionCommand(BOTON1);
		but1.addActionListener(this);
		
		but2 = new JButton("Botón 2");
		but2.setActionCommand(BOTON2);
		but2.addActionListener(this);
		
		but3 = new JButton("Botón 3");
		but3.setActionCommand(BOTON3);
		but3.addActionListener(this);
		
		but4 = new JButton("Botón 4");
		but4.setActionCommand(BOTON4);
		but4.addActionListener(this);
		
		panelBotones.add(but1);
		panelBotones.add(but3);
		panelBotones.add(but2);
		panelBotones.add(but4);
		
		add(panelScrMascotas);
		add(panelBotones);		
	}
	
	
	public void refrescarLista( ArrayList nuevaLista) {
		listaMascotas.setListData( nuevaLista.toArray( ) );
		listaMascotas.setSelectedIndex(0);
	}
	
	public void seleccionar( int seleccionado )
    {
        listaMascotas.setSelectedIndex( seleccionado );
        listaMascotas.ensureIndexIsVisible( seleccionado );
    }
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		String comando = evento.getActionCommand();
		
		if (comando.equals(BOTON1) ) {
			JOptionPane.showMessageDialog(this, "Pronto se implementará este botón");
			
		} else if ( comando.equals(BOTON3)) {
			
		} else if ( comando.equals(BOTON2)) {
			
		} else if ( comando.equals(BOTON4)) {
			
		}
	}
	
	
}
