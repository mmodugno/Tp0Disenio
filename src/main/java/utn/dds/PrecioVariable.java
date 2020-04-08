package utn.dds;

import utn.dds.exceptions.PrecioNegativoException;

public class PrecioVariable implements TipoPrecio{

	public void validarCambio(float nuevoPrecio) {
		if (nuevoPrecio<0) {
			throw new PrecioNegativoException("El precio debe ser un numero positivo");
		}
			
	
	}
}
