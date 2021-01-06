package cargaDatos.mundo;

import java.io.*;
import java.util.*;
import javax.swing.*;


public class CargaDatos {

	public static void main(String[] args) {
		List lineas = new ArrayList();
		try{
			BufferedReader br = new BufferedReader(new FileReader("data/datos.csv"));
			String line;
			while ((line = br.readLine()) != null) {
		        String[] values = line.split(";");
		        System.out.println("Nombre libro: " + values[0]);
		        System.out.println("Peso: " + values[1]);
		        System.out.println("Hojas: " + values[2]);
		    }
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error en la carga de datos");
		}
	}

}
