package veterinaria.interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelInformacion extends JPanel {
	
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtPropietario;
	private JTextField txtFechaIngreso;
	
	private JLabel labNombre;
	private JLabel labEdad;
	private JLabel labPropietario;
	private JLabel labFechaIngreso;
	
	private JCheckBox cbSeguro;
	
	/**
	 * Create the panel.
	 */
	public PanelInformacion() {
		setLayout(new GridLayout(5,2));
		setPreferredSize( new Dimension(0,130));
		
		TitledBorder border = BorderFactory.createTitledBorder( "Información");
		border.setTitleColor(Color.LIGHT_GRAY);
		setBorder(border);
		
		labNombre = new JLabel("Nombre");
		labEdad = new JLabel("Edad");
		labPropietario = new JLabel("Propietario");
		labFechaIngreso = new JLabel("Fecha de ingreso");
		
		cbSeguro = new JCheckBox("Seguro médico");
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtPropietario = new JTextField();
		txtPropietario.setEditable(false);
		txtFechaIngreso = new JTextField();
		txtFechaIngreso.setEditable(false);
		
		add(labNombre);
		add(txtNombre);
		add(labEdad);
		add(txtEdad);
		add(labPropietario);
		add(txtPropietario);
		add(labFechaIngreso);
		add(txtFechaIngreso);
		add(new JLabel(""));
		add(cbSeguro);
	}
}
