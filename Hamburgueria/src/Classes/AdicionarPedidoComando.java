package Classes;

public class AdicionarPedidoComando implements ComandoCozinha {
    private FilaPreparoPedidos fila;
    private PedidoCompleto pedido;

    public AdicionarPedidoComando(FilaPreparoPedidos fila, PedidoCompleto pedido) {
        this.fila   = fila;
        this.pedido = pedido;
    }

    @Override
    public void executar() { fila.adicionarPedido(pedido); }

    @Override
    public void cancelar() { fila.removerPedido(pedido); }
}
