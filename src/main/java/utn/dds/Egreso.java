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
	
	public boolean seHaceElRemito() {
		return contenido.stream().allMatch(item -> item.necesitaRemito());	
	}
	
	
	
	public double calcular() {
		this.cerrarOperacion();
		
		double total = contenido.stream()
	      .mapToDouble(item -> item.getPrecio())
	      .sum();
		
		if(this.seHaceElRemito()) {
			new Remito(total);
		}
		
		return total;
		
		
	}
	
}


