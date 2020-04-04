package utn.dds;

public abstract class Item {
	private String nombre;
	private float precio;
	

	
	public Item(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public void cambiarPrecio(float nuevoPrecio){
		this.precio = nuevoPrecio;
	}
	public float getPrecio() {
		return precio;
	}
	
	//Si es un servicio, no necesita remito : seteo que lo necesita como general para items y en clase Servicio lo modifico
		public boolean necesitaRemito() {
		return true;
	}
	
	
}
