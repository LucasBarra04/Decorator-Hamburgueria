package Classes.HistoricoEPosVenda;
import Classes.MontagemHamburguer.PedidoCompleto;

import java.util.Iterator;

public class RelatorioCliente {
    private HistoricoCliente historico;

    public RelatorioCliente(HistoricoCliente historico) {
        this.historico = historico;
    }

    public int getTotalPedidos() {
        int total = 0;
        Iterator<PedidoCompleto> it = historico.iterator();
        while (it.hasNext()) { it.next(); total++; }
        return total;
    }

    public double getSomaTotal() {
        double soma = 0;
        for (PedidoCompleto p : historico) {
            soma += p.getCustoTotal();
        }
        return soma;
    }

    public void exibirHistorico() {
        Iterator<PedidoCompleto> it = historico.iterator();
        int i = 1;
        while (it.hasNext()) {
            PedidoCompleto p = it.next();

        }
    }
}
