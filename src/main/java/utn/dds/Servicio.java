package utn.dds;

public class Servicio extends Item{
	public Servicio(String nombre, float precio) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean necesitaRemito() {
		return false;
	}
}
