package Clases;

public class PaqueteTuristico {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int duracionDias;
    private int duracionNoches;
    private String tipo;
    private double precioPersona;
    private String fechaSalida;
    private String fechaRetorno;
    private int cupoMaximo;
    private String estado;
    private DestinoTuristico[] destinos;
    private ServicioIncluido[] servicios;
    private int cantidadDestinos;
    private int cantidadServicios;
    private Itinerario[] itinerarios;
    private int cantidadItinerarios;
    public PaqueteTuristico(String codigo, String nombre, String descripcion,int duracionDias, int duracionNoches,String tipo, double precioPersona,String fechaSalida, String fechaRetorno,int cupoMaximo, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionDias = duracionDias;
        this.duracionNoches = duracionNoches;
        this.tipo = tipo;
        this.precioPersona = precioPersona;
        this.fechaSalida = fechaSalida;
        this.fechaRetorno = fechaRetorno;
        this.cupoMaximo = cupoMaximo;
        this.estado = estado;
        destinos = new DestinoTuristico[10];
        servicios = new ServicioIncluido[10];
        cantidadDestinos = 0;
        cantidadServicios = 0;
        itinerarios = new Itinerario[20];
        cantidadItinerarios = 0;
    }
    public void agregarDestino(DestinoTuristico destino){
        if(cantidadDestinos < destinos.length){
            destinos[cantidadDestinos] = destino;
            cantidadDestinos++;
        }
    }
    public void agregarServicio(ServicioIncluido servicio){
        if(cantidadServicios < servicios.length){
            servicios[cantidadServicios] = servicio;
            cantidadServicios++;
        }
    }
    public String mostrarInformacion(){
                return "Código: " + codigo + 
                "\nNombre: " + nombre + 
                "\nDescripción: " + descripcion + 
                "\nDuración: " + duracionDias + " días / "+ duracionNoches + " noches"+
                "\nTipo: " + tipo + 
                "\nPrecio por persona: S/ " + precioPersona + 
                "\nFecha salida: " + fechaSalida + 
                "\nFecha retorno: " + fechaRetorno + 
                "\nCupo máximo: " + cupoMaximo + 
                "\nEstado: " + estado + "\n";
    }
    public String mostrarServicios() {
        String texto = "";
        for(int i = 0; i < cantidadServicios; i++) {
            texto += servicios[i].mostrarDatos() + "\n";
    }
        return texto;
    }
    public void agregarItinerario(Itinerario itinerario){

    if(cantidadItinerarios < itinerarios.length){

        itinerarios[cantidadItinerarios] = itinerario;
        cantidadItinerarios++;

    }

}
public String mostrarItinerario(){
    String texto = "";
    if(cantidadItinerarios == 0){
        return "No existe itinerario registrado.";
    }
    for(int i = 0; i < cantidadItinerarios; i++){
        texto += itinerarios[i].mostrarInformacion() + "\n";
    }
    return texto;

}    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public int getDuracionNoches() {
        return duracionNoches;
    }

    public void setDuracionNoches(int duracionNoches) {
        this.duracionNoches = duracionNoches;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioPersona() {
        return precioPersona;
    }

    public void setPrecioPersona(double precioPersona) {
        this.precioPersona = precioPersona;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(String fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public DestinoTuristico[] getDestinos() {
        return destinos;
    }

    public void setDestinos(DestinoTuristico[] destinos) {
        this.destinos = destinos;
    }

    public ServicioIncluido[] getServicios() {
        return servicios;
    }

    public void setServicios(ServicioIncluido[] servicios) {
        this.servicios = servicios;
    }

    public int getCantidadDestinos() {
        return cantidadDestinos;
    }

    public void setCantidadDestinos(int cantidadDestinos) {
        this.cantidadDestinos = cantidadDestinos;
    }

    public int getCantidadServicios() {
        return cantidadServicios;
    }

    public void setCantidadServicios(int cantidadServicios) {
        this.cantidadServicios = cantidadServicios;
    }
}