package celular.interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelNuevo extends JPanel{

	/*
	 * Atributos
	 */
	JTextField cuadroDeTexto;
	JRadioButton botonRedondo;
	JComboBox miComboBox;
	
	/*
	 * Constructor
	 */
	public PanelNuevo() {
		
		this.setLayout( new GridLayout( 3 , 4 ) );
		
		cuadroDeTexto = new JTextField("Agregue lo que usted desee");
		cuadroDeTexto.setEditable(false);
		botonRedondo = new JRadioButton("Easy");
		miComboBox = new JComboBox<>();
		
		add(cuadroDeTexto);
		add(botonRedondo);
		add(miComboBox);
	}
	
	
}
