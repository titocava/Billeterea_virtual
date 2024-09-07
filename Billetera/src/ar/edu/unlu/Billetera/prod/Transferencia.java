package ar.edu.unlu.Billetera.prod;

public class Transferencia {
	private Billetera billeteraOrigen;
	private Billetera billeteraDestino;
	private Dinero dinero;
	
	public Transferencia(Billetera billeteraOrigen, Billetera billeteraDestino, Dinero dinero) {
		this.billeteraOrigen = billeteraOrigen;
		this.billeteraDestino = billeteraDestino;
		this.dinero = dinero;
	}

	public void realizarTransferencia() {
        // Verificar si la billetera origen tiene suficiente saldo
        if (billeteraOrigen.consultarSaldo(dinero.getMoneda()) < dinero.getMonto()) {
            throw new IllegalArgumentException("Saldo insuficiente en la billetera origen");
        }

        // Retirar dinero de la billetera origen
        billeteraOrigen.retirarDinero(dinero);

        // Agregar dinero a la billetera destino
        billeteraDestino.agregarDinero(dinero);
    }

}
