package gestionGimnasios.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gestionGimnasios.entidades.Asistente;

public class ControladorAsistente extends SuperControlador {

	////////////
	private static String coma = ", ";
	private static String igualA = " = ?";
	///////////
	
	///////////columnas/////////////////
	private static String columm1 = "id";
	private static String columm2 = "idGimnasio";
	private static String columm3 = "dniNiePasaporte";
	private static String columm4 = "idLocalidad";
	private static String columm5 = "activo";
	private static String columm6 = "nombre";
	private static String columm7 = "apellidos";
	private static String columm8 = "fechaNacimiento";
	private static String columm9 = "cuotaMensual";
	///////////columnas/////////////////
	
	
	public static Asistente getEntidadfromResultSet(ResultSet rs) throws SQLException {

		Asistente o = new Asistente();

//		o.setId(rs.getInt(columm1));
		o.setId(rs.getInt(columm1));
		o.setIdGimnasio(rs.getInt(columm2));
		o.setDniNiePasaporte(rs.getString(columm3));
		o.setIdLocalidad(rs.getInt(columm4));
		o.setActivo(rs.getBoolean(columm5));
		o.setNombre(rs.getString(columm6));
		o.setApellidos(rs.getString(columm7));
		o.setFechaNac(rs.getDate(columm8));
		o.setCuota(rs.getFloat(columm9));

		return o;

	}
	
	/**
	 * Actualiza un registro usando un objeto
	 * 
	 * @param o
	 * @throws SQLException
	 */
	public static void actualizacion(Asistente o) throws SQLException {

		PreparedStatement ps = ConnectionManager.getConexion().prepareStatement("" + " update " + getminombretabla()
				+ " set " + columm2 + igualA + coma + columm3 + igualA + coma + columm4 + igualA + coma + columm5 + igualA + coma + columm6 + igualA + coma + columm7 + igualA + columm8 + igualA + columm9 + " where " + columm1 + igualA);

		ps.setInt(1, o.getIdGimnasio());
		ps.setString(2, o.getDniNiePasaporte());
		ps.setInt(3, o.getIdLocalidad());
		ps.setBoolean(4, o.isActivo());
		ps.setString(5, o.getNombre());
		ps.setString(6, o.getApellidos());
		ps.setDate(7, o.getFechaNac());
		ps.setFloat(8, o.getCuota());
		ps.setInt(9, o.getId());
		
		//ps.setInt(7, o.getId());


		ps.executeUpdate();

	}
	
	/**
	 * devuelve una entidad a traves de un resulset
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static List<Asistente> getall(String exp) {
		List<Asistente> l = new ArrayList<Asistente>();

		try {

			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("select * from " + getminombretabla() + " where " + columm7 + " like '%" + exp + "%' ;");

			while (rs.next()) {
				Asistente o = getEntidadfromResultSet(rs);
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
		return nombreTabla = "asistente";
	}
}
