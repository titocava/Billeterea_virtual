package ar.edu.unlu.Billetera.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ar.edu.unlu.Billetera.prod.Dinero;
import ar.edu.unlu.Billetera.prod.Moneda;


class DineroTest {

	
	@Test
	public void CrearDineroConMonto() {
		Dinero unMonto = new Dinero(100, null);  // CrearDineroConUnMonto
        assertEquals(100, unMonto.getMonto());
        }
	@Test
	public void sumarUnMontoAunDinero() {
	    Dinero unMonto = new Dinero(100, Moneda.PESO); // Define la moneda
	    Dinero otroMonto = new Dinero(50, Moneda.PESO); // Define la misma moneda
	    unMonto.sumar(otroMonto);
	    assertEquals(150, unMonto.getMonto(), 0.01); // Tercer parámetro para la precisión de comparación
	}

	
	@Test
	public void restarUnMontoAUnDinero() {
	    Dinero unMonto = new Dinero(100, Moneda.PESO); // Define la moneda
	    Dinero otroMonto = new Dinero(50, Moneda.PESO); // Define la misma moneda
	    unMonto.restar(otroMonto);
	    assertEquals(50, unMonto.getMonto(), 0.01); // Tercer parámetro para la precisión de comparación
	}

	@Test
	public void compararSiDosMontosSonIguales() {
		Dinero dinero1 = new Dinero(100, null);
		Dinero dinero2 = new Dinero(100, null);
		assertTrue(dinero1.equals(dinero2));
	}

}
