package gestionGimnasios.entidades;

public class Localidad {
	
	private int id;
	private String localidad;
	
	/**
	 * **************************
	 */
	public Localidad() {
		super();
	}


	/////////////////////////////////////////7
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	@Override
	public String toString() {
		return localidad;
	}
	
	
	
	

}
