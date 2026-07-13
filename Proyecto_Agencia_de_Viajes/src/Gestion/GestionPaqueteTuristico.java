package Gestion;
import Clases.Imprimir;
import Clases.PaqueteTuristico;
import java.util.Scanner;
public class GestionPaqueteTuristico {
    private PaqueteTuristico[] paquetes;
    private int contador;
    private Scanner sc;
    public GestionPaqueteTuristico(int capacidad){
        paquetes = new PaqueteTuristico[capacidad];
        contador = 0;
        sc = new Scanner(System.in);
    }
    public void registrarPaquete(){
        if(contador == paquetes.length){
            Imprimir.imprimir("No hay espacio.");
            return;
        }
        Imprimir.imprimir("Código:");
        String codigo = sc.nextLine();

        Imprimir.imprimir("Nombre:");
        String nombre = sc.nextLine();

        Imprimir.imprimir("Descripción:");
        String descripcion = sc.nextLine();

        Imprimir.imprimir("Días:");
        int dias = sc.nextInt();

        Imprimir.imprimir("Noches:");
        int noches = sc.nextInt();
        sc.nextLine();

        Imprimir.imprimir("Tipo:");
        String tipo = sc.nextLine();

        Imprimir.imprimir("Precio:");
        double precio = sc.nextDouble();
        sc.nextLine();
        
        Imprimir.imprimir("Fecha salida:");
        String salida = sc.nextLine();
        
        Imprimir.imprimir("Fecha retorno:");
        String retorno = sc.nextLine();

        Imprimir.imprimir("Cupo:");
        int cupo = sc.nextInt();
        sc.nextLine();

        System.out.println("Estado:");
        String estado = sc.nextLine();

        paquetes[contador] =new PaqueteTuristico(codigo,nombre,descripcion,dias,noches,tipo,precio,salida,retorno,cupo,estado);
        contador++;
        Imprimir.imprimir("Registrado correctamente.");
    }

    public void listarPaquetes(){
        for(int i=0;i<contador;i++){
            Imprimir.imprimir("----------------");
            Imprimir.imprimir(paquetes[i].mostrarInformacion());
        }
    }

    public PaqueteTuristico buscarPaquete(String codigo){
        for(int i=0;i<contador;i++){
            if(paquetes[i].getCodigo().equals(codigo)){
                return paquetes[i];
            }
        }
        return null;
    }
    public void eliminarPaquete(String codigo){
        for(int i=0;i<contador;i++){
            if(paquetes[i].getCodigo().equals(codigo)){
                for(int j=i;j<contador-1;j++){
                    paquetes[j]=paquetes[j+1];
                }
                paquetes[contador-1]=null;
                contador--;
                Imprimir.imprimir("Eliminado.");
                return;
            }
        }
    }
    public boolean agregarPaquete(PaqueteTuristico paquete){

    if(contador >= paquetes.length){
        return false;
    }

    paquetes[contador] = paquete;
    contador++;

    return true;
}

public boolean modificarPaquete(String codigo,String nombre,String descripcion,int dias,int noches,String tipo,double precio,String salida,String retorno,int cupo,String estado){

    for(int i=0;i<contador;i++){

        if(paquetes[i].getCodigo().equalsIgnoreCase(codigo)){

            paquetes[i].setNombre(nombre);
            paquetes[i].setDescripcion(descripcion);
            paquetes[i].setDuracionDias(dias);
            paquetes[i].setDuracionNoches(noches);
            paquetes[i].setTipo(tipo);
            paquetes[i].setPrecioPersona(precio);
            paquetes[i].setFechaSalida(salida);
            paquetes[i].setFechaRetorno(retorno);
            paquetes[i].setCupoMaximo(cupo);
            paquetes[i].setEstado(estado);

            return true;
        }
    }

    return false;
}

public boolean eliminarPaqueteGUI(String codigo){

    for(int i=0;i<contador;i++){

        if(paquetes[i].getCodigo().equalsIgnoreCase(codigo)){

            for(int j=i;j<contador-1;j++){
                paquetes[j]=paquetes[j+1];
            }

            paquetes[contador-1]=null;
            contador--;

            return true;
        }
    }

    return false;
}

}