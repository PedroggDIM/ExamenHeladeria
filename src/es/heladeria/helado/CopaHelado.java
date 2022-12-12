package es.heladeria.helado;

import java.util.Iterator;

public class CopaHelado implements ConDescripcion, ConPrecio, Comparable<CopaHelado> {

	private final static int COMPLEMENTOS_MAXIMO = 3;
	private static final IngredienteBase BASE_DEFAULT = new IngredienteBase("vainilla");

	private IngredienteBase ingredienteBase;
	private final Ingrediente[] complementos;

	public IngredienteBase getIngredienteBase() {
		return ingredienteBase;
	}

	public Ingrediente[] getComplementos() {
		return complementos;
	}

	protected void setIngredienteBase(IngredienteBase ingredienteBase) {
		this.ingredienteBase = ingredienteBase;
	}
    // constructor por defecto
	public CopaHelado() {
		this(BASE_DEFAULT);
		// this.complemento = new Ingrediente[COMPLEMENTOS_MAXIMO];
	}
    //constructor que admita un ingrediente base.
	public CopaHelado(IngredienteBase base) {
		setIngredienteBase(base);
		// en el constructor inicializo Ingrediente[] complementos
		this.complementos = new Ingrediente[COMPLEMENTOS_MAXIMO];
	}

	public boolean addComplemento(Ingrediente ingrediente) {
		boolean anadido = false;
        // necesito saber el número de complementos que hay
		int numeroDeComplementos = numeroDeComplementos();
		if (numeroDeComplementos < getComplementos().length) {
			getComplementos()[numeroDeComplementos] = ingrediente;
			anadido = true;
		}
		return anadido;
	}

	public boolean addComplemento(Ingrediente... ingredientes) {
		boolean anadido = true;

		for (Ingrediente ingrediente : ingredientes) {
			anadido = addComplemento(ingrediente);
		}
		return anadido;
	}

//	public boolean addComplemento(Ingrediente ingrediente, Ingrediente ingrediente2) {
//		boolean anadido = addComplemento(ingrediente);
//		anadido = addComplemento(ingrediente2);
//		
//		 return anadido;
//	}	
//	
//	public boolean addComplemento(Ingrediente ingrediente, Ingrediente ingrediente2, Ingrediente ingrediente3) {
//		boolean anadido = addComplemento(ingrediente);
//		anadido = addComplemento(ingrediente2);
//		anadido = addComplemento(ingrediente3);
//		 return anadido;
//	}
//	
//	public boolean addComplemento(Ingrediente[] ingredientes) {
//		boolean anadido = true;
//	    for (int i = 0; i < ingredientes.length; i++) {
//			anadido = addComplemento(ingredientes[i]);
//		}
//	    return anadido;		
//	}

	public int numeroDeComplementos() {
		int numeroComplementos = 0;
		for (Ingrediente ingrediente : getComplementos()) {
	// si es distinto de null es que es un complemento, sino no ha sido añadido todavía
			if (ingrediente != null) {
				numeroComplementos++;
			}
		}
		return numeroComplementos;
	}

	

// Copa de Helado de Vainilla con Virutas de chocolate, Virutas de chocolate y Galletitas

	@Override
	public String getDescripcion() {
		String complementos = "";
		int numeroComplementos = numeroDeComplementos();
		if (numeroComplementos > 0) {
			complementos += " con ";
			if (numeroComplementos == 1) {
				complementos = complementos + getComplementos()[0];
			} else {
				for (int i = 0; i < numeroComplementos - 1; i++) {
					complementos = complementos + getComplementos()[i] + ", ";
				}
			}
			if (numeroComplementos > 1) {
				complementos = complementos.substring(0, complementos.length() - 2) + " y "
						+ getComplementos()[numeroComplementos - 1];
			}
		}
		return "Copa de Helado  de " + getIngredienteBase().getSabor() + complementos;
	}

	@Override
	public int compareTo(CopaHelado otraCopaHelado) {

		return -Float.compare(getPrecio(), otraCopaHelado.getPrecio());
	}

	@Override
	public float getPrecio() {
		// el precio es la suma del precio de la base (que es fijo, siempre 2 euros) + los complementos
		float total = getIngredienteBase().getPrecio();
		for (int i = 0; i < getComplementos().length; i++) {
			if (getComplementos()[i] != null) {
				total += getComplementos()[i].getPrecio();
			}
		}
		return total;
	}
	
	@Override
	public String toString() {
		return getDescripcion();
	}


}
