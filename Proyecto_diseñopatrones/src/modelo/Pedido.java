package modelo;

import java.util.*;

public class Pedido implements Cloneable {
    private int id;
    private Date fecha;
    private EstadoPedido estado;
    private String clienteNombre;
    private List<DetallePedido> detalles;

    public Pedido() {
        this.estado = new Pendiente(); // Estado inicial
        this.detalles = new ArrayList<>();
    }

// Constructor corregido (opcional, si deseas mantenerlo)
public Pedido(String clienteNombre, int idProducto, int cantidad) {
    this(); // llama al constructor por defecto
    this.fecha = new Date();
    this.clienteNombre = clienteNombre;
    DetallePedido detalle = new DetallePedido(idProducto, cantidad);
    this.detalles.add(detalle);
}



    public void agregarDetalle(DetallePedido detalle) {
        detalles.add(detalle);
    }

    public void procesar() {
        estado = estado.procesar();
    }

    public void enviar() {
        estado = estado.enviar();
    }

    public void entregar() {
        estado = estado.entregar();
    }

    public String getEstado() {
        return estado.getNombre();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EstadoPedido getEstadoPedido() {
        return estado;
    }

    public void setEstadoPedido(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }


    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    @Override
    public Pedido clone() {
        try {
            Pedido clon = (Pedido) super.clone();
            clon.detalles = new ArrayList<>(this.detalles); // Clona la lista (shallow copy)
            return clon;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
