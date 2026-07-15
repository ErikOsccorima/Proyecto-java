package Clases;

public class Promocion {

    private String codigo;
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String estado;
    public Promocion(String codigo, String nombre,String descripcion,String fechaInicio,String fechaFin,String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }
    public String mostrarDatos() {
        return "Código: " + codigo +
                "\nNombre: " + nombre +
                "\nDescripción: " + descripcion +
                "\nFecha inicio: " + fechaInicio +
                "\nFecha fin: " + fechaFin +
                "\nEstado: " + estado;
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getEstado() {
        return estado;
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

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}