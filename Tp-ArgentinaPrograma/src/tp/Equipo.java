package tp;

public class Equipo {
	
	private String nombre;
	private String descripcion;
	
	public Equipo(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	protected String getNombre() {
		return nombre;
	}

	protected String getDescripcion() {
		return descripcion;
	}
	
	
	

}
