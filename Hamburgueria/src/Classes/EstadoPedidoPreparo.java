package Classes;

public class EstadoPedidoPreparo extends EstadoPedido {

    private static EstadoPedidoPreparo instance;

    private EstadoPedidoPreparo() {}

    public static EstadoPedidoPreparo getInstance() {
        if (instance == null) {
            instance = new EstadoPedidoPreparo();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em Preparo";
    }

    @Override
    public void transportar(Pedido pedido) {
        System.out.println("Pedido saiu para entrega!");
        pedido.setEstado(EstadoPedidoTransporte.getInstance());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("Pedido cancelado a partir de Em Preparo.");
        pedido.setEstado(EstadoPedidoCancelado.getInstance());
    }
}
