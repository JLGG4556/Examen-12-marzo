package mismetodos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class UtilsProperties {

	/**
	 * Introduce las propidedades de un fichero de propiedades a un hashmap
	 * 
	 * @return
	 */
	public static HashMap<String, Object> propiedadesAhashmap(Properties propiedades) {
		HashMap<String, Object> mapaPropiedades = new HashMap<>();

		for (String clave : propiedades.stringPropertyNames()) {
			Object valor = propiedades.getProperty(clave);
			mapaPropiedades.put(clave, valor);
		}

		return mapaPropiedades;
	}

	/**
	 * Muestra las propiedades introducidas en un hashmap
	 * 
	 * @param map
	 */
	public static void mostrarPropiedadeshashmap(HashMap<String, Object> map) {
		System.out.println("Propiedades en HashMap:");
		for (HashMap.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	/**
	 * Filtra los valores que son interger y los guarda en una lista
	 * 
	 * @param map
	 * @return
	 */
	private static List<Integer> filtrarEnteros(HashMap<String, Object> map) {
		List<Integer> numeros = new ArrayList<>();

		for (HashMap.Entry<String, Object> entry : map.entrySet()) {
			Object valor = entry.getValue();
			if (valor instanceof Integer) {
				numeros.add((Integer) valor);
			}
			// Puedes agregar más casos según los tipos de datos que deseas incluir
		}
		return numeros;
	}

	/**
	 * 
	 * @param p
	 * @param ruta
	 * @return
	 */
	public static Properties getPropiedades(Properties p, String ruta) {

		if (p == null) {
			p = new Properties();

			try {

				File fichero = new File(ruta);
				 System.out.println("Se a encontrado el fichero " + fichero.exists());
				p.load(new FileReader(fichero));

			} catch (FileNotFoundException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			}

			return p;

		}

		return p;
	}

}
