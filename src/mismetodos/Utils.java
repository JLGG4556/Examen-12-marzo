package mismetodos;

import java.util.Scanner;

public class Utils {

	/**
	 * Se obtiene un numero al azar del 0 al 100
	 * 
	 * @return Devuelve el numero obtenido
	 */
	public static int obtenerNumeroAzar() {
		return (int) Math.round(Math.random() * 100);
	}
	
	/**
	 * obtione los un numero al azar entre los limites de un array
	 * @param a
	 * @return
	 */
	public static int obtenerNumeroAzardeLongituddeArray(int[] a) {
		return (int) Math.round(Math.random() * ((a.length - 1) - 0));
	}
	
	/**
	 * Este metodo devuelve un numero del 0 al 100 que es primo
	 * @return devuelve el valor primo
	 */
	public static int obtenerPrimoAzar() {
		int num;
		
		do {
			
			num = (int) Math.round(Math.random() * 100);
			
		} while (!compruebaPrimo(num));
		return num;
	}
	
	/**
	 * Pide un numeor primo entre dos limites
	 * @param min
	 * @param max
	 * @return
	 */
	public static int obtenerPrimoAzar(int min, int max) {
		int num;
		
		do {
			
			num = (int) Math.round(Math.random() * (max - min)) + min;
			
		} while (!compruebaPrimo(num));
		
		return num;
	}

	/**
	 * Se obtiene un numero al azar entre dos limites
	 * 
	 * @param Este el limite menor
	 * @param Este el limite mayor
	 * @return Devuelve el numero obtenido
	 */
	public static int obtenerNumeroAzarConLimites(int min, int max) {
		return (int) Math.round(Math.random() * (max - min)) + min;

	}

	/**
	 * Este metodo pide un numero
	 * 
	 * @param Mensaje a mostrar
	 * @return Devuelve el valor introducir
	 */
	public static int pideNumeroEntero(String mensaje) {
		int n = 0;
		boolean esNumeroCorrecto;
		Scanner sc = new Scanner(System.in);

		do {
			esNumeroCorrecto = false;
			try {
				System.out.println(mensaje);
				n = Integer.parseInt(sc.nextLine());
				esNumeroCorrecto = true;
			} catch (Exception e) {
				System.err.println("No ha introducido un número");
			}
		} while (esNumeroCorrecto == false);

		return n;
	}

	/**
	 * Diferencia si un numero es par o impar
	 * 
	 * @param a Variable a comprobar
	 */
	public static void DiferenciarNumerosParesoImpares(int a) {

		if (a % 2 == 0)
			System.out.println("Es par");

		else {
			System.out.println("Es impar");

		}

	}

	/**
	 * Combrueba si un numero es primo si lo es devuelve true
	 * 
	 * @param a Numero a comprobar
	 * @return Devuelve ture o false
	 */
	public static boolean compruebaPrimo(int a) {
		if (a <= 1)
			return false;

		if (a <= 2)
			return true;

		if (a % 2 == 0 | a % 3 == 0)
			return false;

		for (int i = 5; i * i <= a; i += 6) {

			if (a % i == 0 || a % (i + 2) == 0) {
				return false;
			}
		}

		return true;

	}



	/**
	 * Cuenta los digitos combirtiendolos en un texto
	 * 
	 * @param a Digitos a contar
	 */
	public static void cuentaDigitos(int a) {

		System.out.println(("" + a).length());
	}

	/**
	 * Devuelve true si es par devuelve false si es impar
	 * @param num
	 * @return
	 */
	public static boolean parOImpar(int num) {
		
		if ((num % 2) == 0) return true;
		
		else return false;
	}

	/**
	 * Realiza un figonachi segun el limite introducido
	 * @param limite
	 */
	public static void fibonachi2(int limite) {
		int num1 = 1;
		int num2 = 1;
		int result;
	
		for (int i = 0; i < limite; i++) {
			//sumo el primero mas el anterior y me da el resulrado del siguiente
			result = num1 + num2;
			
			num1 = num2;
			num2 = result;
			System.out.println(result);
		}
	}
	
	/**
	 * Devuelve el factorial de un numero
	 * @param num
	 * @return
	 */
	public static int factorial(int num) {
		int resultado = num;
		
		if (num == 0) {
			return 1;
		}
		
		else {
		
		for (int i = 1; i < num; i++) {
			resultado *= i;
		}
		
		}
		
		return resultado;
	}
	
	/**
	 * Devuelve un numero entero a hexadecimal
	 * @param num
	 * @return
	 */
	public static String numeroAHexadecimal(int num) {
		String hexadecimal = Integer.toHexString(num);
		
		return hexadecimal;
	}
	
	

}
