package Classes.FilaCozinhaECicloPedido;

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

        pedido.setEstado(EstadoPedidoPreparo.getInstance());
    }

    @Override
    public void cancelar(Pedido pedido) {

        pedido.setEstado(EstadoPedidoCancelado.getInstance());
    }
}
