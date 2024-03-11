package mismetodos;

public class Utilsmatrix {

	/**
	 * Inicializo una matriz con numeros aleatorios del 0 al 100
	 * 
	 * @param a matriz a inicializar
	 */
	public static void inicializaMatrix(int a[][]) {

		for (int i = 0; i < a.length; i++) {
			// matrix[i] para matrices rectangulares
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) Math.round(Math.random() * 100);
			}

		}

	}
	
	/**
	 * 
	 * @param filas
	 * @param cols
	 * @param valorInicial
	 * @return
	 */
	public static int[][] creaEInicializaMatriz (int filas, int cols, int valorInicial) {
		int m[][] = new int[filas][cols];
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = valorInicial;
			}
		}
		
		return m;
	}

	/**
	 * Rellena una matriz con valores entre dos numeros
	 * 
	 * @param a
	 * @param min
	 * @param max
	 */
	public static void inicializaMatrix(int a[][], int min, int max) {

		for (int i = 0; i < a.length; i++) {
			// matrix[i] para matrices rectangulares
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = Utils.obtenerNumeroAzarConLimites(min, max);
			}

		}

	}
	
	/**
	 * Rellena una matriz con valores pares entre dos numeros
	 * 
	 * @param a
	 * @param min
	 * @param max
	 */
	public static void inicializaMatrixConPares(int a[][], int min, int max) {

		for (int i = 0; i < a.length; i++) {
			// matrix[i] para matrices rectangulares
			for (int j = 0; j < a[i].length; j++) {
				do {
					a[i][j] = Utils.obtenerNumeroAzarConLimites(min, max);
				} while (Utils.parOImpar(a[i][j]));
			}

		}

	}
	
	/**
	 * Rellena una matriz con valores impares entre dos numeros
	 * 
	 * @param a
	 * @param min
	 * @param max
	 */
	public static void inicializaMatrixConImpares(int a[][], int min, int max) {

		for (int i = 0; i < a.length; i++) {
			// matrix[i] para matrices rectangulares
			for (int j = 0; j < a[i].length; j++) {
				do {
					a[i][j] = Utils.obtenerNumeroAzarConLimites(min, max);
				} while (!Utils.parOImpar(a[i][j]));
			}

		}

	}

	/**
	 * Imprime una matriz
	 * 
	 * @param a matriz a imprimir
	 */
	public static void imprimeMatrix(int a[][]) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Comprueva si todos los valores son positivos
	 * 
	 * @param a matriz a comprobar
	 * @return su lo son devuevo true
	 */
	public static boolean todosSonPositivos(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				if (a[i][j] < 0)
					return false;
			}

		}
		return true;
	}

	/**
	 * Comprueva si los valores en la diagonal de la matriz son ceros
	 * 
	 * @param a matriz a comprobar
	 * @Nota Se puede mejorar
	 * 
	 * @return si lo son devuevo true
	 */
	public static boolean todosnulosMenosDiagonal(int a[][]) {
		int[][] matrizCuadrada = null;

		matrizCuadrada = Utilsmatrix.cuadrificarMatriz(a);

		for (int i = 0; i < matrizCuadrada.length; i++) {
			for (int j = 0; i < matrizCuadrada[i].length; j++) {
				if ((i != j && matrizCuadrada[i][j] != 0) || i == j && matrizCuadrada[i][j] == 0)
					return false;
			}

		}

		return true;
	}

	/**
	 * Combierte cualquier matriz incluso si es asimetrica en un cuadrado relleno
	 * los valores con ceros
	 * 
	 * @param a matriz que se va a tranformar en un cuadrado
	 * @return se devuelve una matriz en forma cuadrada
	 */
	public static int[][] cuadrificarMatriz(int a[][]) {
		int filaMasLarga = 0;
		int cuadrado;

		// longitud de la primera columna
		int longitudprimeracolumna = a.length;

		for (int i = 0; i < a.length - 1; i++) {

			// compruebo la fila mas larga
			if (a[i].length > a[i + 1].length)
				filaMasLarga = a[i].length;

		}
		if (filaMasLarga > a.length)
			cuadrado = filaMasLarga;

		else if (a.length > filaMasLarga)
			cuadrado = a.length;

		else
			cuadrado = a.length;

		int[][] matrizCuadrada = new int[cuadrado][cuadrado];

		for (int i = 0; i < a.length; i++) {
			// matrix[i] para matrices rectangulares
			for (int j = 0; j < a[i].length; j++) {
				matrizCuadrada[i][j] += a[i][j];
			}

		}

		return matrizCuadrada;
	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	public static boolean trianguloInferiorNulos(int a[][]) {

		int[][] matrizCuadrada = Utilsmatrix.cuadrificarMatriz(a);

		for (int i = 0, i2 = 0; i < matrizCuadrada.length; i++) {

			if (matrizCuadrada[i][i2] != 0)
				return false;

			for (int j = matrizCuadrada[i2].length; j > 0; j--) {

				if (matrizCuadrada[i][i2] != 0)
					return false;
			}

		}
		return true;
	}

	/**
	 * Nota no funciona con asimetricas
	 * 
	 * @param a
	 * @return
	 */
	public static boolean esDispersa(int a[][]) {
		boolean alMenosUno;
		int contfilas = 0;
		int contcolumnas = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				if (a[i][j] == 0)
					alMenosUno = true;

				else
					alMenosUno = false;

				if (alMenosUno)
					contfilas++;
			}

		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				if (a[j][i] == 0)
					alMenosUno = true;

				else
					alMenosUno = false;

				if (alMenosUno)
					contcolumnas++;
			}

		}

		if (contfilas >= a.length && contcolumnas >= a[0].length)
			return true;

		else
			return false;
	}

	/**
	 * Cuent los valores de una matriz
	 * 
	 * @param a
	 * @return
	 */
	public static int cuentaValoresMatriz(int a[][]) {
		int cont = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				cont++;
			}

		}
		return cont;
	}

	/**
	 * Comrpueba si una matriz es cuadrada
	 * 
	 * @param a
	 * @return
	 */
	public static boolean esCuadrada(int a[][]) {
		int filaMasLarga = 0;
		int filaMasCorta = a.length;

		for (int i = 0; i < a.length - 1; i++) {

			// compruebo la fila mas larga
			if (a[i].length > a[i + 1].length)
				filaMasLarga = a[i].length;

			if (a[i].length < a[i + 1].length)
				filaMasCorta = a[i].length;

		}
		if (filaMasLarga > a.length)
			return false;

		else if (filaMasCorta < a.length)
			return false;

		else
			return true;
	}

	/**
	 * para una matriz a un array
	 * 
	 * @param a
	 * @return
	 */
	public static int[] pasaMatrizAArray(int a[][]) {
		int tamañoDeArray = Utilsmatrix.cuentaValoresMatriz(a);
		int Array[] = new int[tamañoDeArray];
		int k = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++, k++) {
				Array[k] += a[i][j];
			}
		}
		return Array;
	}

	/**
	 * gira la forma de la matriz no los valores
	 * 
	 * @param a
	 */
	public static int[][] matrizTrapuesta(int a[][]) {
		int[][] matrizTraspuesta = new int[a[0].length][a.length];

		for (int i = 0; i < matrizTraspuesta.length; i++) {
			for (int j = 0; j < matrizTraspuesta[i].length; j++) {
				matrizTraspuesta[i][j] = a[j][i];
			}
		}
		return matrizTraspuesta;
	}

	/**
	 * Comprueba si los valores de los triangulos son simetricos
	 * 
	 * @param a
	 * @return
	 */
	public static boolean tieneValoresSimetricos(int a[][]) {

		if (Utilsmatrix.esCuadrada(a)) {

			for (int i = 0, i2 = a.length - 1; i < a.length && i2 > 0; i++, i2--) {
				for (int j = 0; j < a[i].length; j++) {
					// compara la del triangulo de arriba con la del triangulo de abajo empenzando
					// por la izquierda
//					System.out.println(a[i][j]);
//					System.out.println(a[j][i]);
					if (a[i][j] != a[j][i]) {

						return false;
					}
				}

			}
			return true;
		}

		else
			return false;
	}

	/**
	 * Elimina una fila de una matriz
	 * 
	 * @param m
	 * @param filaAEliminar
	 * @return
	 */
	public static int[][] eliminaFila(int m[][], int filaAEliminar) {

		if (filaAEliminar >= m.length) {
			return m;
		}

		// Sólo llego aquí si no se ha entrado en el "if"
		int nueva[][] = new int[m.length - 1][m[0].length];
		int k = 0;
		for (int i = 0; i < m.length; i++) {
			if (filaAEliminar != i) {
				for (int j = 0; j < m[i].length; j++) {
					nueva[k][j] = m[i][j];
				}
				k++;
			}
		}
		return nueva;
	}

	/**
	 * Inicianila un array con una serie de valores aleatorios entre dos numeros
	 * 
	 * @param a
	 * @param min
	 * @param max
	 */
	public static void inicializaMatrixConMinimoMaximo(int a[][], int min, int max) {
		boolean lotengo = false;

		for (int i = 0; i < a.length; i++) {
			// matrix[i] para matrices rectangulares
			for (int j = 0; j < a[i].length; j++) {
				do {
					lotengo = false;
					a[i][j] = Utils.obtenerNumeroAzarConLimites(min, max);

					for (int j2 = 0; j2 < a.length; j2++) {
						for (int j3 = 0; j3 < a[j2].length; j3++) {

							if (i == j2 && j == j3)
								;

							else if (a[j2][j3] == a[i][j])
								lotengo = true;
						}
					}

				} while (lotengo);

			}

		}

	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	public static int coordenadaMenorDeUnaMatriz(int a[][]) {
		int menor = a[0][0];
		int columna = 0, fila = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				if (menor > a[i][j]) {
					menor = a[i][j];
					fila = i;
					columna = j;
				}

			}
		}
		System.out.println("El mayor esta en la fila " + (fila + 1) + " de la columna " + (columna + 1));
		return menor;
	}

	/**
	 * comprueba cual es el mayor valor de un
	 * 
	 * @param a
	 * @return
	 */
	public static int coordenadaMayorDeUnaMatriz(int a[][]) {
		int mayor = a[0][0];
		int columna = 0, fila = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				if (mayor < a[i][j]) {
					mayor = a[i][j];
					fila = i;
					columna = j;
				}

			}
		}
		System.out.println("El mayor esta en la fila " + (fila + 1) + " de la columna " + (columna + 1));
		return mayor;
	}

	/**
	 * Comprue si el orden de una matriz es correcto
	 * 
	 * @param m matriz que se va a comprobar
	 * @return devuelve true si esta ordenada
	 */
	public static boolean Compruevosuorden(int[][] m) {
		int[] array = Utilsmatrix.pasaMatrizAArray(m);

		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1])
				return false;
		}
		return true;
	}

	/**
	 * Encuentra si un valor ya esiste en una matriz
	 * 
	 * @param m            matriz en la que se va a buscar
	 * @param valorBuscado valor que se va a buscar
	 * @return de devuelve un true si se encuentra al menos una vez
	 */
	public static boolean existeValorEnMatriz(int m[][], int valorBuscado) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == valorBuscado) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param m
	 */
	public static void tableroAjedrez(int[][] m) {

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {

				// gracias a que le suma la i al saltar a la siguiente fila vuelve a colocar el
				// vaor
				if ((i + j) % 2 == 0)
					m[i][j] = -1;
			}
		}
	}

	/**
	 * Este metodo pasa un array a una matriz cuadrada pero puede perder valores
	 * 
	 * @param array
	 */
	public static void pasaArrayAMatriz(int[] array) {
		// Realiza una raiz cuadrada de la longitud del array para sacar el lado del
		// cuadrado
		// importante saver que hace redondeos
		int lado = (int) Math.sqrt(array.length);

		if (arrayNoCuadrado(array, lado)) {
			System.out.println("no se puede realizar un cuadrado");

		}

		else {
			int[][] matriz = convertirArrayAMatrizCuadrada(array, lado);
			Utilsmatrix.imprimeMatrix(matriz);
		}
	}

	/**
	 * 
	 * @param array
	 * @param lado
	 * @return
	 */
	public static boolean arrayNoCuadrado(int[] array, int lado) {

		// si lado es diferente de la logitud del array este array no podra tener forma
		// de cuadrado
		if (lado * lado != array.length) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param array
	 * @param lado
	 * @return
	 */
	public static int[][] convertirArrayAMatrizCuadrada(int[] array, int lado) {
		int[][] matrizCuadrada = new int[lado][lado];

		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++) {
				matrizCuadrada[i][j] = array[i * lado + j];
			}
		}

		return matrizCuadrada;
	}

}
