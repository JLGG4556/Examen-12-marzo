package gestionGimnasios.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gestionGimnasios.entidades.Gimnasio;

public class ControladorGimnasio extends SuperControlador {

	/**
	 * getall
	 */
	
	////////////
	private static String coma = ", ";
	private static String igualA = " = ?";
	///////////
	
	///////////columnas/////////////////
	private static String columm1 = "id";
	private static String columm2 = "descripcion";
	///////////columnas/////////////////
	
	/**
	 * devuelve una entidad a traves de un resulset
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static Gimnasio getEntidadfromResultSet(ResultSet rs) throws SQLException {

		Gimnasio o = new Gimnasio();

		o.setId(rs.getInt(columm1));
		o.setDescripcion(rs.getString(columm2));

		return o;

	}
	
	/**
	 * devuelve una entidad a traves de un resulset
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static List<Gimnasio> getall() {
		List<Gimnasio> l = new ArrayList<Gimnasio>();

		try {

			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("select * from " + getminombretabla() + ";");

			while (rs.next()) {
				Gimnasio o = getEntidadfromResultSet(rs);
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
		return nombreTabla = "gimnasio";
	}
}
