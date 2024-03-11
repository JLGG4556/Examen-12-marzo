package mismetodos;

import java.util.Iterator;

public class UtilsArrays {

	/**
	 * Este metodo imprime un array
	 * 
	 * @param a Array que se va a imprimir
	 */
	public static void imprimeArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}
	
	/**
	 * Este metodo imprime un array de chars
	 * 
	 * @param a Array que se va a imprimir
	 */
	public static void imprimeArray(char a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}
	
	/**
	 * Este metodo imprime un array
	 * 
	 * @param a Array que se va a imprimir
	 */
	public static void imprimeArray(String a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}

	/**
	 * Inicializa un Array con dos limites
	 * 
	 * @param a      Array a inicializar
	 * @param limInf Limite inferior del array
	 * @param limSup Limite superior del array
	 */
	public static void inicializaArray(int a[], int limInf, int limSup) {
		for (int i = 0; i < a.length; i++) {
			a[i] = Utils.obtenerNumeroAzarConLimites(limInf, limSup);
		}
	}
	
	/**
	 * Inicializa un array con numeros impares
	 * @param a
	 * @param limInf
	 * @param limSup
	 */
	public static void inicializaArrayImpares(int a[], int limInf, int limSup) {

		for (int i = 0; i < a.length; i++) {
			do {
				a[i] = Utils.obtenerNumeroAzarConLimites(limInf, limSup);
			} while (Utils.parOImpar(a[i]));
		}
	}

	/**
	 * Inicializa un array con numeros pares
	 * @param a
	 * @param limInf
	 * @param limSup
	 */
	public static void inicializaArraypares(int a[], int limInf, int limSup) {

		for (int i = 0; i < a.length; i++) {
			do {
				a[i] = Utils.obtenerNumeroAzarConLimites(limInf, limSup);
			} while (!Utils.parOImpar(a[i]));
		}
	}

	/**
	 * encuentra si un valor existe ya en una matriz
	 * 
	 * @param a            array
	 * @param valorBuscado
	 * @return
	 */
	public static boolean existeValorEnArray(int[] a, int valorBuscado) {

		for (int i = 0; i < a.length; i++) {

			if (a[i] == valorBuscado)
				return true;
		}
		return false;
	}

	/**
	 * Inicializo un array con valores al azar que no se van a repetir
	 * 
	 * @param a
	 */
	public static void inializaunArraysinRepetir(int[] a) {
		int num;

		for (int i = 0; i < a.length; i++) {

			do {
				num = Utils.obtenerNumeroAzar();

			} while (existeValorEnArray(a, num));

			a[i] = num;
		}
	}

	/**
	 * Inicializo un array con valores al azar que no se van a repetir entre dos
	 * limites especificos
	 * 
	 * @param a
	 */
	public static void inializaunArraysinRepetirConLimites(int[] a, int inferior, int superior) {
		int num;

		for (int i = 0; i < a.length; i++) {

			do {
				num = Utils.obtenerNumeroAzarConLimites(inferior, superior);

			} while (existeValorEnArray(a, num));

			a[i] = num;
		}
	}

	/**
	 * Este metodo desordena un Array
	 * 
	 * @param a
	 * @return
	 */
	public static int[] desordenaArray(int[] a) {
		int[] nuevoArray = new int[a.length];
		int[] posiciones = new int[a.length];

		generaposiciones(posiciones);

		for (int i = 0, j = 0; i < a.length; i++, j++) {

			nuevoArray[posiciones[j]] = a[i];
		}
		return nuevoArray;
	}
	
	/**
	 * Mezcla un array
	 * @param a
	 */
	public static void desordenaArray2(int[] a) {
		
		for (int i = 0; i < a.length; i++) {
			int indi = Utils.obtenerNumeroAzarConLimites(0, a.length -1);
			int indi2 = Utils.obtenerNumeroAzarConLimites(0, a.length -1);
			
			int aux = a[indi];
			a[indi] = a[indi2];
			a[indi2] = aux;
		}
	}

	/**
	 * Genera posiciones para un array
	 * 
	 * @param a array de las supuestas posiciones
	 */
	public static void generaposiciones(int[] a) {
		int num;

		// se puede colocar un valor donde alla un -1
		for (int i = 0; i < a.length; i++) {
			a[i] = -1;
		}

		// no puede generar 0
		for (int i = 0; i < a.length; i++) {

			do {
				num = Utils.obtenerNumeroAzarConLimites(0, a.length - 1);

			} while (UtilsArrays.existeValorEnArray(a, num));

			a[i] = num;
		}
	}

	/**
	 * Suma todos lo valores de un array en unico valor
	 * 
	 * @param array Este es el Array que se va a sumar
	 * @return Devuelve el resultado de sumar todos los valores del array
	 */
	public static int sumadearrays(int array[]) {
		int suma = 0;
		for (int i = 0; i < array.length; i++) {
			suma += array[i];
		}
		return suma;
	}

	/**
	 * Se realiza una media de los valores del array
	 * 
	 * @param array Array al que se le va a realizar la media
	 * @return Devuelve el resultado de la media
	 */
	public static float mediadeunarray(int array[]) {
		return sumadearrays(array) / (float) array.length;
	}

	/**
	 * Comprueba cual es el mayor valor de un array y lo devuelve
	 * 
	 * @param array Array a comprobar
	 * @return Devuelve el valor mayor
	 */
	public static int mayordeunArray(int array[]) {
		int mayor = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > mayor)
				mayor = array[i];
		}
		return mayor;
	}

	/**
	 * Comprueba cual es el manor valor de un array y lo devuelve
	 * 
	 * @param array Array a comprobar
	 * @return Devuelve el valor menor
	 */
	public static int menordeunArray(int array[]) {
		int menor = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < menor)
				menor = array[i];
		}
		return menor;
	}

	/**
	 * Cambia los signos de los valores del array intercambiado negativos por
	 * positivos y viceversa
	 * 
	 * @param array Array al que se le van a cambiar los signos
	 */
	public static void cambiaSignoEnValoresDeArray(int array[]) {

		for (int i = 0; i < array.length; i++) {
			array[i] *= -1;
		}

	}

	/**
	 * Se crea un Array nuevo a partir de los valores de dos Array distintos
	 * 
	 * @param a1 Se sacan los valores impares del primer array
	 * @param a2 Se sacan los valores pares del segundo array
	 * @return Se mezclan los dos array en un unico Array
	 */
	public static int[] creaTercerArrayAPartitDeDosArrays(int a1[], int a2[]) {
		int Array3[] = new int[150];

		for (int i = 0; i < a1.length; i++) {

			// si esto esta en una posicion impar
			if ((i & 1) == 1) {

				// se guarda en una posicion impar del array3
				Array3[i] = a1[i];
			}
		}
		for (int i = 0; i < a2.length; i++) {
			if ((i & 1) != 1) {
				Array3[i] = a2[i];
			}
		}

		return Array3;
	}

	/**
	 * Multiplica el Array por un valor introducido
	 * 
	 * @param a      Array a multiplicar
	 * @param factor Factor que va a multiplicar el Array
	 */
	public static void multiplicaValoresPorFactor(int a[], int factor) {

		for (int i = 0; i < a.length; i++) {

			a[i] *= factor;

		}
	}

	/**
	 * Hace un dezplazamiento ciclico hacia la derecha
	 * 
	 * @param a Array a desplazar
	 */
	public static void desplazaCiclicoDerechaDeUnArray(int a[]) {
		// a.length es igual a los arrays que tengo alli
		// se guarda un array del mismo tamaño sin valores
		int ArrayAux[] = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			ArrayAux[i] = a[i];
		}

		for (int i = 0; i < a.length; i++) {

			if (i == 0)
				a[i] = ArrayAux[a.length - 1];

			else
				a[i] = ArrayAux[i - 1];
		}
	}

	/**
	 * Hace uno o varios dezplazamientos ciclicos hacia la derecha
	 * 
	 * @param a          Array a dezplazar
	 * @param posiciones Posiciones que se va a dezplazar
	 */
	public static void desplazaCiclicoDerechaConNumeroDeVueltas(int a[], int posiciones) {
		// a.length es igual a los arrays que tengo alli
		// se guarda un array del mismo tamaño sin valores
		int ArrayAux[] = new int[a.length];

		for (int i = 0; i < posiciones; i++) {

			for (int J = 0; J < a.length; J++) {
				ArrayAux[J] = a[J];
			}

			for (int J = 0; J < a.length; J++) {

				if (J == 0)
					a[J] = ArrayAux[a.length - 1];

				else
					a[J] = ArrayAux[J - 1];
			}
			UtilsArrays.imprimeArray(ArrayAux);
		}
	}

	/**
	 * Hace uno o varios dezplazamientos ciclicos hacia la izquierda
	 * 
	 * @param a          Array a dezplazar
	 * @param posiciones Posiciones que se va a dezplazar
	 */
	public static void desplazaCiclicoIzquierdaConNumeroDeVueltas(int a[], int posiciones) {
		// a.length es igual a los arrays que tengo alli
		// se guarda un array del mismo tamaño sin valores
		int ArrayAux[] = new int[a.length];

		for (int i = 0; i < posiciones; i++) {

			for (int J = 0; J < a.length; J++) {
				ArrayAux[J] = a[J];
			}

			for (int J = 0; J < a.length; J++) {

				if (J == 0)
					a[J] = ArrayAux[0];

				else {
					a[a.length - 1] = ArrayAux[0];
					a[J - 1] = ArrayAux[J];

				}
			}
			UtilsArrays.imprimeArray(ArrayAux);
		}
	}

	/**
	 * Hace uno o varios dezplazamientos ciclicos
	 * 
	 * @param a          Array a dezplazar
	 * @param posiciones Posiciones que se va a dezplazar
	 * @param direccion  Direccion en la que se va a dezplazar 1 es a la derecha y 2
	 *                   a la izquierda
	 */
	public static void desplazaCiclico(int a[], int posiciones, int direccion) {

		if (direccion == 1)
			UtilsArrays.desplazaCiclicoDerechaConNumeroDeVueltas(a, posiciones);
		;

		if (direccion == 2)
			UtilsArrays.desplazaCiclicoIzquierdaConNumeroDeVueltas(a, posiciones);
	}

	/**
	 * Inicializa un array con numeros contando hacia adelante
	 * 
	 * @param a Array a inicializar
	 */
	public static void InicializarArrayConNumerosHaciaDelante(int a[]) {

		for (int i = 0; i < a.length; i++) {
			a[i] = i;

		}
	}

	/**
	 * Inicializa un array con numeros contando hacia adelante comenzando desde 1
	 * 
	 * @param a Array a inicializar
	 */
	public static void InicializarArrayConNumerosHaciaDelanteComenzandoEnUno(int a[]) {

		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;

		}
	}

	/**
	 * 
	 * @param a
	 */
	public static void InicializaUnArrayConNumerosPrimos(int a[]) {
		int num = 2;

		for (int i = 0; i < a.length;) {
			if (true == Utils.compruebaPrimo(num)) {
				a[i] = num;
				i++;
			}
			num++;
		}

	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	public static int[] pareIzquieredaImparesDerecha(int[] a) {
		int[] arraypareIZimparesDE = new int[a.length];
		int j = 0;

		for (int i = 0; i < a.length; i++) {

			// si es par
			if ((a[i] % 2) == 0) {
				arraypareIZimparesDE[j] = a[i];
				j++;
			}
		}

		for (int i = 0; i < a.length; i++) {

			// si es impar
			if ((a[i] % 2) != 0) {
				arraypareIZimparesDE[j] = a[i];
				j++;
			}
		}

		return arraypareIZimparesDE;
	}

	/**
	 * Combierte los valores de numeros enteros de un array en un caracter segun su
	 * valo
	 * 
	 * @param a array de valores enteros
	 * @return cadena que se va a devolver
	 */
	public static String stringFronArray(int[] a) {
		String cadenaArray = "";
		char letra;

		for (int i = 0; i < a.length; i++) {
			letra = (char) a[i];
			cadenaArray += letra;
		}
		return cadenaArray;
	}

	/**
	 * Este metodo intercambia los valores de un array
	 * 
	 * @param array
	 * @param busca
	 * @param cambio
	 */
	public static void findAndReplace(int[] array, int busca, int cambio) {

		for (int i = 0; i < array.length; i++) {

			if (array[i] == busca)
				array[i] = cambio;
		}
	}

	/**
	 * Añade un numero entero a un array nuevo
	 * 
	 * @param a   array base
	 * @param num numero que se va a añadir
	 * @return se devuelve el nuevo array
	 */
	public static int[] addInterger(int[] a, int num) {
		int[] arrayNuevo = new int[a.length + 1];

		for (int i = 0; i < a.length; i++) {

			arrayNuevo[i] = a[i];

			if (arrayNuevo[a.length - 1] == arrayNuevo[i])
				arrayNuevo[i + 1] = num;
		}

		return arrayNuevo;
	}

	/**
	 * Este metodo cuenta las veces que a aparecido un numero que a pedido el
	 * usuario
	 * 
	 * @param a   array en el que se va a buscar
	 * @param num numero que se va buscar
	 * @return se devuelve el conteo
	 */
	public static int countOccurences(int[] a, int num) {
		int cont = 0;

		for (int i = 0; i < a.length; i++) {

			if (a[i] == num)
				cont++;
		}

		return cont;
	}

	/**
	 * Este metodo elimina un numero de una array
	 * 
	 * @param a   Array que se va a utilizar
	 * @param num numero que se va a eliminar
	 * @return
	 */
	public static int[] removeInterger(int[] a, int num) {

		int menoscelda = UtilsArrays.countOccurences(a, num);
		int[] newArray = new int[a.length - menoscelda];
		int i = 0, j = 0;

		while (i < a.length) {

			if (a[i] != num) {
				newArray[j] = a[i];
				j++;
			}
			i++;
		}

		return newArray;
	}

	/**
	 * Este metodo guarda una cadena en un array diferenciandolar por un caracter
	 * 
	 * @param ignorar
	 * @param cadena
	 * @return
	 */
	public static String[] arrayDePalabras(char ignorar, String cadena) {
		// Creo un array segun cadenas que alla
		String[] Arraypalabra = new String[UtilsString.CuentaPalabras(ignorar, cadena)];

		// recorro el array
		for (int i = 0, j = 0; i < Arraypalabra.length; i++) {

			// ELimino el nulo del array
			Arraypalabra[i] = "";

			// Sigo abanzando en la cadena si no encuentro nada
			while (ignorar == cadena.charAt(j)) {
				j++;
			}

			// si encuentro algo que no es un espacio lo guardo en mi parte del array y sigo
			// avanzando el la cadena
			while (ignorar != cadena.charAt(j)) {
				Arraypalabra[i] += cadena.charAt(j);
				j++;
			}

		}

		return Arraypalabra;

	}

}
