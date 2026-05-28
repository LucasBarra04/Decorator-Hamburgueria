package Classes;

public abstract class TipoAtendimento {
    protected PedidoCompleto pedido;

    public TipoAtendimento(PedidoCompleto pedido) {
        this.pedido = pedido;
    }

    public double calcularValorFinal() {
        return pedido.getCustoTotal() + calcularTaxa();
    }

    public abstract double calcularTaxa();
    public abstract String getTipoAtendimento();
}
