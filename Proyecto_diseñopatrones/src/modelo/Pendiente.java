package modelo;

public class Pendiente implements EstadoPedido {
    
    public EstadoPedido procesar() { return new Procesado(); }
    public EstadoPedido enviar() { return this; }
    public EstadoPedido entregar() { return this; }
    public String getNombre() { return "PENDIENTE"; }
}



