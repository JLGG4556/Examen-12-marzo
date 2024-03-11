package mismetodos;

import java.util.List;

public class UtilsListaEnteros {
	/**
	 * Pide un tamaño de lista y se rellena con objetos Interger con valores
	 * aleatorios entre un valor maximo y un minimo
	 * 
	 * @param lista
	 */
	public static void listaDenumerosEnterosAleatorios(List<Integer> lista) {

		int ran = Utils.pideNumeroEntero("Introduce el tamaño de la lista");
		int min = Utils.pideNumeroEntero("Numero minimo");
		int max = Utils.pideNumeroEntero("Numero maximo");

		for (int i = 0; i < ran; i++) {
			// añade
			lista.add(i, Utils.obtenerNumeroAzarConLimites(min, max));
		}
	}

	/**
	 * suma toda la lista
	 */
	public static int sumalistaEnteros(List<Integer> lista) {
		int sumalista = 0;

		for (int i = 0; i < lista.size(); i++) {
			sumalista += lista.get(i).intValue();
		}

		return sumalista;
	}

	/**
	 * Encuentra el mayor de la lista
	 * 
	 * @param lista
	 * @return
	 */
	public static int mayordelistaEnteros(List<Integer> lista) {

		int mayor = lista.get(0).intValue();

		for (int i = 0; i < lista.size(); i++) {

			if (mayor < lista.get(i).intValue()) {
				mayor = lista.get(i).intValue();
			}
		}

		return mayor;
	}

	/**
	 * Encuentra el menor de la lista
	 * 
	 * @param lista
	 * @return
	 */
	public static int menordelistaEnteros(List<Integer> lista) {
		int menor = lista.get(0).intValue();

		for (int i = 0; i < lista.size(); i++) {

			if (menor > lista.get(i).intValue()) {
				menor = lista.get(i).intValue();
			}
		}

		return menor;
	}

	/**
	 * saca la media redondeada de una lista de enteros
	 * 
	 * @param lista
	 * @return
	 */
	public static int mediaDeUnaListaDeEnteros(List<Integer> lista) {

		int sum = sumalistaEnteros(lista);

		int media = sum / lista.size();

		return media;
	}

	/**
	 * Agrega un numero entero al final de lista
	 * 
	 * @param lista
	 */
	public static void agregaUnEntero(List<Integer> lista) {

		int intro = Utils.pideNumeroEntero("Introduce la cantidad de numeros que vas a introducir");

		for (int i = 0; i < intro; i++) {
			lista.add(2, Utils.pideNumeroEntero("introduce numero"));
		}
	}

	/**
	 * se inserta un numero en el lugar pedido
	 * 
	 * @param lista
	 */
	public static void agregaUnEnteroEnLugar(List<Integer> lista) {

		int intro = Utils.pideNumeroEntero("Introduce la cantidad de numeros que vas a introducir");
		int pos = Utils.pideNumeroEntero("Introduce en que posicion bas a isertar los numeros");

		for (int i = intro; i < 0; i--) {
			lista.add(pos, Utils.pideNumeroEntero("introduce numero"));
		}

	}
	
	/**
	 * elimina los elementos de una lista de enteros en un intervalo indicado
	 * @param lista
	 */
	public static void eliminarElementosEnUnIntervalo(List<Integer> lista) {

		int posini = Utils.pideNumeroEntero("Introduce la posicion de inicio");
		int posfin = Utils.pideNumeroEntero("Introduce la posicion final");

		for (int i = lista.size(); i > 0; i--) {

			if (posfin >= i && posini <= i) {
				lista.remove(i);
			}
		}
	}
}
