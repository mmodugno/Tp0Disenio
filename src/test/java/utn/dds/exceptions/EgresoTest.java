package utn.dds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class EgresoTest {
	private Egreso egreso;
	private Articulo computadora = new Articulo("Computadora",100);
	private Articulo escritorio = new Articulo("Escritorio",50);
	
	
	@Before
	public void init() {
		    egreso = new Egreso();
		  }
	
	@Test
	public void testPrecioTotalDeEgresos() {
		
		egreso.cargarItem(computadora);
		egreso.cargarItem(escritorio);
		
		Assert.assertEquals(150, egreso.precioTotal(), 0.01);
	}
	
	
	@Test (	expected=RuntimeException.class)

 	public void testCerrarOperacionesYNoCambiarPrecios() {
		egreso.cargarItem(computadora);
		egreso.cerrarOperacion();
		computadora.cambiarPrecio(200);
 	}
	
}


 