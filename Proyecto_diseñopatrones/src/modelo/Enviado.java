
package modelo;

public class Enviado implements EstadoPedido {
    public EstadoPedido procesar() { return this; }
    public EstadoPedido enviar() { return this; }
    public EstadoPedido entregar() { return new Entregado(); }
    public String getNombre() { return "ENVIADO"; }
}