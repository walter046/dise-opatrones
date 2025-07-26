
package modelo;


public class Entregado implements EstadoPedido {
    public EstadoPedido procesar() { return this; }
    public EstadoPedido enviar() { return this; }
    public EstadoPedido entregar() { return this; }
    public String getNombre() { return "ENTREGADO"; }
}