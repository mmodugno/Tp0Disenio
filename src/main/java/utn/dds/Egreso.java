package utn.dds;

import java.util.ArrayList;
import java.util.List;

public class Egreso {

	List<Item> contenido = new ArrayList<Item>();
	private boolean estaCerrada = false;
	
	
	public boolean getEstaCerrada() {
		return this.estaCerrada;
	}
	
	public void cerrarOperacion(){
		this.estaCerrada = true;
		}
	
	public void cargarItem(Item nuevoItem) {
		contenido.add(nuevoItem);
	}
	
	public boolean seNecesitaElRemito() {
		return contenido.stream().allMatch(item -> item.necesitaRemito());	
	}
	
	public double precioTotal() {
		return contenido.stream()
			      .mapToDouble(item -> item.getPrecio())
			      .sum();
	}
	
	
	public void realizarRemito(double monto) {
		if(this.seNecesitaElRemito()) {
			new Remito(this.precioTotal());
		}	
	}
}


