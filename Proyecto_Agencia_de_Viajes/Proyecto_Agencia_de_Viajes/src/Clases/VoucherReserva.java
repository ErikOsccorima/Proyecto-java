package Clases;

public class VoucherReserva {
    private ReservaPaqueteTuristico reserva;
    public VoucherReserva(ReservaPaqueteTuristico reserva) {
        this.reserva = reserva;
    }
    public String generarVoucher() {
        return "========== VOUCHER DE RESERVA ==========" +
                "\n\nCódigo de Reserva: "
                + reserva.getCodigoReserva()
                + "\n\n----- DATOS DEL CLIENTE -----"
                + "\n"
                + reserva.getCliente().mostrarInformacion()
                + "\n\n----- DATOS DEL PAQUETE -----"
                + "\nPaquete: "
                + reserva.getPaquete().getNombre()
                + "\nDescripción: "
                + reserva.getPaquete().getDescripcion()
                + "\nFecha de salida: "
                + reserva.getPaquete().getFechaSalida()
                + "\nFecha de retorno: "
                + reserva.getPaquete().getFechaRetorno()
                + "\n\n----- PASAJEROS -----"
                + "\nAdultos: "
                + reserva.getAdultos()
                + "\nMenores: "
                + reserva.getMenores()
                + "\nTotal pasajeros: "
                + (reserva.getAdultos() + reserva.getMenores())
                + "\n\n----- SERVICIOS INCLUIDOS -----"
                + "\n"
                + reserva.getPaquete().mostrarServicios()
                + "\n\n----- INFORMACIÓN DE PAGO -----"
                + "\nPrecio total: S/ "
                + reserva.getMontoTotal()
                + "\nMonto abonado: S/ "
                + reserva.obtenerTotalPagado()
                + "\nSaldo pendiente: S/ "
                + reserva.getSaldoPendiente()
                + "\n\nEstado: "
                + reserva.getEstado()
                + "\n\n========================================";
    }
}