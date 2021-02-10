package buscaminas.interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import buscaminas.mundo.Nivel;

public class VentanaNivel extends JFrame implements ActionListener{
	
	private JPanel panel;
	private JComboBox<Nivel> cblista;
	private JButton botonAceptar;
	private Nivel info;
	private InterfazBuscaminas principal;
	
	public VentanaNivel(InterfazBuscaminas interfaz) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setSize(180,150);
		setLocation(300,300);
		principal = interfaz;
		panel = new JPanel();
		TitledBorder border = BorderFactory.createTitledBorder( "Nivel");
		border.setTitleColor(Color.LIGHT_GRAY);
		panel.setBorder(border);
		cblista = new JComboBox<Nivel>();
		for (Nivel nivel : Nivel.values()) {
			cblista.addItem(nivel);
		}
		cblista.setSelectedIndex(0);
		botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(this);
		panel.add(cblista);
		panel.add(botonAceptar);
		add(panel);
	}
	
	public Nivel getInfo() {
		return info;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAceptar) {
			info = (Nivel) cblista.getSelectedItem();
			principal.inicializarJuego(info);
			this.dispose();
		}
	}
	
}
