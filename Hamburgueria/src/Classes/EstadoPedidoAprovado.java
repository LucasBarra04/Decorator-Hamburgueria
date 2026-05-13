package Classes;

public class EstadoPedidoAprovado extends EstadoPedido {

    private static EstadoPedidoAprovado instance;

    private EstadoPedidoAprovado() {}

    public static EstadoPedidoAprovado getInstance() {
        if (instance == null) {
            instance = new EstadoPedidoAprovado();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Aprovado";
    }

    @Override
    public void preparar(Pedido pedido) {
        System.out.println("Pedido em preparo na cozinha!");
        pedido.setEstado(EstadoPedidoPreparo.getInstance());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("Pedido cancelado a partir de Aprovado.");
        pedido.setEstado(EstadoPedidoCancelado.getInstance());
    }
}
