package Classes;

public class DadosPedidoProxy implements IDadosPedido {
    private DadosPedido dadosReais;
    private PedidoCompleto pedido;

    public DadosPedidoProxy(PedidoCompleto pedido) {
        this.pedido = pedido;
    }

    private void carregarSeNecessario() {
        if (dadosReais == null) {
            dadosReais = new DadosPedido(pedido);
        }
    }

    @Override
    public String getNomeCliente() {
        carregarSeNecessario();
        return dadosReais.getNomeCliente();
    }

    @Override
    public String getFormaPagamento() {
        carregarSeNecessario();
        return dadosReais.getFormaPagamento();
    }

    @Override
    public double getCustoTotal() {
        carregarSeNecessario();
        return dadosReais.getCustoTotal();
    }

    @Override
    public String getResumo() {
        carregarSeNecessario();
        return dadosReais.getResumo();
    }

    public boolean isCarregado() { return dadosReais != null; }
}
