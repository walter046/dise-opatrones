package modelo;

public interface EstadoPedido {
    EstadoPedido procesar();
    EstadoPedido enviar();
    EstadoPedido entregar();
    String getNombre();
}