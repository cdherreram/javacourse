package mundo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.time.*;

public class Main {
	
	public static void main(String[] args) {
	
//		Date nuevaFecha = new Date(); // Se crea primero
//		System.out.println(nuevaFecha);
//		Date nuevaFecha2 = new Date();
//		System.out.println(nuevaFecha2);
//		System.out.println(nuevaFecha.compareTo(nuevaFecha2)); // new Date () es ahora
//		System.out.println(nuevaFecha.getHours( )); // Formato militar - Deprecated
//		Date nuevaFecha3 = new Date(100, 4, 25); // Año = 1900 + 100, mes inicia desde 0 
//		System.out.println(nuevaFecha3);
//		Calendar fecha = new GregorianCalendar(2000, Calendar.APRIL, 30);
//		SimpleDateFormat formato = new SimpleDateFormat("dd-mm-yyyy hh:mm");
		
		Empleado empleado1 = new Empleado(1, "Mañana", "Juan");
		System.out.println(empleado1.getNombre());
		Asistente asistente1 = new Asistente(2, "Tarde", "Maria Paula", "Cajera");
		System.out.println(asistente1.getNombre());
		System.out.println(asistente1.getDatos());
		System.out.println(asistente1.getNombre("la colaboracion"));
		
		
	}
}
