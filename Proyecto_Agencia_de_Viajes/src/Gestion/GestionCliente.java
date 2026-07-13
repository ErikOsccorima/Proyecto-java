package Gestion;
import Clases.Cliente;
import Clases.Imprimir;
public class GestionCliente {
    private Cliente[] clientes;
    private int contador;
    public GestionCliente(int capacidad) {
        clientes = new Cliente[capacidad];
        contador = 0;
    }
    
    public void registrarCliente(Cliente cliente) {
        if(contador < clientes.length) {
            clientes[contador] = cliente;
            contador++;
            Imprimir.imprimir("Cliente registrado correctamente.");
        } else {
            Imprimir.imprimir("No hay espacio disponible.");
        }
    }
    // BUSCAR CLIENTE POR DNI
    public Cliente buscarCliente(String dni) {
        for(int i = 0; i < contador; i++) {
            if(clientes[i].getDni().equals(dni)) {
                return clientes[i];
            }
        }
        return null;
    }
    // MODIFICAR CLIENTE
    public void modificarCliente(String dni,String telefono,String correo) {
        Cliente cliente = buscarCliente(dni);
        if(cliente != null) {
            cliente.setTelefono(telefono);
            cliente.setCorreo(correo);
            Imprimir.imprimir("Cliente modificado correctamente.");
        } else {
            Imprimir.imprimir("Cliente no encontrado.");
        }
    }
    // ELIMINAR CLIENTE
    public void eliminarCliente(String dni) {
        for(int i = 0; i < contador; i++) {
            if(clientes[i].getDni().equals(dni)) {
                for(int j = i; j < contador - 1; j++) {
                    clientes[j] = clientes[j+1];
                }
                clientes[contador-1] = null;
                contador--;
                Imprimir.imprimir("Cliente eliminado correctamente.");
                return;
            }
        }
        Imprimir.imprimir("Cliente no encontrado.");
    }
    // LISTAR CLIENTES
    public void listarClientes() {
        if(contador == 0) {
            Imprimir.imprimir("No existen clientes registrados.");
            return;
        }
        for(int i = 0; i < contador; i++) {
            Imprimir.imprimir("----------------------");
            Imprimir.imprimir(clientes[i].mostrarInformacion());
        }
    }

    public Cliente[] getClientes() {
        return clientes;
    }
    public int getContador() {
        return contador;
    }
}