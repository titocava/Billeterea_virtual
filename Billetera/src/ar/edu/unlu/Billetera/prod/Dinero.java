package ar.edu.unlu.Billetera.prod;

import java.util.Objects;

public class Dinero {
    private double monto;
    private Moneda moneda;

    public Dinero(double monto, Moneda moneda) {  // crearDineroConUnMonto
        this.monto = monto;
        this.moneda = moneda;
    }

    public double getMonto() {
        return monto;
    }
    
    public Moneda getMoneda() {
    	return moneda;
    }
    
    public double setMonto(double monto) {
        return this.monto = monto;
    }
    
    public Moneda setMoneda(Moneda moneda) {
    	return this.moneda = moneda;
    }

    public void sumar(Dinero otroMonto) {
        if (this.moneda.equals(otroMonto.getMoneda())) {
            this.monto += otroMonto.getMonto();
        } else {
            throw new IllegalArgumentException("Monedas diferentes no pueden sumarse");
        }
    }

    public void restar(Dinero otroMonto) {
        if (this.moneda.equals(otroMonto.getMoneda())) {
            this.monto -= otroMonto.getMonto();
        } else {
            throw new IllegalArgumentException("Monedas diferentes no pueden restarse");
        }
    }
    
    @Override
    public String toString() {
        return monto + " " + moneda;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dinero otroDinero = (Dinero) obj;
        return Double.compare(otroDinero.monto, monto) == 0 && moneda == otroDinero.moneda;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(monto, moneda);
    }
	
	public boolean esValido() {
        return this.monto >= 0;
    }
	
		
}

