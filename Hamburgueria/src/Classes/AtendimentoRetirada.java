package Classes;

public class AtendimentoRetirada extends TipoAtendimento {

    public AtendimentoRetirada(PedidoCompleto pedido) {
        super(pedido);
    }

    @Override
    public double calcularTaxa() { return 0.0; }

    @Override
    public String getTipoAtendimento() { return "Retirada na Loja"; }
}
