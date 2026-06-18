package Classes.FilaCozinhaECicloPedido;

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

        pedido.setEstado(EstadoPedidoTransporte.getInstance());
    }

    @Override
    public void cancelar(Pedido pedido) {

        pedido.setEstado(EstadoPedidoCancelado.getInstance());
    }
}
