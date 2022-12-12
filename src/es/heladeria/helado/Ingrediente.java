package es.heladeria.helado;

public interface Ingrediente extends ConPrecio, ConDescripcion{

	default public boolean sirveComoBase() {
		return false;
	}
	
}
