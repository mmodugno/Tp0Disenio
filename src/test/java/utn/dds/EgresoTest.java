package utn.dds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utn.dds.Articulo;
import utn.dds.Egreso;
import utn.dds.exceptions.CambiarPrecioFijoException;
import utn.dds.exceptions.PrecioNegativoException;


public class EgresoTest {
	private Egreso egreso;
	private Articulo computadora = new Articulo("Computadora",100);
	private Articulo escritorio = new Articulo("Escritorio",50);
		
	private Servicio mantenimiento = new Servicio("Mantenimiento",500);
	
	private Egreso egresoVacio = new Egreso();
	
	@Before
	public void init() {
		    egreso = new Egreso(); //el egreso siempre contiene una computadora
		    egreso.cargarItem(computadora);
		  }
	
	
	
	@Test
	public void testPrecioTotalDeEgresos() {
		
		egreso.cargarItem(escritorio);
		egreso.cerrarOperacion();
		Assert.assertEquals(150, egreso.precioTotal(), 0.01);
	}
	
	
	@Test
	public void testTotalEnUnEgresoVacio() {
		Assert.assertEquals(0, egresoVacio.precioTotal(), 0.01);
	}
	
	@Test
	public void testCambiarPrecioAntesDeCerrarOperacion() {

		Assert.assertEquals(100, egreso.precioTotal(), 0.01); //ANTES de modificar el precio el total es 100
		
		computadora.cambiarPrecio(120);
		egreso.cerrarOperacion();
		Assert.assertEquals(120, egreso.precioTotal(), 0.01);
	}
	
	
	@Test 
 	public void testCerrarOperacionesYCambiarPrecios() {
		
		try {
		egreso.cerrarOperacion();
		computadora.cambiarPrecio(200);
		 Assert.fail("Debería tirar una excepcion");
		}
		catch(CambiarPrecioFijoException excepcion) {
			String message = "El precio no puede modificarse, porque la operacion esta cerrada";
			Assert.assertEquals(message, excepcion.getMessage());
		}
 	}
	
	
	
	@Test (expected = PrecioNegativoException.class)
	public void testCambiarAPrecioNegativo() {
		computadora.cambiarPrecio(-300);
	
	}
	
	@Test
	public void testSiHayServicioNoNecesitaRemito() {
		egreso.cargarItem(mantenimiento);
		Assert.assertFalse(egreso.seNecesitaElRemito());
	}
	
	
	
	@Test
	public void testNecesitaRemitoHastaAgregarUnServicio() {
		egreso.cargarItem(escritorio);
		Assert.assertTrue(egreso.seNecesitaElRemito());
		
		egreso.cargarItem(mantenimiento);
		Assert.assertFalse(egreso.seNecesitaElRemito());
	}
	
	
}

