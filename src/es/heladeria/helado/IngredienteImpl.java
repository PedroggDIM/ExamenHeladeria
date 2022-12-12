package es.heladeria.helado;
public abstract class IngredienteImpl implements Ingrediente {

	private float precio;
	private String descripcion;

	protected void setPrecio(float precio) {
		this.precio = precio;
	}

	protected void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public float getPrecio() {
		return precio;
	}


	public IngredienteImpl(String descripcion, float precio) {
		setDescripcion(descripcion);
		setPrecio(precio);
	}

	@Override
	public String toString() {
		return getDescripcion();
	}	

}
