package buscaminas.interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import buscaminas.mundo.Nivel;

public class VentanaNivel extends JFrame implements ActionListener{
	private JPanel panel;
	private JComboBox cblista;
	private JList lista;
	private JButton botonAceptar;
	private Nivel info;
	
	public VentanaNivel() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setSize(180,150);
		setLocation(300,300);
		panel = new JPanel();
		cblista = new JComboBox();
		lista = new JList();
		info = Nivel.PRINCIPIANTE;
		lista.setSelectedIndex(0);
		botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(this);
		for (Nivel nivel : Nivel.values()) {
			cblista.addItem(nivel);
		}
		panel.add(cblista);
		panel.add(botonAceptar);
		add(panel);
	}

	
	public Nivel getInfo() {
		return info;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		info = (Nivel) lista.getSelectedValue();
		try {
			this.finalize();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
