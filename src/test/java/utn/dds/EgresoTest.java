package utn.dds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utn.dds.Articulo;
import utn.dds.Egreso;


public class EgresoTest {
	private Egreso egreso;
	private Articulo computadora = new Articulo("Computadora",100);
	private Articulo escritorio = new Articulo("Escritorio",50);
	
	private Servicio actualizaciones = new Servicio("Actualizaciones",500);
	
	@Before
	public void init() {
		    egreso = new Egreso(); //el egreso siempre contiene una computadora
		    egreso.cargarItem(computadora);
		  }
	
	@Test
	public void testPrecioTotalDeEgresos() {
		
		egreso.cargarItem(escritorio);
		
		Assert.assertEquals(150, egreso.precioTotal(), 0.01);
	}
	
	
	@Test (	expected=RuntimeException.class)
 	public void testCerrarOperacionesYNoCambiarPrecios() {
		
		egreso.cerrarOperacion();
		computadora.cambiarPrecio(200);
	
 	}
	
	@Test
	public void siHayServicioNoNecesitaRemito() {
		
		egreso.cargarItem(actualizaciones);
		
		Assert.assertFalse(egreso.seNecesitaElRemito());
	}
	
	
}

