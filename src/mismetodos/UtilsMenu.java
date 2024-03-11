package mismetodos;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UtilsMenu {

	/**
	 * Una platilla para menus que se puede modificar facilmente
	 * 
	 * @return
	 */
	public static int pantillaMenu() {

		int num = UtilsMenu.pidenumeromenuV2(
				"Opciones \n" + "1. opc \n" + "2. opc \n" + "3. opc \n" + "4. opc \n" + "5. opc \n" + "6. opc \n");

		return num;
	}

	/**
	 * Muentra un menu que pide texto por pantalla
	 * 
	 * @param s
	 * @return
	 */
	public static String pideTextoMenu(String s) {

		String str = JOptionPane.showInputDialog(s);

		return str;
	}

	/**
	 * Muestra un menu al que se le inserta un numero
	 * 
	 * @param s
	 * @return
	 */
	public static int pidenumeromenu(String s) {
		int n = 0;
		boolean esNumeroCorrecto;

		do {
			esNumeroCorrecto = false;
			try {
				n = Integer.parseInt(JOptionPane.showInputDialog(s));
				esNumeroCorrecto = true;
			} catch (Exception e) {
				System.out.println("No ha introducido un número");
			}
		} while (esNumeroCorrecto == false);

		return n;
	}

	public static int pidenumeromenuV2(String s) {
		int n = 0;
		boolean esNumeroCorrecto;
		boolean cancelado = false;

		do {
			esNumeroCorrecto = false;
			try {
				String input = JOptionPane.showInputDialog(s);

				// Verificar si se ha cancelado la entrada (input es null)
				if (input == null) {
					cancelado = true;
					break; // Salir del bucle
				}

				n = Integer.parseInt(input);
				esNumeroCorrecto = true;
			} catch (NumberFormatException e) {
				UtilsMenu.mensajemenu("No se a introducido un numero valido");
			}
		} while (!esNumeroCorrecto);

		// Si se ha cancelado la entrada, puedes manejarlo según tus necesidades
		if (cancelado) {
			// Puedes elegir qué hacer en este caso, por ejemplo, salir del programa
			System.exit(0);
		}

		return n;
	}

	public static Float pidenumeromenuV2float(String s) {
		float n = 0;
		boolean esNumeroCorrecto;
		boolean cancelado = false;

		do {
			esNumeroCorrecto = false;
			try {
				String input = JOptionPane.showInputDialog(s);

				// Verificar si se ha cancelado la entrada (input es null)
				if (input == null) {
					cancelado = true;
					break; // Salir del bucle
				}

				n = Float.parseFloat(input);
				esNumeroCorrecto = true;
			} catch (NumberFormatException e) {
				UtilsMenu.mensajemenu("No se a introducido un numero valido");
			}
		} while (!esNumeroCorrecto);

		// Si se ha cancelado la entrada, puedes manejarlo según tus necesidades
		if (cancelado) {
			// Puedes elegir qué hacer en este caso, por ejemplo, salir del programa
			System.exit(0);
		}

		return n;
	}

	/**
	 * Muestra un menu al que se le inserta un numero
	 * 
	 * @param s
	 * @return
	 */
	public static double pidenumeromenudouble(String s) {
		double n = 0;
		boolean esNumeroCorrecto;

		do {
			esNumeroCorrecto = false;
			try {

				n = Double.parseDouble(JOptionPane.showInputDialog(s));
				esNumeroCorrecto = true;
			} catch (Exception e) {
				System.out.println("No ha introducido un número");
			}
		} while (esNumeroCorrecto == false);

		return n;
	}

	/**
	 * Muestra una ventana de cierre y se cierra si se pulsa aceptar
	 * 
	 * @param mensaje
	 * @param titulo
	 * @param v
	 */
	public static void cierraVentana(String mensaje, String titulo, JFrame v) {
		String[] opciones = { "Aceptar", "Cancelar" };

		// sintaxis de showOptionDialog ¿Sobre donde?, ¿Que texto?, ¿Que titulo?,
		// ¿Que tipo?, ¿Que tipo de mesaje?, cosa, opciones, por defecto

		int eleccion = JOptionPane.showOptionDialog(v, mensaje, titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");

		// compare si lo que a salido de eleccion es igual al YES_OPTION
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	/**
	 * metodo para realiazar una pregunta al usuario y devolver falso o verdadero
	 * 
	 * @param mensaje
	 * @param titulo
	 * @param v
	 * @return
	 */
	public static boolean pregunta(String mensaje, String titulo, JFrame v) {
		String[] opciones = { "Aceptar", "Cancelar" };

		// sintaxis de showOptionDialog ¿Sobre donde?, ¿Que texto?, ¿Que titulo?,
		// ¿Que tipo?, ¿Que tipo de mesaje?, cosa, opciones, por defecto

		int eleccion = JOptionPane.showOptionDialog(v, mensaje, titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");

		// compare si lo que a salido de eleccion es igual al YES_OPTION
		if (eleccion == JOptionPane.YES_OPTION) {
			return true;
		}

		else {
			return false;
		}
	}

	public static void mensajemenu(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

}
