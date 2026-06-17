package Classes.HistoricoEPosVenda;
import Classes.MontagemHamburguer.PedidoCompleto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HistoricoCliente implements Iterable<PedidoCompleto> {
    private PedidoEstado estadoAtual;
    private PedidoCompleto pedidoAtual;
    private List<PedidoEstado>   memento       = new ArrayList<>();
    private List<PedidoCompleto> pedidosSalvos = new ArrayList<>();

    public HistoricoCliente() {
        this.estadoAtual = PedidoEstadoAberto.getInstance();
        memento.add(this.estadoAtual);
    }

    public void setEstado(PedidoEstado estado, PedidoCompleto pedido) {
        this.estadoAtual = estado;
        this.pedidoAtual = pedido;
        memento.add(estado);
        pedidosSalvos.add(pedido);
    }

    public void restaurarPedido(int indice) {
        this.estadoAtual = memento.get(indice);
        this.pedidoAtual = pedidosSalvos.get(indice - 1);
    }

    @Override
    public Iterator<PedidoCompleto> iterator() {
        return pedidosSalvos.iterator();
    }

    public int getTotalPedidos()               { return pedidosSalvos.size(); }
    public PedidoEstado getEstadoAtual()       { return estadoAtual; }
    public PedidoCompleto getPedidoAtual()     { return pedidoAtual; }
    public List<PedidoEstado> getMemento()     { return memento; }
    public List<PedidoCompleto> getPedidosSalvos() { return pedidosSalvos; }
}
