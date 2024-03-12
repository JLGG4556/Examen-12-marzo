package mismetodos.plantillas.bbdd.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Controlador extends SuperControlador {
	
	////////////
	private static String coma = ", ";
	private static String igualA = " = ?";
	///////////
	
	///////////columnas/////////////////
	private static String columm1 = "id";
	private static String columm2 = "nombre";
	private static String columm3 = "idNivel";
	private static String columm4 = "codigo";
	private static String columm5 = "urlClassroom";
	private static String columm6 = "admiteMatricula";
	private static String columm7 = "fechaInicio";
	///////////columnas/////////////////
	
	/**
	 * Devuelve un registro exacto
	 * @return
	 */
	public static Object getExacto() {
		try {
			return getEntidad("select * from " + getminombretabla() + " where id = " + columm1 + ";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * consulta que optiene el primer registro
	 * 
	 * @return
	 */
	public static Object getPrimero() {

		try {
			
			return getEntidad("select * from " + getminombretabla() + " order by id asc limit 1");
			
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * consulta que optiene el ultimo registro
	 * 
	 * @return
	 */
	public static Object getUltimo() {
		try {
			return getEntidad("select * from " + getminombretabla() + " order by id desc limit 1");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * consulta que optiene el registro anterior al seleccionado en el panel
	 * 
	 * @return
	 */
	public static Object getAnterior(int idActual) {
		try {
			String sql = "select * from " + getminombretabla() + " where id < " + idActual + " order by id desc limit 1";
			return getEntidad(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * consulta que optiene el registro siguiente al seleccionado en el panel
	 * 
	 * @return
	 */
	public static Object getSiguiente(int idActual) {
		try {
			return getEntidad(
					"select * from " + getminombretabla() + " where id > " + idActual + " order by id asc limit 1");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Devuelve una entidad
	 * 
	 * @return
	 */
	private static Object getEntidad(String sql) throws SQLException {

		Statement s = ConnectionManager.getConexion().createStatement();
		ResultSet rs = s.executeQuery(sql);

		Object o = null;
		if (rs.next()) {
			o = new Object();
			//o.setId(rs.getInt("id"));
			
			//o.setFechainicio(rs.getDate("fechaInicio"));

		}
		return o;
	}
	
	/**
	 * Se inserta un registro a travez de un registro
	 * 
	 * @param o
	 * @return
	 * @throws SQLException
	 */
	public static int insercion(Object o) throws SQLException {

		PreparedStatement ps = ConnectionManager.getConexion().prepareStatement("" + " insert into " + getminombretabla()
				+ " (" + columm1 + coma + columm2 + coma + columm3 + coma + columm4 + coma + columm5 + coma + columm6 + coma + columm7 + ") values (?, ?, ?, ?, ?, ?, ?)");

		int idnuevo = nextIdEnTabla(nombreTabla);

//  	ps.setInt(1, idnuevo);

//		ps.setDate(7, o.getFechainicio());


		ps.executeUpdate();

		return idnuevo;
	}
	
	/**
	 * Actualiza un registro usando un objeto
	 * 
	 * @param o
	 * @throws SQLException
	 */
	public static void actualizacion(Object o) throws SQLException {

		PreparedStatement ps = ConnectionManager.getConexion().prepareStatement("" + " update " + getminombretabla()
				+ " set " + columm2 + igualA + coma + columm3 + igualA + coma + columm4 + igualA + coma + columm5 + igualA + coma + columm6 + igualA + coma + columm7 + igualA + " where " + columm1 + igualA);

		//ps.setString(1, o.getNombre());

		//ps.setInt(7, o.getId());


		ps.executeUpdate();

	}
	
	/**
	 * Elimina un registro
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public static void eliminacion(int id) throws SQLException {

		PreparedStatement ps = ConnectionManager.getConexion()
				.prepareStatement("delete from " + getminombretabla() + " where id = " + id);

		ps.execute();
	}
	
	/**
	 * devuelve una entidad a traves de un resulset
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static Object getEntidadfromResultSet(ResultSet rs) throws SQLException {

		Object o = new Object();

//		o.setId(rs.getInt(columm1));
//		o.setNombre(rs.getString(columm2));
//		o.setIdNivel(rs.getInt(columm3));
//		o.setCodigo(rs.getString(columm4));
//		o.setUrlclassroom(rs.getString(columm5));
//		o.setAdmiteMatricula(rs.getBoolean(columm6));
//		o.setFechainicio(rs.getDate(columm7));

		return o;

	}
	
	/**
	 * devuelve una entidad a traves de un resulset
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static List<Object> getall() {
		List<Object> l = new ArrayList<Object>();

		try {

			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("select * from " + getminombretabla() + ";");

			while (rs.next()) {
				Object o = getEntidadfromResultSet(rs);
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
		return nombreTabla = "";
	}
}
