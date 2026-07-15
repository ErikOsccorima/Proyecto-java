package Gestion;
import Clases.Cliente;
import Clases.Imprimir;
import Clases.Pago;
import Clases.PaqueteTuristico;
import Clases.ReservaPaqueteTuristico;
import Clases.VoucherReserva;
import java.util.Scanner;
public class GestionReserva {
    private ReservaPaqueteTuristico[] reservas;
    private int contador;
    private Scanner sc;
    public GestionReserva(int capacidad) {
        reservas = new ReservaPaqueteTuristico[capacidad];
        contador = 0;
        sc = new Scanner(System.in);
    }
    public void registrarReserva(Cliente cliente, PaqueteTuristico paquete) {
        if(contador >= reservas.length){
            Imprimir.imprimir("No hay espacio para más reservas.");
            return;
        }
        Imprimir.imprimir("Código de reserva: ");
        String codigo = sc.nextLine();

        Imprimir.imprimir("Cantidad de adultos: ");
        int adultos = Integer.parseInt(sc.nextLine());

        Imprimir.imprimir("Cantidad de menores: ");
        int menores = Integer.parseInt(sc.nextLine());
        int pasajeros = adultos + menores;
        if(pasajeros > paquete.getCupoMaximo()){
            Imprimir.imprimir("No existen suficientes cupos.");
            return;
        }
        Imprimir.imprimir("Fecha de reserva: ");
        String fecha = sc.nextLine();
        ReservaPaqueteTuristico reserva =  new ReservaPaqueteTuristico(codigo,cliente,paquete,adultos,menores,fecha);
        reservas[contador] = reserva;
        contador++;

        paquete.setCupoMaximo(paquete.getCupoMaximo() - pasajeros);
        Imprimir.imprimir("Reserva registrada correctamente.");
        Imprimir.imprimir("Monto total: S/ "+ reserva.getMontoTotal()
        );
    }
    public ReservaPaqueteTuristico buscarReserva(String codigo){
        for(int i = 0; i < contador; i++){
            if(reservas[i].getCodigoReserva().equalsIgnoreCase(codigo)){
                return reservas[i];
            }
        }
        return null;
    }
    public void mostrarReservas(){
        if(contador == 0){
            Imprimir.imprimir("No existen reservas.");
            return;
        }
        for(int i = 0; i < contador; i++){
            Imprimir.imprimir("-------------------------");
            Imprimir.imprimir(reservas[i].mostrarInformacion());
        }
    }

    public void mostrarReserva(){
        Imprimir.imprimir("Código de reserva: ");
        String codigo = sc.nextLine();
        
        ReservaPaqueteTuristico reserva =  buscarReserva(codigo);
        if(reserva == null){
            Imprimir.imprimir("Reserva no encontrada.");
        }else{           
            Imprimir.imprimir(reserva.mostrarInformacion());
        }
    }

    public void registrarPagoReserva(){
        Imprimir.imprimir("Código de reserva: ");
        String codigo = sc.nextLine();
        ReservaPaqueteTuristico reserva =  buscarReserva(codigo);
        if(reserva == null){Imprimir.imprimir("Reserva no encontrada.");
            return;
        }

        Imprimir.imprimir("Código de pago: ");
        String codigoPago = sc.nextLine();
        
        Imprimir.imprimir("Monto del pago: ");
        double monto = Double.parseDouble(sc.nextLine());
        
        Imprimir.imprimir("Método de pago: ");
        String metodo = sc.nextLine();
        
        Imprimir.imprimir("Fecha de pago: ");
        String fecha = sc.nextLine();
        
        Pago pago = new Pago(codigoPago, monto,metodo,fecha);
        if(reserva.registrarPago(pago)){
            Imprimir.imprimir("Pago registrado correctamente.");
            Imprimir.imprimir("Saldo pendiente: S/ "+ reserva.getSaldoPendiente());
            Imprimir.imprimir("Estado: "+ reserva.getEstado());
        }else{
            Imprimir.imprimir( "No se pudo registrar el pago.");
        }
    }
    public void mostrarPagosReserva(){
        Imprimir.imprimir("Código de reserva: ");
        String codigo = sc.nextLine();
        ReservaPaqueteTuristico reserva = buscarReserva(codigo);
        if(reserva == null){
            Imprimir.imprimir("Reserva no encontrada.");
        }else{
            Imprimir.imprimir(reserva.mostrarPagos());
        }
    }
    public void generarVoucher(){
        Imprimir.imprimir("Código de reserva: ");
        String codigo = sc.nextLine();
        ReservaPaqueteTuristico reserva =buscarReserva(codigo);
        if(reserva == null){
            Imprimir.imprimir("Reserva no encontrada.");
            return;
        }
        VoucherReserva voucher =new VoucherReserva(reserva);
        Imprimir.imprimir(voucher.generarVoucher());
    }
    public boolean agregarReserva(ReservaPaqueteTuristico reserva){
    if(contador >= reservas.length){
        return false;
    }
    reservas[contador] = reserva;
    contador++;

    return true;
}

public boolean eliminarReserva(String codigo){
    for(int i = 0; i < contador; i++){
        if(reservas[i].getCodigoReserva().equalsIgnoreCase(codigo)){
            for(int j = i; j < contador - 1; j++){
                reservas[j] = reservas[j+1];
            }
            reservas[contador-1] = null;
            contador--;
                return true;
            }
        }

        return false;
    }

    public ReservaPaqueteTuristico[] getReservas(){
        return reservas;
    }
    public int getContador(){
        return contador;
    }
}