
package modelo;

public class Procesado implements EstadoPedido {
    public EstadoPedido procesar() { return this; }
    public EstadoPedido enviar() { return new Enviado(); }
    public EstadoPedido entregar() { return this; }
    public String getNombre() { return "PROCESADO"; }
}
