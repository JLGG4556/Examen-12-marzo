package mismetodos;

public class UtilsValidacion {

	/**
	 * Validacion de un Email
	 * @param Email
	 * @return
	 */
	public static boolean isValidEmail(String Email) {

		// Compruebo que el email recivido no esta vacio o null
		if (Email == null || Email.trim().equals("")) {
			return false;
		}

		// Compruebo si lo que e recivido al menos tiene una arroba y un punto
		if (Email.contains(".") || Email.contains("@")) {

			// Compruebo si existe mas de una arroba
			if (UtilsString.conteoOcurrencia(Email, "@") > 1) {
				return false;
			}

			// Compruebo si hay un punto delante de la arroba o detras
			if (UtilsString.conteoOcurrencia(Email, "@.") >= 1 || UtilsString.conteoOcurrencia(Email, ".@") >= 1) {
				return false;
			}

			// Compruebo si hay algun punto detras de la arroba
			if (Email.lastIndexOf(".") < Email.lastIndexOf("@")) {
				return false;
			}

			// Por ultimo compruebo si ese punto no es justo el ultimo
			if (Email.lastIndexOf(".") == Email.length() - 1) {
				return false;
			}
			
			//Si no se da ninguna de las condiciones anteriores devuelvo un true
			return true;
			
		} else
			return false;
	}

	/**
	 * Si el tamaño del texto que se recivio e igual al tamaño del texto que se
	 * expecifico devuelve un true Sirve para comprovar la longitud de un texto
	 * 
	 * @param str
	 * @param size
	 * @return
	 */
	public static boolean isValidSize(String str, int size) {

		if (str.length() == size)
			return true;

		else
			return false;
	}
	
	/**
	 * Este metodo sirve para validar codigos
	 * 
	 * En este ejemplo las tres primeras letras empiezan por mayuscula
	 * [A-Z][3,]. 
	 * 
	 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/regex/Pattern.html#sum
	 * 
	 * @param str
	 * @param exRegular
	 * @return
	 */
	public static boolean isValidCode(String str, String exRegular) {
		
		return str.matches(exRegular);
		
	}
}
