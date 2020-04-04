package utn.dds;

public abstract class Item {
	private String nombre;
	private float precio;
	
	//Si es un servicio, no necesita remito : seteo que lo necesita como general para articulos y en clase Servicio lo modifico
	
	
	
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
