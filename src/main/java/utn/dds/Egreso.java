package utn.dds;

import java.util.ArrayList;
import java.util.List;

public class Egreso {

	List<Item> contenido = new ArrayList<Item>();

	
	public void cerrarOperacion(){
		contenido.forEach(item -> item.fijarPrecio());
		}
	
	
	public void cargarItem(Item nuevoItem) {
		contenido.add(nuevoItem);
	}
	

	public double precioTotal() {
		return contenido.stream()
			      .mapToDouble(item -> item.getPrecio())
			      .sum();
	}
	
	public boolean seNecesitaElRemito() {
		return contenido.stream().allMatch(item -> item.necesitaRemito());	
	}
		
	public void realizarRemito(double monto) {
		if(this.seNecesitaElRemito()) {
			new Remito(this.precioTotal());
		}	
	}
}


