package veterinaria.interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import veterinaria.mundo.*;

public class InterfazVeterinaria extends JFrame {

	private Veterinaria veterinaria;
	private PanelImagen panelImagen;
	private PanelMascotas panelMascotas;
	private PanelMedicos panelMedicos;
	private PanelInformacion panelInformacion;
	
	/**
	 * Crear la interfaz con JFrame.
	 */
	public InterfazVeterinaria() {
		setTitle("Veterinaria");
		setSize(500, 600); //setBounds(100, 100, 450, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout( new GridLayout(4,1));
		
		panelImagen = new PanelImagen();
		add( panelImagen);
		
		panelMascotas = new PanelMascotas();
		add(panelMascotas);
		
		panelInformacion = new PanelInformacion();
		add(panelInformacion);
		
		panelMedicos = new PanelMedicos();
		add(panelMedicos);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazVeterinaria frame = new InterfazVeterinaria();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
