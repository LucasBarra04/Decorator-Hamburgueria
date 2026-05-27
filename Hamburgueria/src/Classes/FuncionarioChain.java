package Classes;
import java.util.ArrayList;
import java.util.List;
public abstract class FuncionarioChain {
    protected List<TipoPedidoEspecial> listaPedidos = new ArrayList<>();
    private FuncionarioChain superior;
    public FuncionarioChain getSuperior()        { return superior; }
    public void setSuperior(FuncionarioChain s)  { this.superior = s; }
    public abstract String getCargo();
    public abstract double getLimiteAprovacao();
    public String aprovarPedido(PedidoEspecial pedido) {
        if (listaPedidos.contains(pedido.getTipo())
                && pedido.getValor() <= getLimiteAprovacao()) {
            return getCargo() + " aprovou pedido especial de R$"
                    + pedido.getValor() + " ["
                    + pedido.getTipo().getClass().getSimpleName() + "]";
        }
        if (superior != null) return superior.aprovarPedido(pedido);
        return "Pedido não pôde ser aprovado: R$" + pedido.getValor();
    }
}
