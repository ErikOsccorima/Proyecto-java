package Clases;

public class ReservaPaqueteTuristico {

    private String codigoReserva;
    private Cliente cliente;
    private PaqueteTuristico paquete;

    private int adultos;
    private int menores;

    private double montoTotal;
    private String fechaReserva;


    private Pago[] pagos;
    private int cantidadPagos;

    private double saldoPendiente;
    private String estado;



    public ReservaPaqueteTuristico(
            String codigoReserva,
            Cliente cliente,
            PaqueteTuristico paquete,
            int adultos,
            int menores,
            String fechaReserva) {


        this.codigoReserva = codigoReserva;
        this.cliente = cliente;
        this.paquete = paquete;

        this.adultos = adultos;
        this.menores = menores;

        this.fechaReserva = fechaReserva;
        calcularTotal();
        saldoPendiente = montoTotal;
        estado = "Pendiente";
        pagos = new Pago[20];
        cantidadPagos = 0;
    }
    public void calcularTotal() {
        double precioAdulto = paquete.getPrecioPersona();
        double precioMenor = precioAdulto * 0.50;
        montoTotal =(adultos * precioAdulto)+(menores * precioMenor);
    }
    public boolean registrarPago(Pago pago) {
        if(cantidadPagos >= pagos.length){
            return false;
        }
        if(pago.getMonto() > saldoPendiente){
            return false;
        }
        pagos[cantidadPagos] = pago;
        cantidadPagos++;
        saldoPendiente -= pago.getMonto();
        if(obtenerTotalPagado() >= montoTotal * 0.30){
            estado = "Confirmada";
        }
        if(saldoPendiente == 0){
            estado = "Pagada";
        }
        return true;
    }
    public double obtenerTotalPagado(){
        double total = 0;
        for(int i = 0; i < cantidadPagos; i++){
            total += pagos[i].getMonto();
        }
        return total;
    }
    public String mostrarPagos(){
        String texto = "";
        if(cantidadPagos == 0){
            return "No existen pagos registrados.";
        }
        for(int i = 0; i < cantidadPagos; i++){
            texto += pagos[i].mostrarInformacion()+ "\n\n";
        }
        return texto;
    }
    public String mostrarInformacion(){
        return "Código Reserva: " + codigoReserva +
                "\nCliente: " + cliente.mostrarInformacion() +
                "\nPaquete: " + paquete.getNombre() +
                "\nAdultos: " + adultos +
                "\nMenores: " + menores +
                "\nMonto Total: S/ " + montoTotal +
                "\nTotal Pagado: S/ " + obtenerTotalPagado() +
                "\nSaldo Pendiente: S/ " + saldoPendiente +
                "\nEstado: " + estado +
                "\nFecha Reserva: " + fechaReserva;

    }
    public String getCodigoReserva(){
        return codigoReserva;

    }

    public Cliente getCliente(){
        return cliente;

    }

    public PaqueteTuristico getPaquete(){
        return paquete;

    }

    public double getMontoTotal(){
        return montoTotal;

    }

    public double getSaldoPendiente(){
        return saldoPendiente;

    }

    public String getEstado(){
        return estado;

    }

    public String getFechaReserva(){
        return fechaReserva;

    }

    public int getAdultos(){
        return adultos;

    }

    public int getMenores(){
        return menores;

    }
}