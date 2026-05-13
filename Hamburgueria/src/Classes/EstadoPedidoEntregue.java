package Classes;

public class EstadoPedidoEntregue extends EstadoPedido {

    private static EstadoPedidoEntregue instance;

    private EstadoPedidoEntregue() {}

    public static EstadoPedidoEntregue getInstance() {
        if (instance == null) {
            instance = new EstadoPedidoEntregue();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Entregue";
    }
}
