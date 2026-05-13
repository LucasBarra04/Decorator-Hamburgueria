package Classes;

public class EstadoPedidoCancelado extends EstadoPedido {

    private static EstadoPedidoCancelado instance;

    private EstadoPedidoCancelado() {}

    public static EstadoPedidoCancelado getInstance() {
        if (instance == null) {
            instance = new EstadoPedidoCancelado();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Cancelado";
    }
}
