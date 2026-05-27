package Classes;
public class GerenteChain extends FuncionarioChain {
    public GerenteChain() {
        listaPedidos.add(TipoPedidoEspecialSimples.getInstance());
        listaPedidos.add(TipoPedidoEspecialCombo.getInstance());
        listaPedidos.add(TipoPedidoEspecialCorporativo.getInstance());
    }
    @Override public String getCargo()           { return "Gerente"; }
    @Override public double getLimiteAprovacao() { return 200.0; }
}
