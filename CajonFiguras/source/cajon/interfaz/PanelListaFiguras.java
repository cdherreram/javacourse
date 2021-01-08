package cajon.interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cajon.mundo.*;

public class PanelListaFiguras extends JPanel implements ListSelectionListener {

	private JList listaFiguras;
	private JScrollPane scrFiguras;
	
	private InterfazCajonFiguras principal;

	/**
	 * Create the panel.
	 */
	public PanelListaFiguras( InterfazCajonFiguras interfaz) {
		
		principal = interfaz;
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);
		
		TitledBorder border = BorderFactory.createTitledBorder( "Lista de Figuras");
		border.setTitleColor(Color.LIGHT_GRAY);
		setBorder(border);
		
		listaFiguras = new JList();
		listaFiguras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaFiguras.addListSelectionListener(this);
		
		
		scrFiguras = new JScrollPane(listaFiguras);
		scrFiguras.setVisible(true);
		scrFiguras.setPreferredSize(new Dimension(200,250));
		add(scrFiguras);
	}
	
	public void refrescarLista( ArrayList lista) {
		listaFiguras.setListData(lista.toArray());
		listaFiguras.setSelectedIndex(0);
	}

	public void seleccionar( int seleccionado )
    {
        listaFiguras.setSelectedIndex( seleccionado );
        listaFiguras.ensureIndexIsVisible( seleccionado );
    }
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if( listaFiguras.getSelectedValue( ) != null )
        {
            Figura p = ( Figura )listaFiguras.getSelectedValue( );
            principal.verDatos( p );
        }
	}
}
