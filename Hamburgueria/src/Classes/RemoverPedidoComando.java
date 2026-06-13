package Classes;

public class RemoverPedidoComando implements ComandoCozinha {
    private FilaPreparoPedidos fila;
    private PedidoCompleto pedido;

    public RemoverPedidoComando(FilaPreparoPedidos fila, PedidoCompleto pedido) {
        this.fila   = fila;
        this.pedido = pedido;
    }

    @Override
    public void executar() { fila.removerPedido(pedido); }

    @Override
    public void cancelar() { fila.adicionarPedido(pedido); }
}
