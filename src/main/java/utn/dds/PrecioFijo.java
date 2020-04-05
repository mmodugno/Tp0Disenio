package utn.dds;

public class PrecioFijo implements TipoPrecio{
	public void validarCambio() {
		throw new RuntimeException("El precio no puede modificarse, porque esta fijo");
	}

}
