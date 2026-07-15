package Clases;
public class ServicioIncluido {
    private String codigo;
    private String nombre;
    private String descripcion;
    private String tipo;
    public ServicioIncluido(String codigo, String nombre, String descripcion, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
    public String mostrarDatos() {
        return "Código: " + codigo +
                "\nNombre: " + nombre +
                "\nDescripción: " + descripcion +
                "\nTipo: " + tipo;
    }
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}