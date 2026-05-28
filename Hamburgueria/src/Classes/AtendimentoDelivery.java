package Classes;

public class AtendimentoDelivery extends TipoAtendimento {

    public AtendimentoDelivery(PedidoCompleto pedido) {
        super(pedido);
    }

    @Override
    public double calcularTaxa() { return 6.50; }

    @Override
    public String getTipoAtendimento() { return "Delivery"; }
}
