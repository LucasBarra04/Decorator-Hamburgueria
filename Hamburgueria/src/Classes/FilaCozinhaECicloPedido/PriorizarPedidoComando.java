package Classes.FilaCozinhaECicloPedido;

import Classes.MontagemHamburguer.PedidoCompleto;

public class PriorizarPedidoComando implements ComandoCozinha {
    private FilaPreparoPedidos fila;
    private PedidoCompleto pedido;

    public PriorizarPedidoComando(FilaPreparoPedidos fila, PedidoCompleto pedido) {
        this.fila   = fila;
        this.pedido = pedido;
    }

    @Override
    public void executar() { fila.priorizarPedido(pedido); }

    @Override
    public void cancelar() {
        if (fila.getPedidosNaFila().remove(pedido)) {
            fila.getPedidosNaFila().add(pedido);

        }
    }
}
