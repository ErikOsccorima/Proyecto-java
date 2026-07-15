package Gestion;

import Clases.Pago;
import java.util.ArrayList;

public class GestionarPago {

    private static ArrayList<Pago> listaPagos = new ArrayList<>();


    // Registrar un nuevo pago
    public static void registrarPago(Pago pago){
        listaPagos.add(pago);
    }


    // Obtener todos los pagos registrados
    public static ArrayList<Pago> listarPagos(){
        return listaPagos;
    }


    // Buscar pago por código
    public static Pago buscarPago(String codigo){

        for(Pago pago : listaPagos){

            if(pago.getCodigoPago().equals(codigo)){
                return pago;
            }

        }

        return null;
    }


    // Eliminar pago
    public static void eliminarPago(String codigo){

        Pago pago = buscarPago(codigo);

        if(pago != null){
            listaPagos.remove(pago);
        }

    }

}