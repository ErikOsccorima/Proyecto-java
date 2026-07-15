package Gestion;
import Clases.DestinoTuristico;
import Clases.Imprimir;
import java.util.Scanner;

public class GestionDestino {
    private DestinoTuristico[] destinos;
    private int contador;
    Scanner entrada = new Scanner(System.in);
    public GestionDestino(int tamanio) {
        destinos = new DestinoTuristico[tamanio];
        contador = 0;
    }
    // Registrar destino
    public void registrarDestino() {
        if (contador >= destinos.length) {
            Imprimir.imprimir("No hay espacio para registrar destinos.");
            return;
        }

        Imprimir.imprimir("Nombre:");
        String nombre = entrada.nextLine();

        Imprimir.imprimir("País:");
        String pais = entrada.nextLine();

        Imprimir.imprimir("Ciudad:");
        String ciudad = entrada.nextLine();

        Imprimir.imprimir("Descripción:");
        String descripcion = entrada.nextLine();

        Imprimir.imprimir("Clima:");
        String clima = entrada.nextLine();

        Imprimir.imprimir("Idioma principal:");
        String idioma = entrada.nextLine();

        Imprimir.imprimir("Ruta de imagen:");
        String imagen = entrada.nextLine();

        destinos[contador] = new DestinoTuristico(nombre, pais, ciudad, descripcion,clima, idioma, imagen);
        contador++;
        Imprimir.imprimir("Destino registrado correctamente.");
    }
    public boolean agregarDestino(DestinoTuristico destino){

        if(contador >= destinos.length){
            return false;
    }

    destinos[contador] = destino;
    contador++;
    
    return true;
}
    // Modificar destino
    public void modificarDestino() {
        Imprimir.imprimir("Ingrese el nombre del destino:");
        String nombre = entrada.nextLine();
        for (int i = 0; i < contador; i++) {
            if (destinos[i].getNombre().equalsIgnoreCase(nombre)) {
                Imprimir.imprimir("Nuevo país:");
                destinos[i].setPais(entrada.nextLine());

                Imprimir.imprimir("Nueva ciudad:");
                destinos[i].setCiudad(entrada.nextLine());

                Imprimir.imprimir("Nueva descripción:");
                destinos[i].setDescripcion(entrada.nextLine());

                Imprimir.imprimir("Nuevo clima:");
                destinos[i].setClima(entrada.nextLine());

                Imprimir.imprimir("Nuevo idioma principal:");
                destinos[i].setIdioma(entrada.nextLine());

                Imprimir.imprimir("Nueva ruta de imagen:");
                destinos[i].setImagen(entrada.nextLine());
                Imprimir.imprimir("Destino modificado correctamente.");
                return;
            }
        }
        Imprimir.imprimir("Destino no encontrado.");
    }
    public boolean modificarDestino(String nombre,String pais,String ciudad,String descripcion,String clima,String idioma,String imagen){

    for(int i = 0; i < contador; i++){

        if(destinos[i].getNombre().equalsIgnoreCase(nombre)){

            destinos[i].setPais(pais);
            destinos[i].setCiudad(ciudad);
            destinos[i].setDescripcion(descripcion);
            destinos[i].setClima(clima);
            destinos[i].setIdioma(idioma);
            destinos[i].setImagen(imagen);

            return true;
        }
    }

    return false;
}
    // Eliminar destino
    public void eliminarDestino() {
        Imprimir.imprimir("Ingrese el nombre del destino:");
        String nombre = entrada.nextLine();
        for (int i = 0; i < contador; i++) {
            if (destinos[i].getNombre().equalsIgnoreCase(nombre)) {
                for (int j = i; j < contador - 1; j++) {
                    destinos[j] = destinos[j + 1];
                }
                destinos[contador - 1] = null;
                contador--;
                Imprimir.imprimir("Destino eliminado correctamente.");
                return;
            }
        }
        Imprimir.imprimir("Destino no encontrado.");
    }
    public boolean eliminarDestino(String nombre){

    for(int i = 0; i < contador; i++){

        if(destinos[i].getNombre().equalsIgnoreCase(nombre)){

            for(int j = i; j < contador - 1; j++){
                destinos[j] = destinos[j+1];
            }

            destinos[contador-1] = null;
            contador--;

            return true;
        }
    }

    return false;
}
    
}