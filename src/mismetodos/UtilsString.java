package mismetodos;

import java.util.Scanner;

public class UtilsString {
	
	/**
	 * Este metodo imprime un texto
	 * 
	 * @param a texto a imprimir
	 */
	public static void ImprimeTexto(String a) {

		System.out.println(a);
	}
	
	/**
	 * Este metodo cambia las solo las mayusculas por minusculas
	 * 
	 * @param a texto a comprovar
	 * @return texto nuevo a devolver
	 */
	public static String combertirAMayusculasLasMinusculas(String a) {

		String textoMayuscula = "";

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) >= 'a' && a.charAt(i) <= 'z')
				textoMayuscula += (char) (a.charAt(i) - 32);

			else
				textoMayuscula += (char) a.charAt(i);

		}

		return textoMayuscula;
	}
	
	/**
	 * Este metodo cambia las solo las minusculas por mayusculas
	 * 
	 * @param a texto a comprovar
	 * @return texto nuevo a devolver
	 */
	public static String combertirAMinusculasLasMayuscula(String a) {

		String textoMinuscula = "";

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z')
				textoMinuscula += (char) (a.charAt(i) + 32);

			else
				textoMinuscula += (char) a.charAt(i);

		}

		return textoMinuscula;
	}
	
	
	
	/**
	 * Cuenta las palabras de una frase
	 * 
	 * @param texto Texto a comprobar
	 * @return Numero de palabras devuelto
	 */
	public static int cuentaPalabras(String texto) {
		boolean estoyEnPalabra = true;
		int cont = 0;

		// texto.split separa las codenas de caracteres segun el caracter colocado en
		// texto.split("caracter a colocar");
		String cadenaFrase[] = texto.split(" ");

		for (int i = 0; i < cadenaFrase.length; i++) {
			// Comprueba si lo que hay dentro de la frase no esta vacia si el caso se cumple
			// se añade un valor al contador
			if (cadenaFrase[i] != "")
				cont++;

		}

		return cont;

	}
	
	/**
	 * Este metodo cuenta palabra separando por un caracter
	 * @param ignorar
	 * @param cadena
	 * @return
	 */
	public static int CuentaPalabras(char ignorar, String cadena) {
		int contpalabras = 0;
		String cadenadeplabras = ignorar + cadena;
		cadenadeplabras += ignorar;
		
		for (int i = 0; i < cadenadeplabras.length() - 1; i++) {
			
			if ( (ignorar == cadenadeplabras.charAt(i)) && cadenadeplabras.charAt(i + 1) != ignorar) contpalabras++;
			
		}
		return contpalabras;
	}

	/**
	 * Elimina los espacios de un texto
	 * 
	 * @param texto String al que se le van a eleminir los espacios
	 * @return Nuevo string que se va a devolver
	 */
	public static String eliminaEsoacuiosDeunString(String texto) {
		String nuevoTexto = "";

		for (int i = 0; i < texto.length(); i++) {

			if (texto.charAt(i) != 32)
				nuevoTexto += texto.charAt(i);

		}
		return nuevoTexto;
	}

	/**
	 * Descifra un cifrado cesar en tres desplazamientos
	 * 
	 * @param texto a descifrar
	 * @return texto a devolver
	 */
	public static String descifradocesarDesplazamiento3(String texto) {
		String textoAdevolver = "";
		// .tocharArray convierte mi cadena de caracteras a un array
		char[] textoAux = texto.toCharArray();

		for (int i = 0; i < texto.length(); i++) {

			// Se aplica un rango del 87 al 91 para que no se valla a a que vale 65
			if (textoAux[i] > 64 && textoAux[i] < 68 || textoAux[i] > 96 && textoAux[i] < 100) {
				textoAux[i] = (char) (textoAux[i] + 26 - 3);
			}

			// este else sirve para ignorar espacios
			else if (textoAux[i] == 32)
				;

			else {
				textoAux[i] -= 3;
			}
			textoAdevolver += textoAux[i];
		}

		return textoAdevolver;
	}

	/**
	 * Cifra un texto en 3 desplazamientos
	 * 
	 * @param texto a cifrar
	 * @return texto a devolver
	 */
	public static String cifradocesarDesplazamiento3(String texto) {
		String textoAdevolver = "";
		// .tocharArray convierte mi cadena de caracteras a un array
		char[] textoAux = texto.toCharArray();

		for (int i = 0; i < texto.length(); i++) {

			// Se aplica un rango del 87 al 91 para que no se valla a a que vale 65
			if (textoAux[i] > 87 && textoAux[i] < 91 || textoAux[i] > 119 && textoAux[i] < 123) {
				textoAux[i] = (char) (textoAux[i] - 26 + 3);
			}

			// este else sirve para ignorar espacios
			else if (textoAux[i] == 32)
				;

			else {
				textoAux[i] += 3;
			}
			textoAdevolver += textoAux[i];
		}

		return textoAdevolver;
	}

	/**
	 * Comprueba cual es la palabra mas larga de la cadena
	 * 
	 * @param texto a comprobar
	 * @return devuelve la palabra mas larga
	 */
	public static String palabraMasLarga(String texto) {

		String cadenaPalabra[] = texto.split(" ");
		String palabraMasLarga = "";
		int Aux = 0;
		for (int i = 0; i < cadenaPalabra.length; i++) {

			// compruebo que la palabra no es vacia
			if (cadenaPalabra[i] == "") {
			}

			else {
				// Comprubo si la longito de mi palabra es mayor que la que e guardado anterior
				// mente
				if (cadenaPalabra[i].length() > Aux) {
					// igualo lo que hay en cadenapalabra en palabramaslarga
					palabraMasLarga = cadenaPalabra[i];
					// aqui igualo aux con la logintud de cadenapalabra para provar la sigiente
					// palabra
					Aux = cadenaPalabra[i].length();
				}

			}

		}
		return palabraMasLarga;
	}
	
	/**
	 * Cuenta la cantida de ocurrencia en un texto
	 * 
	 * @param texto a comprobar
	 * @param texto2 ocurrencia
	 * @return 
	 */
	public static int conteoOcurrencia(String texto, String texto2) {
		boolean coincideciaNoVacia = true;
		int cont = 0;

		if (texto2.trim().equals("") || texto2 == null) {
			coincideciaNoVacia = false;
		}

		if (coincideciaNoVacia) {

			// tengo un texto y lo recorro con un margen del segundo texto
			for (int i = 0; i <= texto.length() - texto2.length(); i++) {

				boolean coincidencias = true;

				// recorro el segundo texto varias veces
				for (int j = 0; j < texto2.length(); j++) {

					// compruebo si los caracteres que hay en texto son iguales a los de texto2 si
					// lo son no cuento nada
					if (texto.charAt(i + j) != texto2.charAt(j))
						coincidencias = false;

				}
				if (coincidencias)
					cont++;
			}
			
		}
		return cont;
	}
	
	/**
	 * Este metodo invierte una cadena de texto para ello usa charAt que hace
	 * mencion al la posicion del caracter introducido
	 * 
	 * @param CadenaCarac Texto a invertir
	 */
	public static void imprimeTextoinverso(String CadenaCarac) {

		for (int i = CadenaCarac.length() - 1; i > -1; i--) {
			System.out.print(CadenaCarac.charAt(i));
		}
	}

	/**
	 * Este metodo pide texto al usuario al momento del pulsar el intro se guarda la
	 * linea
	 * 
	 * @param Mensaje que se va a mostrar
	 * @return Cadena de caracteres que se va a devolver
	 */
	public static String pideTexto(String Mensaje) {

		Scanner sc = new Scanner(System.in);
		System.out.println(Mensaje);
		String CadenaDeCaracteres = sc.nextLine();

		return CadenaDeCaracteres;

	}

	

	/**
	 * Este metodo cuanta las vocales de una cadena de caracteres Nota: mejorable
	 * 
	 * @param CadenaCaracteres Cadena a comprobar
	 * @return Devuelve el numero de vovales contadas
	 */
	public static int CuentaVolales(String CadenaCaracteres) {
		int contVocal = 0;

		for (int i = 0; i < CadenaCaracteres.length(); i++) {
			if (CadenaCaracteres.charAt(i) == 'a' || CadenaCaracteres.charAt(i) == 'e'
					|| CadenaCaracteres.charAt(i) == 'o' || CadenaCaracteres.charAt(i) == 'u'
					|| CadenaCaracteres.charAt(i) == 'i' || CadenaCaracteres.charAt(i) == 'A'
					|| CadenaCaracteres.charAt(i) == 'E' || CadenaCaracteres.charAt(i) == 'O'
					|| CadenaCaracteres.charAt(i) == 'U' || CadenaCaracteres.charAt(i) == 'I')
				contVocal++;

		}
		return contVocal;

	}

	/**
	 * Este chorizo cuenta las consonantes de una cadena de caracteres Nota:
	 * mejorable
	 * 
	 * @param CadenaCaracteres Cadena a comprobar
	 * @return Devuelve el numero de cpnsonates contadas
	 */
	public static int CuentaConsonante(String CadenaCaracteres) {
		int contCon = 0;

		for (int i = 0; i < CadenaCaracteres.length(); i++) {

			if (CadenaCaracteres.charAt(i) == 'B' || CadenaCaracteres.charAt(i) == 'b'
					|| CadenaCaracteres.charAt(i) == 'C' || CadenaCaracteres.charAt(i) == 'c'
					|| CadenaCaracteres.charAt(i) == 'D' || CadenaCaracteres.charAt(i) == 'd'
					|| CadenaCaracteres.charAt(i) == 'F' || CadenaCaracteres.charAt(i) == 'f'
					|| CadenaCaracteres.charAt(i) == 'G' || CadenaCaracteres.charAt(i) == 'g'
					|| CadenaCaracteres.charAt(i) == 'H' || CadenaCaracteres.charAt(i) == 'h'
					|| CadenaCaracteres.charAt(i) == 'J' || CadenaCaracteres.charAt(i) == 'j'
					|| CadenaCaracteres.charAt(i) == 'K' || CadenaCaracteres.charAt(i) == 'k'
					|| CadenaCaracteres.charAt(i) == 'L' || CadenaCaracteres.charAt(i) == 'l'
					|| CadenaCaracteres.charAt(i) == 'M' || CadenaCaracteres.charAt(i) == 'm'
					|| CadenaCaracteres.charAt(i) == 'N' || CadenaCaracteres.charAt(i) == 'n'
					|| CadenaCaracteres.charAt(i) == 'P' || CadenaCaracteres.charAt(i) == 'p'
					|| CadenaCaracteres.charAt(i) == 'Q' || CadenaCaracteres.charAt(i) == 'q'
					|| CadenaCaracteres.charAt(i) == 'R' || CadenaCaracteres.charAt(i) == 'r'
					|| CadenaCaracteres.charAt(i) == 'S' || CadenaCaracteres.charAt(i) == 's'
					|| CadenaCaracteres.charAt(i) == 'T' || CadenaCaracteres.charAt(i) == 't'
					|| CadenaCaracteres.charAt(i) == 'w' || CadenaCaracteres.charAt(i) == 'W'
					|| CadenaCaracteres.charAt(i) == 'Y' || CadenaCaracteres.charAt(i) == 'y'
					|| CadenaCaracteres.charAt(i) == 'Z' || CadenaCaracteres.charAt(i) == 'z') {
				contCon++;

			}

		}
		return contCon;

	}

	/**
	 * Este metodo comprueba si una palabra es palindroma Nota: Si se insertan
	 * mayusculas o espacios es posible que no funcione
	 * 
	 * @param texto Palabra a comprobar
	 * @return Si es palindromo se devuelve el valor true
	 */
	public static boolean esPalindromo(String texto) {
		int cont = 0;

		for (int i = 0; i < texto.length(); i++) {

			if (texto.charAt(i) == texto.charAt(texto.length() - i - 1)) {
				cont++;
			}

		}
		if (cont == texto.length())
			return true;
		return false;
	}

	/**
	 * Este metodo comrprueba si una cadena de caracteres es mayor segun ASCII
	 * 
	 * @param a primera cadena a comprobar
	 * @param b segunda cadena a comprobar
	 */
	public static void compruebaTextoMayorSegunASCII(String a, String b) {
		int array1[] = new int[a.length()];
		int array2[] = new int[b.length()];
		int suma1;
		int suma2;

		System.out.println("aqui");
		for (int i = 0; i < a.length(); i++) {
			array1[i] = a.charAt(i);
		}
		System.out.println("aqui");
		for (int i = 0; i < b.length(); i++) {
			array2[i] = b.charAt(i);
		}

		suma1 = UtilsArrays.sumadearrays(array1);
		suma2 = UtilsArrays.sumadearrays(array2);

		if (suma1 > suma2)
			System.out.println("El primer texto introducido es mayor");

		if (suma1 < suma2)
			System.out.println("El segundo texto introducido es mayor");

		if (suma1 == suma2)
			System.out.println("Los testo valen lo mismo");

	}

	/**
	 * Genera un texto nuevo con la mismas letras pero en mayuscula
	 * 
	 * @param texto a cambiar
	 * @return devuelve el nuevo texto
	 */
	public static String combertirAMayusculas(String a) {
		String textoMayuscula;
		textoMayuscula = a.toUpperCase();

		return textoMayuscula;
	}

	/**
	 * Genera un texto nuevo con la mismas letras pero en minuscula
	 * 
	 * @param texto a cambiar
	 * @return devuelve el nuevo texto
	 */
	public static String combertirAMinuscula(String a) {
		String textoMinuscula;
		textoMinuscula = a.toUpperCase();

		return textoMinuscula;
	}
	
	/**
	 * 
	 * @param CadenaCarac
	 * @return
	 */
	public static String nuevoTextoInverso(String CadenaCarac) {
		String nuevaCadena = "";
		for (int i = CadenaCarac.length() - 1; i > -1; i--) {
			nuevaCadena += CadenaCarac.charAt(i); 
		}
		
		return nuevaCadena;
	}

	/**
	 * Este metodo comprueba si es un pangrama
	 * @param a texto a comprobar
	 * @return devuelve un boleano true si lo es
	 */
	public static boolean esPangrama(String a) {
		int Array[] = new int[26];
		boolean esPangrama = true;
		String letras = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		
		for (int i = 0; i < a.length();i++) {
			
			for (int j = 0; j < letras.length(); j++) {
				
				if (a.charAt(i) == letras.charAt(j)) Array[i] += 1;
			}
		}
		
		for (int i = 0; i < Array.length; i++) {
			esPangrama = true;

			if (Array[i] != 1) {
				
				return esPangrama = false;
				
			}
		}
		
		return esPangrama;
		
	}
	
	public static String nuevaCadenaDeCaracteresPalabraInvertida(String a) {
		int logitugPalabra = 0;
		String nuevaCadena = "";
		String palabra = "";
		a += " ";

		for (int i = 0; i < a.length(); i++) {
			boolean esPalabra = true;

			if (a.charAt(i) > 64 && a.charAt(i) < 91 || a.charAt(i) > 96 && a.charAt(i) < 123) {
				palabra += a.charAt(i);
				logitugPalabra++;
			}

			else {
				esPalabra = false;

				for (int j = 0; j < logitugPalabra; j++) {
						nuevaCadena += UtilsString.nuevoTextoInverso(palabra);
						palabra = "";
					
				}

			}

			if (esPalabra == false)
				nuevaCadena += a.charAt(i);

		}
		return nuevaCadena;
	}
	
	/**
	 * 
	 * @param texto
	 * @param clave
	 * @return
	 */
	public static String cifradocesarDesplazamiento(String texto, int clave) {
		String textoAdevolver = "";
		// .tocharArray convierte mi cadena de caracteras a un array 
		char[] textoAux = texto.toCharArray();
		
		for (int i = 0; i < texto.length(); i++) {
			
			//Se aplica un rango del 87 al 91 para que no se valla a a que vale 65
			if (textoAux[i] > 87 && textoAux[i] < 91 || textoAux[i] > 119 && textoAux[i] < 123) {
				textoAux[i] = (char) (textoAux[i] - 26 + clave);
			}
			
			//este else sirve para ignorar espacios
			else if (textoAux[i] == 32);
			
			else {
				textoAux[i] += clave;
			}
			textoAdevolver += textoAux[i];
		}
		
		return textoAdevolver;
		}
	
	/**
	 * 
	 * @param texto
	 * @param clave
	 * @return
	 */
	public static String descifradocesarDesplazamiento(String texto, int clave) {
		String textoAdevolver = "";
		// .tocharArray convierte mi cadena de caracteras a un array
		char[] textoAux = texto.toCharArray();

		for (int i = 0; i < texto.length(); i++) {

			// Se aplica un rango del 87 al 91 para que no se valla a a que vale 65
			if (textoAux[i] > 64 && textoAux[i] < 68 || textoAux[i] > 96 && textoAux[i] < 100) {
				textoAux[i] = (char) (textoAux[i] + 26 - clave);
			}

			// este else sirve para ignorar espacios
			else if (textoAux[i] == 32)
				;

			else {
				textoAux[i] -= clave;
			}
			textoAdevolver += textoAux[i];
		}

		return textoAdevolver;
	}
	
	/**
	 * Coloca letra a un DNI
	 */
	public static void letradeunDNI() {
		int numDni = 0;
		String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCK";
		int resulletra;
		
		do {
			numDni = Utils.pideNumeroEntero("introduce un numero entero de 8 digitos");
			
			if (("" + numDni).length() != 8) System.err.println("No tiene una logintud de 8 digitos");
			
		} while (("" + numDni).length() != 8);
		
		resulletra = numDni % 23;
		
		System.out.println(letrasDNI.charAt(resulletra));
		
		System.out.println("El dni seria: " + numDni + letrasDNI.charAt(resulletra));
	}
	
	/**
	 * Combierte los valores de numeros enteros de un array en un caracter segun su valo
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
	 * Combierte los valores de numeros enteros de un array en un caracter segun su valo
	 * @param a array de valores enteros 
	 * @return cadena que se va a devolver
	 */
	public static StringBuffer stringFronArray2(int[] a) {
		StringBuffer sb = new StringBuffer();
		
		
		for (int i = 0; i < a.length; i++) {
			sb.append((char) a[i]);
		}
		return sb;
	}
	
	/**
	 * Este metodo guarda una cadena en un array diferenciandolar por un caracter
	 * @param ignorar
	 * @param cadena
	 * @return
	 */
	public static String[] arrayDePalabras(char ignorar, String cadena) {
		//Creo un array segun cadenas que alla
		String[] Arraypalabra = new String[UtilsString.CuentaPalabras(ignorar ,cadena)];
		cadena += " ";
		
		//recorro el array
		for (int i = 0, j = 0; i < Arraypalabra.length; i++) {
			
			//ELimino el nulo del array
			Arraypalabra[i] = "";
			
			//Sigo abanzando en la cadena si no encuentro nada
			while (ignorar == cadena.charAt(j)) {
				j++;
			}
			
			//si encuentro algo que no es un espacio lo guardo en mi parte del array y sigo avanzando el la cadena
			while (ignorar != cadena.charAt(j)) {
				Arraypalabra[i] += cadena.charAt(j);
				j++;
			}
			
		}
		
		return Arraypalabra;
	
	}

	/**
	 * Devuelve una array de caracteres de un String
	 * @param s
	 * @return
	 */
	public static char[] stringAarraydeCaracteres(String s) {
		
		char[] array = new char[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			array[i] = s.charAt(i);
		}
		
		return array;
	}
	
	/**
	 * Comprueba si una letra es minuscula
	 * @param c
	 * @return
	 */
	public static boolean esMinuscula(char c) {
		if (c >= 'a' && c <= 'z') return true;
		
		else return false;
	}
	
	/**
	 * Comprueba si es una letra mayuscula
	 * @param c
	 * @return
	 */
	public static boolean esMayuscula(char c) {
		if (c >= 'A' && c <= 'Z') return true;
		
		else return false;
	}
	
	/**
	 * Comprueba si es un numero
	 * @param c
	 * @return
	 */
	public static boolean esNumero(char c) {
		if (c >= '0' && c <= '9') return true;
		
		else return false;
	}
	
	/**
	 * Comprueba si es alfanumerico
	 * @param c
	 * @return
	 */
	public static boolean esAlfanumerico(char c) {
		if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')) return true;
		
		else return false;
	}

}
