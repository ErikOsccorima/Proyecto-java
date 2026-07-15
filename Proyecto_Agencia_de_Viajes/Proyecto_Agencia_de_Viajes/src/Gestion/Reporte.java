package Gestion;
import Clases.ReservaPaqueteTuristico;
public class Reporte {
    private ReservaPaqueteTuristico[] reservas;
    private int cantidadReservas;
    public Reporte(ReservaPaqueteTuristico[] reservas, int cantidadReservas) {
        this.reservas = reservas;
        this.cantidadReservas = cantidadReservas;
    }

    public String reporteReservasPorPaquete(String nombrePaquete) {
        String texto = "";
        for(int i = 0; i < cantidadReservas; i++) {
            if(reservas[i].getPaquete().getNombre().equalsIgnoreCase(nombrePaquete)) {
                texto += reservas[i].mostrarInformacion();
                texto += "\n-------------------------\n";
            }
        }if(texto.equals("")) {
            return "No existen reservas para ese paquete.";
        }
        return texto;
    }

    public String reporteReservasPorFecha(
            String fechaInicio,
            String fechaFin) {
        String texto = "";
        for(int i = 0; i < cantidadReservas; i++) {
            String fecha = reservas[i].getFechaReserva();
            if(fecha.compareTo(fechaInicio) >= 0 &&
               fecha.compareTo(fechaFin) <= 0) {
                texto += reservas[i].mostrarInformacion();
                texto += "\n-------------------------\n";
            }
        }
        if(texto.equals("")) {
            return "No existen reservas en ese rango de fechas.";
        }
        return texto;
    }

    public String reporteDestinosSolicitados() {
        String texto = "";
        for(int i = 0; i < cantidadReservas; i++) {
            texto += "Reserva: "+ reservas[i].getCodigoReserva()+ "\n";
            texto += "Destino(s):\n";
            for(int j = 0;j < reservas[i].getPaquete().getCantidadDestinos();j++) {
                texto += "- "+ reservas[i].getPaquete().getDestinos()[j].getNombre()+ "\n";
            }
            texto += "-------------------------\n";
        } if(texto.equals("")) {
            return "No existen destinos registrados.";
        }
        return texto;
    }
    public String reporteClientesPendientesPago() {
        String texto = "";
        for(int i = 0; i < cantidadReservas; i++) {
            if(reservas[i].getSaldoPendiente() > 0) {
                texto += "Cliente:\n";
                texto += reservas[i].getCliente().mostrarInformacion();
                texto += "\nSaldo pendiente: S/ " + reservas[i].getSaldoPendiente();
                texto += "\nEstado: "+ reservas[i].getEstado();
                texto += "\n-------------------------\n";
            }
        }
        if(texto.equals("")) {
            return "No existen clientes con pagos pendientes.";
        }
        return texto;
    }
    public double reporteIngresosTotales() {
        double total = 0;
        for(int i = 0; i < cantidadReservas; i++) {
            total += reservas[i].obtenerTotalPagado();
        }
        return total;
    }
}