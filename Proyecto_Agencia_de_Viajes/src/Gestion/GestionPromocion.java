package Gestion;
import Clases.Promocion;
import Clases.Imprimir;
import java.util.Scanner;
public class GestionPromocion {
    private Promocion[] promociones;
    private int contador;
    private Scanner entrada;
    public GestionPromocion(int tamanio) {
        promociones = new Promocion[tamanio];
        contador = 0;
        entrada = new Scanner(System.in);
    }
    public void registrarPromocion() {
        if (contador >= promociones.length) {
            Imprimir.imprimir("No hay espacio para promociones.");
            return;
        }
        Imprimir.imprimir("Código:");
        String codigo = entrada.nextLine();

        Imprimir.imprimir("Nombre:");
        String nombre = entrada.nextLine();

        Imprimir.imprimir("Descripción:");
        String descripcion = entrada.nextLine();

        Imprimir.imprimir("Fecha inicio:");
        String fechaInicio = entrada.nextLine();

        Imprimir.imprimir("Fecha fin:");
        String fechaFin = entrada.nextLine();

        Imprimir.imprimir("Estado (Activo, Inactivo):");
        String estado = entrada.nextLine();

        Promocion promocion = new Promocion(codigo,nombre,descripcion,fechaInicio,fechaFin,estado);
        promociones[contador] = promocion;
        contador++;
        Imprimir.imprimir("Promoción registrada correctamente.");
    }
    public void modificarPromocion() {
        Imprimir.imprimir("Ingrese código de la promoción:");
        String codigo = entrada.nextLine();
        for(int i = 0; i < contador; i++){
            if(promociones[i].getCodigo().equalsIgnoreCase(codigo)){
                Imprimir.imprimir("Nuevo nombre:");
                promociones[i].setNombre(entrada.nextLine());

                Imprimir.imprimir("Nueva descripción:");
                promociones[i].setDescripcion(entrada.nextLine());

                Imprimir.imprimir("Nueva fecha inicio:");
                promociones[i].setFechaInicio(entrada.nextLine());

                Imprimir.imprimir("Nueva fecha fin:");
                promociones[i].setFechaFin(entrada.nextLine());

                Imprimir.imprimir("Nuevo estado:");
                promociones[i].setEstado(entrada.nextLine());

                Imprimir.imprimir("Promoción modificada correctamente.");
                return;
            }
        }
        Imprimir.imprimir("Promoción no encontrada.");
    }

    public void eliminarPromocion() {
        Imprimir.imprimir("Ingrese código de la promoción:");
        String codigo = entrada.nextLine();
        for(int i = 0; i < contador; i++){
            if(promociones[i].getCodigo().equalsIgnoreCase(codigo)){
                for(int j = i; j < contador - 1; j++){
                    promociones[j] = promociones[j+1];
                }
                promociones[contador-1] = null;
                contador--;
                Imprimir.imprimir("Promoción eliminada correctamente.");
                return;
            }
        }
        Imprimir.imprimir("Promoción no encontrada.");
    }

    public void mostrarPromociones(){
        if(contador == 0){
            Imprimir.imprimir("No hay promociones registradas.");
            return;
        }
        for(int i = 0; i < contador; i++){
            Imprimir.imprimir(promociones[i].mostrarDatos());
            Imprimir.imprimir("-----------------------------");
        }
    }
}