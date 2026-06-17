package Classes.HistoricoEPosVenda;

import Classes.MontagemHamburguer.PedidoCompleto;

public class DadosPedido implements IDadosPedido {
    private PedidoCompleto pedido;

    public DadosPedido(PedidoCompleto pedido) {
        this.pedido = pedido;
        System.out.println("DadosPedido: carregando dados sensíveis do pedido...");
    }

    @Override
    public String getNomeCliente()    { return pedido.getNomeCliente(); }

    @Override
    public String getFormaPagamento() { return pedido.getFormaPagamento(); }

    @Override
    public double getCustoTotal()     { return pedido.getCustoTotal(); }

    @Override
    public String getResumo() {
        return "Cliente: " + getNomeCliente()
             + " | Pagamento: " + getFormaPagamento()
             + " | Total: R$" + getCustoTotal();
    }
}
