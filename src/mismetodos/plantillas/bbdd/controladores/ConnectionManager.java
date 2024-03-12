package mismetodos.plantillas.bbdd.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {

	private static Connection conexion = null;

	
	/*
	 * Cuando llamo al metodo get connection
	 */
	public static Connection getConexion() throws SQLException {
		// Si es la primera vez que accedemos a la conexión, debemos instanciarla
		if (conexion == null) {
			conectar();
		}
		// Compruebo si la conexión sigue estando activa
		while (!conexion.isValid(5)) {
			conectar();
		}

		return conexion;

	}

	private static void conectar() {

		// Datos consigidos del fichero y clase propiedades
		String driver = Propiedades.getProperty("JDBC_DRIVER_CLASS");
		String user = Propiedades.getProperty("JDBC_USER");
		String password = Propiedades.getProperty("JDBC_PASSWORD");
		String host = Propiedades.getProperty("JDBC_HOST");
		String schema = Propiedades.getProperty("JDBC_SCHEMA_NAME");
		String properties = Propiedades.getProperty("JDBC_PROPERTIES");

		try {

			Class.forName(driver);

			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://" + host + "/" + schema + properties,
					user, password);


		} catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
		} catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
		}

	}

}
