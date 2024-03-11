package mismetodos;

import java.util.HashMap;

public class Utilshashmap {
	
	/**
	 * Muestra el hashmap
	 * @param hm
	 */
	public static void muestraHashmap(HashMap hm) {
		
		Object clave[] = hm.keySet().toArray();
		
		//separador
		System.out.println("///////////////////");
		for (int i = 0; i < clave.length; i++) {
			
			System.out.println("|Clave: " + clave[i].toString() + " | Objeto: " + hm.get(clave[i]) + " |");

		}
		System.out.println("///////////////////");
	}
	
//	public static void introducirObjetoOMITECLAVE(HashMap hm) {
//		
//		int max = UtilsMenu.pidenumeromenu("Cuantos objetos quieres");
//		
//		for (int i = 0; i < max; i++) {
//			
//			hm.put(i, );
//		}
//	}
	

	public static void existeelobjeto(HashMap hm) {
		
		
	}
}
