package utn.dds;

import utn.dds.exceptions.CambiarPrecioFijoException;

public class PrecioFijo implements TipoPrecio{
	public void validarCambio(float nuevoPrecio) {
		throw new CambiarPrecioFijoException("El precio no puede modificarse, porque la operacion esta cerrada");
	}

}
