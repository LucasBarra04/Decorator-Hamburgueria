package Classes.FilaCozinhaECicloPedido;
import Classes.MontagemHamburguer.PedidoCompleto;

import java.util.ArrayList;
import java.util.List;

public class FilaPreparoPedidos {
    private List<PedidoCompleto> pedidosNaFila = new ArrayList<>();

    public void adicionarPedido(PedidoCompleto pedido) {
        pedidosNaFila.add(pedido);
        System.out.println("Pedido de " + pedido.getNomeCliente() + " adicionado à fila da cozinha.");
    }

    public void removerPedido(PedidoCompleto pedido) {
        pedidosNaFila.remove(pedido);
        System.out.println("Pedido de " + pedido.getNomeCliente() + " removido da fila da cozinha.");
    }

    public void priorizarPedido(PedidoCompleto pedido) {
        if (pedidosNaFila.remove(pedido)) {
            pedidosNaFila.add(0, pedido);
            System.out.println("Pedido de " + pedido.getNomeCliente() + " priorizado na fila.");
        }
    }

    public List<PedidoCompleto> getPedidosNaFila() { return pedidosNaFila; }
    public int getTotalNaFila()                     { return pedidosNaFila.size(); }
}
