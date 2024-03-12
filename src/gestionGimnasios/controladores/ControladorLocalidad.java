package gestionGimnasios.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gestionGimnasios.entidades.Localidad;

public class ControladorLocalidad extends SuperControlador {
	
	////////////
	private static String coma = ", ";
	private static String igualA = " = ?";
	///////////
	
	///////////columnas/////////////////
	private static String columm1 = "id";
	private static String columm2 = "localidad";
	///////////columnas/////////////////

	
	public static Localidad getEntidadfromResultSet(ResultSet rs) throws SQLException {

		Localidad o = new Localidad();

		o.setId(rs.getInt(columm1));
		o.setLocalidad(rs.getString(columm2));

		return o;

	}
	
	/**
	 * devuelve una entidad a traves de un resulset
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static List<Localidad> getall() {
		List<Localidad> l = new ArrayList<Localidad>();

		try {

			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("select * from " + getminombretabla() + ";");

			while (rs.next()) {
				Localidad o = getEntidadfromResultSet(rs);
				l.add(o);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;

	}
	
	/**
	 * Nombre de la tabla
	 * @return
	 */
	private static String getminombretabla() {
		return nombreTabla = "localidad";
	}
}
