package Clases;
public class Pago {
    private String codigoPago;
    private double monto;
    private String metodoPago;
    private String fechaPago;
    public Pago(String codigoPago, double monto, String metodoPago, String fechaPago) {
        this.codigoPago = codigoPago;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = fechaPago;
    }

    public String getCodigoPago() {
        return codigoPago;
    }

    public double getMonto() {
        return monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setCodigoPago(String codigoPago) {
        this.codigoPago = codigoPago;
    }

    public void setMonto(double monto) {
        if (monto > 0) {
            this.monto = monto;
        }
    }

    public void setMetodoPago(String metodoPago) {
        if (metodoPago.equalsIgnoreCase("Efectivo") ||
            metodoPago.equalsIgnoreCase("Tarjeta") ||
            metodoPago.equalsIgnoreCase("Transferencia")) {
        this.metodoPago = metodoPago;
        }
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String mostrarInformacion() {
        return "Código Pago: " + codigoPago +
               "\nMonto: S/ " + monto +
               "\nMétodo de Pago: " + metodoPago +
               "\nFecha de Pago: " + fechaPago;
    }
}