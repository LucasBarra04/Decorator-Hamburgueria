package Classes.FilaCozinhaECicloPedido;

public class EstadoPedidoTransporte extends EstadoPedido {

    private static EstadoPedidoTransporte instance;

    private EstadoPedidoTransporte() {}

    public static EstadoPedidoTransporte getInstance() {
        if (instance == null) {
            instance = new EstadoPedidoTransporte();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em Transporte";
    }

    @Override
    public void entregar(Pedido pedido) {

        pedido.setEstado(EstadoPedidoEntregue.getInstance());
    }
}
