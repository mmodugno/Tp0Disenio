package utn.dds;

public class Servicio extends Item{
	public Servicio(String nombre, float precio) {
		super(nombre, precio);
	}
	@Override
	public boolean necesitaRemito() {
		return false;
	}
}
