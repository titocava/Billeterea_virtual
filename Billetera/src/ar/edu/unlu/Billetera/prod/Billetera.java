package ar.edu.unlu.Billetera.prod;

public class Billetera {
	
	private static final double TASA_CAMBIO_PESO_A_DOLAR = 1 / 1500.0;
    private static final double TASA_CAMBIO_DOLAR_A_PESO = 1500.0;
	private double saldoPesos;
    private double saldoDolares;

    public Billetera() {
        this.saldoPesos = 0.0;
        this.saldoDolares = 0.0;
    }

    public void agregarDinero(Dinero dinero) {
        switch (dinero.getMoneda()) {
            case PESO:
                saldoPesos += dinero.getMonto();
                break;
            case DOLAR:
                saldoDolares += dinero.getMonto();
                break;
        }
    }

    public double consultarSaldo(Moneda moneda) {
        switch (moneda) {
            case PESO:
                return saldoPesos;
            case DOLAR:
                return saldoDolares;
            default:
                throw new IllegalArgumentException("Moneda no soportada");
        }
    }
	
	public void retirarDinero(Dinero dinero) {
        switch (dinero.getMoneda()) {
            case PESO:
                if (saldoPesos >= dinero.getMonto()) {
                    saldoPesos -= dinero.getMonto();
                } else {
                    throw new IllegalArgumentException("Saldo insuficiente para retirar");
                }
                break;
            case DOLAR:
                if (saldoDolares >= dinero.getMonto()) {
                    saldoDolares -= dinero.getMonto();
                } else {
                    throw new IllegalArgumentException("Saldo insuficiente para retirar");
                }
                break;
        }
    }
	
    public void convertir(Moneda monedaOrigen, Moneda monedaDestino, double monto) {
        if (monedaOrigen == monedaDestino) {
            throw new IllegalArgumentException("La moneda de origen y destino no pueden ser iguales");
        }

        if (monedaOrigen == Moneda.PESO) {
            double montoEnDolares = monto * TASA_CAMBIO_PESO_A_DOLAR;
            if (saldoPesos >= monto) {
                saldoPesos -= monto;
                saldoDolares += montoEnDolares;
            } else {
                throw new IllegalArgumentException("Saldo insuficiente para convertir");
            }
        } else if (monedaOrigen == Moneda.DOLAR) {
            double montoEnPesos = monto * TASA_CAMBIO_DOLAR_A_PESO;
            if (saldoDolares >= monto) {
                saldoDolares -= monto;
                saldoPesos += montoEnPesos;
            } else {
                throw new IllegalArgumentException("Saldo insuficiente para convertir");
            }
        }
    }

    @Override
    public String toString() {
        return "Billetera{" +
                "saldoPesos=" + saldoPesos +
                ", saldoDolares=" + saldoDolares +
                '}';
    }
}
