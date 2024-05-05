package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}


	
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaPago = fechaPago;
    }

    @Override
    public void realizarPago(double monto) {
        this.montoPagado = monto * 1.15; // 15% de recargo
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Pago con Tarjeta:");
        System.out.println("Número de tarjeta: " + numeroTarjeta);
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
    }

}
