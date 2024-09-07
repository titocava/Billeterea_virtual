package ar.edu.unlu.Billetera.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import ar.edu.unlu.Billetera.prod.Billetera;
import ar.edu.unlu.Billetera.prod.Dinero;
import ar.edu.unlu.Billetera.prod.Moneda;
import ar.edu.unlu.Billetera.prod.Transferencia;

public class BilleteraTest {
	 @Test
	    public void ConsultarSaldo() {
	        Billetera billetera = new Billetera();
	        Dinero dinero = new Dinero(100, Moneda.PESO);
	        billetera.agregarDinero(dinero);
	        assertEquals(100, billetera.consultarSaldo(Moneda.PESO));
	    }
	 @Test
	    public void AgregarDinero() {
	        Billetera billetera = new Billetera();
	        Dinero dinero = new Dinero(100, Moneda.PESO);
	        billetera.agregarDinero(dinero);
	        assertEquals(100, billetera.consultarSaldo(Moneda.PESO));
	    }
	 
	 @Test
	    public void TransferirDinero() {
	        Billetera billetera1 = new Billetera(); // Instancia independiente
	        Billetera billetera2 = new Billetera(); // Instancia independiente
	        Dinero dinero = new Dinero(100, Moneda.PESO);
	        billetera1.agregarDinero(dinero);

	        Transferencia transferencia = new Transferencia(billetera1, billetera2, new Dinero(50, Moneda.PESO));
	        transferencia.realizarTransferencia();

	        assertEquals(50, billetera1.consultarSaldo(Moneda.PESO));
	        assertEquals(50, billetera2.consultarSaldo(Moneda.PESO));
	    }

	    @Test
	    public void TransferenciaSaldoInsuficiente() {
	        Billetera billetera1 = new Billetera(); // Instancia independiente
	        Billetera billetera2 = new Billetera(); // Instancia independiente
	        Dinero dinero = new Dinero(100, Moneda.PESO);
	        billetera1.agregarDinero(new Dinero(30, Moneda.PESO));

	        Transferencia transferencia = new Transferencia(billetera1, billetera2, dinero);
	        assertThrows(IllegalArgumentException.class, transferencia::realizarTransferencia);
	    }
	 
	 
	 
	 
	 
	 
	 
	 @Test
	    public void testConvertirPesosADolares() {
	        Billetera billetera = new Billetera();
	        billetera.agregarDinero(new Dinero(3000, Moneda.PESO)); // 3000 PESO = 2 DOLAR
	        billetera.convertir(Moneda.PESO, Moneda.DOLAR, 3000);
	        assertEquals(2, billetera.consultarSaldo(Moneda.DOLAR));
	        assertEquals(0, billetera.consultarSaldo(Moneda.PESO));
	    }

	    @Test
	    public void testConvertirDolaresAPesos() {
	        Billetera billetera = new Billetera();
	        billetera.agregarDinero(new Dinero(2, Moneda.DOLAR)); // 2 DOLAR = 3000 PESO
	        billetera.convertir(Moneda.DOLAR, Moneda.PESO, 2);
	        assertEquals(3000, billetera.consultarSaldo(Moneda.PESO));
	        assertEquals(0, billetera.consultarSaldo(Moneda.DOLAR));
	    }

	    @Test
	    public void testConvertirSaldoInsuficiente() {
	        Billetera billetera = new Billetera();
	        billetera.agregarDinero(new Dinero(1000, Moneda.PESO));
	        assertThrows(IllegalArgumentException.class, () -> billetera.convertir(Moneda.PESO, Moneda.DOLAR, 1500));
	    }	
	 

}
