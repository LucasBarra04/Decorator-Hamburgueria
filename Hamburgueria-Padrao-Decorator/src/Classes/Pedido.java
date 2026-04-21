package Classes;

public class Pedido {

    private EstadoPedido estado;
    private Hamburguer hamburguer;

    public Pedido(Hamburguer hamburguer) {
        this.hamburguer = hamburguer;
        this.estado = EstadoPedidoPagamentoPendente.getInstance();
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado.getEstado();
    }

    public Hamburguer getHamburguer() {
        return hamburguer;
    }

    public void pagamentoPendente() { estado.pagamentoPendente(this); }
    public void aprovar()           { estado.aprovar(this); }
    public void preparar()          { estado.preparar(this); }
    public void transportar()       { estado.transportar(this); }
    public void entregar()          { estado.entregar(this); }
    public void cancelar()          { estado.cancelar(this); }
}
