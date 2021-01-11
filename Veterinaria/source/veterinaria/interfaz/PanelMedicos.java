package veterinaria.interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class PanelMedicos extends JPanel implements ActionListener {

	/*
	 * Constantes
	 */
	public final static String BOTON5 = "Botón 5";
	public final static String BOTON6 = "Botón 6";
	
	/*
	 * Atributos
	 */
	private JButton but5;
	private JButton but6;
	private JScrollPane scrMascotas;
	private JList listaMedicos;
	
	/*
	 * Constructor
	 */
	public PanelMedicos() {
		setLayout(new GridLayout(1,2));
		setPreferredSize( new Dimension(133, 180));
		setForeground( Color.BLUE);
		
		TitledBorder border = BorderFactory.createTitledBorder( "Personal");
		border.setTitleColor(Color.LIGHT_GRAY);
		setBorder(border);
		
		JPanel panelScroll = new JPanel();
		panelScroll.setLayout(new GridLayout(1,1));
		panelScroll.setSize(getWidth()/2,getHeight());
		add(panelScroll);
		
		listaMedicos = new JList();
		listaMedicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaMedicos.setForeground(Color.BLACK);
		JScrollPane scrMedicos = new JScrollPane(listaMedicos);
		scrMedicos.setBorder(new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ));
		panelScroll.add(scrMedicos);
		
		JPanel panelBotones = new JPanel();
		add(panelBotones);
		panelBotones.setLayout(new GridLayout(2, 1, 0, 0));
		
		but5 = new JButton("Botón 5");
		but5.setActionCommand(BOTON5);
		but5.addActionListener(this);
		panelBotones.add(but5);
		
		but6 = new JButton( "Botón 6");
		but6.setActionCommand(BOTON6);
		but6.addActionListener(this);
		panelBotones.add(but6);
	}
	
	public void refrescarLista( ArrayList nuevaLista) {
		listaMedicos.setListData( nuevaLista.toArray( ) );
		listaMedicos.setSelectedIndex(0);
	}
	
	public void seleccionar( int seleccionado )
    {
        listaMedicos.setSelectedIndex( seleccionado );
        listaMedicos.ensureIndexIsVisible( seleccionado );
    }
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		
		if ( comando.equals(BOTON6)) {
			JOptionPane.showMessageDialog(this, "Pronto se implementará este botón");;
			
		} else if ( comando.equals(BOTON5)) {
			JOptionPane.showMessageDialog(this, "Pronto se implementará este botón");;
			
		}
		
	}
}
