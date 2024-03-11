package mismetodos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilsFecha {
	/**
	 * Suma dias a una fecha
	 * @param c
	 * @return 
	 */
	public static void calendarSumaDia(Calendar c) {
		c.add(Calendar.DAY_OF_MONTH, UtilsMenu.pidenumeromenu("Introduce los dias a sumar"));
	}
	
	/**
	 * Suma semanas a una fecha
	 * @param c
	 * @return 
	 */
	public static void calendarSumaSemanas(Calendar c) {
		c.add(Calendar.WEEK_OF_MONTH , UtilsMenu.pidenumeromenu("Introduce las semanas a sumar"));
	}
	
	/**
	 * Suma anios de una fecha
	 * @param c
	 */
	public static void calendarSumaAnios(Calendar c) {
		c.add(Calendar.YEAR, UtilsMenu.pidenumeromenu("Introduce los años a sumar"));
		
	}
	

	/**
	 * Este metodo permite introducir una fecha
	 * 
	 * @return
	 */
	public static Date introducirFecha() {
		boolean fechaCorrecta = true;
		SimpleDateFormat formatoFecha;
		Date fechaParseada = null;

		do {
			String fecha1 = UtilsMenu.pideTextoMenu("Introduce una fecha con formato: \ndd/MM/yyyy HH:mm:ss");
			fechaCorrecta = true;
			// Formato de la fecha
			formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			try {

				fechaParseada = formatoFecha.parse(fecha1);

			} catch (Exception e) {
				UtilsMenu.mensajemenu("Error de fecha");
				fechaCorrecta = false;
			}

		} while (!fechaCorrecta);

		return fechaParseada;
	}

	/**
	 * Convierte un tipo date a calendar
	 * @param fec
	 * @return
	 */
	public static Calendar converCalendar(Date fec) {
		Calendar fechaCalenda = Calendar.getInstance();
		fechaCalenda.setTime(fec);

		return fechaCalenda;

	}
	
	/**
	 * Covierte un tipo calendar a date
	 * @param c
	 * @return
	 */
	public static Date converDate(Calendar c) {
		Date fechaDate = c.getTime();
		
		return fechaDate;	
	}
	
	
	/**
	 * Formatea una fecha escrita a un tipo date
	 * @param fechaString
	 * @return
	 */
	public static Date formateoFecha(String fechaString) {
		Date fechaDate = new Date();
		SimpleDateFormat sdf;
		String formato = null;
		// String formateoFecha; //= UtilsMenu.pideTextoMenu(fechaString);

//		int opc = UtilsMenu.pidenumeromenu(
//				"Introduce un formato para la fecha \n" + "1 yyyy-MM-dd HH:mm:ss \n" + "2 dd-MM-yyyy HH:mm:ss");
//
//		switch (opc) {
//
//		case 1:
//			formato = "yyyy-MM-dd HH:mm:ss";
//			break;
//		case 2:
//			formato = "dd-MM-yyyy HH:mm:ss";
//			break;
//		default:
//			UtilsMenu.mensajemenu("opcion no valida");
//		}

		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {

			fechaDate = sdf.parse(fechaString);
			System.out.println("parseo completado");
		} catch (Exception e) {
			System.err.println(e.getMessage());

		}
		
		return fechaDate;
	}
	
	/**
	 * Introducir fechas compatibles con mysql
	 * Formatea una fecha sql
	 * @param fecha
	 * @return devuelve un string con la fecha
	 */
	public static String fechaSQL(String fecha) {
		SimpleDateFormat sdfentrada = new SimpleDateFormat("dd/MM/yyyy");
		String fechadelUsuario = fecha;
		
		Date date = new Date();
		try {
			
			date = sdfentrada.parse(fechadelUsuario);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		SimpleDateFormat sdfsalida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdfsalida.format(date);
	}
	
	/**
	 * convierte un string a una fecha compatible con sql
	 * @param fecha
	 * @param formato
	 * @return
	 */
	public static java.sql.Date converDATEsql(String fecha, String formato) {
		SimpleDateFormat sdf;
		
		//Formateo de fecha
		if (formato == null) {
			sdf = new SimpleDateFormat("dd/MM/yyyy");
		} 
		
		else {
			sdf = new SimpleDateFormat(formato);
		}
		
		try {
			java.util.Date fechajava = sdf.parse(fecha);
			
			// Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaSQL = new java.sql.Date(fechajava.getTime());
			
			return fechaSQL;
            
		} catch (ParseException e) {
			System.err.println("Problema al formatear la fecha");
			
			e.printStackTrace();
		}
		
		return null;

	}
	
	/**
	 * Convierte una fecha sql a string
	 * @param fecha
	 * @param formato
	 * @return
	 */
	public static String sqlDateAString(java.sql.Date fecha, String formato) {
		SimpleDateFormat sdf;
		
		
		if (formato == null) sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		else sdf = new SimpleDateFormat(formato);
		
		String fechaStr = sdf.format(fecha);
		
		return fechaStr;
	}
	
}
