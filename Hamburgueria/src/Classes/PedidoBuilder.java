package Classes;

public class PedidoBuilder {
    private PedidoCompleto pedido;

    public PedidoBuilder() {
        this.pedido = new PedidoCompleto();
    }

    public PedidoCompleto build() { return pedido; }

    public PedidoBuilder setNomeCliente(String nome) {
        pedido.setNomeCliente(nome);
        return this;
    }
    public PedidoBuilder setHamburguer(Hamburguer hamburguer) {
        pedido.setHamburguer(hamburguer);
        return this;
    }
    public PedidoBuilder setAcompanhamento(Acompanhamento acompanhamento) {
        pedido.setAcompanhamento(acompanhamento);
        return this;
    }
    public PedidoBuilder setFormaPagamento(String formaPagamento) {
        pedido.setFormaPagamento(formaPagamento);
        return this;
    }
    public PedidoBuilder setObservacoes(String observacoes) {
        pedido.setObservacoes(observacoes);
        return this;
    }
    public PedidoBuilder setParaViagem(boolean paraViagem) {
        pedido.setParaViagem(paraViagem);
        return this;
    }
}
