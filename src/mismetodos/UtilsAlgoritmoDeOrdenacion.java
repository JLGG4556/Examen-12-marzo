package mismetodos;

public class UtilsAlgoritmoDeOrdenacion {

	public static void AlgoritmoDeOrdenacionBurbuja(int a[]) {
		int Aux = 0;

		// entro al bucle for y le doy vueltas el - 1 es el margen ya que la i empieza
		// por 0
		for (int i = 0; i < a.length - 1; i++) {

			// entro al bucle donde j debe de ser menor que la longitud del array que es (6)
			// - 0 - 1
			// Nota: jamas comprobamos el ultimo valor
			for (int j = 0; j < a.length - i - 1; j++) {
				// doy vueltas asta que llego al antepenultimo
				//System.out.println("Comparo " + a[j] + " con " + a[j + 1]);
				if (a[j] > a[j + 1]) {
					// Intercambiar los elementos a[j] y a[j+1]
					Aux = a[j];
					a[j] = a[j + 1];
					a[j + 1] = Aux;
					//UtilsArrays.imprimeArray(a);
					//System.out.println();
				}
			}
		}

	}

	public static void AlgoritmoDeOrdenacionInseccionDirecta(int a[]) {
		int Aux = 0;
		int j;

		// Entro al for colocando un margen
		for (int i = 0; i < a.length - 1; i++) {
			// guarda lo que alla en la siguiente posicion de un array
			Aux = a[i + 1];
			// compruebo si mi valor es mayor a lo que hay en el sigiente
			if (a[i] > a[i + 1]) {
				for (j = i; j >= 0; j--) {
					// compruebo si lo que tengo es menor que lo que hay en esa posicion del array
					if (Aux < a[j]) {
						a[j + 1] = a[j];
						a[j] = Aux;
					}
				}

			}

		}

	}

	public static void AlgoritmoDeOrdenacionPorSeleccion(int a[]) {
		int pos;
		int Aux;

		for (int i = 0; i < a.length - 1; i++) {
			// guardo la posicion de array
			pos = i;
			for (int j = i + 1; j < a.length; j++) {
				// comapro el array por el que voy con el array que tenia (para hacerlo e guardo
				// la posicion del anterior)
				if (a[j] < a[pos]) {
					// si el array que estoy comprovando es menor guardo la posicion del menor
					pos = j;
				}
			}

			Aux = a[i];
			a[i] = a[pos];
			a[pos] = Aux;

		}

	}

	public static void AlgoritmoDeOrdenacionShell(int a[]) {
		int Aux = 0;
		int j;
		// intervarlo con un tamaño de uno
		int shell = 1;

		// cuando mi intervalo se menor la logintud de mi array dividida entre tres
		// entro al while
		while (shell < a.length / 3) {
			// aqui multiplico el intervarlo por 3 y le sumo 1
			shell = shell * 3 + 1;
			// combierto el intervarlo en cuatro
		}
		// si mi intervalo es igual o mayor que 1 entro
		while (shell >= 1) {

			for (int i = shell; i < a.length; i++) {
				Aux = a[i];
				j = i;
				// entro aqui si J es mayor o igual que shell y ademas si el array eb mosicion
				// de j - shell es mayor que el auxiliar
				while (j >= shell && a[j - shell] > Aux) {
					a[j] = a[j - shell];
					j -= shell;
				}

				a[j] = Aux;
			}
			// reduccion del shell
			shell = shell / 3;
		}

	}
	
	/**
	 * Este algoritmo separa los pares de los impares
	 * @param a
	 */
	public static void ordenaParesEImpares (int a[]) {
		
		while ( !(posicionUltimoPar(a) < posicionPrimerImpar(a))) {
			int primeraPosImpar = posicionPrimerImpar(a);
			int ultimaPosPar = posicionUltimoPar(a);
			
			int aux = a[primeraPosImpar];
			a[primeraPosImpar] = a[ultimaPosPar];
			a[ultimaPosPar] = aux;			
		}
	}
	
	
	public static int posicionUltimoPar (int a[]) {
		int posicion = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				posicion = i;
			}
		}
		return posicion;
	}
	
	
	public static int posicionPrimerImpar (int a[]) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 1) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Este metodo recive una matriz y la ordena
	 * @param m
	 */
	public static void ordenamatriz(int[][] m) {
		int k = 0;
		
		int[] array = Utilsmatrix.pasaMatrizAArray(m);
		//lo puedes cambiar por otro algoritmo
		UtilsAlgoritmoDeOrdenacion.AlgoritmoDeOrdenacionBurbuja(array);
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = array[k];
				k++;
			}
		}
		
	}

}